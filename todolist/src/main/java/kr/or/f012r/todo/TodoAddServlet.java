package kr.or.f012r.todo;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addTodo")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public TodoAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/todoForm.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));
		System.out.println("add) " + title + ", " + name + ", " + sequence);
		TodoDao todoDao = new TodoDao();
		int insertCount = todoDao.addTodo(title, name, sequence);
		
		if (insertCount == 1) {
			response.sendRedirect("./main");
		}
		else {
			response.sendError(400);
		}
	}
}