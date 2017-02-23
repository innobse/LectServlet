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

public class RefactorServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(RefactorServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = null;
        try {
            student = DAOStudent.getStudent(Integer.parseInt(req.getParameter(DAOStudent.ID)));
        } catch (EntityNotFoundException e) {
            req.setAttribute(REQ_ERROR, e.getMessage());
            resp.sendRedirect(REDIR_ERROR);
        }
//        if(student != null){
            req.setAttribute(REQ_STUDENT, student);
            getServletContext().getRequestDispatcher(DISP_REFACTOR_STUDENT).forward(req, resp);
//        } else{
//            req.setAttribute(REQ_ERROR, ERROR);
//            resp.sendRedirect(DISP_ERROR);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = -1;
        String name = req.getParameter(DAOStudent.NAME);
        int group_id = 0;
        Date birthday = null;
        char sex = 'm';
        try {
            id = Integer.parseInt(req.getParameter(DAOStudent.ID));
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
            DAOStudent.updateStudent(new Student(id, group_id, name, birthday, sex));
        } catch (EntityNotFoundException e) {
            req.setAttribute(REQ_ERROR, e.getMessage());
            resp.sendRedirect(DISP_ERROR);
        }
        resp.sendRedirect(REDIR_LIST);
    }
}
