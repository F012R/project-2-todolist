package org.f012r.miniproject02;

import org.f012r.miniproject02.dao.TodoDao;
import org.f012r.miniproject02.dto.TodoDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "mainServlet", value = "/")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoDao todoDao = new TodoDao();
        List<TodoDto> todoList = todoDao.getTodos();

        req.setAttribute("todoList", todoList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/main.jsp");
        dispatcher.forward(req, resp);
    }
}
