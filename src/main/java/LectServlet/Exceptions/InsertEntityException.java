package LectServlet.Exceptions;

/**
 * Created by bse71 on 23.02.2017.
 */
public class InsertEntityException extends Exception {

    public InsertEntityException(){

    }

    public InsertEntityException(String message){
        super(message);
    }
}
