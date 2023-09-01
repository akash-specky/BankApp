package exceptions;

public class ExternalBankTransferException extends Exception {

    public ExternalBankTransferException(){
        super();
    }

    public ExternalBankTransferException(String msg){
        super(msg);
    }
}
