<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>나의 해야할 일들</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<body>
<button class="register-btn">새로운 TODO 등록</button>
<div class="container">
    <div class="column">
        <div class="category">
            <h2>TODO</h2>
        </div>
        <div class="task">
            <p class="task-name">자바스크립트 공부하기</p>
            <p class="task-description">등록날짜: 2018.03.10, 홍길동, 우선순위 1</p>
            <button class="arrow-button">→</button>
        </div>
        <div class="task">
            <p class="task-name">리포트 제출하기</p>
            <p class="task-description">등록날짜: 2018.02.20, 홍길동, 우선순위 1</p>
            <button class="arrow-button">→</button>
        </div>
    </div>
    <div class="column">
        <div class="category">
            <h2>DOING</h2>
        </div>
        <div class="task">
            <p class="task-name">다음달 계획서 작성방법 고민하기</p>
            <p class="task-description">등록날짜: 2018.01.22, 홍길동, 우선순위 1</p>
            <button class="arrow-button">→</button>
        </div>
        <div class="task">
            <p class="task-name">데모페이지 개발</p>
            <p class="task-description">등록날짜: 2018.01.10, 홍길동, 우선순위 1</p>
            <button class="arrow-button">→</button>
        </div>
        <div class="task">
            <p class="task-name">웹 관련 책 찾아보기</p>
            <p class="task-description">등록날짜: 2018.02.20, 홍길동, 우선순위 1</p>
            <button class="arrow-button">→</button>
        </div>
        <div class="task">
            <p class="task-name">웹폰트 공부하기</p>
            <p class="task-description">등록날짜: 2018.01.20, 홍길동, 우선순위 1</p>
            <button class="arrow-button">→</button>
        </div>
    </div>
    <div class="column">
        <div class="category">
            <h2>DONE</h2>
        </div>
        <div class="task">
            <p class="task-name">CSS학습</p>
            <p class="task-description">등록날짜: 2018.01.10, 홍길동, 우선순위 1</p>
        </div>
        <div class="task">
            <p class="task-name">JAVA 객체지향 설계 복습</p>
            <p class="task-description">등록날짜: 2018.01.10, 홍길동, 우선순위 1</p>
        </div>
        <div class="task">
            <p class="task-name">이사할 곳 알아보기</p>
            <p class="task-description">등록날짜: 2018.01.03, 홍길동, 우선순위 1</p>
        </div>
    </div>
</div>
</body>
</html>
