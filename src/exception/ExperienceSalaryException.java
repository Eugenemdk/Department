package exception;

public class ExperienceSalaryException extends Exception{
    public ExperienceSalaryException() {
        super("Experience cannot be so miserable return when you will haveenough experiance");
    }

    public ExperienceSalaryException(String message) {
        super(message);
    }
}
