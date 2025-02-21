package org.f012r.miniproject02.dao;

import org.f012r.miniproject02.dto.TodoDto;
import org.f012r.miniproject02.global.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TodoDao {
    public int addTodo(TodoDto todoDto) {
        int result = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "insert into todo(title, name, sequence) values(?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, todoDto.getTitle());
            ps.setString(2, todoDto.getName());
            ps.setInt(3, todoDto.getSequence());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps);
        }

        return result;
    }

    public List<TodoDto> getTodos(String type) {
        List<TodoDto> list = new ArrayList<>();
        TodoDto todoDto = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = DBUtil.getConnection();
            String sql = "select id, title, name, sequence, type, regdate from todo where type = ? order by regdate desc";
            ps = conn.prepareStatement(sql);
            ps.setString(1, type);
            rs = ps.executeQuery();

            while(rs.next()){
                todoDto = new TodoDto();
                todoDto.setId(rs.getLong(1));
                todoDto.setTitle(rs.getString(2));
                todoDto.setName(rs.getString(3));
                todoDto.setSequence(rs.getInt(4));
                todoDto.setType(rs.getString(5));

                String regdate = dateFormating(rs.getString(6));
                todoDto.setRegDate(regdate);
                list.add(todoDto);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }

        return list;
    }

    public TodoDto getTodo(Long id) {
        TodoDto result = null;
        TodoDto todoDto = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "select id, title, name, sequence, type, regdate from todo where id = ? order by regdate desc";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id.toString());
            rs = ps.executeQuery();

            if(rs.next()){
                todoDto = new TodoDto();
                todoDto.setId(rs.getLong(1));
                todoDto.setTitle(rs.getString(2));
                todoDto.setName(rs.getString(3));
                todoDto.setSequence(rs.getInt(4));
                todoDto.setType(rs.getString(5));

                String regdate = dateFormating(rs.getString(6));
                todoDto.setRegDate(regdate);

                result = todoDto;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps);
        }

        return result;
    }

    public int updateTodo(TodoDto todoDto) {
        int result = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "update todo set type = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, todoDto.getType());
            ps.setLong(2, todoDto.getId());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps);
        }

        return result;
    }

    private String dateFormating(String beforeDate) throws ParseException {
        String afterDate = "";
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy.MM.dd");

        try {
            Date formatDate = beforeFormat.parse(beforeDate);
            afterDate = afterFormat.format(formatDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return afterDate;
    }
}
