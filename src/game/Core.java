package game;

import game.commands.ClearCommand;
import game.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Core {
    private static Core instance = new Core();
    JdkElf elf = JdkElf.getInstance();
    ArrayList<Command> commands = new ArrayList<Command>();
    ArrayList<Line> draws = new ArrayList<Line>();

    public static Core getInstance() {
        return instance;
    }
    public JdkElf getElf()
    {
        return elf;
    }
    //Minden listával kapcsolatos metodus
    public void addCommands(Command command){
        commands.add(command);
    }
    public void addDraws(Line draw){
        draws.add(draw);
    }
    public void clearDraws(){ draws.clear();}
    public List<Line> getList(){
        return draws;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public List<String> getCommandsListString(){
        List<String> out = new ArrayList<>();
        for(Command command : commands) {
            out.add(command.toString());
        }
        return out;
    }
    public void undo(){ //Ezen még gondolkozni kell ;)
        commands.remove(commands.size()-2);
        commands.remove(commands.size()-1);
    }
    public void clear(){
        setDefault();
        draws.clear();
        commands = new ArrayList<Command>();

    }

    // Commands
    public void doCommands(){
        setDefault();
            for (Command command: commands){
                command.method(this);
                System.out.println(elf.toString());
        }
            System.out.println();
    }
    private void setDefault(){
        elf.setElfDefault();
        draws.clear();
    }
    public String doCommandsString(){
        String out = "";
        System.out.println(elf.toString());
        for (int i = 0; i < commands.size(); i++){
            commands.get(i).method(this);
            out.concat(elf.toString());
        }
        return out;
    }
    public void showDrawnObjects(){
        for(int i = 0; i < draws.size(); i++){
           System.out.println(draws.get(i).toString());
        }
    }


}
