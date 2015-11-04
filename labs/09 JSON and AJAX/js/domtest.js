/**
 * Created with Web-tekniikat.
 * User: joseu
 * Date: 2015-11-04
 * Time: 12:52 PM
 */
var window, document;
window.onload = function () {
    "use strict";
    var list = document.createElement("ul");
    var i, item;
    for(i = 1; i <= 5; i += 1) {
        item = document.createElement("li");
        item.innerHTML = "List item #" + i;
        list.appendChild(item);
    }
    document.body.appendChild(list);
};