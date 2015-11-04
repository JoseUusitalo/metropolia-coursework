// tasks.js
// This script manages a to-do list.
// Need a global variable:
var tasks = [];
// Function called when the form is submitted.
// Function adds a task to the global array.

function updateList() {
    var output = document.getElementById('output');
    // Update the page:
    message = '<h2>To-Do</h2><ol>';
    for(var i = 0, count = tasks.length; i < count; i++) {
        message += '<li>' + tasks[i] + '</li>';
    }
    message += '</ol>';
    output.innerHTML = message;
}

function addTask() {
    'use strict';
    // Get the task:
    var task = document.getElementById('task');
    // Reference to where the output goes:
    // For the output:
    var message = '';
    if(task.value) {
        // Add the item to the array:
        tasks.push(task.value);
        updateList();
    } // End of task.value IF.
    // Return false to prevent submission:
    return false;
} // End of addTask() function.

function removeDuplicates() {
    var iCurrent;
    var iNext;
    for(iCurrent = 0; iCurrent < tasks.length; iCurrent += 1) {
        console.log("Current list: " + tasks);
        console.log("Checking duplicates for: " + tasks[iCurrent] + " at id " + iCurrent);
        // Do nothing at the end of the loop, increment ID manually only when the items DO NOT match.
        for(iNext = iCurrent + 1; iNext < tasks.length;) {
            console.log("Checking id " + iNext);
            if(tasks[iCurrent] === tasks[iNext]) {
                tasks.splice(iNext, 1);
                console.log("Duplicate removed at at id " + iNext);
            } else {
                iNext += 1;
            }
        }
    }
    updateList();
}
// Initial setup:

function init() {
    'use strict';
    document.getElementById('theForm').onsubmit = addTask;
    document.getElementById('removeDuplicates').onclick = removeDuplicates;
} // End of init() function.
window.onload = init;