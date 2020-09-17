import java.util.ArrayList;

import controller.Controller;
import controller.Game;
import controller.Move;
import gui.MainWindow;
import utilities.Pair;
public class MainProgram {
    public static void main(String[] args) {
        Controller controller = Controller.getController();
        Game game = new Game(true);
        ArrayList<Move> awd = game.generateAllColourMoves(true);
        for(int i=0;i<awd.size();++i){
            System.out.println("move " + awd.get(i) + ": " + awd.get(i).getFrom() + " " + awd.get(i).getTo());
        }
    }
}
