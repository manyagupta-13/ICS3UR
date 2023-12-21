import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

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

    //Player variables
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    //Mouse Tracking Instance Variables
    private int mouseXPosDragged;
    private int mouseYPosDragged;
    private boolean mouseIsDown;
    private boolean mouseReleased;

    //Animation Frame Counter
    private int flyingAnimationFrameNum;
    private int currentFrameNum;


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
        int[] playerStartCoords = new int[]{300, 300, 1100, 300};
        player1 = new Player(player1Character, playerStartCoords[0], playerStartCoords[1]);
        player2 = new Player(player2Character, playerStartCoords[2], playerStartCoords[3]);

        currentPlayer = player1;

        System.out.println(player1.getXPos() + ", " + player1.getYPos());
        System.out.println(player1.getXPos() + player1.getWidth());

        //DefineHealthBarDisplay
        p1HealthBar.setValue(100);
        p2HealthBar.setValue(100);

        //MouseListener
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mouseIsDown = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mouseIsDown = false;
                mouseReleased = true;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });


        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //TODO: (Manya + Jimmy) Feed mouse dragged position to weapon object through player
                //Feed coordinates to weapon via e.getY() and e.getX()
                //See https://www.javatpoint.com/java-mousemotionlistener for more details
                mouseXPosDragged = e.getX();
                mouseYPosDragged = e.getY();

                //System.out.println("(" + mouseXPosDragged + ", " + mouseYPosDragged + ")");


                //DrawShortPath
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        //Default Frame Num Values
        currentFrameNum = 0;

        repaint();
        //TODO: Ensure connectivity to player objects
    }

    private void weaponFire(Graphics g) throws InterruptedException {
        //Get path from player's weapon
        if (currentFrameNum == flyingAnimationFrameNum - 1) {
            //Reset Fire Sequence Variables
            mouseReleased = false;
            currentFrameNum = 0;
        } else {
            currentFrameNum++;
            repaint();
        }
    }


    private void drawFirePath(Graphics g) {
        currentPlayer.setXPos(300);
        currentPlayer.setYPos(300);

        currentPlayer.getWeapon().setCoords(mouseXPosDragged, mouseYPosDragged);
        System.out.println("Mouse Coords: " + mouseXPosDragged + ", " + mouseYPosDragged);

        g.drawOval(30, 30, 30, 30);
        int[][] tempProjectedPoints = currentPlayer.getWeapon().getPathShort();
        int[][] testingLongList = currentPlayer.getWeapon().getPathFull();

        System.out.println("XPos on short list: " + tempProjectedPoints[0][0]);
        System.out.println("XPos on long list: " + testingLongList[0][0]);
//        System.out.println(Arrays.toString(tempProjectedPoints[0]) + ", " + Arrays.toString(tempProjectedPoints[1]));
//        System.out.println(Arrays.toString(testingLongList[0]) + ", " + Arrays.toString(testingLongList[1]));

        int radius = 9;


        for (int i = 0; i < 3; i++) {
            g.drawOval(tempProjectedPoints[0][i] + currentPlayer.getWeapon().getXPos(), tempProjectedPoints[1][i] + currentPlayer.getWeapon().getYPos(), radius, radius);
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

        if (mouseIsDown) {
            drawFirePath(g);
            //System.out.println("Painted");
        } else if (mouseReleased) {
            //Get projected points from current player's weapon
            int[][] tempProjectedPoints = currentPlayer.getWeapon().getPathFull();
            flyingAnimationFrameNum = tempProjectedPoints[0].length;
            Projectile testingProj = new Projectile(0, currentPlayer.getWeapon().getXPos(), currentPlayer.getWeapon().getXPos());

            int currentProjectileXPos = tempProjectedPoints[0][currentFrameNum] + currentPlayer.getWeapon().getXPos();
            int currentProjectileYPos = tempProjectedPoints[1][currentFrameNum] + currentPlayer.getWeapon().getYPos();

            System.out.println(currentProjectileXPos + ", " + currentProjectileYPos);
            System.out.println("Frame Number: " + currentFrameNum);

            g.drawOval(currentProjectileXPos, currentProjectileYPos, 10, 10);
            g.drawOval(100 + 5 * currentFrameNum, 100 + 5 * currentFrameNum, 10, 10);
            testingProj.setXPos(currentProjectileXPos);
            testingProj.setYPos(currentProjectileYPos);
            //g.drawImage(testingProj.getImage(), testingProj.getXPos() + testingProj.getXCenterBall(), testingProj.getYPos() + testingProj.getYCenterBall(), this);

            try {
                Thread.sleep((int) (currentPlayer.getWeapon().getSpeed() * 50));
                weaponFire(g);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
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
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        gamePanel.add(panel1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        p1HealthBar = new JProgressBar();
        p1HealthBar.setString("");
        p1HealthBar.setStringPainted(false);
        panel1.add(p1HealthBar, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        player1HealthLabel = new JLabel();
        player1HealthLabel.setText("Player 1 Health");
        panel1.add(player1HealthLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        gamePanel.add(panel2, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        p2HealthBar = new JProgressBar();
        panel2.add(p2HealthBar, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        player2HealthLabel = new JLabel();
        player2HealthLabel.setText("Player 2 Health");
        panel2.add(player2HealthLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gameFieldPanel = new JPanel();
        gameFieldPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        gamePanel.add(gameFieldPanel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(1400, 500), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return gamePanel;
    }

}