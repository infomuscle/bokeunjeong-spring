var openButtons = new Array()
var modals = new Array()
var closeButtons = new Array()

var modalSize = document.getElementsByClassName("project-modal").length;
for (var i = 0; i < modalSize; i++) {
    var openButton = document.getElementById("open" + (i + 1));
    openButtons.push(openButton)

    var modal = document.getElementById("project-modal" + (i + 1));
    modals.push(modal)

    var closeButton = modal.querySelector("button");
    closeButtons.push(closeButton)
}

var openModal = (idx) => {
    modals[idx - 1].classList.remove("hidden");
}
var closeModal = (idx) => {
    modals[idx - 1].classList.add("hidden");
}
var dropDown = () => {
    var navbarResponsive = document.getElementById("navbarResponsive");
    navbarResponsive.classList.toggle("show");
}