package LectServlet.controllers;
import LectServlet.Exceptions.EntityNotFoundException;
import LectServlet.db.DAO.DAOStudent;
import LectServlet.db.POJO.Student;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import static LectServlet.Const.*;

public class AddServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(AddServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher(DISP_ADD_STUDENT).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter(DAOStudent.NAME);
        int group_id = 0;
        Date birthday = null;
        char sex = 'm';
        try {
            group_id = Integer.parseInt(req.getParameter(DAOStudent.GROUP_ID));
            birthday = Date.valueOf(req.getParameter(DAOStudent.BIRTHDAY));
            sex = req.getParameter(DAOStudent.SEX).charAt(0);
        } catch (NumberFormatException e){
            String message = "Incorrect group_id: " + req.getParameter(DAOStudent.GROUP_ID) + "!";
            log.error(message + " Can not parse this!");
            req.setAttribute(REQ_ERROR, message);
            resp.sendRedirect(REDIR_ERROR);
        }

        try {
            DAOStudent.addStudent(new Student(-1, group_id, name, birthday, sex));
        } catch (EntityNotFoundException e) {
            req.setAttribute(REQ_ERROR, e.getMessage());
            resp.sendRedirect(DISP_ERROR);
        }
        resp.sendRedirect(REDIR_LIST);
    }
}
