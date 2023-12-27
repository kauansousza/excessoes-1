package model.exceptions;

import java.io.Serial;

public class DomainException extends RuntimeException{

    public DomainException(String msg){
        super(msg);
    }



    @Serial
    private static final long serialVersionUID = 1L;
    

    
}
