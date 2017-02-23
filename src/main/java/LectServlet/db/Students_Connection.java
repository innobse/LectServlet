package LectServlet.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static LectServlet.Const.*;

/**
 * Created by bse71 on 21.02.2017.
 */
public class Students_Connection {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/students";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    private static final Logger log = Logger.getLogger(Students_Connection.class);

    @Override
    protected void finalize() throws Throwable {
        log.info(CLOSE_CONNECTION);
        Connections.DB_STUDENTS.getConnection().close();
        super.finalize();
    }

    public enum Connections{
        DB_STUDENTS;
        private final Connection conn;

        Connections(){
            Connection conn = null;
            try {
                log.info(CLASS_LOADER_DOWNLOAD + DB_DRIVER);
                Class.forName(DB_DRIVER);
                log.info(DONE);

                log.info(OPEN_CONNECTION);
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                log.info(DONE);
            } catch (ClassNotFoundException e) {
                log.error(ERROR + e.getMessage());
            } catch (SQLException e) {
                log.error(ERROR + e.getMessage());
            }
            this.conn = conn;
        }

        public final Connection getConnection(){
            return conn;
        }
    }
}