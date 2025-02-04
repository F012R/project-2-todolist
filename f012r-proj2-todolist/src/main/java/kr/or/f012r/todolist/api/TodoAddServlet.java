package kr.or.f012r.todolist.api;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.f012r.todolist.dao.TodoDao;
import kr.or.f012r.todolist.dto.TodoDto;


@WebServlet("/ToAddServlet")
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

		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("priority"));
	
        TodoDto todoDto = new TodoDto(title, name, sequence, "TODO");
        TodoDao todoDao = new TodoDao();
        todoDao.addTodo(todoDto);
		

		response.sendRedirect(request.getContextPath() + "/MainServlet");
	}


}
