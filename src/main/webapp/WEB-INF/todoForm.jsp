<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>할일 등록</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/todoForm.css">
</head>
<body>
  <h1>할일 등록</h1>
  <form action="/todo-form" method="post">
    <label for="task">어떤일인가요?</label>
    <input type="text" id="task" name="task" placeholder="swift 공부하기(24자까지)" maxlength="24">

    <label for="person">누가 할일인가요?</label>
    <input type="text" id="person" name="person" placeholder="홍길동">

    <label>우선순위를 선택하세요</label>
    <div class="priority">
      <input type="radio" id="priority1" name="priority" value="1">
      <label for="priority1">1순위</label>
      <input type="radio" id="priority2" name="priority" value="2">
      <label for="priority2">2순위</label>
      <input type="radio" id="priority3" name="priority" value="3">
      <label for="priority3">3순위</label>
    </div>

    <div class="buttons">
      <button type="button" onclick="history.back()">이전</button>
      <button type="submit">제출</button>
      <button type="reset">내용지우기</button>
    </div>
  </form>
</body>
</html>

