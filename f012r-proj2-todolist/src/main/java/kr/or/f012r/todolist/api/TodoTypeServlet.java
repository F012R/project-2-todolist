package kr.or.f012r.todolist.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.f012r.todolist.dao.TodoDao;


@WebServlet("/TodoTypeServlet")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
    public TodoTypeServlet() {
        super();
        
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String type = request.getParameter("type");

        try {
            long id = Long.parseLong(idStr);  // ID를 long 타입으로 변환
            String newStatus = getNextStatus(type);  // 현재 상태에 맞는 다음 상태 얻기
            
            TodoDao todoDao = new TodoDao();
            

            // DB에서 상태를 업데이트하고 성공 여부 반환
            int updateCount = todoDao.updateTodoStatus(id, newStatus);

            if (updateCount > 0) {  // 업데이트가 성공하면
            	response.getWriter().write("success");
            } else {
                response.getWriter().write("fail");
            }
        } catch (Exception e) {
            response.getWriter().write("fail");
        }
    }

    // 현재 상태에 맞는 다음 상태를 반환
    private String getNextStatus(String currentStatus) {
        switch (currentStatus) {
            case "TODO":
                return "DOING";  
            case "DOING":
                return "DONE";   
            default:
                return "TODO";   // 그 외에는 todo
        }
    }
}
