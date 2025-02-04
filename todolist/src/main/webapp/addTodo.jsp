<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>새로운 TODO 등록</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f0f0f0;
        }
        h1 {
            color: #333;
        }
        form {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input[type="text"], input[type="submit"], input[type="reset"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 3px;
        }
        input[type="radio"] {
            margin-right: 5px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="reset"], .back-btn {
            background-color: #f44336;
            color: white;
            border: none;
            padding: 10px;
            margin-top: 10px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>새로운 TODO 등록</h1>
    <form action="addTodo" method="post" onsubmit="return validateForm()">
        <label for="title">할일 제목:</label>
        <input type="text" id="title" name="title" maxlength="24" required>

        <label for="name">담당자:</label>
        <input type="text" id="name" name="name" required>

        <label>우선순위:</label>
        <input type="radio" id="low" name="sequence" value="1" required>
        <label for="low">낮음</label>
        <input type="radio" id="medium" name="sequence" value="2">
        <label for="medium">중간</label>
        <input type="radio" id="high" name="sequence" value="3">
        <label for="high">높음</label>

        <input type="submit" value="제출">
        <input type="reset" value="내용 지우기">
    </form>
    <a href="main" class="back-btn">이전</a>

    <script>
        function validateForm() {
            var title = document.getElementById("title").value;
            var name = document.getElementById("name").value;
            var sequence = document.querySelector('input[name="sequence"]:checked');

            if (title.trim() === "" || name.trim() === "" || !sequence) {
                alert("모든 항목을 입력해주세요.");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>
