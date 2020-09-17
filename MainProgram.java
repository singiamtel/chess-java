import java.util.ArrayList;

import controller.Controller;
import controller.Game;
import controller.Move;
import gui.MainWindow;
import utilities.Pair;
public class MainProgram {
    public static void main(String[] args) {
<<<<<<< HEAD
        Controller controller = Controller.getController();
=======
        Controller controller = new Controller();
        MainWindow mainWindow = new MainWindow(controller);
        Game game = new Game(true);
        ArrayList<Move> awd = game.generateAllColourMoves(true);
        for(int i=0;i<awd.size();++i){
            System.out.println("move " + awd.get(i) + ": " + awd.get(i).getFrom() + " " + awd.get(i).getTo());
        }
>>>>>>> af92c8b1475512e142ab38e0a0e4ac0438d60732
    }
}
