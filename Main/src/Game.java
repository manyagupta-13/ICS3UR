import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Game extends JFrame implements MouseMotionListener {
    private JPanel gamePanel;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JLabel player1HealthLabel;
    private JLabel player2HealthLabel;
    private JPanel gameFieldPanel;

    private final int mapSelection;

    //private final Player player1;
    //private final Player player2;
    int currentTurn = 0;

    private int mouseXPosDragged;
    private int mouseYPosDragged;

    public Game(String player1Character, String player2Character, int mapSelection_) {
        mapSelection = mapSelection_;

        //Initialise MouseMotion Listener
        addMouseMotionListener(this);

        //Set Starting Positions and Content Panel
        setContentPane(gamePanel);
        setTitle("Battlistas");



        //Define Panel Attributes
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1400, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        /*TODO: Ensure connectivity to player objects
        Code dependencies to be integrated:

        player1 = new Player(player1Character, );
        player2 = new Player(player2Character, );

         */


    }

    //TODO: (Kale) Try to resolve flickering through double-buffering by rendering in gameFieldPanel only
    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);

        //Draw Players
        //g.drawImage(player1.getImage(), player1.getXPos(), player1.getYPos, this);
        //g.drawImage(player2.getImage(), player2.getXPos(), player2.getYPos, this);

        //Example code which moves a blue rectangle when mouse is dragged.
        g.setColor(Color.BLUE);
        g.fillRect(mouseXPosDragged, mouseYPosDragged, 50, 50);

        switch (mapSelection) {
            case 0:
                drawMap1(g);
            case 1:
                drawMap2(g);
            case 2:
                drawMap3(g);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Game("wizard", "ballista", 0);
        });
    }


    //TODO: (Chris) Add Obstacle design in drawMap# Methods
    private void drawMap1(Graphics g) {
        //Example code on drawing a rectangle (You specify xPos and yPos for each rectangle)
        //g.setColor(Color.BLUE);
        //g.fillRect(xPos, yPos, 50, 50)

    }

    private void drawMap2(Graphics g) {

    }

    private void drawMap3(Graphics g) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //TODO: (Manya + Jimmy) Feed mouse dragged position to weapon object through player
        //Feed coordinates to weapon via e.getY() and e.getX()
        //See https://www.javatpoint.com/java-mousemotionlistener for more details
        mouseXPosDragged = e.getX();
        mouseYPosDragged = e.getY();

        System.out.println("(" + mouseXPosDragged + ", " + mouseYPosDragged + ")");

        switch (currentTurn) {
            case 0:
                //player1.weapon.pullBackCoords(mouseXPosDragged, mouseYPosDragged); (Just Stand-in Example Code)
                break;
            case 1:
                //player2.weapon.pullBackCoords(mouseXPosDragged, mouseYPosDragged); (Just Stand-in Example Code)
                break;
        }
        repaint();
    }

    //mouseMoved method from MouseMotionListener interface - never used
    @Override
    public void mouseMoved(MouseEvent e) {
    }
}