// 2 possible use cases for site, entering pin and editing record
const PIN_ENTRY_CONTAINER = document.getElementById("otp-submission-container");
const RECORD_EDIT_CONTAINER = document.getElementById("record-edit-container");

// HELPER FUNCTIONS
// UpdateFormWithPreviousValues takes a list of previous values and inserts them into the value text on the form
function UpdateFormWithPreviousValues(form ,previousValues) {
    // for each child element of the form (can be label, input or textarea)
    form.reset();
    let count = 0;
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

    // request previous record values from API
    request = "http://localhost:8081/api/v1/dbCrud/getRecordFromOTP/" + otp;
    response = await fetch(request);
    // check for API response error
    if (!(response.status >= 200 && response.status <= 299)) {
        return false;
    }
    // await response and retrieve json list of records
    let oldData = await response.json();

    // populate record edit container with correct values

}