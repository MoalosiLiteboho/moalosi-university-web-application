let sideBar = document.querySelector("nav"),
    sideBarToggle = document.querySelector(".sidebar-toggle");

sideBarToggle.addEventListener("click", () => {
    sideBar.classList.toggle("close");
});