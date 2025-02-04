package com.example.miniproject2todolist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateTaskStatus")
public class UpdateTaskStatusServlet extends HttpServlet {

    // POST 요청을 처리하는 메소드
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));  // 클라이언트에서 보낸 taskId 가져오기
        String newStatus = request.getParameter("newStatus");  // 클라이언트에서 보낸 newStatus 가져오기

        try (Connection conn = DBConnection.getConnection()) {
            // SQL 쿼리 작성
            String query = "UPDATE tasks SET status = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, newStatus);  // 상태값을 SET
                stmt.setInt(2, taskId);  // taskId로 특정 레코드를 UPDATE

                int rowsAffected = stmt.executeUpdate();  // 쿼리 실행

                if (rowsAffected > 0) {
                    response.setStatus(HttpServletResponse.SC_OK);  // 상태가 성공적으로 업데이트된 경우
                    response.getWriter().write("Status updated successfully");
                } else {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);  // 업데이트 실패
                    response.getWriter().write("Error updating task status");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Database error");
        }
    }
}

