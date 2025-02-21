<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>나의 해야할 일들</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<body>
<button class="register-btn" onclick="location.href='/todo-form'">새로운 TODO 등록</button>
<div class="container">
    <div class="column" id="TODO">
        <div class="category">
            <h2>TODO</h2>
        </div>
        <c:forEach var="todoTask" items="${todoList}">
            <div class="task" id="task-${todoTask.getId()}">
                <p class="task-name">${todoTask.getTitle()}</p>
                <p class="task-description">등록날짜: ${todoTask.getRegDate()}, ${todoTask.getName()}, 우선순위 ${todoTask.getSequence()}</p>
                <button class="arrow-button" onclick="moveTask(${todoTask.getId()})">→</button>
            </div>
        </c:forEach>
    </div>
    <div class="column" id="DOING">
        <div class="category">
            <h2>DOING</h2>
        </div>
        <c:forEach var="doingTask" items="${doingList}">
            <div class="task" id="task-${doingTask.getId()}">
                <p class="task-name">${doingTask.getTitle()}</p>
                <p class="task-description">등록날짜: ${doingTask.getRegDate()}, ${doingTask.getName()}, 우선순위 ${doingTask.getSequence()}</p>
                <button class="arrow-button" onclick="moveTask(${doingTask.getId()})">→</button>
            </div>
        </c:forEach>
    </div>
    <div class="column" id="DONE">
        <div class="category">
            <h2>DONE</h2>
        </div>
        <c:forEach var="doneTask" items="${doneList}">
            <div class="task" id="task-${doneTask.getId()}">
                <p class="task-name">${doneTask.getTitle()}</p>
                <p class="task-description">등록날짜: ${doneTask.getRegDate()}, ${doneTask.getName()}, 우선순위 ${doneTask.getSequence()}</p>
            </div>
        </c:forEach>
    </div>
</div>

<script>
    function moveTask(taskId) {
        const taskElement = document.getElementById("task-" + taskId);
        var targetListElement = null;
        var targetColumn = null;
        console.log(taskId, "task-" + taskId);

        if (taskElement) {
            if (taskElement.parentElement.id == "TODO") {
                targetListElement = document.getElementById("DOING");
                targetColumn = "DOING";
            } else if (taskElement.parentElement.id == "DOING") {
                targetListElement = document.getElementById("DONE");
                targetColumn = "DONE";
                taskElement.removeChild(taskElement.lastElementChild)
            }
            targetListElement.appendChild(taskElement);

            const xhr = new XMLHttpRequest();
            xhr.open('POST', '/', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send("taskId=" + taskId + "&targetColumn=" + targetColumn);
        }
    }
</script>
</body>
</html>
