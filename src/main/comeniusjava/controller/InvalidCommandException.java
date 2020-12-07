package comeniusjava.controller;

public class InvalidCommandException extends Exception {
    private final String command;

    public InvalidCommandException(String command) {
        super("Invalid command: " + command);
        this.command = command;
    }
}
