/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginandsignup;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class TaskOne{

    private static JFrame frame = new JFrame("Typing Test");
    private JPanel typingPanel = new JPanel();



    class CustomJLabel extends JLabel {
        public CustomJLabel(String text) {
            super(text);
            setOpaque(true); // Make the label opaque
            setBackground(new Color(173, 216, 230)); // Light blue background

        }
    }

    // Replace your existing JLabels with the custom JLabels
    private JLabel instructions1 = new CustomJLabel("<html><font color = 'RED' >Task :- You Have to Type >= 20 words in 1 Minute To Win These Task </font></html>");
    private JLabel instructions2 = new CustomJLabel("To begin the test, press the start button below.");
    private JLabel instructions3 = new CustomJLabel("You have one minute to type the sentence");
    private JLabel instructions4 = new CustomJLabel("as many times as you can. Good luck.");
    private JLabel sentenceToType = new CustomJLabel("The quick brown fox jumped over the lazy dog.");
    private JTextArea wordBank = new JTextArea(20, 70);
    private JButton startButton = new JButton("Click  These  Start  Button");
    private JButton resetButton = new JButton("Reset");
    private JLabel secLeftPrompt = new JLabel("Seconds Left:");
    public static JLabel secondsLeft = new JLabel("60");
    private JLabel line = new CustomJLabel("");
	  





    private Timer timer;
    private TimerTask task;
    private TimerTask task2;

    public TaskOne() {
        resetButton.setEnabled(false);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		startButton.setEnabled(true);
                wordBank.setEditable(false);
                wordBank.setText("");
                secondsLeft.setText("60");
                if (task != null) {
                    task.cancel();
                }
                if (task2 != null) {
                    task2.cancel();
                }
            }
        });
        
        // Set the background color of the resetButton to blue and text color to white
        resetButton.setBackground(Color.WHITE);
        resetButton.setForeground(Color.BLACK);
        
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetButton.setEnabled(true);
                pickRandomSentence();
                wordBank.setEditable(true);
                wordBank.setText("");
                secondsLeft.setText("60");
                if (task != null) {
                    task.cancel();
                }
                if (task2 != null) {
                    task2.cancel();
                }

                timer = new Timer();
                task = new TimerTask() {
                    @Override
                    public void run() {
                        int wpm = calculateWPM();
                        showResultDialog(wpm);
                        wordBank.setEditable(false);
                    }
                };

                updateSecondsCountdown();
                startButton.setEnabled(false); // Disable the Start button
                timer.schedule(task, 60000);
            }
        });
        
        // Set the background color of the startButton to blue and text color to white
        startButton.setBackground(UIManager.getColor("Button.background"));
        startButton.setForeground(Color.BLACK);
    }

    public static void main(String[] args) {
        TaskOne ty = new TaskOne();
        ty.initializeDisplay();
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(1000, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(ty.typingPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateSecondsCountdown() {
        Timer t2 = new Timer();
        task2 = new TimerTask() {
            int secLeft = 59;

            @Override
            public void run() {
                String sec = String.valueOf(secLeft);
                if (secLeft < 10) {
                    sec = "0" + sec;
                }
                secondsLeft.setText(sec);
                secondsLeft.setForeground(Color.RED);
                secLeft -= 1;

                if (secLeft < 0) {
                    task2.cancel();
                }
            }
        };

        t2.schedule(task2, 1000, 1000);
    }

    private int calculateWPM() {
        String[] correctWords = sentenceToType.getText().split(" ");
        String[] typedWords = wordBank.getText().split(" ");
        double repeats = Math.ceil(typedWords.length / (double) correctWords.length);
        int correctWordCount = 0;

        for (int i = 0; i < typedWords.length; i++) {
            if (i < correctWords.length * repeats && typedWords[i].equals(correctWords[i % correctWords.length])) {
                correctWordCount++;
            }
        }

        return correctWordCount;
    }

   private void showResultDialog(int wpm) {
    JDialog resultDialog = new JDialog(frame, "Typing Test Result");
    resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    resultDialog.setSize(800, 300);

    JPanel resultPanel = new JPanel();
    resultPanel.setLayout(new BorderLayout());

    // Change the background color to orange
    resultPanel.setBackground(new Color(173, 216, 230)); // result background Color

    JLabel resultLabel = new JLabel("<html><br/><br/>You typed " + wpm + " words per minute correctly in 60 seconds.</html>");
    Font boldFont = new Font("Arial", Font.BOLD, 28);
    resultLabel.setFont(boldFont);
    resultLabel.setHorizontalAlignment(JLabel.CENTER);

    // Add an additional message if the user typed 20 correct words
    String additionalMessage = "";
    if (wpm >= 20) {
        additionalMessage = "Congratulations, you won!";
    } else {
        additionalMessage = "Oops, You Lost!";
    }

    JLabel additionalMessageLabel = new JLabel("<html>" + additionalMessage + "</html>");
    additionalMessageLabel.setFont(boldFont);
    additionalMessageLabel.setHorizontalAlignment(JLabel.CENTER);

    resultPanel.add(resultLabel, BorderLayout.NORTH);
    resultPanel.add(additionalMessageLabel, BorderLayout.CENTER);
    resultDialog.add(resultPanel);

    resultDialog.setVisible(true);
}





    private void pickRandomSentence() {
        Random r = new Random();
        String[] sentences = new String[10];
        sentences[0] = "The quick brown fox jumped over the lazy dog.";
        sentences[1] = "The small boy went down to the apple orchard.";
        sentences[2] = "The teacher asked the class if anyone knew the answer.";
        sentences[3] = "The spry owl flew down from the top of the tree.";
        sentences[4] = "The musician jumped off the edge of the stage.";
        sentences[5] = "The math test was extremely hard for most of the students.";
        sentences[6] = "The computer program took too long to finish.";
        sentences[7] = "The car wash was postponed to next weekend instead.";
        sentences[8] = "The backpack was on sale for half its regular price.";
        sentences[9] = "The water spilled all over the student's history report.";
        int num = r.nextInt(10);
        sentenceToType.setText(sentences[num]);
    }

    private void initializeDisplay() {
        Font font = new Font("Arial", Font.BOLD, 22);
        instructions1.setFont(font);
        instructions2.setFont(font);
        instructions3.setFont(font);
        instructions4.setFont(font);
        sentenceToType.setFont(font);
        startButton.setFont(font);
        resetButton.setFont(font);
        wordBank.setFont(font);

        Font lineFont = new Font(line.getFont().getName(), Font.BOLD, 24);
        line.setFont(lineFont);

        instructions1.setForeground(Color.BLUE);
        instructions2.setForeground(Color.BLUE);
        instructions3.setForeground(Color.BLUE);
        instructions4.setForeground(Color.BLUE);
        sentenceToType.setForeground(Color.RED);

        Font secondsLeftFont = new Font("Arial", Font.BOLD, 36);
        secLeftPrompt.setFont(secondsLeftFont);
        secondsLeft.setFont(secondsLeftFont);

        wordBank.setBackground(new Color(255, 255, 204)); // Light yellow
        wordBank.setEditable(false);
        wordBank.setLineWrap(true);
        typingPanel.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new GridLayout(7, 1));
        topPanel.add(instructions1);
        topPanel.add(instructions2);
        topPanel.add(instructions3);
        topPanel.add(instructions4);
        topPanel.add(line);
        topPanel.add(sentenceToType);
        topPanel.add(startButton);
        typingPanel.add(topPanel, BorderLayout.NORTH);
        typingPanel.add(new JScrollPane(wordBank, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(secLeftPrompt);
        bottomPanel.add(secondsLeft);
        bottomPanel.add(resetButton);
        typingPanel.add(bottomPanel, BorderLayout.SOUTH);



JButton backButton = new JButton("Back");
    backButton.setFont(font);
    backButton.setBackground(Color.WHITE);
    backButton.setForeground(Color.BLACK);

    // Add action listener for the back button
    backButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose(); // Close the JFrame
        }
    });

    // Create a panel for the bottom buttons
    JPanel bottomButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    bottomButtonPanel.add(secLeftPrompt);
    bottomButtonPanel.add(secondsLeft);
    bottomButtonPanel.add(resetButton);
    bottomButtonPanel.add(backButton); // Add the back button to the bottom panel

    typingPanel.add(bottomButtonPanel, BorderLayout.SOUTH);
    }
}
