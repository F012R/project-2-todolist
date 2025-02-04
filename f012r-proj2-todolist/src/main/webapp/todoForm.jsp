<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>할 일 추가하기</title>
    <link rel="stylesheet" href="css/todoForm.css">
</head>
<body>
    <div class="form-container">
        <h1 class="form-title">할일 등록</h1>
        <form action="./ToAddServlet" method="post">
            <label for="title">어떤 일인가요?</label>
            <input type="text" id="title" name="title" placeholder="머신러닝 공부하기(24자까지)" maxlength="24" class="input-field" required>
            
            <label for="name">누가 할 일인가요?</label>
            <input type="text" id="name" name="name" placeholder="김바덕" class="input-field" required>
            
            <label>우선순위를 선택하세요</label>
            <div class="radio-buttons">
                <input type="radio" id="first" name="priority" value="1" required><label for="first">1순위</label>
                <input type="radio" id="second" name="priority" value="2" required><label for="second">2순위</label>
                <input type="radio" id="third" name="priority" value="3" required><label for="third">3순위</label>
            </div>
            
            <div class="button-group">
                <button type="button" class="back-btn" onclick="history.back()">이전</button>
                <button type="submit" class="submit-btn">제출</button>
                <button type="reset" class="reset-btn">내용 지우기</button>
            </div>
            
            <div class="button-group">
    			<button type="button" class="back-btn" onclick="history.back()">< 이전</button>
    			<div class="right-buttons">
        			<button type="submit" class="submit-btn">제출</button>
        			<button type="reset" class="reset-btn">내용지우기</button>
    			</div>
			</div>
            
            
            
        </form>
    </div>
</body>
</html>
