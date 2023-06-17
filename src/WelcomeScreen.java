import javax.swing.*;
import java.awt.*;

public class WelcomeScreen extends JFrame {
  public WelcomeScreen() {
    super("Welcome Screen");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 600);

    // Create a panel with BorderLayout
    JPanel panel = new JPanel(new BorderLayout());

    // Create a label with a greeting message
    JLabel label = new JLabel("Last Minute Legends");
    label.setFont(new Font("Arial", Font.BOLD, 24));
    label.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(label, BorderLayout.NORTH);

    // Create a label for the image
    JLabel imageLabel = new JLabel();
    ImageIcon imageIcon = new ImageIcon("src/OpenerPhoto.jpg");
    imageLabel.setIcon(imageIcon);
    panel.add(imageLabel, BorderLayout.CENTER);

    // Create a button to proceed
    JButton button = new JButton("Play");
    button.addActionListener(e -> {
      // Handle button click event
      CharacterCreation characterCreationScreen = new CharacterCreation();
      characterCreationScreen.setVisible(true);
      dispose(); // Close the welcome screen
    });
    panel.add(button, BorderLayout.SOUTH);

    // Set the panel as the content pane
    setContentPane(panel);
    setLocationRelativeTo(null); // Center the window on the screen
  }
}


