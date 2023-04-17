let dashboardContent = document.querySelector('.dashboard-content');
let menuItems = document.querySelectorAll('.nav-links li a');
let button = document.querySelector('#updateDeadlineId')

const updateDashboardContent = (url) => {
    let httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200)
            dashboardContent.innerHTML = this.responseText;
    };
    httpRequest.open("get", url, true);
    httpRequest.send();
};

menuItems.forEach(menuItem => {
    menuItem.addEventListener("click", (event) => {
        event.preventDefault();
        updateDashboardContent(menuItem.href);
    });
});

button.addEventListener("click", (event) => {
    event.preventDefault();
    dashboardContent.innerHTML = "";
    dashboardContent.style.display = "block";
    updateDashboardContent(button.href)
})