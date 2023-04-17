let Navigation_Bar = document.getElementById("Navigation_ID");
let Menu = document.getElementById("Menu_ID");

window.onscroll = function () {
    if (window.pageYoffset >= Menu.offsetTop) Navigation_Bar.classList.add("sticky");
    else Navigation_Bar.classList.remove("sticky");
}