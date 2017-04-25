package ohtu.command;

public class PrintCommand implements Command{

    private final String toPrint;

    public PrintCommand(String toPrint) {
        this.toPrint = toPrint;
    }
    
    @Override
    public void execute() {
        System.out.println(toPrint);
    }

    @Override
    public void undo() {}
    
}
