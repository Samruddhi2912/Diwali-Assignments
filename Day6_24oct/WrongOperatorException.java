// Custom checked exception for invalid operators
class WrongOperatorException extends Exception {
    public WrongOperatorException(String message) {
        super(message);
    }
}