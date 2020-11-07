package exception;

public class ExceptionAge extends Exception{
    public ExceptionAge() {
        super("Sorry your age is lower than your activity, you're liar");
    }

    public ExceptionAge(String message) {
        super(message);
    }
}
