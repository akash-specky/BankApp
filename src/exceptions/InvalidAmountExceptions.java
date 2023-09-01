package exceptions;

public class InvalidAmountExceptions extends Exception{
    public InvalidAmountExceptions(){
        super();
    }

    public InvalidAmountExceptions(String msg){
        super(msg);
    }
}
