package com.example.miniproject2todolist;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todos")
public class TodoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        JsonArray jsonArray = new JsonArray();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 형식 지정

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tasks")) {

            while (rs.next()) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("id", rs.getInt("id"));
                jsonObject.addProperty("title", rs.getString("title")); // 할 일 제목
                jsonObject.addProperty("assignee", rs.getString("assignee")); // 담당자
                jsonObject.addProperty("priority", rs.getString("priority")); // 우선순위
                jsonObject.addProperty("status", rs.getString("status")); // 상태

                // 날짜만 추출 (시간은 제외)
                Date createdAt = rs.getTimestamp("created_at");
                String formattedDate = dateFormat.format(createdAt); // yyyy-MM-dd 형식으로 변환
                jsonObject.addProperty("created_at", formattedDate); // 등록 날짜

                jsonArray.add(jsonObject);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        out.print(jsonArray.toString());
        out.flush();
    }
}
