package todo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dao.TodoDao;
import todo.dto.TodoDto;


@WebServlet("/todotype")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoTypeServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");

		TodoDao dao = new TodoDao();
		TodoDto dto = new TodoDto();
		dto.setId(id);
		dto.setType(type);
		dao.updateTodo(dto);
		
		// 응답결과로 success 보내기 
		 PrintWriter out = response.getWriter(); 
		 out.println("success");
	}

}
