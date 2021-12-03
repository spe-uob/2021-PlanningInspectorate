
// drag and drop element for edit button at the end of each table row
const editButtonTableCell = '<td><button class="dialog-button mdl-button mdl-js-button mdl-button--icon">\n' +
    '                            <i class="material-icons">edit</i>\n' +
    '                        </button></td>';


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
    console.log(newRow);
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
    console.log(searchValue);

}


function ProcessEditRecordForm(){
    // todo

}