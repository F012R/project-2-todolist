package kr.or.f012r.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/todo_db?serverTimezone=UTC";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public List<TodoDto> getTodos() {
        List<TodoDto> todos = new ArrayList<>();
        String sql = "SELECT id, title, name, sequence, type, regdate FROM todo ORDER BY regdate DESC";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TodoDto todo = new TodoDto(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("name"),
                    rs.getInt("sequence"),
                    rs.getString("type"),
                    rs.getTimestamp("regdate").toLocalDateTime()
                );
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

    public int addTodo(String title, String name, int sequence) {
        String sql = "INSERT INTO todo (title, name, sequence) VALUES (?, ?, ?)";
        int insertCount = 0;

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, name);
            ps.setInt(3, sequence);
            insertCount = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertCount;
    }

    public int updateTodo(long id, String type) {
        String sql = "UPDATE todo SET type = ? WHERE id = ?";
        int updateCount = 0;

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, type);
            ps.setLong(2, id);
            updateCount = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateCount;
    }
}
