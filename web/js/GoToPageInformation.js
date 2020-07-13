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

let userInfoButton = document.getElementById("#userbtn");
userInfoButton.addEventListener("click", function() {
    window.location.href = "http://localhost:8080/UserInformation";
});

let pointInfoButton = document.getElementById("#pointbtn");
pointInfoButton.addEventListener("click", function() {
    window.location.href = "http://localhost:8080/SharingPointInformation";
});
