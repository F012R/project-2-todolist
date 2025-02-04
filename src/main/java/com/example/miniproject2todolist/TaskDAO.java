package com.example.miniproject2todolist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDAO {
    public void addTask(Task task) {
        System.out.println("할일 제목: " + task.getTitle());
        System.out.println("담당자: " + task.getAssignee());
        System.out.println("우선순위: " + task.getPriority());
        System.out.println("상태: " + task.getStatus());

        String query = "INSERT INTO tasks (title, assignee, priority, status) VALUES (?, ?, ?, ?)";

        // DBConnection을 통해 연결을 받아옴
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getAssignee());
            stmt.setInt(3, task.getPriority());
            stmt.setString(4, task.getStatus());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
