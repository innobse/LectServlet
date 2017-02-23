package LectServlet.db.DAO;

import static LectServlet.Const.*;

import LectServlet.Exceptions.EntityNotFoundException;
import LectServlet.Exceptions.GettingEntityException;
import LectServlet.db.POJO.Student;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import static LectServlet.db.Students_Connection.Connections.DB_STUDENTS;

/**
 * Created by bse71 on 21.02.2017.
 */
public final class DAOStudent {
    public static final String ID = "id";
    public static final String GROUP_ID = "group_id";
    public static final String NAME = "name";
    public static final String BIRTHDAY = "birthday";
    public static final String SEX = "sex";

    private static final Logger log = Logger.getLogger(DAOStudent.class);

    public static void addStudent(Student student) throws EntityNotFoundException {
        String sql = "INSERT INTO students(group_id, name, birthday, sex) VALUES(?, ?, ?, ?);";
        Connection conn = DB_STUDENTS.getConnection();

        log.info("Add new student in database...");
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, student.getGroup_id());
            ps.setString(2, student.getName());
            ps.setDate(3, student.getBirthday());
            ps.setString(4, String.valueOf(student.getSex()));
            ps.execute();
        } catch (SQLException e) {
            log.error(ERROR + e.getMessage());
            throw new EntityNotFoundException(INSERT_ENTITY_NOT_EXECUTED);
        }
        log.info(DONE);
    }

    public static void updateStudent(Student student) throws EntityNotFoundException {
        String sql = "UPDATE students SET group_id = ?, name = ?, birthday = ?, sex = ? WHERE id = ?;";
        Connection conn = DB_STUDENTS.getConnection();

        log.info("Update student in database...");
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, student.getGroup_id());
            ps.setString(2, student.getName());
            ps.setDate(3, student.getBirthday());
            ps.setString(4, String.valueOf(student.getSex()));
            ps.setInt(5, student.getId());
            log.info("Execute: " + ps.toString());
            ps.execute();
        } catch (SQLException e) {
            log.error(ERROR + e.getMessage());
            throw new EntityNotFoundException(INSERT_ENTITY_NOT_EXECUTED);
        }
        log.info(DONE);
    }

    public static Student getStudent(int id) throws EntityNotFoundException {
        String sql = "SELECT * FROM students WHERE id = ?;";
        Student student = null;
        Connection conn = DB_STUDENTS.getConnection();
        log.info("Getting student with id = " + id + "...");
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            log.info("Execute: " + ps.toString());
            student = new Student();
            ResultSet rs = ps.executeQuery();
            rs.next();
            setFieldsToStudent(student, rs);
        } catch (SQLException e) {
            log.error(ERROR + e.getMessage());
            throw new EntityNotFoundException(STUDENT_NOT_FOUND);
        } catch (IllegalAccessException e) {
            log.error(ERROR + e.getMessage());
        }
        log.info(DONE);
        return student;
    }

    public static void eraseStudent(Student student) throws EntityNotFoundException {
        eraseStudent(student.getId());
    }

    public static void eraseStudent(int id) throws EntityNotFoundException {
        String sql = "DELETE FROM students WHERE id = ?;";
        Connection conn = DB_STUDENTS.getConnection();
        log.info("Deleting students with id = " + id + "...");
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            log.info("Execute: " + ps.toString());
            ps.execute();
        } catch (SQLException e) {
            log.error(ERROR + e.getMessage());
            throw new EntityNotFoundException(STUDENT_NOT_FOUND);
        }
        log.info(DONE);
    }

    public static ArrayList<Student> getStudents() throws GettingEntityException {
        ArrayList<Student> al = new ArrayList<>(20);
        String sql = "SELECT * FROM students;";
        Connection conn = DB_STUDENTS.getConnection();

        log.info("Getting all students...");
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Student cortege;
            while(rs.next()){
                cortege = Student.class.newInstance();
                al.add(cortege);
                setFieldsToStudent(cortege, rs);
            }

        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            log.error(ERROR + e.getMessage());
            throw new GettingEntityException(GETTING_ENTITY_ERROR);
        }
        log.info(DONE);
        return al;
    }

    private static void setField(Student cortege, ResultSet rs, Field field, String nameField) throws SQLException, IllegalAccessException {

        switch(field.getType().getSimpleName()){
            case "Character":
            case "char": field.set(cortege, rs.getString(nameField).charAt(0)); break;
            case "Date": field.set(cortege, rs.getDate(nameField)); break;
            case "Timestamp": field.set(cortege, rs.getTimestamp(nameField)); break;
            case "short": field.setShort(cortege, rs.getShort(nameField)); break;
            default: field.set(cortege, rs.getObject(nameField)); break;
        }
    }

    private static void setFieldsToStudent(Student cortege, ResultSet rs) throws SQLException, IllegalAccessException {
        for (Field f : Student.class.getDeclaredFields()) {
            f.setAccessible(true);
            setField(cortege, rs, f, f.getName());
        }
    }

}
