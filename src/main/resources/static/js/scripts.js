var openButtons = new Array()
var modals = new Array()
var closeButtons = new Array()
for (var i = 0; i < 5; i++) {
    var openButton = document.getElementById("open" + (i + 1));
    openButtons.push(openButton)

    var modal = document.getElementById("project-modal" + (i + 1));
    modals.push(modal)

    var closeButton = modal.querySelector("button");
    closeButtons.push(closeButton)
}

const overlay = modal.querySelector(".md_overlay");


//동작함수
const openModal = () => {
    modal.classList.remove("hidden");
}
const closeModal = () => {
    modal.classList.add("hidden");
}
//클릭 이벤트
for (var i = 0; i < 5; i++) {
    openButtons[i].addEventListener("click", openModal);
    closeButtons[i].addEventListener("click", closeModal);
}