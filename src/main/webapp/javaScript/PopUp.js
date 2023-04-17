let dashboardContent = document.querySelector(".dashboard-content");

document.querySelector("#add-user-id").addEventListener("click", () => {
    dashboardContent.classList.add("active-popup");
});

document.querySelector(".pop-up .closing-button").addEventListener("click", () => {
    dashboardContent.classList.remove("active-popup");
});