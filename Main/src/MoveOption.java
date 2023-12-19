import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveOption extends JFrame{
    private JButton attackButton;
    private JButton moveButton;
    private JLabel moveQuery;
    private JPanel moveOption;
    private boolean attack;

    public MoveOption(int player) {
        setContentPane(moveOption);
        setTitle("Battlistas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        moveQuery.setText("Player" + player + ". What would you like to do?");
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Change Projectile to Attack
                dispose();
            }
        });

        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Change Projectile to Move
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new MoveOption(2);
    }

}
