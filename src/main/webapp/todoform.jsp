<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todo form</title>
<link href="css/form_style.css" rel="stylesheet"/>
</head>
<body>

  <h3>할 일 등록</h3>
  <form action="/todo/todoadd" method="post" class="form-example">
  <div class="single-form-container">
    <label for="title">어떤 일인가요? </label><br>
    <input type="text" name="title" id="title" size="44" maxlength="24" placeholder="swift 공부하기(24까지)" required />
  </div>
  <div class="single-form-container">
    <label for="name">누가 할 일인가요? </label> <br>
    <input type="text" name="name" id="name" placeholder="홍길동" required />
  </div>
  <div class="single-form-container">
  <label></label>
    <input type="radio" id="seq1" name="sequence" value="1" required>
	  <label for="seq1">1순위</label>
	  <input type="radio" id="seq2" name="sequence" value="2" required>
	  <label for="seq2">2순위</label>
	  <input type="radio" id="seq3" name="sequence" value="3" required>
	  <label for="seq3">3순위</label>
  </div>
  
  <div class="container-btn">  
  	<div class="container-btn-pre">
		<button type="button" class="btn-pre" onclick="location.href='/todo/main'">< 이전</button>
  	</div>
	<div class="container-btn-txt">
		<input type="submit" value="제출" />
		<button type="button" id="btn-reset">내용 지우기</button>
	</div>
  </div>
</form>

<script type="text/javascript" src="./scripts/form_ac.js"></script> 
</body>
</html>