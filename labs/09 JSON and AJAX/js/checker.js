/**
 * Created with Web-tekniikat. User: joseu Date: 2015-11-04 Time: 02:32 PM
 */
var document, console, window, httpRequest;

function showStatus() {
	"use strict";
	console.log("Ready state: " + httpRequest.readyState);
	if (httpRequest.readyState === 4) {
		console.log("Alerting!");
		if (httpRequest.status === 404) {
			alert("Site is down or doesn't exists.");
		} else {
			alert("Site is up. (" + httpRequest.status + ")");
		}
	} else {
		console.log("Not ready yet!");
	}
}

function makeRequest(url) {
	"use strict";
	console.log("Making a request...");
	if (window.XMLHttpRequest) { // Mozilla, Safari, ...
		httpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE
		try {
			httpRequest = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (ex) {
			console.log(ex.name + ": " + ex.message);
			try {
				httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (ex2) {
				alert(ex2);
			}
		}
	}
	if (!httpRequest) {
		alert("Giving up. Cannot create an XMLHTTP instance");
		return false;
	}
	// Callback function on complete
	httpRequest.onreadystatechange = showStatus;
	// AJAX request
	console.log("Sending GET...");
	httpRequest.open("GET", url);
	httpRequest.send();
	return false;
}

function check() {
	"use strict";
	var testUrl = "http://cors.io/?u=" + document.getElementById('urlBox').value;
	console.log("Checking URL: " + testUrl);
	makeRequest(testUrl);
	console.log("Request made.");
}
window.onload = function() {
	"use strict";
	document.getElementById('main').onsubmit = check;
	console.log("Assigned function to submit button.");
};