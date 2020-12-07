package game.commands;
import game.Core;
import model.MyColor;

public class backgroundCommand implements Command{
    MyColor color;
    public backgroundCommand(MyColor color){
        this.color = color;
    }
    @Override
    public void method(Core core) {
        core.setBackGroundColor(color);
    }

    @Override
    public String toString() {
        return "Background color: "+color.toString()+"! ";
    }
}
