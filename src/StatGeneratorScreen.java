import javax.swing.*;
import java.awt.*;

public class StatGeneratorScreen extends JFrame {

  private final String[] heroNames;
  private final StatGenerator[] heroStats = new StatGenerator[3];
  private JButton doneButton;
  public StatGeneratorScreen(String[] heroNames){

    super("Stat Generator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 600);

    this.heroNames = heroNames;
    // Create a panel to hold the components
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4 + 3 * 2, 1));
    panel.add(new JLabel("Generating stats for the following heroes:"));
    panel.add(new JLabel("The six stats are: strength, dexterity, constitution"));
    panel.add(new JLabel("    intelligence, wisdom, charisma"));
    // Display hero names and fillable boxes for stats
    for (int i = 0; i < 3; i++) {
      JLabel nameLabel = new JLabel("Hero " + (i + 1) + ": " + heroNames[i]);
      panel.add(nameLabel);

      // Create a nested panel for the fillable boxes
      JPanel statsPanel = new JPanel();
      heroStats[i] = new StatGenerator();
      // Add fillable boxes for stats
      for (int j = 0; j < 6; j++) {
        JTextField textField = new JTextField();
        textField.setText(heroStats[i].getStatBlock()[j]);
        textField.setPreferredSize(new Dimension(30, 20)); // Set preferred size
        statsPanel.add(textField);
      }
      panel.add(statsPanel);
    }
    initializeDoneButton();
    panel.add(doneButton);

    add(panel);

  setLocationRelativeTo(null); // Center the window on the screen
}
  private void initializeDoneButton() {
    doneButton = new JButton("Done");
    doneButton.addActionListener(e -> {
      // Perform actions when the "Done" button is clicked
      // For now, you can simply display a message
      JOptionPane.showMessageDialog(null, "\"Now let the adventure start, best of luck hero. There are 18 quests to complete with your 3 heroes.");
      GamePlayScreen gamePlayScreen = new GamePlayScreen(heroNames, heroStats,0,0);
      gamePlayScreen.setVisible(true);
      dispose();
    });
  }
}
