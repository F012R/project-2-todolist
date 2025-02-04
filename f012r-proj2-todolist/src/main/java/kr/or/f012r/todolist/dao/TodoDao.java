package kr.or.f012r.todolist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import kr.or.f012r.todolist.dto.TodoDto;

public class TodoDao {
    private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
    private static String dbUser = "connectuser";
    private static String dbpasswd = "connect123!@#";

    public int addTodo(TodoDto dto) {
        int insertCount = 0;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        String sql = "INSERT INTO todo(title, name, sequence, type) VALUES(?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, dto.getTitle());
            ps.setString(2, dto.getName());
            ps.setInt(3, dto.getSequence());
            ps.setString(4, dto.getType());  
            
            insertCount = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return insertCount;
    }

    public List<TodoDto> getTodos() {
        List<TodoDto> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "SELECT id, title, name, sequence, type, regdate FROM todo ORDER BY regdate";
        try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    long id = rs.getLong(1);
                    String title = rs.getString(2);
                    String name = rs.getString(3);
                    int sequence = rs.getInt(4);
                    String type = rs.getString(5);
                    Timestamp regDateTimeStamp = rs.getTimestamp(6);
                    
                    LocalDateTime regDateTime = regDateTimeStamp.toLocalDateTime();
                    String regDate = regDateTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));

                    TodoDto todo = new TodoDto(id, title, name, sequence, type, regDate);
                    list.add(todo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public int updateTodoStatus(long id, String type) {
        int updateCount = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "UPDATE todo SET type = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, type);
            ps.setLong(2, id);

            updateCount = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return updateCount;
    }
}
