package controller;

import game.Core;
import game.Orientation;
import game.commands.*;
import model.MyColor;

public class CommandTranslator {
    public void translate(String input){
        Command command = null;
        String[] s = input.split(" ");
        switch (s[0].toLowerCase()){
            case "move":
                command = new MoveCommand(Integer.decode(s[1].toLowerCase()));
                break;
            case "color":
                MyColor color = new MyColor();
                color.setColor(s[1].toLowerCase());
                command = new ColorCommand(color);
                break;
            case "pen":
                if("down".equals(s[1].toLowerCase())){
                    command = new DrawingCommand(true);
                }else if("up".equals(s[1].toLowerCase())){
                    command = new DrawingCommand(false);
                }else if("thickness".equals(s[1].toLowerCase())){
                    command = new ThicknessCommand(Integer.decode(s[2]));
                }
                break;
            case"rotate":
                if("forward".equals(s[1].toLowerCase()))
                command = new RotationCommand(Orientation.NORTH);
                if("backward".equals(s[1].toLowerCase()))
                command = new RotationCommand(Orientation.SOUTH);
                if("right".equals(s[1].toLowerCase()))
                command = new RotationCommand(Orientation.EAST);
                if("left".equals(s[1].toLowerCase()))
                command = new RotationCommand(Orientation.WEST);
                break;
            case "undo":
                if(Core.getInstance().getCommands().size() > 0)
                    Core.getInstance().getCommands().remove(Core.getInstance().getCommands().size()-1);
                break;
            case "home":
                command = new HomeCommand();
                break;
            case "clear":
                command = new ClearCommand();
                break;

                default:
                System.out.println("Not a valid command");
                break;
        }
        if(command != null)
            Core.getInstance().addCommands(command);
        Core.getInstance().doCommands();
    }
}
