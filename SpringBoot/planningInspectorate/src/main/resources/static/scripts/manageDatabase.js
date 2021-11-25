(function() {
    'use strict';
    var dialog = document.querySelector('#edit-record-dialog');

    var dialogButtons = document.querySelectorAll('.dialog-button');

    for (var i = 0, len = dialogButtons.length; i < len; i++) {

        if (!dialog.showModal) {
            dialogPolyfill.registerDialog(dialog);
        }
        dialogButtons[i].addEventListener('click', function () {
            dialog.showModal();
        });
        dialog.querySelector('button:not([disabled])')
            .addEventListener('click', function () {
                dialog.close();
            });
    }
}());