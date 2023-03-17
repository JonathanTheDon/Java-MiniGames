package rockpaperscissors;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlayGame extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L;
	private JButton rockButton, paperButton, scissorsButton;
    private JLabel playerLabel, computerLabel, resultLabel;
    private int playerScore, computerScore;

    public PlayGame() {
        // Set up the JFrame with a title and layout
        super("Rock Paper Scissors");
        setLayout(new FlowLayout());
        // Create the buttons for the player to choose rock, paper, or scissors
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");
        // Add the buttons to the JFrame and set their action commands
        add(rockButton);
        rockButton.setActionCommand("Rock");
        rockButton.addActionListener(this);
        
        add(paperButton);
        paperButton.setActionCommand("Paper");
        paperButton.addActionListener(this);
        
        add(scissorsButton);
        scissorsButton.setActionCommand("Scissors");
        scissorsButton.addActionListener(this);
        // Create the labels to display the player and computer choices, and the game result
        playerLabel = new JLabel("Player: ");
        computerLabel = new JLabel("Computer: ");
        resultLabel = new JLabel("");
        // Add the labels to the JFrame
        add(playerLabel);
        add(computerLabel);
        add(resultLabel);
        // Set the size and visibility of the JFrame
        setSize(600, 100);
        setVisible(true);
    }
     // This method is called when one of the buttons is clicked
    public void actionPerformed(ActionEvent e) {
    	// Get the player's choice from the button's action command
        String playerChoice = e.getActionCommand();  
        // Generate a random choice for the computer
        String[] choices = {"Rock", "Paper", "Scissors"};
        int computerIndex = (int) (Math.random() * 3);
        String computerChoice = choices[computerIndex];
        // Display the player and computer choices in the labels
        playerLabel.setText("Player: " + playerChoice);
        computerLabel.setText("Computer: " + computerChoice);
        // Determine the winner and display the result in the label
        if (playerChoice.equals(computerChoice)) {
            resultLabel.setText("It's a tie!");
        } else if (playerChoice.equals("Rock") && computerChoice.equals("Scissors")
                   || playerChoice.equals("Paper") && computerChoice.equals("Rock")
                   || playerChoice.equals("Scissors") && computerChoice.equals("Paper")) {
            resultLabel.setText("You win!");
            playerScore++;
        } else {
            resultLabel.setText("Computer wins!");
            computerScore++;
        }  
        // Display the current score in the JFrame title
        setTitle("Rock Paper Scissors (Player: " + playerScore + " Computer: " + computerScore + ")");
    } 
    public static void main(String[] args) {
    	PlayGame game = new PlayGame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}