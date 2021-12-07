


// drag and drop element for edit button at the end of each table row
const editButtonTableCell = '<td><button class="dialog-button mdl-button mdl-js-button mdl-button--icon">\n' +
    '                            <i class="material-icons">edit</i>\n' +
    '                        </button></td>';

const loadingBar = '<div id="p2" class="mdl-progress mdl-js-progress mdl-progress__indeterminate"></div>'

// SearchDatabase is an asynchronous function to search database and update results
async function GetRecordApi(searchTerm) {
    // make API call
    let request = "http://localhost:8081/api/v1/dbCrud/getRecords/" + searchTerm;
    let response = await fetch(request);
    // check for API response error
    if (!(response.status >= 200 && response.status <= 299)) {
        console.log(response.status, response.statusText);
        return false;
    }
    // await response and retrieve json list of records
    let data = await response.json();
    console.log(data);
    // retrieve and clear table body
    let tableBodyReference = document.getElementById("database-table-body");
    while (tableBodyReference.firstChild){
        tableBodyReference.removeChild(tableBodyReference.firstChild);
    }
    // update table body with new records
    //for (let record of data) {
    //    CreateNewDatabaseViewRow(record)
    //}
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
        body: data.toJSON()
        });
    // check for API response error
    if (!(response.status >= 200 && response.status <= 299)) {
        console.log(response.status, response.statusText);
        return false;
    }
    return true;
}

// AddRecordApi is an asynchronous function to add records to the database
async function AddRecordApi(data) {
    // setup request link
    let request = "http://localhost:8081/api/v1/dbCrud/addRecords";
    // send API request with data using correct method
    let response = await fetch(request,
        {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: data.toJSON()
        });
    // check for API response error
    if (!(response.status >= 200 && response.status <= 299)) {
        console.log(response.status, response.statusText);
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
        newCell.innerHTML = cell;
        newRow.appendChild(newCell);
    }
    newRow.appendChild(document.createRange().createContextualFragment(editButtonTableCell));
    tableBodyReference.appendChild(newRow);
    return true;
}

// SearchDatabaseButton is called when the search database form is completed either by clicking the search button or
// by pressing enter whilst using the text box
function SearchDatabaseButton(){
    let form = document.getElementById("search-database-form");
    let textInput = document.getElementById("search-database-input");
    let button = document.getElementById("search-database-button");
    // check for empty input
    if (textInput.value === "") {
        form.classList.add("is-invalid");
        button.style.color = "#D50000";
        return false;
    }
    // if not empty then reset colours and proceed processing input
    form.classList.remove("is-invalid");
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
    // for the id of each component in the form
    for (let formId of formIds) {
        if (type === "add"){
            formId = formId.concat("-add");
        }
        // get the element and its value
        let formInput = document.getElementById(formId).value;
        if (formInput === "") {
            // if the value is empty then send null
            if (type === "edit") {
                formData.push("null");
            }
        } else {
            // else push the new value
            formData.push(formInput);
        }
    }

    // display loading bar and hide buttons
    let saveButton = document.getElementById("save-edit-record-button");
    let closeButton = document.getElementById("close-popup-button");
    let loadingBar = document.getElementById("edit-record-loading-bar");
    loadingBar.style.display = "block";
    saveButton.style.display = "none";
    closeButton.style.display = "none";

    // todo make api call with new data
    if (type === "edit"){
        EditRecordApi(formData);
    } else if (type === "add"){
        AddRecordApi(formData);
    }

    // hide popup and reset loading bar and buttons
    loadingBar.style.display = "none";
    let popup = document.getElementById("edit-record-popup");
    saveButton.style.display = "block";
    closeButton.style.display = "block";
    popup.style.display = "none";

}
