package com.example.miniproject2todolist;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createTask")  // 클라이언트에서 POST 요청할 URL 매핑
public class CreateTaskServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // JSON 데이터 읽기
        StringBuilder sb = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        String requestBody = sb.toString();
        System.out.println("Request Body: " + requestBody); // JSON 데이터 확인

        try {
            // Gson을 사용한 JSON 파싱
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(requestBody, JsonObject.class);

            String title = jsonObject.has("title") ? jsonObject.get("title").getAsString() : null;
            String assignee = jsonObject.has("assignee") ? jsonObject.get("assignee").getAsString() : null;
            String priority = jsonObject.has("priority") ? jsonObject.get("priority").getAsString() : null;
            String status = jsonObject.has("status") ? jsonObject.get("status").getAsString() : null;

            // 🚨 값이 정상적으로 들어오는지 확인
            System.out.println("title: " + title);
            System.out.println("assignee: " + assignee);
            System.out.println("priority: " + priority);
            System.out.println("status: " + status);

            // 필수 필드 확인 (title이 없으면 400 에러)
            if (title == null || title.trim().isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("Error: Title is required");
                return;
            }

            // DB 저장 로직
            try (Connection conn = DBConnection.getConnection()) {
                String query = "INSERT INTO tasks (title, assignee, priority, status) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, title);
                    stmt.setString(2, assignee);
                    stmt.setString(3, priority);
                    stmt.setString(4, status);

                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        response.setStatus(HttpServletResponse.SC_OK);
                        response.getWriter().write("Task created successfully");
                    } else {
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        response.getWriter().write("Error creating task");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error processing request");
        }
    }
}
