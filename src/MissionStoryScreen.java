import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MissionStoryScreen extends JFrame {

  private static final Map<String, String> skillMissions = new HashMap<>();
  private static final Map<String, Integer> modifierIndex = new HashMap<>();
  static {
    // Populate the skill missions
    skillMissions.put("Acrobatics", "Mission: Retrieve a stolen artifact \nhidden in a heavily guarded fortress. Your acrobatic skills will be crucial to navigate through traps and avoid detection.");
    skillMissions.put("Animal Handling", "Mission: Assist a local wildlife \nexpert in tracking down and capturing a rare creature that has been causing disruptions in the nearby village.");
    skillMissions.put("Arcana", "Mission: Investigate a series of mysterious magical disturbances occurring in a remote mountain region. Uncover the source of these disturbances and restore balance.");
    skillMissions.put("Athletics", "Mission: Compete in a grand athletic tournament representing your kingdom. Your strength, agility, and endurance will be put to the test against formidable opponents.");
    skillMissions.put("Deception", "Mission: Infiltrate an enemy stronghold disguised as a spy. Use your deceptive skills to gather vital information and sabotage their operations.");
    skillMissions.put("History", "Mission: Explore ancient ruins and decipher the secrets of a long-lost civilization. Your knowledge of history will guide you in solving puzzles and uncovering hidden treasures.");
    skillMissions.put("Insight", "Mission: Attend a diplomatic meeting between two warring factions. Your keen insight into human behavior will help in negotiating a peaceful resolution.");
    skillMissions.put("Intimidation", "Mission: Confront a notorious gang leader and intimidate them into ceasing their criminal activities.");
    skillMissions.put("Investigation", "Mission: Solve a complex murder mystery that has baffled the local authorities. Your investigative skills and attention to detail will be crucial in identifying the culprit.");
    skillMissions.put("Medicine", "Mission: Travel to a plague-stricken village and provide medical aid to the afflicted. Your knowledge of medicine will help in finding a cure and preventing further spread.");
    skillMissions.put("Nature", "Mission: Explore a dense and dangerous forest to gather rare herbs and ingredients for an important alchemical experiment.");
    skillMissions.put("Perception", "Mission: Uncover a spy within the royal court. Your keen perception will aid in detecting subtle clues and uncovering the traitor.");
    skillMissions.put("Performance", "Mission: Entertain a crowd of nobles at a grand masquerade ball with your captivating performance skills. Impress influential individuals and gather valuable information.");
    skillMissions.put("Persuasion", "Mission: Convince a powerful warlord to join forces with your kingdom in the face of an imminent threat.");
    skillMissions.put("Religion", "Mission: Undertake a pilgrimage to a sacred temple and prove your devotion to the gods through a series of trials and challenges.");
    skillMissions.put("Sleight of Hand", "Mission: Retrieve a stolen artifact from a high-security museum using your exceptional sleight of hand skills to bypass security measures.");
    skillMissions.put("Stealth", "Mission: Infiltrate an enemy stronghold undetected and gather crucial intelligence without raising any alarms.");
    skillMissions.put("Survival", "Mission: Brave the harsh wilderness and survive against the elements. Your survival skills will be tested as you navigate treacherous terrains.");

  }
  //Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma
  static {
    modifierIndex.put("Acrobatics", 1);
    modifierIndex.put("Animal Handling", 4);
    modifierIndex.put("Arcana", 3);
    modifierIndex.put("Athletics", 0);
    modifierIndex.put("Deception", 5);
    modifierIndex.put("History", 3);
    modifierIndex.put("Insight", 4);
    modifierIndex.put("Intimidation", 5);
    modifierIndex.put("Investigation", 3);
    modifierIndex.put("Medicine", 4);
    modifierIndex.put("Nature", 3);
    modifierIndex.put("Perception", 4);
    modifierIndex.put("Performance", 5);
    modifierIndex.put("Persuasion", 5);
    modifierIndex.put("Religion", 3);
    modifierIndex.put("Sleight of Hand", 1);
    modifierIndex.put("Stealth", 1);
    modifierIndex.put("Survival", 4);
  }

  JPanel panel;

  public MissionStoryScreen(String selectedSkill, String[] heroNames, StatGenerator[] heroStats, int missionsPassed, int missionsFailed) {
    super("Mission Story");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(800, 600);


    // Create a JPanel to hold the components
    panel = new JPanel(new BorderLayout());

    // Create a JLabel to display the selected skill
    JLabel skillLabel = new JLabel("Selected Skill: " + selectedSkill);

    // Add the skillLabel to the center of the panel
    panel.add(skillLabel, BorderLayout.NORTH);

    // Create a JLabel to display the mission prompt
    JLabel missionLabel = new JLabel(skillMissions.getOrDefault(selectedSkill, "No mission available for this skill."));
    missionLabel.setVerticalAlignment(JLabel.TOP);

    // Wrap the missionLabel within a JScrollPane
    JScrollPane scrollPane = new JScrollPane(missionLabel);

    // Add the scrollPane below the skillLabel
    panel.add(scrollPane, BorderLayout.CENTER);

    // Create a JPanel to hold the buttons
    JPanel buttonPanel = new JPanel(new FlowLayout());

    // Create a JLabel to display the "Pick a hero" message
    JLabel heroLabel = new JLabel("Pick a hero for the mission");
    buttonPanel.add(heroLabel);



    // Create three buttons for hero selection
    for (String heroName : heroNames) {
      JButton heroButton = new JButton(heroName);
      heroButton.addActionListener(e -> {
        String clickedHeroName = ((JButton) e.getSource()).getText();
        int modifier = modifierIndex.get(selectedSkill);
        int clickedHeroIndex = -1;
        for (int i = 0; i < heroNames.length; i++) {
          if (heroNames[i].equals(clickedHeroName)) {
            clickedHeroIndex = i;
            break;
          }
        }
        Random rand = new Random();
        int rolledNumber = rand.nextInt(21) + heroStats[clickedHeroIndex].getModifiers()[modifier];

        String outcomeMessage = "";
        switch (selectedSkill) {
          case "Acrobatics":
            outcomeMessage = "The hero's acrobatic skills enable them to navigate through traps and evade detection, successfully retrieving the stolen artifact from the heavily guarded fortress.";
            break;
          case "Animal Handling":
            outcomeMessage = "The hero's expertise in animal handling helps them track down and capture the rare creature that has been causing disruptions in the nearby village, earning the gratitude of the locals.";
            break;
          case "Arcana":
            outcomeMessage = "The hero's knowledge of arcane arts allows them to investigate and resolve the mysterious magical disturbances occurring in the remote mountain region, restoring balance to the area.";
            break;
          case "Athletics":
            outcomeMessage = "The hero's athletic prowess shines as they compete in the grand athletic tournament, showcasing their strength, agility, and endurance against formidable opponents, ultimately emerging as the victor.";
            break;
          case "Deception":
            outcomeMessage = "The hero's deceptive skills prove invaluable as they successfully infiltrate the enemy stronghold disguised as a spy, gathering vital information and sabotaging their operations without raising suspicion.";
            break;
          case "History":
            outcomeMessage = "The hero's vast knowledge of history guides them through ancient ruins, allowing them to decipher the secrets of a long-lost civilization, solve puzzles, and uncover hidden treasures.";
            break;
          case "Insight":
            outcomeMessage = "The hero's keen insight into human behavior plays a crucial role in attending a diplomatic meeting between two warring factions, helping to negotiate a peaceful resolution and avert further conflict.";
            break;
          case "Intimidation":
            outcomeMessage = "The hero's intimidating presence and persuasive skills instill fear in the notorious gang leader, forcing them to cease their criminal activities and bringing a sense of safety to the community.";
            break;
          case "Investigation":
            outcomeMessage = "The hero's exceptional investigative skills and attention to detail unravel the complex murder mystery that has baffled the local authorities, leading to the identification and capture of the culprit.";
            break;
          case "Medicine":
            outcomeMessage = "The hero's extensive knowledge of medicine and their selfless efforts to provide aid to the plague-stricken village prove instrumental in finding a cure, saving lives, and preventing the further spread of the disease.";
            break;
          case "Nature":
            outcomeMessage = "The hero's deep connection with nature guides them through the dense and dangerous forest, allowing them to gather rare herbs and ingredients for an important alchemical experiment.";
            break;
          case "Perception":
            outcomeMessage = "The hero's keen perception uncovers the spy within the royal court, detecting subtle clues and revealing the traitor, thus safeguarding the kingdom from potential harm.";
            break;
          case "Performance":
            outcomeMessage = "The hero's captivating performance skills enthrall the crowd of nobles at the grand masquerade ball, impressing influential individuals, and providing them with valuable information for future endeavors.";
            break;
          case "Persuasion":
            outcomeMessage = "The hero's persuasive abilities and charisma convince the powerful warlord to join forces with their kingdom, strengthening their position and unity in the face of an imminent threat.";
            break;
          case "Religion":
            outcomeMessage = "The hero's unwavering devotion and successful completion of the trials and challenges during the pilgrimage to the sacred temple demonstrate their profound connection with the gods, earning them divine blessings.";
            break;
          case "Sleight of Hand":
            outcomeMessage = "The hero's masterful sleight of hand allows them to outwit the cunning thieves' guild, reclaiming the stolen heirloom and leaving behind an illusion that further confuses their adversaries.";
            break;
          case "Stealth":
            outcomeMessage = "The hero's exceptional stealth skills enable them to infiltrate the enemy camp undetected, gathering vital information and disabling their defenses, paving the way for a successful assault.";
            break;
          case "Survival":
            outcomeMessage = "The hero's survival instincts and knowledge of the wilderness enable them to lead their group through treacherous terrains, scarce resources, and harsh weather conditions, ensuring everyone's safe arrival at their destination.";
            break;
          case "Intelligence":
            outcomeMessage = "The hero's exceptional intelligence and problem-solving abilities allow them to crack the complex encryption guarding the secret plans, providing their faction with a critical advantage in the upcoming battle.";
            break;
          case "Wisdom":
            outcomeMessage = "The hero's wise judgment and intuition enable them to mediate a dispute between rival factions, fostering understanding, and preventing a violent conflict that could have resulted in devastating consequences.";
            break;
          case "Charisma":
            outcomeMessage = "The hero's magnetic charisma and persuasive charm win over the influential council members, swaying their decisions in favor of an important political reform that brings positive change to the realm.";
            break;
        }

        JOptionPane.showMessageDialog(panel, outcomeMessage, "Mission Outcome", JOptionPane.INFORMATION_MESSAGE);
        // Create an instance of GamePlayScreen and make it visible again
        GamePlayScreen gamePlayScreen;
        if(rolledNumber > 10) gamePlayScreen = new GamePlayScreen(heroNames,heroStats, missionsPassed+1, missionsFailed);
        else gamePlayScreen = new GamePlayScreen(heroNames, heroStats, missionsPassed, missionsFailed+1);
        gamePlayScreen.setVisible(true);

        // Close the MissionStoryScreen
        dispose();
      });
      buttonPanel.add(heroButton);
    }

    JButton statButton = new JButton("Stats");
    JButton helpButton = new JButton("Help");
    buttonPanel.add(statButton);
    helpButton.addActionListener(e -> {
      // Show a pop-up message
      JOptionPane.showMessageDialog(panel, "One of the 6 main stats gives you the best chance to succeed");
    });
    buttonPanel.add(helpButton);
    statButton.addActionListener(e -> {
      // Show a pop-up message
      StringBuilder messageBuilder = new StringBuilder();
      for (int i = 0; i < heroNames.length; i++) {
        String heroName = heroNames[i];
        messageBuilder.append("Hero: ").append(heroName).append("\n\n")
            .append("Strength: ").append(heroStats[i].getStatBlock()[0]).append("\n")
            .append("Agility: ").append(heroStats[i].getStatBlock()[1]).append("\n")
            .append("Intelligence: ").append(heroStats[i].getStatBlock()[2]).append("\n")
            .append("Charisma: ").append(heroStats[i].getStatBlock()[3]).append("\n")
            .append("Luck: ").append(heroStats[i].getStatBlock()[4]).append("\n")
            .append("Endurance: ").append(heroStats[i].getStatBlock()[5]).append("\n\n");
      }
      String message = messageBuilder.toString();
      JOptionPane.showMessageDialog(panel, message, "Hero Stats", JOptionPane.INFORMATION_MESSAGE);
    });
    // Add the buttonPanel to the bottom of the panel
    panel.add(buttonPanel, BorderLayout.SOUTH);
    add(panel);
    setLocationRelativeTo(null); // Center the window on the screen
  }
}



