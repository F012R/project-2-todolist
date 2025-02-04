package kr.or.f012r.todolist.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.f012r.todolist.dao.TodoDao;
import kr.or.f012r.todolist.dto.TodoDto;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public MainServlet() {
        super();
        
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	TodoDao todoDao = new TodoDao();
    	
		List<TodoDto> todoList = todoDao.getTodos();
		request.setAttribute("todoList", todoList);
		
		String[] todoTypes= {"TODO","DOING","DONE"};
		request.setAttribute("todoTypes", todoTypes);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
		requestDispatcher.forward(request, response);
		
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
	
}
