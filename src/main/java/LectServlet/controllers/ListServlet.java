package LectServlet.controllers;

import LectServlet.Exceptions.GettingEntityException;
import LectServlet.db.DAO.DAOStudent;
import LectServlet.db.POJO.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static LectServlet.Const.*;

public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Student> students = null;
        try {
            students = DAOStudent.getStudents();
        } catch (GettingEntityException e) {
            req.setAttribute(REQ_ERROR, e.getMessage());
            getServletContext().getRequestDispatcher(DISP_ERROR).forward(req, resp);
        }
        req.setAttribute(REQ_STUDENTS, students);
        getServletContext().getRequestDispatcher(DISP_LIST).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
