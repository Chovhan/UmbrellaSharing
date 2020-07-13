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

let addPointButton = document.getElementById("#addpointbtn");
addPointButton.addEventListener("click", function() {
    window.location.href = "http://localhost:8080/AddSharingPoint";
});

let deletePointButton = document.getElementById("#deletepointbtn");
deletePointButton.addEventListener("click", function() {
    window.location.href = "http://localhost:8080/DeleteSharingPoint";
});

let closePointButton = document.getElementById("#changepointbtn");
closePointButton.addEventListener("click", function() {
    window.location.href = "http://localhost:8080/ChangeSharingPointAvailability";
});
