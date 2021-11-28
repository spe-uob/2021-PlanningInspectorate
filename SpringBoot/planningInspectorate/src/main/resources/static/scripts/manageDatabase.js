
let textFieldTemplate = `<form action="#">
                                <div class="mdl-textfield mdl-js-textfield">
                                    <input class="mdl-textfield__input" type="text" id="sample1">
                                    <label class="mdl-textfield__label" for="sample1">Txxt...</label>
                                </div>
                          </form>`;

function CreateTableRow(data) {
    let row = document.createElement("tr");
    for (let value of data) {
        let cell = document.createElement("td");
        cell.className = "mdl-data-table__cell--non-numeric";
        cell.innerHTML = value;
        row.appendChild(cell);
    }
    return row;
}


function SetupEditRecordPopup() {
// Get the popup element
    let popup = document.getElementById("edit-record-popup");
// Get the buttons that open the popup
    let openBtn = document.getElementsByClassName("dialog-button");
// Get the <button> element that closes the popup
    let closeBtn = document.getElementById("close-popup-button");
// When the user clicks on the button, open the popup
    for (let i = 0; i < openBtn.length; i++) {
        openBtn[i].onclick = function () {
            // display popup
            popup.style.display = "block";

            let popupTableBody = document.getElementById("popup-table-body");
            popupTableBody.innerHTML = "";


            let firstColumn = [];
            // get column names for the table
            let tableHead = document.getElementById("database-table-head");
            for (let heading of tableHead.querySelectorAll("th")){
                // if header isn't blank
                if (heading.innerHTML !== "") {
                    firstColumn.push(heading.innerHTML);
                }
            }

            let secondColumn = [];
            let tableRow = document.getElementById("database-table-body").querySelectorAll("tr")[i];
            for (let dataCell of tableRow.querySelectorAll("td")){
                secondColumn.push(dataCell.innerHTML);
            }

            for (let j = 0; j < firstColumn.length; j++) {
                popupTableBody.appendChild(CreateTableRow([firstColumn[j], secondColumn[j]]));
            }
        }
    }
    closeBtn.onclick = function () {
        popup.style.display = "none";
    }
}

SetupEditRecordPopup();
