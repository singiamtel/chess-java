import controller.Controller;
import gui.MainWindow;
public class MainProgram {
    public static void main(String[] args) {
        Controller controller = new Controller();
        MainWindow mainWindow = new MainWindow(controller);
    }
}
