/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginandsignup;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TypingSpeedTestInstructionGUI extends JFrame {
    public TypingSpeedTestInstructionGUI() {
        setTitle("Typing Speed Test Instructions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Adjusted smaller dimensions
        setLocationRelativeTo(null); // Center the window

        // Create a panel to hold the instructions
        JPanel instructionPanel = new JPanel();
        instructionPanel.setLayout(new BoxLayout(instructionPanel, BoxLayout.Y_AXIS));
        instructionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Smaller border
        instructionPanel.setBackground(new Color(255, 204, 153)); // Light orange color

        // Add a decorative title
        JLabel title = new JLabel("Typing Speed Test Instructions");
        title.setFont(new Font("Arial", Font.BOLD, 24)); // Smaller font size
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create a shorter set of adjusted instructions with smaller font
        JTextArea instructionsTextArea = new JTextArea(
                "1. Choose difficulty level: Beginner, Intermediate, or Advanced.\n" +
                "2. Click 'Start Test' to begin.\n" +
                "3. Complete the task quickly and accurately.\n" +
                "4. Minimize the window to switch tasks.\n" +
                "5. Keep fingers on home row keys (ASDF, JKL;).\n" +
                "6. Focus on proper touch-typing technique.\n" +
                "7. Minimize errors; accuracy matters.\n" +
                "8. Use keyboard shortcuts to improve efficiency.\n" +
                "9. Rest wrists on a pad to prevent strain.\n" +
                "10. Maintain good posture.\n" +
                "11. Use proper keyboard ergonomics.\n" +
                "12. Warm up fingers and wrists.\n" +
                "13. Challenge yourself to improve.\n" +
                "14. Take regular breaks to prevent fatigue.\n" +
                "15. Customize typing environment.\n" +
                "16. Track progress and set goals.\n" +
                "17. Stay motivated; practice regularly.\n" +
                "18. Practice leads to improvement.\n" +
                "19. Enjoy the test and have fun!\n" +
                "20. For assistance, contact: 9321122580."
        );
        instructionsTextArea.setFont(new Font("Arial", Font.PLAIN, 18)); // Smaller font size
        instructionsTextArea.setLineWrap(true);
        instructionsTextArea.setWrapStyleWord(true);
        instructionsTextArea.setEditable(false);
        instructionsTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add a Back button
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	backButton.setFont(backButton.getFont().deriveFont(Font.BOLD, 20f)); // Larger font size
        backButton.setPreferredSize(new Dimension(100, 40));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current window when Back is clicked
            }
        });

        // Add components to the main frame
        instructionPanel.add(title);
        instructionPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        instructionPanel.add(instructionsTextArea);
        instructionPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        instructionPanel.add(backButton);

        add(instructionPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TypingSpeedTestInstructionGUI();
        });
    }
}

