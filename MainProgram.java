
import controller.Game;
import gui.GameController;
import gui.MainWindow;
public class MainProgram {
    public static void main(String[] args) {
    	GameController controller = new GameController();
        MainWindow mainwindow = new MainWindow(controller.getGame());
    }
}
