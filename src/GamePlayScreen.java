import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GamePlayScreen extends JFrame {
  private List<String> availableSkills;
  public GamePlayScreen(String[] heroNames, StatGenerator[] heroStats, int missionsPassed, int missionsFailed) {
      super("Game Play");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(800, 600);
      StringBuilder remainingHeroesText = new StringBuilder("Your Heroes: ");
      for (String heroName : heroNames) {
        remainingHeroesText.append(heroName).append(", ");
      }
      remainingHeroesText.deleteCharAt(remainingHeroesText.length() - 1); // Remove the trailing comma
      remainingHeroesText.deleteCharAt(remainingHeroesText.length() - 1); // Remove the space after the last hero name

      // Create a JLabel to display the remaining heroes text
      JLabel remainingHeroesLabel = new JLabel(remainingHeroesText.toString());

      availableSkills = new ArrayList<>();
      availableSkills.add("Acrobatics");
      availableSkills.add("Animal Handling");
      availableSkills.add("Arcana");
      availableSkills.add("Athletics");
      availableSkills.add("Deception");
      availableSkills.add("History");
      availableSkills.add("Insight");
      availableSkills.add("Intimidation");
      availableSkills.add("Investigation");
      availableSkills.add("Medicine");
     availableSkills.add("Nature");
    availableSkills.add("Perception");
    availableSkills.add("Performance");
    availableSkills.add("Persuasion");
    availableSkills.add("Religion");
    availableSkills.add("Sleight of Hand");
    availableSkills.add("Stealth");
    availableSkills.add("Survival");

      //Create a JTextArea to display the skills
      JTextArea skillsTextArea = new JTextArea();
      skillsTextArea.setEditable(false); // Set it to read-only
      skillsTextArea.setLineWrap(true); // Enable line wrapping
      skillsTextArea.setWrapStyleWord(true); // Wrap at word boundaries


    // Append the skills to the JTextArea
    for (String skill : availableSkills) {
      skillsTextArea.append(skill + "\n");
    }

    // Create a JScrollPane to provide scrolling functionality
    JScrollPane scrollPane = new JScrollPane(skillsTextArea);

    JLabel missionProgressLabel = new JLabel(missionsPassed +"/18 missions complete\n" +missionsFailed + "/10 missions failed");

    // Add a MouseListener to the JTextArea to handle skill selection
    skillsTextArea.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        // Get the selected skill
        int pos = skillsTextArea.viewToModel2D(e.getPoint());
        int start = 0;
        int end = 0;
        try {
          start = skillsTextArea.getLineStartOffset(skillsTextArea.getLineOfOffset(pos));
          end = skillsTextArea.getLineEndOffset(skillsTextArea.getLineOfOffset(pos));
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        String selectedSkill = skillsTextArea.getText().substring(start, end).trim();

        availableSkills.remove(selectedSkill);

        skillsTextArea.setText("");
        for (String skill : availableSkills) {
          skillsTextArea.append(skill + "\n");
        }

        if (availableSkills.isEmpty()) {
          // Display report card
          StringBuilder reportCard = new StringBuilder();
          reportCard.append("Congratulations on completing all missions!\n");
          reportCard.append("Missions Passed: ").append(missionsPassed).append("\n");
          reportCard.append("Missions Failed: ").append(missionsFailed).append("\n");

          JOptionPane.showMessageDialog(GamePlayScreen.this, reportCard.toString(), "Report Card",
              JOptionPane.INFORMATION_MESSAGE);

          // Close the game
          dispose();
        } else {
          // Open a new screen with the story for the selected mission
          MissionStoryScreen missionStoryScreen = new MissionStoryScreen(selectedSkill, heroNames,
              heroStats, missionsPassed, missionsFailed);
          missionStoryScreen.setVisible(true);
        }
      }

      @Override
      public void mousePressed(MouseEvent e) {

      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {

      }

      @Override
      public void mouseExited(MouseEvent e) {

      }

      // Other MouseListener methods...
    });

    // Create a JPanel to hold the remaining heroes label and the scroll pane
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(remainingHeroesLabel, BorderLayout.NORTH);
    panel.add(missionProgressLabel, BorderLayout.CENTER);
    panel.add(scrollPane, BorderLayout.SOUTH);

    // Add the scrollPane to the appropriate position in the layout
    getContentPane().add(panel);

    if (missionsPassed >= 18) {
      // Show congratulations message and close the game
      JOptionPane.showMessageDialog(this, "Congratulations! You have completed all missions!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
      dispose();
    } else if (missionsFailed >= 10) {
      // Show failure message and close the game
      JOptionPane.showMessageDialog(this, "Mission failed! You have failed too many missions.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
      dispose();
    }

    setLocationRelativeTo(null); // Center the window on the screen
    setVisible(true);
    }
}