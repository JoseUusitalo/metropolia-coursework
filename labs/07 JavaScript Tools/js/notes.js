"use strict";
var notes = [];
var textbox;
var document;
var button;
var console;
var localStorage;

function displayList() {
    var table = document.getElementById('list');
    var i;
    var html;
    var node;
    var note;
    table.innerHTML = '';
    for(i = 0; i < notes.length; i += 1) {
        note = notes[i];
        node = document.createElement('tr');
        html = '<td>' + note.title + '</td><td>' + note.quantity + '</td><td><a href="#" onClick="deleteIndex(' + i + ')">delete</td>';
        node.innerHTML = html;
        table.appendChild(node);
    }
}

function addItem() {
    textbox = document.getElementById('item');
    var itemText = textbox.value;
    var old = false;
    textbox.value = '';
    textbox.focus();
    var i;
    for(i = 0; i < notes.length; i += 1) {
        if(notes[i].title === itemText) {
            notes[i].quantity += 1;
            old = true;
            break;
        }
    }
    if(!old) {
        var newItem = {
            title: itemText,
            quantity: 1
        };
        notes.push(newItem);
    }
    displayList();
}

function deleteIndex(i) {
    notes.splice(i, 1);
    displayList();
}

function saveList() {
    localStorage.notes = JSON.stringify(notes);
}

function loadList() {
    console.log('loadList');
    if(localStorage.notes) {
        notes = JSON.parse(localStorage.notes);
        displayList();
    }
}
button = document.getElementById('add');
button.onclick = addItem;