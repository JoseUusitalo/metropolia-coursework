console.log(document);
document.querySelector('#userForm input[type="text"]').onkeyup = function () {
    var name = document.querySelector('#userForm input[type="text"]');
    document.querySelector('#summary h1').innerHTML = name.value;
};
document.querySelector('#userForm input[type="password"]').onkeyup = function () {
    var password = document.querySelector('#userForm input[type="password"]');
    document.querySelectorAll('#summary p')[1].innerHTML = password.value;
};
document.querySelector('#userForm input[type="email"]').onkeyup = function () {
    var email = document.querySelector('#userForm input[type="email"]').value;
    document.querySelector('#summary p').innerHTML = email;
};