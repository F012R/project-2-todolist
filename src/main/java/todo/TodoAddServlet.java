package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dao.TodoDao;
import todo.dto.TodoDto;


@WebServlet("/todoadd")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TodoAddServlet() {
        super();
    }   

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String sequence = request.getParameter("sequence");
		
		// test code
//		System.out.println("담당자:"+name);
//		System.out.println("할 일:"+title);
//		System.out.println("우선순위:"+sequence);
		
		TodoDao dao = new TodoDao();
		TodoDto newDto = new TodoDto();
		newDto.setName(name);
		newDto.setTitle(title);
		newDto.setSequence(Integer.parseInt(sequence));
		
		dao.addTodo(newDto);
		response.sendRedirect("/todo/main");
	}


}
