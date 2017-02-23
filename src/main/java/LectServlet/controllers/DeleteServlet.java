package LectServlet.controllers;

import LectServlet.Exceptions.EntityNotFoundException;
import LectServlet.db.DAO.DAOStudent;
import LectServlet.db.POJO.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import static LectServlet.Const.*;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(DAOStudent.ID));
        try {
            DAOStudent.eraseStudent(id);
        } catch (EntityNotFoundException e) {
            req.setAttribute(REQ_ERROR, e.getMessage());
            resp.sendRedirect(DISP_ERROR);
        }
        resp.sendRedirect(REDIR_LIST);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.append(req.getAttribute("input").toString());
        pw.close();
    }
}
