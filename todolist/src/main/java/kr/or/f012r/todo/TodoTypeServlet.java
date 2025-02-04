package kr.or.f012r.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/type")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public TodoTypeServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		String type = request.getParameter("type");
		System.out.println("type) " + idStr + ", " + type);
		long id = Long.parseLong(idStr);
		TodoDao todoDao = new TodoDao();
		int updateCount = todoDao.updateTodo(id, type);
		if (updateCount == 1) {
			response.setStatus(200);
		}
		else {
			response.sendError(400, "해당하는 ID값이 없습니다.");
		}
	}
}