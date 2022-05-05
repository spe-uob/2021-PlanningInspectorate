// 2 possible use cases for site, entering pin and editing record
const PIN_ENTRY_CONTAINER = document.getElementById("otp-submission-container");
const RECORD_EDIT_CONTAINER = document.getElementById("record-edit-container");
let currentOTP = "";

// HELPER FUNCTIONS
// UpdateFormWithPreviousValues takes a list of previous values and inserts them into the value text on the form
function UpdateFormWithPreviousValues(form ,previousValues) {
    // for each child element of the form (can be label, input or textarea)
    form.reset();
    console.log("prev: ",previousValues[2]);
    let count = 1;
    for (let i = 0; i < form.childNodes.length; i++) {
        {
            // if input or textarea
            if (form.childNodes[i].tagName === "INPUT") {
                // set value text to previous value
                form.childNodes[i].setAttribute("value", previousValues[count]);
                count++;
            } else if (form.childNodes[i].tagName === "TEXTAREA") {
                form.childNodes[i].innerHTML = previousValues[count];
                count++;
            }
        }
    }
}

async function SubmitOtp(){
    // one time pin is below
    let otp = document.getElementById("otpEntry").value;
    // make api call to verify otp exists
    let request = "http://localhost:8081/api/v1/dbCrud/verifyOTP/" + otp;
    let response = await fetch(request);
    // check for API response error
    if (!(response.status >= 200 && response.status <= 299)) {
        return false;
    }

    // verify otp
    let validPin = response.text();
    if (!validPin) {
        alert("The pin you have entered is invalid, please ensure it is typed correctly");
        return;
    }

    // hide this reveal other
    PIN_ENTRY_CONTAINER.setAttribute("style","display: none;")
    RECORD_EDIT_CONTAINER.setAttribute("style","display: flex;")
    currentOTP = otp;

    // request previous record values from API
    request = "http://localhost:8081/api/v1/dbCrud/getRecordFromOTP/" + otp;
    response = await fetch(request);
    // check for API response error
    if (!(response.status >= 200 && response.status <= 299)) {
        return false;   
    }
    // await response and retrieve json list of records
    console.log(response.body);
    let jsonVals = await response.json();
    console.log(jsonVals);
    let oldData = [];
    let keys = Object.keys(jsonVals);
    keys.forEach(function(key){
        oldData.push(jsonVals[key]);
    });

    // populate record edit container with correct values
    let otpRecordForm = document.getElementById("otp-edit-record");
    console.log("json: ",oldData);
    UpdateFormWithPreviousValues(otpRecordForm, oldData);
}

function RecordUpdateOnClick(){
    let formIds = ["schedOne","orgName","apfpRegs","notes","contactMethod","name","email"];
    let formData = [];
    // first push the id of the record being edited
    formData.push(currentOTP);
    // for the id of each component in the form
    for (let formId of formIds) {
        // get the element and its value
        formData.push(document.getElementById(formId).value);
    }
    // call api request
    SubmitRecordUpdates(formData);
    alert("data submitted for review, thank you for using the service");
    PIN_ENTRY_CONTAINER.setAttribute("style","display: flex;")
    RECORD_EDIT_CONTAINER.setAttribute("style","display: none;")
    currentOTP = "";
}

async function SubmitRecordUpdates(data){
    // setup request link
    let request = "http://localhost:8081/api/v1/dbCrud/updateOtp";
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