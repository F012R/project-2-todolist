<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo List</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <section class="todo-container">
        <header>
            <h1 class="page-title">나의 해야 할 일들</h1>
        </header>
        <div class="add-todo-container">
    		<div class="add-todo" onclick="location.href='./TodoFormServlet'">새로운 TODO 등록</div>
		</div>
        <div class="todo-box">
            <c:forEach var="type" items="${todoTypes}">
                <section class="todo-section" id="${type}">
                    <div class="list-header">${type}</div>
                    <c:forEach var="list" items="${todoList}">
                        <c:if test="${list.type eq type}">
                            <div class="todo-item">
                                <h2 class="todo-title">${list.title}</h2>
                                
                                <div class="todo-meta">
                                	<p class="todo-details">등록날짜: ${list.regdate}, ${list.name}, 우선순위 ${list.sequence}</p>
                                	<c:if test="${list.type ne 'DONE'}">
                                    	<button class="change-btn" onclick="changeButtonClick(${list.id}, this)">→</button>
                                	</c:if>
                                	
                                </div>
                                
                            </div>
                        </c:if>
                    </c:forEach>
                </section>
            </c:forEach>
        </div>
    </section>
    <script src="javascript/main.js"></script>
</body>
</html>
