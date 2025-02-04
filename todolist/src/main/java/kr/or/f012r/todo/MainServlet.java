package kr.or.f012r.todo;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TodoDao todoDao = new TodoDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TodoDto> todos = todoDao.getTodos();
        
        request.setAttribute("todoList", todos.stream().filter(todo -> "TODO".equals(todo.getType())).collect(Collectors.toList()));
        request.setAttribute("doingList", todos.stream().filter(todo -> "DOING".equals(todo.getType())).collect(Collectors.toList()));
        request.setAttribute("doneList", todos.stream().filter(todo -> "DONE".equals(todo.getType())).collect(Collectors.toList()));
        
        request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}