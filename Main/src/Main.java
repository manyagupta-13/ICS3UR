import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    private JPanel main;
    private JPanel parentPanel;
    private JPanel mainMenu;
    private JPanel gameOptions;
    private JPanel gameOver;
    private JButton playButton;
    private JButton quitButton;
    private JRadioButton wizardRadioButtonP1;
    private JRadioButton ballistaRadioButtonP1;
    private JRadioButton wizardRadioButtonP2;
    private JRadioButton ballistaRadioButtonP2;
    private JButton playButton1;
    private JComboBox mapSelectionComboBox;
    private JButton startGameButton;
    private JLabel gameOptionsMessage;
    private JLabel results;

    private String p1CharChoice = "";
    private String p2CharChoice = "";

    public Main() {
        setContentPane(main);
        setTitle("Battlistas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        //Main Menu Action Listener:
        //Action Listener for Play Button in Main Menu
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Swap to Game Option Menu
                parentPanel.removeAll();
                parentPanel.add(gameOptions);
                parentPanel.repaint();
                parentPanel.revalidate();

            }
        });

        //Action Listener for Quit Button
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Exit the program
                System.exit(0);
            }
        });


        //GameOption Action Listeners
        wizardRadioButtonP1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1CharChoice = "wizard";
            }
        });

        ballistaRadioButtonP1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1CharChoice = "ballista";
            }
        });

        wizardRadioButtonP2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p2CharChoice = "wizard";
            }
        });

        ballistaRadioButtonP2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p2CharChoice = "ballista";
            }
        });


        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(p1CharChoice.isEmpty() || p2CharChoice.isEmpty()) {
                    gameOptionsMessage.setText("Please select characters for each player before starting!");
                } else {
                    dispose();
                    //new Game(p1CharChoice, p2CharChoice, mapSelectionComboBox.getSelectedIndex())
                    System.out.println(mapSelectionComboBox.getSelectedIndex());
                    System.out.println(p1CharChoice + " " + p2CharChoice);

                }

            }
        });

    }
    public static void main(String[] args) {
        new Main();
    }
}
