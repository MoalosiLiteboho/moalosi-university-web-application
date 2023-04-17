function refreshTable() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            const newData = JSON.parse(this.responseText);
            var table = document.getElementById("dataTable");
            table.innerHTML = "";
            newData.forEach(function(row) {
                var tableRow = document.createElement("tr");
                var cell = document.createElement("td");
                cell.innerText = row;
                tableRow.appendChild(cell);
                table.appendChild(tableRow);
            });
        }
    };
    xhttp.open("GET", "data", true);
    xhttp.send();
}

document.getElementById("refreshButton").addEventListener("click", refreshTable);
