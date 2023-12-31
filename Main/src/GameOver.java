/*
Game over GUI
Kale Wu
12/21/2023

Window which displays game results and redirects to main menu.
 */

//Import Dependencies
//Intellij UI Designer
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

//JSwing and AWT for GUI Animation and Input Listening
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends JFrame {
    //Create GUI Objects
    private JPanel gameOverPanel;
    private JButton returnToMainMenuButton;
    private JLabel winnerMessage;
    private JLabel gameOverMessage;
    private JPanel win;



    public GameOver(String winner) {
        //Define Panel Characteristics
        setContentPane(gameOverPanel);
        setTitle("Wizard Battle!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        //Display appropriate winner message
        winnerMessage.setText("Congratulations " + winner + ", you are the superior wizard!");

        //Listener for main menu redirect
        returnToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenu();
                setVisible(false);
            }
        });
    }

    //GUI Source code alternative to .form file (Converted automatically from .form file)
    //Note: forms_rt.jar must be added to classpath in order to run this program!

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        gameOverPanel = new JPanel();
        gameOverPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        win = new JPanel();
        win.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        gameOverPanel.add(win, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        gameOverMessage = new JLabel();
        gameOverMessage.setHorizontalAlignment(0);
        gameOverMessage.setText("Game Over!");
        win.add(gameOverMessage, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        winnerMessage = new JLabel();
        winnerMessage.setHorizontalAlignment(0);
        winnerMessage.setText("Label");
        win.add(winnerMessage, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        gameOverPanel.add(panel1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        returnToMainMenuButton = new JButton();
        returnToMainMenuButton.setText("Return to MainMenu Menu");
        panel1.add(returnToMainMenuButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return gameOverPanel;
    }

}
