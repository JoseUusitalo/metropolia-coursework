// contact.js
// This script checks a contact form submission for HTML and a valid email address.
// Function called when the form is submitted.
// Function validates the data and returns a Boolean. (Logs to console in this example)
/*global alert */
var document;
var console;
var window;

function process() {
    'use strict';
    // Variable to represent validity:
    var i;
    var okay = true;
    var nameOK = true;
    // Get form references:
    var sFullName = document.getElementById('fullName');
    var email = document.getElementById('email');
    var comments = document.getElementById('comments');
    // Split name into array.
    var parts = sFullName.value.split(" ");
    console.log("parts: " + parts + " | " + parts.length);
    // Check for double and trailing spaces.
    for(i = 0; i < parts.length; i = +1) {
        if(!parts[i]) {
            console.log("Empty name part!");
            nameOK = false;
            break;
        }
    }
    // Validate the name:
    if(!sFullName || !sFullName.value || (sFullName.value.length < 3) || (sFullName.value.length > 100) || (sFullName.value.indexOf(' ') === -1) || parts.length < 2 || !nameOK) {
        okay = false;
        alert('Please enter your first name and last name separated with a space! (Must be between 3-100 characters long and must not contain double or trailing spaces..)');
    }
    // Validate the email address:
    if(!email || !email.value || (email.value.length < 6) || (email.value.indexOf('@') === -1)) {
        okay = false;
        alert('Please enter a valid email address!');
    }
    // Validate the comments:
    var maxLength = 100;
    if(!comments || !comments.value || (comments.value.indexOf('<') !== -1)) {
        okay = false;
        alert('Please enter your comments, without any HTML!');
    } else if(comments.value.length > maxLength) {
        okay = false;
        var originalText = comments.value;
        // Find the last space before the limit:
        var lastSpace = originalText.lastIndexOf(' ', maxLength);
        // Trim the text to that spot:
        var limitedText = originalText.slice(0, lastSpace);
        comments.value = limitedText;
        okay = true;
        alert('Comment was trimmed under ' + maxLength + ' characters');
    }
    // Normally you would "return okay;" here to submit/block the form submission
    // return okay;
    // For this example we alert the user and log details to the console
    var message;
    if(okay) {
        message = "Form submitted";
    } else {
        message = "Form not submitted";
    }
    console.log(message);
    console.log("Full Name: " + sFullName.value);
    console.log("Email: " + email.value);
    console.log("Comments: " + comments.value);
    alert(message);
    // Prevent submission for the purposes of this example:
    return false;
} // End of process() function.
// Initial setup:

function init() {
    'use strict';
    document.getElementById('theForm').onsubmit = process;
} // End of init() function.
window.onload = init;