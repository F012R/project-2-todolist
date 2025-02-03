<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="todo.dao.*" %>
<%@ page import="todo.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	@ SuppressWarnings("unchecked")
    List<TodoDto> todos = (List<TodoDto>)request.getAttribute("todos");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main todo list</title>
<link href="css/styles.css" rel="stylesheet"/>

</head>
<body>

	<main>
		<div class="txt-works">나의 해야할 일들</div>
  		<div class="block-btn">
      		<button type="button" class="btn-create" onclick="location.href='/todo/todoform'">새로운 TODO 등록</button>      
    	</div>
    	<div class="todo-container">
		    <section class="todo-section">
		    	<div class="col-name">TODO</div>
				<c:forEach items="${todos }" var="todo">
					<c:if test="${todo.type eq 'TODO' }">					
						<article data-type="${todo.type }" data-id="${todo.id }" data-regDate="${todo.regDate}">
							<h3 class="block-title">${todo.title }</h3>
							<div class="block-info">							
								등록날짜: 
<!-- 							regDate format 후 출력하기: yyyy.MM.dd 형식  -->
								<fmt:parseDate value="${fn:substringBefore(todo.regDate, '.')}" var="fmtRegDate" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate pattern="yyyy.MM.dd" value="${fmtRegDate}" />, 
								${todo.name }, 
								우선순위: ${todo.sequence } 
								<span class="todo-id" style="display: none">${todo.id }</span>
								<button class="btn-move">→</button>			
							</div>
						</article>
					</c:if>
				</c:forEach>
			</section>
		   <section class="doing-section">
		      <div class="col-name">DOINIG</div>
				<c:forEach items="${todos }" var="todo">
					<c:if test="${todo.type eq 'DOING' }">
						<article data-type="${todo.type }" data-id="${todo.id }"  data-regDate="${todo.regDate}" >
							<h3 class="block-title">${todo.title }</h3>
							<div class="block-info">
								등록날짜: 
<!-- 							regDate format 후 출력하기: yyyy.MM.dd 형식  -->
								<fmt:parseDate value="${fn:substringBefore(todo.regDate, '.')}" var="fmtRegDate" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate pattern="yyyy.MM.dd" value="${fmtRegDate}" />, 
								${todo.name }, 
								우선순위: ${todo.sequence } 
								<button class="btn-move">→</button>			
							</div>				
						</article>
					</c:if>
				</c:forEach>
			</section>		
		   <section class="done-section">
		   		<div class="col-name">DONE</div>
				<c:forEach items="${todos }" var="todo">
					<c:if test="${todo.type eq 'DONE' }">
						<article data-type="${todo.type }" data-id="${todo.id }"  data-regDate="${todo.regDate}">
							<h3 class="block-title">${todo.title }</h3>
							<div class="block-info">
								등록날짜: 
<!-- 							regDate format 후 출력하기: yyyy.MM.dd 형식  -->
								<fmt:parseDate value="${fn:substringBefore(todo.regDate, '.')}" var="fmtRegDate" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate pattern="yyyy.MM.dd" value="${fmtRegDate}" />, 
								${todo.name }, 
								우선순위: ${todo.sequence } 
							</div>
						</article>
					</c:if>
				</c:forEach>
			</section>	
		</div>
	</main>		
</body>
</html>