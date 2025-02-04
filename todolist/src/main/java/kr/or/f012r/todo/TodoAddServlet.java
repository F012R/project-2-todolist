package kr.or.f012r.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addTodo")
public class TodoAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TodoDao todoDao = new TodoDao();
       
    public TodoAddServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String title = request.getParameter("title");
        String name = request.getParameter("name");
        int sequence = Integer.parseInt(request.getParameter("sequence"));

        int result = todoDao.addTodo(title, name, sequence);

        if (result > 0) {
            response.sendRedirect("main");
        } else {
            request.setAttribute("error", "할 일 추가에 실패했습니다.");
            request.getRequestDispatcher("/todoForm.jsp").forward(request, response);
        }
    }
}