/*
Game window GUI
Kale Wu
12/21/2023

Window which integrates other classes to handle the GUI representation of the game.
 */


//Import Dependencies
//Intellij UI Designer
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

//JSwing and AWT for GUI Animation and Input Listening
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class Game extends JFrame implements MouseMotionListener, MouseListener {
    //Create GUI Objects
    private JPanel gamePanel;
    private JProgressBar p1HealthBar;
    private JProgressBar p2HealthBar;
    private JLabel player1HealthLabel;
    private JLabel player2HealthLabel;
    private JPanel gameFieldPanel;

    //Buffered Image for Background Rendering (Not yet integrated)
    private BufferedImage gameFieldVisuals;

    //Player variables
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private Player inActivePlayer;

    //Mouse Tracking Instance Variables
    private int mouseXPosDragged;
    private int mouseYPosDragged;
    private boolean mouseIsDown;
    private boolean mouseReleased;

    //Animation Frame Counter
    private int flyingAnimationFrameNum;
    private int currentFrameNum;

    //Animation listener pause
    private boolean pauseListeners;


    public Game(String player1Character, String player2Character, int mapSelection_) {
        //Gameplay affecting variables

        //Initialise MouseMotion Listener
        addMouseMotionListener(this);

        //Set Starting Positions and Content Panel
        setContentPane(gamePanel);
        setTitle("Wizard Battle!");

        //Define Panel Characteristics
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1400, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        //Define Player Objects
        //TODO: Define Player Start Coordinates here!
        int[] playerStartCoords = new int[]{300, 300, 1100, 300};
        player1 = new Player(player1Character, 300, 300);
        player2 = new Player(player2Character, 1100, 300);

        currentPlayer = player1;
        inActivePlayer = player2;

        //DefineHealthBarDisplay
        p1HealthBar.setMaximum(100);
        p2HealthBar.setMaximum(100);
        p1HealthBar.setValue(player1.getHealth());
        p2HealthBar.setValue(player2.getHealth());

        //MouseListener
        pauseListeners = false;

        //Add Mouse Listener (Mouse Pressed and Release Detection) to Window
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //Set boolean variables
                if (!pauseListeners) {
                    mouseIsDown = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //Set boolean variables
                if (!pauseListeners) {
                    mouseIsDown = false;
                    mouseReleased = true;
                }
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        //Add Mouse Motion Listener to Window
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //Continuously update position and rerender
                if (!pauseListeners) {
                    mouseXPosDragged = e.getX();
                    mouseYPosDragged = e.getY();
                }
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        //Default Frame Num Values
        currentFrameNum = 0;

        repaint();

    }

    //Method weaponFire recursively updates paint() to render the ball flying animation
    private void weaponFire(Graphics g) throws InterruptedException {
        //Get path from player's weapon
        if (currentFrameNum == flyingAnimationFrameNum - 1) {
            //Reset Fire Sequence Variables
            pauseListeners = false;
            mouseReleased = false;
            currentFrameNum = 0;

            //Switch Current Player
            if (currentPlayer == player1) {
                currentPlayer = player2;
                inActivePlayer = player1;
            } else {
                currentPlayer = player1;
                inActivePlayer = player2;
            }

        } else {
            currentFrameNum++;
            repaint();
        }
    }

    //Method for drawing the fire path preview
    private void drawFirePath(Graphics g) {
        //Get coordinates from current player's weapon
        currentPlayer.getWeapon().setCoords(mouseXPosDragged, mouseYPosDragged);
        int[][] tempProjectedPoints = currentPlayer.getWeapon().getPathShort();

        int radius = 9;

        //Draw points to represent path preview
        for (int i = 0; i < 3; i++) {
            g.setColor(Color.BLUE);
            g.drawOval(tempProjectedPoints[0][i] + currentPlayer.getWeapon().getXPos(), tempProjectedPoints[1][i] + currentPlayer.getWeapon().getYPos(), radius, radius);
            radius -= 3;
        }
    }

    //Paint
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponents(g);

        //Draw Floor
        g.drawRect(0, player1.getYPos() + player1.getHeight(), 1400, 400);
        Hitbox groundHitbox = new Hitbox(0, player1.getYPos() + player1.getHeight(), 1400, 400);

        g.drawImage(player1.getImage(), player1.getXPos(), player1.getYPos(), this);
        g.drawImage(player2.getImage(), player2.getXPos(), player2.getYPos(), this);
        //g.drawImage(currentWeapon.getDisplayImg(), currentWeapon.getXPos(), currentWeapon.getYPos(), this);

        //Update Player Health
        p1HealthBar.setValue(player1.getHealth());
        p2HealthBar.setValue(player2.getHealth());

        //Draw Fire Path if mouse is down
        if (mouseIsDown) {
            drawFirePath(g);

        } else if (mouseReleased) {
            //Pause input listeners
            pauseListeners = true;

            //Get projected points from current player's weapon
            int[][] tempProjectedPoints = currentPlayer.getWeapon().getPathFull();
            flyingAnimationFrameNum = tempProjectedPoints[0].length;

            //Get current projectile position
            int currentProjectileXPos = tempProjectedPoints[0][currentFrameNum] + currentPlayer.getWeapon().getXPos();
            int currentProjectileYPos = tempProjectedPoints[1][currentFrameNum] + currentPlayer.getWeapon().getYPos();

            //Oval with hitbox stand-in for not yet integrated Projectile class
            int ovalDia = 10;
            g.drawOval(currentProjectileXPos, currentProjectileYPos, ovalDia, ovalDia);
            Hitbox ovalHitbox = new Hitbox(currentProjectileXPos, currentProjectileYPos, ovalDia, ovalDia);

            //End animation of oval intersects ground
            if (ovalHitbox.intersects(groundHitbox)) {
                currentFrameNum = flyingAnimationFrameNum - 1;
            }

            //Projectile-Player Collision Detection
            if (ovalHitbox.intersects(inActivePlayer.getHitbox())) {
                //Reduce health if collision is detected
                inActivePlayer.setHealth(inActivePlayer.getHealth() - 20);
                if (currentPlayer == player2) {
                    p1HealthBar.setValue(player1.getHealth());
                } else {
                    p2HealthBar.setValue(player2.getHealth());
                }

                //Check for player death
                if (player1.getHealth() <= 0) {
                    new GameOver("Player 2");
                    setVisible(false);

                } else if (player2.getHealth() <= 0) {
                    new GameOver("Player 1");
                    setVisible(false);
                }
            }

            //Pause and recursion
            try {
                Thread.sleep((int) (50 / currentPlayer.getWeapon().getSpeed()));
                weaponFire(g);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Not yet integrated Map-GUI code framework
    private void testMap(Graphics g) {
    }

    private void drawMap1(Graphics g) {
        //ImageIcon background1ImgIcon = new ImageIcon("C:\\Users\\kalew\\Documents\\GitHub\\ICS3UR\\Game Resources\\Field1Final.png");
    }
    private void drawMap2(Graphics g) {
    }

    private void drawMap3(Graphics g) {
    }

    //Mouse Input Listener Methods from Interface (Not used)
    @Override
    public void mouseDragged(MouseEvent e) {
    }

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