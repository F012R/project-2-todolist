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


@WebServlet("/TodoFormServlet")
public class TodoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TodoFormServlet() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./todoForm.jsp");
		requestDispatcher.forward(request, response);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String name = request.getParameter("name");
        String sequenceStr = request.getParameter("sequence");
        int sequence = Integer.parseInt(sequenceStr); 

        // 새로운 할일을 todo로 등록
        TodoDto todoDto = new TodoDto(title, name, sequence, "TODO");
        TodoDao todoDao = new TodoDao();
        todoDao.addTodo(todoDto);

        response.sendRedirect(request.getContextPath() + "/MainServlet");
    }

	
	


}
