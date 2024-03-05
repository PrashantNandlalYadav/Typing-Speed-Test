/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginandsignup;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGui {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
    JFrame frame = new JFrame("Level Selection");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1300, 720);
    


    // Center the frame on the screen
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screenSize.width - frame.getWidth()) / 2;
    int y = (screenSize.height - frame.getHeight()) / 2;
    frame.setLocation(x, y);

    JPanel panel = new JPanel(new GridBagLayout()) {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Set the background color to light orange
            g.setColor(new Color(255, 220, 180));
            g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // Increased insets for buttons

        JButton beginnerButton = new JButton("Beginner");
        JButton intermediateButton = new JButton("Intermediate");
        JButton advancedButton = new JButton("Advanced");
        JButton taskButton = new JButton("Task");
        JButton instructionsButton = new JButton("Instructions");
        JButton closeButton = new JButton("Close"); // Added Close button

        Font buttonFont = new Font("Arial", Font.PLAIN, 18); // Increased font size
        beginnerButton.setFont(buttonFont);
        intermediateButton.setFont(buttonFont);
        advancedButton.setFont(buttonFont);
        taskButton.setFont(buttonFont);
        instructionsButton.setFont(buttonFont);
        closeButton.setFont(buttonFont);

        Dimension buttonSize = new Dimension(200, 40); // Adjusted button size
        beginnerButton.setPreferredSize(buttonSize);
        intermediateButton.setPreferredSize(buttonSize);
        advancedButton.setPreferredSize(buttonSize);
        taskButton.setPreferredSize(buttonSize);
        instructionsButton.setPreferredSize(buttonSize);
        closeButton.setPreferredSize(buttonSize); // Set Close button size

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(beginnerButton, gbc);

        gbc.gridy++;
        panel.add(intermediateButton, gbc);

        gbc.gridy++;
        panel.add(advancedButton, gbc);

        gbc.gridy++;
        panel.add(taskButton, gbc);

        gbc.gridy++;
        panel.add(instructionsButton, gbc);

        gbc.gridy++;
        panel.add(closeButton, gbc); // Added Close button

        frame.add(panel);
        frame.setVisible(true);

        beginnerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BeginnerLevel.main(null); // Call the main method of TypingTest
            }
        });

        intermediateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TypingTest.main(null); // Call the main method of TypingTest
            }
        });

        advancedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Advanced.main(null); // Call the main method of TypingTest
            }
        });

        taskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createTaskGUI();
            }
        });

        instructionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TypingSpeedTestInstructionGUI.main(null);
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the main window
            }
        });
    }

    private static void createTaskGUI() {
    JFrame taskFrame = new JFrame("Task Selection");
    taskFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    taskFrame.setSize(450, 350);

    JPanel panel = new JPanel(new GridBagLayout()) {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Set the background color to light orange
            g.setColor(new Color(255, 220, 180));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);

    JButton taskOneButton = new JButton("Task One");
    JButton taskTwoButton = new JButton("Task Two");
    JButton backButton = new JButton("Back");

    Font buttonFont = new Font("Arial", Font.PLAIN, 14);
    taskOneButton.setFont(buttonFont);
    taskTwoButton.setFont(buttonFont);
    backButton.setFont(buttonFont);

    Dimension largerButtonSize = new Dimension(200, 50); // Larger size for Task buttons
    Dimension smallerButtonSize = new Dimension(180, 40); // Smaller size for Back button
    taskOneButton.setPreferredSize(new Dimension(largerButtonSize.width, 40)); // Task One slightly smaller
    taskTwoButton.setPreferredSize(new Dimension(largerButtonSize.width, 40)); // Task Two slightly smaller
    backButton.setPreferredSize(smallerButtonSize);

    gbc.gridx = 0;
    gbc.gridy = 0;
    panel.add(taskOneButton, gbc);

    gbc.gridy++;
    panel.add(taskTwoButton, gbc);

    gbc.gridy++;
    panel.add(backButton, gbc);

    taskFrame.add(panel);
    taskFrame.setVisible(true);

    taskOneButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            TaskOne.main(null);
        }
    });

    taskTwoButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            TaskTwo.main(null);
        }
    });

    backButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            taskFrame.dispose();
        }
    });
}


    private static void showButtonMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
