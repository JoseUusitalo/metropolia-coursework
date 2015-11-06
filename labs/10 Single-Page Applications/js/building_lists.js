"use strict";
var console, document, i, row, title, year, isbn, author, sectionHead, sectionBody;
var request = new XMLHttpRequest();
request.open('GET', 'data/books.json', false);
request.send(null);
var data = JSON.parse(request.responseText);
var books = data.books;
var table = document.createElement('table');
for (i = -1; i < books.length; i += 1) {
	row = document.createElement("tr");
	row.onclick = function() {
		var p = document.querySelector("p");
		if (!p) {
			p = document.createElement("p");
			var div = document.createElement("div");
			div.appendChild(p);
			document.body.insertBefore(div, document.body.firstChild);
		}
		p.innerHTML = this.childNodes[0].innerHTML;

	};
	if (i < 0) {
		row = document.createElement("tr");
		sectionHead = document.createElement("thead");
		table.appendChild(sectionHead);
		title = document.createElement("th");
		title.innerHTML = "Title";
		row.appendChild(title);
		year = document.createElement("th");
		year.innerHTML = "Year";
		row.appendChild(year);
		isbn = document.createElement("th");
		isbn.innerHTML = "ISBN";
		row.appendChild(isbn);
		author = document.createElement("th");
		author.innerHTML = "Authors";
		row.appendChild(author);
		sectionHead.appendChild(row);
		sectionBody = document.createElement("tbody");
		table.appendChild(sectionBody);
	} else {
		title = document.createElement("td");
		title.innerHTML = books[i].title;
		row.appendChild(title);
		year = document.createElement("td");
		year.innerHTML = books[i].year;
		row.appendChild(year);
		isbn = document.createElement("td");
		isbn.innerHTML = books[i].isbn;
		row.appendChild(isbn);
		author = document.createElement("td");
		author.innerHTML = books[i].authors;
		row.appendChild(author);
		sectionBody.appendChild(row);
	}
}
document.body.appendChild(table);