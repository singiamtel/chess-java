<<<<<<< HEAD

import controller.Game;
import gui.GameController;
=======
import java.util.ArrayList;

import controller.Controller;
import controller.Game;
import controller.Move;
>>>>>>> parent of c099b9b... started controller refactor
import gui.MainWindow;
import utilities.Pair;
public class MainProgram {
    public static void main(String[] args) {
<<<<<<< HEAD
    	GameController controller = new GameController();
        MainWindow mainwindow = new MainWindow(controller.getGame());
=======
        Controller controller = Controller.getController();
        Game game = new Game(true);
        System.out.println(game.isKingOnCheck(true));
>>>>>>> parent of c099b9b... started controller refactor
    }
}
