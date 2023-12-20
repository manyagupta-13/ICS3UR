import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Game extends JFrame implements MouseMotionListener, MouseListener {
    //GUI Related Instance Variables
    private JPanel gamePanel;
    private JProgressBar p1HealthBar;
    private JProgressBar p2HealthBar;
    private JLabel player1HealthLabel;
    private JLabel player2HealthLabel;
    private JPanel gameFieldPanel;

    //Gameplay affecting variables
    private final int mapSelection;


    private BufferedImage gameFieldVisuals;

    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    private int mouseXPosDragged;
    private int mouseYPosDragged;
    private boolean mouseIsDown;



    public Game(String player1Character, String player2Character, int mapSelection_) {
        mapSelection = mapSelection_;

        //Initialise MouseMotion Listener
        addMouseMotionListener(this);

        //Set Starting Positions and Content Panel
        setContentPane(gamePanel);
        setTitle("[GAME NAME]");

        //Define Panel Attributes
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1400, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        //Define Player Objects
        //TODO: Define Player Start Coordinates here!
        int[] playerStartCoords = new int[] {300, 300, 1100, 300};
        player1 = new Player(player1Character, playerStartCoords[0], playerStartCoords[1]);
        player2 = new Player(player2Character, playerStartCoords[2], playerStartCoords[3]);

        currentPlayer = player1;

        System.out.println(player1.getXPos() + ", " + player1.getYPos());
        System.out.println(player1.getXPos()+player1.getWidth());

        //DefineHealthBarDisplay
        p1HealthBar.setValue(100);
        p2HealthBar.setValue(100);

        //MouseListener
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                mouseIsDown = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mouseIsDown = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });


        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //TODO: (Manya + Jimmy) Feed mouse dragged position to weapon object through player
                //Feed coordinates to weapon via e.getY() and e.getX()
                //See https://www.javatpoint.com/java-mousemotionlistener for more details
                mouseXPosDragged = e.getX();
                mouseYPosDragged = e.getY();

                System.out.println("(" + mouseXPosDragged + ", " + mouseYPosDragged + ")");


                //DrawShortPath
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {}
        });

        repaint();
        //TODO: Ensure connectivity to player objects
    }

    public static void weaponFire(Player player){
        //Get path from player's weapon

    }


    private void drawFirePath(Graphics g) {
        currentPlayer.getWeapon().setCoords(mouseXPosDragged, mouseYPosDragged);
        g.drawOval(30, 30, 30, 30);
        int[][] tempProjectedPoints = currentPlayer.getWeapon().getPathShort();

        System.out.println(Arrays.toString(tempProjectedPoints[0]) + ", " + Arrays.toString(tempProjectedPoints[1]));
        int radius = 9;

        for(int i = 0; i < 3; i++) {
            g.drawOval(tempProjectedPoints[0][i], tempProjectedPoints[1][i], radius, radius);
            g.setColor(Color.BLUE);
            radius -= 3;
        }
    }

    //Paint
    //TODO: (Kale) Try to resolve flickering through double-buffering by rendering in gameFieldPanel only
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponents(g);
        g.drawImage(player1.getImage(), player1.getXPos(), player1.getYPos(), this);
        g.drawImage(player1.getWeapon().getDisplayImg(), player1.getWeapon().getXPos(), player1.getWeapon().getYPos(), this);

        if(mouseIsDown) {
            drawFirePath(g);
            System.out.println("Painted");
        }
//        //Draw Players
//        g.drawImage(player1.getImage(), player1.getXPos(), player1.getYPos, this);
//        //g.drawImage(player2.getImage(), player2.getXPos(), player2.getYPos, this);
//
//        //Example code which moves a blue rectangle when mouse is dragged.
//        g.setColor(Color.BLUE);
//        g.fillRect(mouseXPosDragged, mouseYPosDragged, 50, 50);
//
//        switch (mapSelection) {
//            case 0 -> drawMap1(g);
//            case 1 -> drawMap2(g);
//            case 2 -> drawMap3(g);
//            case 4 -> testMap(g);
//        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Game("wizard", "ballista", 0);
        });
    }

    //Map Drawings
    //TODO: (Chris) Add Obstacle design in drawMap# Methods

    private void testMap(Graphics g) {
    }

    private void drawMap1(Graphics g) {
        //Example code on drawing a rectangle (You specify xPos and yPos for each rectangle)
        //g.setColor(Color.BLUE);
        //g.fillRect(xPos, yPos, 50, 50)

    }

    private void drawMap2(Graphics g) {

    }

    private void drawMap3(Graphics g) {

    }

    //Mouse Input Listener Methods
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    //mouseMoved method from MouseMotionListener interface - never used
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}