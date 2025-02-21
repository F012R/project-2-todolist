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
        List<TodoDto> todoList = todoDao.getTodos("TODO");
        List<TodoDto> doingList = todoDao.getTodos("DOING");
        List<TodoDto> doneList = todoDao.getTodos("DONE");

        req.setAttribute("todoList", todoList);
        req.setAttribute("doingList", doingList);
        req.setAttribute("doneList", doneList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/main.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoDao todoDao = new TodoDao();
        TodoDto todoDto = todoDao.getTodo(Long.valueOf(req.getParameter("taskId")));

        if (todoDto != null) {
            todoDto.setType(req.getParameter("targetColumn"));
            todoDao.updateTodo(todoDto);
        }
    }
}
