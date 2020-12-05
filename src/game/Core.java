package game;

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
    public List<String> getCommandsListString(){
        List<String> out = new ArrayList<>();
        for (int i = 0; i < commands.size(); i++){
            out.add(commands.get(i).toString());
        }
        return out;
    }
    /*public void undo(){ //Ezen még gondolkozni kell ;)
        //visszalépésnél leellenörizzük hogy az utolsó parancs move volt-e és lent van-e a toll, mert ebben az esetben az utolsó rajzot is törölni kell.
        if(MoveCommand.class.equals(commands.get(commands.size()-1)) && elf.getPen().isDrawing()){
            draws.remove(draws.size()-1);
            commands.remove(commands.size()-1);
        }else{
            commands.remove(commands.size()-1);
        }
    }*/

    // Commands
    public void doCommands(){
        setDefault();
            for (int i = 0; i < commands.size(); i++){
                commands.get(i).method(this);
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
