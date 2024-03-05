/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginandsignup;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;

public class Advanced extends JFrame {
    private JTextPane textArea;
    private JTextArea inputArea;
    private JButton startButton;
    private JLabel timerLabel;
    private Timer timer;
    private int secondsLeft;
    private long startTime; // Declare startTime as an instance variable
    private long endTime;   // Declare endTime as an instance variable

    private String text = "<html><b><font size='7'>As technology advances, we are seeing a shift towards a more interconnected world. The internet has become a ubiquitous presence in our daily lives, connecting us with people and information from all over the globe. With this increased connectivity comes a wealth of opportunities for businesses and individuals alike. For example, e-commerce sales are expected to reach $4.9 trillion by 2021, a staggering number that showcases the growth and importance of online shopping. Additionally, social media platforms like Facebook and Instagram are playing a larger role in our lives, with over 2.7 billion active users across both platforms. These technological advancements have also led to the creation of new industries, such as big data analysis and cybersecurity, both of which are crucial to ensuring the stability and security of our connected world.</font></b></html>";

    public Advanced() {
        setTitle("Typing Test");
        setSize(1200, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextPane();
        textArea.setContentType("text/html");
        textArea.setEditable(false);
        textArea.setText(text);
        textArea.setPreferredSize(new Dimension(1000, 300));
        textArea.setFont(new Font("Arial", Font.BOLD, 20)); 
        textArea.setBackground(new Color(255, 222, 173)); // Light Orange

        inputArea = new JTextArea();
        inputArea.setWrapStyleWord(true);
        inputArea.setLineWrap(true);
        inputArea.setPreferredSize(new Dimension(1000, 294));
        inputArea.setFont(new Font("Arial", Font.PLAIN, 22));
        inputArea.setBackground(new Color(255, 255, 153)); // Light Yellow

        timerLabel = new JLabel();
        timerLabel.setFont(new Font("Arial", Font.BOLD, 32)); // Increased font size
        timerLabel.setForeground(Color.RED);
        timerLabel.setOpaque(true); // Make the label opaque
        timerLabel.setBackground(new Color(173, 216, 230)); // Light Blue
        timerLabel.setVisible(false);

        startButton = new JButton("Start Test");
        startButton.setPreferredSize(new Dimension(200, 60));
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setBackground(Color.WHITE);
        startButton.setForeground(Color.BLACK);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTestOptions();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(200, 60));
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new BorderLayout());

    // Add the back button to the left side of the panel
    buttonPanel.add(backButton, BorderLayout.WEST);

    // Create a panel for the start button and align it to the right
    JPanel startButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    startButtonPanel.add(startButton);

    // Add the panel containing the start button to the right side of the main button panel
    buttonPanel.add(startButtonPanel, BorderLayout.EAST);

    JPanel inputPanel = new JPanel(new BorderLayout());
    inputPanel.add(new JScrollPane(inputArea), BorderLayout.CENTER);
    inputPanel.add(buttonPanel, BorderLayout.SOUTH);


        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        getContentPane().add(inputPanel, BorderLayout.SOUTH);
        getContentPane().add(timerLabel, BorderLayout.NORTH);
        getContentPane().setBackground(new Color(230, 230, 230));

        setVisible(true);
    }

private void showTestOptions() {
    JFrame frame = new JFrame("Typing Test Options");
    frame.setSize(600, 400); // Increase the size of the frame
    frame.getContentPane().setBackground(new Color(255, 204, 153)); // Set background color to light orange

	

    JLabel titleLabel = new JLabel("Select Test Type");
    titleLabel.setFont(new Font("Verdana", Font.BOLD, 45)); // Increase the font size
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    titleLabel.setForeground(Color.BLACK); // Set the text color to red

    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    panel.setBackground(new Color(255, 204, 153)); // Set background color to light orange



    GridBagConstraints titleConstraints = new GridBagConstraints();
    titleConstraints.gridx = 0;
    titleConstraints.gridy = 0;
    titleConstraints.insets = new Insets(20, 20, 40, 20); // Add more padding
    panel.add(titleLabel, titleConstraints);

    JButton fullTextButton = new JButton("Type in Full Text");
    fullTextButton.setFont(new Font("Verdana", Font.BOLD, 24)); // Increase the font size
    fullTextButton.setBackground(new Color(51, 153, 255));
    fullTextButton.setForeground(Color.WHITE);
    fullTextButton.setPreferredSize(new Dimension(300, 60)); // Increase button size
    fullTextButton.addActionListener(e -> startFullTextTest());
    GridBagConstraints fullTextButtonConstraints = new GridBagConstraints();
    fullTextButtonConstraints.gridx = 0;
    fullTextButtonConstraints.gridy = 1;
    fullTextButtonConstraints.insets = new Insets(20, 20, 20, 20); // Add more padding
    panel.add(fullTextButton, fullTextButtonConstraints);

    JButton oneMinuteButton = new JButton("Type in One Minute");
    oneMinuteButton.setFont(new Font("Verdana", Font.BOLD, 24)); // Increase the font size
    oneMinuteButton.setBackground(new Color(255, 102, 102));
    oneMinuteButton.setForeground(Color.WHITE);
    oneMinuteButton.setPreferredSize(new Dimension(300, 60)); // Increase button size
    oneMinuteButton.addActionListener(e -> startOneMinuteTest());
    GridBagConstraints oneMinuteButtonConstraints = new GridBagConstraints();
    oneMinuteButtonConstraints.gridx = 0;
    oneMinuteButtonConstraints.gridy = 2;
    oneMinuteButtonConstraints.insets = new Insets(20, 20, 20, 20); // Add more padding
    panel.add(oneMinuteButton, oneMinuteButtonConstraints);

    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setVisible(true);
}


    private void startFullTextTest() {
        // Stop the timer and reset the timerLabel
        if (timer != null) {
            timer.stop();
            timerLabel.setVisible(false);
        }

        inputArea.setEnabled(true);
        startButton.setEnabled(false);
        inputArea.setText("");  // Clear any existing text
        inputArea.setFont(new Font("Arial", Font.BOLD, 20));  // Set font to bold
        inputArea.setForeground(Color.RED);  // Set text color to Red
        inputArea.requestFocus();

        inputArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Not needed, but required by the interface
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    endFullTextTest();
                    inputArea.removeKeyListener(this);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not needed, but required by the interface
            }
        });
    }


    private void startOneMinuteTest() {
        inputArea.setEnabled(true);
        startButton.setEnabled(false);
        inputArea.setText("");
        inputArea.setFont(new Font("Arial", Font.BOLD, 20));
        inputArea.setForeground(Color.RED);
        inputArea.requestFocus();
        secondsLeft = 60;
        timerLabel.setText("Time Remaining: " + secondsLeft + " seconds");
        timerLabel.setVisible(true);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsLeft--;
                timerLabel.setText("Time Remaining: " + secondsLeft + " seconds");
                if (secondsLeft == 0) {
                    endOneMinuteTest();
                }
            }
        });
        timer.start();

        inputArea.requestFocus();
    }

    private void endFullTextTest() {
    inputArea.setEnabled(false);

    String fullText = textArea.getText();
    String userInput = inputArea.getText();

    int correct = 0;
    int totalKeystrokes = 0;

    // Calculate the time elapsed during the test
    long startTime = System.currentTimeMillis();
    
    for (int i = 0; i < fullText.length(); i++) {
        totalKeystrokes++;
        if (i < userInput.length() && fullText.charAt(i) == userInput.charAt(i)) {
            correct++;
        }
    }

    long endTime = System.currentTimeMillis();
    long elapsedTime = endTime - startTime;
    
    // Calculate typing speed and accuracy
    double typingSpeed = (int) ((double) correct / (elapsedTime / 1000.0));
    int accuracy = (int) ((double) correct / userInput.length() * 100);

    displayResults("Typing Test Completed", typingSpeed, accuracy);
}

    private void endOneMinuteTest() {
        timer.stop();
        inputArea.setEnabled(false);

        String fullText = textArea.getText();
        String userInput = inputArea.getText();

        int correct = 0;
        int totalKeystrokes = 0;

        for (int i = 0; i < fullText.length(); i++) {
            totalKeystrokes++;
            if (i < userInput.length() && fullText.charAt(i) == userInput.charAt(i)) {
                correct++;
            }
        }

       long elapsedTime = endTime - startTime;
    
    // Calculate typing speed and accuracy
    double typingSpeed = (int) ((double) correct / (elapsedTime / 1000.0));
    int accuracy = (int) ((double) correct / userInput.length() * 100);

        displayResults("Typing Speed Completed ", typingSpeed, accuracy);
    }





private void displayResults(String title, double typingSpeed, int accuracy) {
    JFrame resultFrame = new JFrame(title);
    resultFrame.setSize(800, 600); // Set the size of the result frame
    resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    // Create a panel for the title
    JPanel titlePanel = new JPanel();
    titlePanel.setBackground(new Color(50, 50, 150)); // Dark Blue
    titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    JLabel titleLabel = new JLabel(title);
    titleLabel.setFont(new Font("Verdana", Font.BOLD, 45));
    titleLabel.setForeground(Color.WHITE);
    titlePanel.add(titleLabel);

    // Create a panel for result details
    JPanel resultPanel = new JPanel();
    resultPanel.setLayout(new GridLayout(2, 1));
    resultPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    JLabel typingSpeedLabel = new JLabel("Typing Speed: " + typingSpeed + " characters per second");
    typingSpeedLabel.setFont(new Font("Arial", Font.BOLD, 28));
    JLabel accuracyLabel = new JLabel("Accuracy: " + accuracy + "%");
    accuracyLabel.setFont(new Font("Arial", Font.BOLD, 28));

    resultPanel.add(typingSpeedLabel);
    resultPanel.add(accuracyLabel);

    // Create a panel for additional messages
    JPanel additionalMessagePanel = new JPanel();
    additionalMessagePanel.setBackground(new Color(255, 204, 153)); // Light Orange
    additionalMessagePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    String additionalMessage = "";

    if (typingSpeed >= 5.0) {
        additionalMessage = "<html><font size='25' color='red'><br>You Are A Good Typist</font><br><br><br><br><font size='20' color='blue'>Thank You So Much !</font></html>";
    } else if (typingSpeed >= 3.0) {
        additionalMessage = "<html><font size='25' color='red'><br>You Are A Average Typist</font><br><br><br><br><font size='20' color='blue'>Thank You So Much !</font></html>";
    } else {
        additionalMessage = "<html><font size='25' color='red'><br>You Need More Practice</font><br><br><br><br><font size='20' color='blue'>Thank You So Much !</font></html>";

    }

    JLabel additionalMessageLabel = new JLabel(additionalMessage);
    additionalMessageLabel.setFont(new Font("Arial", Font.BOLD, 28));

    additionalMessagePanel.add(additionalMessageLabel);

    // Create a panel for the close button
    JPanel closeButtonPanel = new JPanel();
    JButton closeButton = new JButton("Close");
    closeButton.setFont(new Font("Arial", Font.BOLD, 24));
    closeButtonPanel.add(closeButton);

    // Add components to the main panel
    mainPanel.add(titlePanel, BorderLayout.NORTH);
    mainPanel.add(resultPanel, BorderLayout.CENTER);
    mainPanel.add(additionalMessagePanel, BorderLayout.CENTER);
    mainPanel.add(closeButtonPanel, BorderLayout.SOUTH);

    resultFrame.add(mainPanel);
    resultFrame.setVisible(true);

    // Close the result frame when the close button is clicked
    closeButton.addActionListener(e -> resultFrame.dispose());
    startButton.setEnabled(true);
}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Advanced();
            }
        });
    }
}
