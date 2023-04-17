let fileInput = document.getElementById("file-input-Id");
let fileList = document.getElementById("file-list");
let numberOfFiles = document.getElementById("number-of-files");


fileInput.addEventListener("change", () => {
    fileList.innerHTML = "";
    numberOfFiles.textContent = `${fileInput.files.length} Files selected`;

    for(index of fileInput.files) {
        let reader = new FileReader();
        let listItem = document.createElement("li");
        let fileName = index.name;
        let fileSize = (index.size /1024).toFixed(1);
        listItem.innerHTML = "<p>" + fileName + "</p><p>" + fileSize + " Kb</p>";
        if(fileSize > 1024){
            fileSize = (fileSize / 1024).toFixed(1);
            listItem.innerHTML = "<p>" + fileName + "</p><p>" + fileSize + " Mb</p>";
        }
        fileList.append(listItem)
    }
})