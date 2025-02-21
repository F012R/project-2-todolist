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

@WebServlet(name = "todoFormServlet", value = "/todo-form")
public class TodoFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todoForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoDao todoDao = new TodoDao();

        String task = req.getParameter("task");
        String person = req.getParameter("person");
        int priority = Integer.parseInt(req.getParameter("priority"));

        TodoDto todoDto = new TodoDto(person, priority, task);

        todoDao.addTodo(todoDto);

        resp.sendRedirect("/");
    }
}
