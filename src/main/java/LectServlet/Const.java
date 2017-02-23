package LectServlet;

/**
 * Created by bse71 on 23.02.2017.
 */
public interface Const {

    //Диспатчеры
    String DISP_ERROR = "/err.jsp";
    String DISP_LIST = "/students.jsp";
    String DISP_ADD_STUDENT = "/students/add.jsp";
    String DISP_DEL_STUDENT = "/students/del.jsp";
    String DISP_REFACTOR_STUDENT = "/students/refactor.jsp";

    //Редирект
    String REDIR_ERROR = "/err";
    String REDIR_LIST = "/students";
    String REDIR_ADD_STUDENT = "/students/add";
    String REDIR_DEL_STUDENT = "/students/del";
    String REDIR_REFACTOR_STUDENT = "/students/refactor";

    //Названия параметров
    String REQ_ERROR = "error";
    String REQ_STUDENTS = "students";
    String REQ_STUDENT = "student";

    //Логи
    String DONE = "Done!";
    String CLOSE_CONNECTION = "Close database connection...";
    String CLASS_LOADER_DOWNLOAD = "Download the mySql driver... ";
    String OPEN_CONNECTION = "Open database connection...";

    //Ошибки
    String ERROR = "Something wrong! ";
    String STUDENT_NOT_FOUND = "Student not found in database!";
    String INSERT_ENTITY_NOT_EXECUTED = "New student can't add to database!";
    String GETTING_ENTITY_ERROR = "Can't get entity from database!";
}
