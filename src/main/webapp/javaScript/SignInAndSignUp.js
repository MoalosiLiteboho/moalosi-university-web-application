let SignInButton = document.querySelector('.signInButton');
let SignUpButton = document.querySelector('.signUpButton');
let Form_Box = document.querySelector('.Form_Box');
let Body = document.querySelector('body');

SignUpButton.onclick = function () {
    Form_Box.classList.add('active');
    Body.classList.add('active');
}

SignInButton.onclick = function () {
    Form_Box.classList.remove('active');
    Body.classList.remove('active');
}