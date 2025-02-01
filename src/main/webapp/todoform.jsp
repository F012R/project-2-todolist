<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todo form</title>
</head>
<body>

  <form action="/todo/todoadd" method="post" class="form-example">
  <div class="form-example">
    <label for="name">어떤 일인가요? </label><br>
    <input type="text" name="title" id="title" required />
  </div>
  <div class="form-example">
    <label for="email">누가 할 일인가요? </label> <br>
    <input type="text" name="name" id="name" required />
  </div>
  <div class="form-sequence">
    <input type="radio" id="seq1" name="sequence" value="1" required>
	  <label for="seq1">1순위</label>
	  <input type="radio" id="seq2" name="sequence" value="2" required>
	  <label for="seq2">2순위</label>
	  <input type="radio" id="seq3" name="sequence" value="3" required>
	  <label for="seq3">3순위</label>
  </div>
  <button type="button" onclick="location.href='/todo/main'">< 이전</button>
  <div class="block-submit">
    <input type="submit" value="제출" />
  </div>
   <button type="button" id="btn-reset">내용 지우기</button>
</form>


</body>
</html>