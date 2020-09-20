import controller.Game;
import gui.MainWindow;
public class MainProgram {
    public static void main(String[] args) {
        Game game = new Game();
        MainWindow mainwindow = new MainWindow(game);
    }
}
