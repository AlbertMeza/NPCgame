import javax.swing.SwingUtilities;

public class Play {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      WelcomeScreen welcomeScreen = new WelcomeScreen();
      welcomeScreen.setVisible(true);
    });
  }
}
