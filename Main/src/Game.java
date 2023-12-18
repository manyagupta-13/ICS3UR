import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private int mapSelection;
    private String player1Character;
    private String player2Character;
    private JPanel Game;

    public Game(String player1Character_, String player2Character_, int mapSelection_) {
        player1Character = player1Character_;
        player2Character = player2Character_;
        mapSelection = mapSelection_;

        setContentPane(Game);
        setTitle("Battlistas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1400, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        /*Code dependencies to be integrated:
        Player player1 = new Player(player1Character);
        Player player2 = new Player(player2Character);

        //Map needs to be able to communicate with player class to specify starting positions
        Map mapLayout = new Map(mapSelection);

         */
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.clearRect(0, 0, getWidth(), getHeight());
        //g.drawString("Coordinates: (" + x + ", " + y + ")", 150, 50);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 50, 50);
    }
    public static void main(String[] args) {
        new Game("wizard", "ballista", 0);
        //SwingUtilities.invokeLater(() -> {});
    }


}
