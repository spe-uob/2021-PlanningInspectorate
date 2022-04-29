
let mostRecentSearch = "";
let beingEditedId = "";

// drag and drop element for edit button at the end of each table row
const editButtonTableCell = '<td><button class="dialog-button mdl-button mdl-js-button mdl-button--icon">\n' +
    '                            <i class="material-icons">edit</i>\n' +
    '                        </button></td>';

// drag and drop element for delete button at the end of each table row
const deleteButtonTableCell = '<td><button class="delete-button mdl-button mdl-js-button mdl-button--icon">\n' +
    '                            <i class="material-icons">delete</i>\n' +
    '                        </button></td>';

// drag and drop element for delete button at the end of each table row
const emailButtonTableCell = '<td><button class="otp-button mdl-button mdl-js-button mdl-button--icon">\n' +
    '                            <i class="material-icons">email</i>\n' +
    '                        </button></td>';

const loadingBar = '<div id="p2" class="mdl-progress mdl-js-progress mdl-progress__indeterminate"></div>'

// SearchDatabase is an asynchronous function to search database and update results
async function GetRecordApi(searchTerm) {
    // update global mostRecentSearch variable so that if record is update, search can be called on the most recent
    // search and show new values
    mostRecentSearch = searchTerm;
    // make API call
    let request = "http://localhost:8081/api/v1/dbCrud/getRecords/" + searchTerm;
    let response = await fetch(request);
    // check for API response error
    if (!(response.status >= 200 && response.status <= 299)) {
        return false;
    }
    // await response and retrieve json list of records
    let data = await response.json();
    // retrieve and clear table body
    let tableBodyReference = document.getElementById("database-table-body");
    while (tableBodyReference.firstChild){
        tableBodyReference.removeChild(tableBodyReference.firstChild);
    }
    // update table body with new records
    data.forEach((record) => {
        let recordToBeAdded = [];
        for (const x in record) {
            recordToBeAdded.push(record[x]);
        }
       CreateNewDatabaseViewRow(recordToBeAdded);
    })
}

// EditRecordApi is an asynchronous function to edit records in the database the data passed to it should be in a json
// format
async function EditRecordApi(data) {
    // setup request link
    let request = "http://localhost:8081/api/v1/dbCrud/editRecords";
    // send API request with data using correct method
    let response = await fetch(request,
        {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
        });
    // check for API response error
    if (!(response.status >= 200 && response.status <= 299)) {
        return false;
    }
    return true;
}

// AddRecordApi is an asynchronous function to add records to the database
async function AddRecordApi(data) {
    // setup request link
    let request = "http://localhost:8081/api/v1/dbCrud/addRecord";
    // send API request with data using correct method
    let response = await fetch(request,
        {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(data)
        });
    // check for API response error
    if (!(response.status >= 200 && response.status <= 299)) {
        return false;
    }
    return true;
}

// CreateNewDatabaseViewRow should take a list of data and construct a html table row with the correct classes and
// styles applied
function CreateNewDatabaseViewRow(data) {
    // gets reference to table body element for appending rows to
    let tableBodyReference = document.getElementById("database-table-body");
    // create the new table row element
    let newRow = document.createElement("tr");

    // for each item in the record
    for (let cell of data) {
        let newCell = document.createElement("td");
        newCell.setAttribute("class", "mdl-data-table__cell--non-numeric");
        newCell.innerHTML = cell;
        newRow.appendChild(newCell);
    }
    newRow.appendChild(document.createRange().createContextualFragment(editButtonTableCell));
    newRow.appendChild(document.createRange().createContextualFragment(deleteButtonTableCell));
    newRow.appendChild(document.createRange().createContextualFragment(emailButtonTableCell));
    tableBodyReference.appendChild(newRow);
    SetupEditRecordPopup();
    SetupDeleteRecordButtons();
    SetupOTPButtons();
    return true;
}

// SearchDatabaseButton is called when the search database form is completed either by clicking the search button or
// by pressing enter whilst using the text box
function SearchDatabaseButton(){
    let form = document.getElementById("search-database-form");
    let textInput = document.getElementById("search-database-input");
    let dropdown = document.getElementById("search-database-dropdown");
    let button = document.getElementById("search-database-button");
    // check for empty input
    if (textInput.value === "") {
        form.classList.add("is-invalid");
        button.style.color = "#D50000";
        return false;
    }
    // if not empty then reset colours and proceed processing input
    //form.classList.remove("is-invalid");
    button.style.color = "#00BCD4";

    let searchValue = textInput.value;
    // remove info text if they perform a search
    let infoText = document.getElementById("search-database-info");
    infoText.innerHTML = loadingBar;

    GetRecordApi(searchValue).then(r => {
        infoText.innerHTML = "";
    });
}

// EditRecordSubmitButton is called when a record is edited, it collects the form data makes an api request and then
// shows a progress bar
function RecordSubmitButton(type){
    let formIds = ["schedOne","orgName","apfpRegs","notes","contactMethod","name","email"];
    let formData = [];
    // first push the id of the record being edited
    formData.push(beingEditedId);
    // for the id of each component in the form
    for (let formId of formIds) {
        if (type === "add"){
            formId = formId.concat("-add");
        }
        // get the element and its value
        formData.push(document.getElementById(formId).value);
    }

    // make api call with new data
    if (type === "edit"){
        EditRecordApi(formData);
    } else if (type === "add"){
        AddRecordApi(formData);
    }
    // close the popup
    let popup;
    if (type === "edit") {
        popup = document.getElementById("edit-record-popup");
        // update viewer
        GetRecordApi(mostRecentSearch);
    } else {
        popup = document.getElementById("add-record-popup");
    }
    popup.style.display = "none";

}

function SetupDeleteRecordButtons(){
    // Get the buttons that delete records
    let deleteBtn = document.getElementsByClassName("delete-button");
    // When the user clicks on the button, open the popup
    for (let i = 0; i < deleteBtn.length; i++) {
        deleteBtn[i].onclick = function () {
            // parse and collect the id of the record being deleted
            let tableRow = document.getElementById("database-table-body").querySelectorAll("tr")[i];
            let id = tableRow.querySelectorAll("td")[0];

            // Get the popup element
            let popup = document.getElementById("delete-record-popup");
            // Get the <button> element that closes the popup
            let closeBtn = document.getElementById("delete-record-close-popup-button");
            // Get the delete button
            let popupDeleteBtn = document.getElementById("delete-record-popup-button");

            popup.style.display = "block";
            popupDeleteBtn.onclick = function () {
                DeleteRecord(id, tableRow);
                popup.style.display = "none";
            }

            closeBtn.onclick = function () {
                popup.style.display = "none";
            }
        }
    }
}

function SetupOTPButtons(){
    // Get the buttons
    let emailBtn = document.getElementsByClassName("otp-button");
    // When the user clicks on the button, open the popup
    for (let i = 0; i < emailBtn.length; i++) {
        emailBtn[i].onclick = async function () {

            // parse and collect the id of the record
            let tableRow = document.getElementById("database-table-body").querySelectorAll("tr")[i];
            let id = tableRow.querySelectorAll("td")[0].innerText;

            // get value box to update
            let otpDisplayBox = document.getElementById("otp-code-display");

            // make api call
            let request = "http://localhost:8081/api/v1/dbCrud/getRecordPin/" + id;
            let response = await fetch(request);
            // check for API response error
            if (!(response.status >= 200 && response.status <= 299)) {
                return false;
            }
            otpDisplayBox.setAttribute("value", await response.text())

            // Get the popup element
            let popup = document.getElementById("otp-record-popup");
            // Get the <button> element that closes the popup
            let closeBtn = document.getElementById("otp-record-close-popup-button");

            popup.style.display = "block";
            closeBtn.onclick = function () {
                popup.style.display = "none";
            }
        }
    }
}

async function DeleteRecord(id, tableRow){
    // make API call
    let request = "http://localhost:8081/api/v1/dbCrud/deleteRecord/" + id.innerHTML;
    let response = await fetch(request,{
        method: "DELETE",
        headers: {"Content-Type": "application/json"},
    });
    // check for API response error
    if (!(response.status >= 200 && response.status <= 299)) {
        return false;
    }
    // delete record from search field
    tableRow.remove();
}