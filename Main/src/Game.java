import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private JPanel gamePanel;

    private int mapSelection;

    private final Player player1;
    private final Player player2;

    public Game(String player1Character, String player2Character, int mapSelection_) {
        mapSelection = mapSelection_;

        //Set Starting Positions and Content Panel
        gamePanel = new JPanel();
        setContentPane(gamePanel);
        setTitle("Battlistas");

        //Define Panel Attributes
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1400, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        /*TODO: Add Map object and ensure connectivity to player objects
        Code dependencies to be integrated:

        Player player2 = new Player(player2Character);
        player1 = new Player(player1Character, );
        player2 = new Player(player2Character, );

        Map HAS-A Player

        //Map needs to be able to communicate with player class to specify starting positions
        Map mapLayout = new Map(mapSelection);

         */
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);

        //Draw Players
        g.drawImage(player1.getImage(), player1.getXPos(), player1.getYPos, this);
        g.drawImage(player2.getImage(), player2.getXPos(), player2.getYPos, this);

        switch (mapSelection) {
            case 0:
                drawMap1(g);
            case 1:
                drawMap2(g);
            case 2:
                drawMap3(g);
        }
        super.paint(g);
        g.clearRect(0, 0, getWidth(), getHeight());
        //g.drawString("Coordinates: (" + x + ", " + y + ")", 150, 50);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 50, 50);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Game("wizard", "ballista", 0);
        });
    }


    //TODO: Implement Obstacle design in drawMap# Methods
    private void drawMap1(Graphics g) {

    }

    private void drawMap2(Graphics g) {

    }

    private void drawMap3(Graphics g) {

    }
}