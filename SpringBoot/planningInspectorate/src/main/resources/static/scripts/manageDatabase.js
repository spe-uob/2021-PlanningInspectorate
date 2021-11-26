// Get the modal
var modal = document.getElementById("edit-record-popup");

// Get the button that opens the modal
var openBtn = document.getElementsByClassName("dialog-button");

// Get the <span> element that closes the modal
var closeBtn = document.getElementById("close-popup-button");

// When the user clicks on the button, open the modal
for (let i = 0; i < openBtn.length; i++) {
    openBtn[i].onclick = function () {
        modal.style.display = "block";
    }
}

closeBtn.onclick = function() {
    modal.style.display = "none";
}