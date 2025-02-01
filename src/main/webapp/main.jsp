<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="todo.dao.*" %>
<%@ page import="todo.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	@ SuppressWarnings("unchecked")
    List<TodoDto> todos = (List<TodoDto>)request.getAttribute("todos");
	// todo table 결과 객체 담기 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main todo list</title>
</head>
<body>

  <main>
    <div class="block-btn">
      <button type="button" onclick="location.href='/todo/todoform'">새로 만들기</button>      
    </div>
    <section class="todo">
    	<div class="col-name">TODO</div>
		<c:forEach items="${todos }" var="todo">
			<c:if test="${todo.type eq 'TODO' }">
			
				<article>
					<h3 class="block-title">${todo.title }</h3>
					<div class="block-info">
						<c:set var="dateValue" value="${todo.regDate }"/>
						등록 날짜: ${fn:substring(dateValue, 0, 10 )},	
						${todo.name }, 
						우선순위: ${todo.sequence } 
						<span class="todo-id" style="display: none">${todo.id }</span>
						<button class="btn-move" onclick="location.href="/todo/todoadd?id=${todo.id}">→</button>			
					</div>
		
				</article>
			</c:if>
		</c:forEach>
	</section>

   <section class="doing">
      <div class="col-name">DOINIG</div>
		<c:forEach items="${todos }" var="todo">
			<c:if test="${todo.type eq 'DOING' }">
				<article>
					<h3 class="block-title">${todo.title }</h3>
					<div class="block-info">
						<c:set var="dateValue" value="${todo.regDate }"/>
						등록 날짜: ${fn:substring(dateValue, 0, 10 )},	
						${todo.name }, 
						우선순위: ${todo.sequence } 
						<button class="btn-move">→</button>			
					</div>				
				</article>
			</c:if>
		</c:forEach>
	</section>

   <section class="done">
   		<div class="col-name">DONE</div>
		<c:forEach items="${todos }" var="todo">
			<c:if test="${todo.type eq 'DONE' }">
				<article>
					<h3 class="block-title">${todo.title }</h3>
					<div class="block-info">
						<c:set var="dateValue" value="${todo.regDate }"/>
						등록 날짜: ${fn:substring(dateValue, 0, 10 )},	
						${todo.name }, 
						우선순위: ${todo.sequence } 
						<button class="btn-move">→</button>			
					</div>
				</article>
			</c:if>
		</c:forEach>
	</section>
	
	</main>
</body>
</html>