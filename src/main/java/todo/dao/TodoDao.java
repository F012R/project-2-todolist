package todo.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import todo.dto.TodoDto;

public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";


	public List<TodoDto> getTodos() {
		List<TodoDto> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "select id, title, name, sequence, type, regdate "
				+ "from todo "
				+ "order by regdate desc ";
//				+ "select id, title, name, sequence, type, regdate "
//				+ "from todo "
//				+ "where type = 'TODO' "
//				+ "order by regdate desc";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					String title = rs.getString("title");
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String regDate = rs.getString("regDate");
					int sequence = rs.getInt("sequence");
					String type = rs.getString("type");
					TodoDto todo = new TodoDto(id, name, regDate, sequence, title, type);
					
					
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
	
	public int addTodo(TodoDto todo) {
		int insertCount = 0;  // 몇 건 수정했는지 

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO Todo (title, name, sequence) VALUES ( ?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());

			insertCount = ps.executeUpdate();	// insert, update, delete 문 사용 시 

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
	
	public int updateTodo(TodoDto todo, String type) {
		int updateCount = 0;  // 몇 건 수정했는지 

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "update Todo set type = ? where id = ?";

		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			String next_type ="";
			if (todo.getType().equals("TODO")) {
				next_type = "DOING";
			} else if (todo.getType().equals("DOING")) {
				next_type = "DONE";
			}
			ps.setString(1, next_type);
			ps.setInt(2, todo.getId());

			updateCount = ps.executeUpdate();	// insert, update, delete 문 사용 시 

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return updateCount;
	}
	
	
}
