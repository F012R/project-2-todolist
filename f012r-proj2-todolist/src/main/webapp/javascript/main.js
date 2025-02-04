function changeButtonClick(id, node) {
    let type = node.closest("section").getAttribute("id");  // 부모 section의 id를 가져옴

    let httpRequest = new XMLHttpRequest();
    
    httpRequest.addEventListener("load", function() {
        if (this.responseText === "success") {
            // 상태를 변경한 후 화면에서 해당 항목을 이동
            change(type, node);
        } else {
            console.log("Failed to update status");
        }
    });
    
    // 서버에 상태 변경 요청을 보냄
    httpRequest.open("GET", "./TodoTypeServlet?id=" + id + "&type=" + type);
    httpRequest.send();
}

function change(type, node) {
    let todoItem = node.closest(".todo-item");  // 클릭한 버튼의 가장 가까운 .todo-item을 찾음
    let title = todoItem.querySelector(".todo-title");  // todo-title 요소를 가져옴

    // 상태에 따라 새로운 상태로 설정
    if (type == "TODO") {
        type = 'DOING';
    } else if (type == "DOING") {
        type = 'DONE';
        
        // 버튼을 숨기는 방식으로 처리
        let button = todoItem.querySelector(".change-btn");
        if (button) {
            button.style.display = "none";  // 버튼을 화면에서 숨김
        }
    }

    // 상태에 맞는 섹션을 찾음
    let list = document.querySelector("section[id=" + type + "]");

    // 해당 섹션이 있으면 항목을 추가
    if (list) {
        list.appendChild(todoItem);  // todo-item을 해당 section에 추가
        // 추가된 todo-item을 보이게 하기 위해 강제로 스크롤을 이동
        list.scrollTop = list.scrollHeight;
    } else {
        console.log("Couldn't find section with id:", type);
    }
}
