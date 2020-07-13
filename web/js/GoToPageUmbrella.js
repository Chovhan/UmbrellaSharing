let infoButton = document.getElementById("#infobtn");
infoButton.addEventListener("click", function() {
    window.location.href = "http://localhost:8080/UserInformation";
});

let umbrellaSharingButton = document.getElementById("#sharingbtn");
umbrellaSharingButton.addEventListener("click", function() {
    window.location.href = "http://localhost:8080/AddSharingPoint";
});

let umbrellaInstanceButton = document.getElementById("#umbrellabtn");
umbrellaInstanceButton.addEventListener("click", function() {
    window.location.href = "http://localhost:8080/AddUmbrella";
});

let addUmbrellaButton = document.getElementById("#addbtn");
addUmbrellaButton.addEventListener("click", function() {
    window.location.href = "http://localhost:8080/AddUmbrella";
});

let deleteUmbrellaButton = document.getElementById("#deletebtn");
deleteUmbrellaButton.addEventListener("click", function() {
    window.location.href = "http://localhost:8080/DeleteUmbrella";
});