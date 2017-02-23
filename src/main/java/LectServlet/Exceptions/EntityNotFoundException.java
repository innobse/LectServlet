package LectServlet.Exceptions;

import java.util.Enumeration;

/**
 * Created by bse71 on 23.02.2017.
 */
public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(){

    }

    public EntityNotFoundException(String message){
        super(message);
    }
}
