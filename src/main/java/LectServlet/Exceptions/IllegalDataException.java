package LectServlet.Exceptions;

/**
 * Created by bse71 on 23.02.2017.
 */
public class IllegalDataException extends Exception {
    public IllegalDataException(){

    }

    public IllegalDataException(String message){
        super(message);
    }
}
