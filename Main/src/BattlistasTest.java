import javax.swing.*;
import java.awt.*;

public class Game extends JFrame{

    private int hitboxPlayer1x = 50;  
    private int hitboxPlayer1y = 345;
    private int hitboxPlayer1W = 295;
    private int hitboxPlayer1L = 50;
    private int hitboxPlayer2x = 1075; 
    private int hitboxPlayer2y = 360;
    private int hitboxPlayer2W = 250;
    private int hitboxPlayer2L = 35;
    private int ObstacleX = 603; 
    private int ObstacleY = 330;
    private int ObstacleW = 227;
    private int ObstacleL = 65;
    private int GroundX = 1;
    private int GroundY = 391;
    private int GroundW = 1400;
    private int GroundL = 108;

    public Game() {
        ImageIcon fieldImage = new ImageIcon("C:/users/lidan/OneDrive/Documents/NetBeansProjects/Battlistas/src/battlistas/pp/Field1Final.png");
        Image gamefield = fieldImage.getImage();
        int ResolWidth = 1400;
        int ResolHeight = 500;
        Image FieldResolution = gamefield.getScaledInstance(ResolWidth, ResolHeight, Image.SCALE_SMOOTH);
        
        
        
        JLabel jlabel = new JLabel(new ImageIcon(FieldResolution));
        add(jlabel);
        setSize(ResolWidth, ResolHeight);
        setLocationRelativeTo(null);
        Panel Panel1 = new Panel();
        setContentPane(Panel1);
   
    }

 

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawRect(hitboxPlayer1x, hitboxPlayer1y, hitboxPlayer1W, hitboxPlayer1L);
        
        g.setColor(Color.GREEN);
        g.drawRect(hitboxPlayer2x, hitboxPlayer2y, hitboxPlayer2W, hitboxPlayer2L);
        
        g.setColor(Color.BLUE);
        g.drawRect(ObstacleX, ObstacleY, ObstacleW, ObstacleL);
        
        g.setColor(Color.WHITE);
        g.drawRect(GroundX, GroundY, GroundW, GroundL);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { Game generateField = new Game();
            generateField.setVisible(true);
        });
    }

  
    class Panel extends JPanel {
        
        @Override
        protected void paintComponent(Graphics g) { 
            super.paintComponent(g);
            Image img = new ImageIcon("C:/users/lidan/OneDrive/Documents/NetBeansProjects/Battlistas/src/battlistas/pp/Field1Final.png").getImage();
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame{

    private int n2hitboxPlayer1x = 200;  
    private int n2hitboxPlayer1y = 426;
    private int n2hitboxPlayer1W = 150;
    private int n2hitboxPlayer1L = 10;
    private int n2hitboxPlayer2x = 1200; 
    private int n2hitboxPlayer2y = 426;
    private int n2hitboxPlayer2W = 150;
    private int n2hitboxPlayer2L = 10;
    private int n2ObstacleX = 700; 
    private int n2ObstacleY = 270;
    private int n2ObstacleW = 235;
    private int n2ObstacleL = 158;
    private int n2groundX = 1;
    private int n2groundY = 428;
    private int n2groundW = 1400;
    private int n2groundL = 71;

    public Game() {
        ImageIcon fieldImage = new ImageIcon("C:/users/lidan/OneDrive/Documents/NetBeansProjects/Battlistas/src/battlistas/pp/Field2Final.png");
        Image gamefield = fieldImage.getImage();
        int n2ResolWidth = 1400;
        int n2ResolHeight = 500;
        Image n2FieldResolution = gamefield.getScaledInstance(n2ResolWidth, n2ResolHeight, Image.SCALE_SMOOTH);
        
        
        
        JLabel jlabel = new JLabel(new ImageIcon(n2FieldResolution));
        add(jlabel);
        setSize(n2ResolWidth, n2ResolHeight);
        setLocationRelativeTo(null);
        Panel n2Panel1 = new Panel();
        setContentPane(n2Panel1);
   
    }

 

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawRect(n2hitboxPlayer1x, n2hitboxPlayer1y, n2hitboxPlayer1W, n2hitboxPlayer1L);
//        
        g.setColor(Color.GREEN);
        g.drawRect(n2hitboxPlayer2x, n2hitboxPlayer2y, n2hitboxPlayer2W, n2hitboxPlayer2L);
        
        g.setColor(Color.BLUE);
        g.drawRect(n2ObstacleX,n2ObstacleY, n2ObstacleW, n2ObstacleL);
        
        g.setColor(Color.WHITE);
        g.drawRect(n2groundX, n2groundY, n2groundW, n2groundL);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { Game generateField = new Game();
            generateField.setVisible(true);
        });
    }

  
    class Panel extends JPanel {
        
        @Override
        protected void paintComponent(Graphics g) { 
            super.paintComponent(g);
            Image img = new ImageIcon("C:/users/lidan/OneDrive/Documents/NetBeansProjects/Battlistas/src/battlistas/pp/Field2Final.png").getImage();
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }
}


import javax.swing.*;
import java.awt.*;

public class Game extends JFrame{

    private int n3hitboxPlayer1x = 10;  
    private int n3hitboxPlayer1y = 320;
    private int n3hitboxPlayer1W = 200;
    private int n3hitboxPlayer1L = 160;
    private int n3hitboxPlayer2x = 1190; 
    private int n3hitboxPlayer2y = 320;
    private int n3hitboxPlayer2W = 200;
    private int n3hitboxPlayer2L = 160;
    private int n3ObstacleX = 440; 
    private int n3ObstacleY = 450;
    private int n3ObstacleW = 575;
    private int n3ObstacleL = 50;
    private int n3groundX = 10;
    private int n3groundY = 490;
    private int n3groundW = 1400;
    private int n3groundL = 10;
    
    public Game() {
        ImageIcon fieldImage = new ImageIcon("C:/users/lidan/OneDrive/Documents/NetBeansProjects/Battlistas/src/battlistas/pp/Field3Final.jpg");
        Image gamefield = fieldImage.getImage();
        int n3ResolWidth = 1400;
        int n3ResolHeight = 500;
        Image n3FieldResolution = gamefield.getScaledInstance(n3ResolWidth, n3ResolHeight, Image.SCALE_SMOOTH);
        
        
        
        JLabel jlabel = new JLabel(new ImageIcon(n3FieldResolution));
        add(jlabel);
        setSize(n3ResolWidth, n3ResolHeight);
        setLocationRelativeTo(null);
        Panel n3Panel1 = new Panel();
        setContentPane(n3Panel1);
   
    }

 

    @Override
    public void paint(Graphics g) {
        super.paint(g);
          g.setColor(Color.WHITE);
        g.drawRect(n3hitboxPlayer1x, n3hitboxPlayer1y, n3hitboxPlayer1W, n3hitboxPlayer1L);
        
        g.setColor(Color.WHITE);
        g.drawRect(n3hitboxPlayer2x, n3hitboxPlayer2y, n3hitboxPlayer2W, n3hitboxPlayer2L);
        
        g.setColor(Color.WHITE);
        g.drawRect(n3ObstacleX, n3ObstacleY, n3ObstacleW, n3ObstacleL);
        
        g.setColor(Color.WHITE);
        g.drawRect(n3groundX, n3groundY, n3groundW, n3groundL);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { Game generateField = new Game();
            generateField.setVisible(true);
        });
    }

  
    class Panel extends JPanel {
        
        @Override
        protected void paintComponent(Graphics g) { 
            super.paintComponent(g);
            Image img = new ImageIcon("C:/users/lidan/OneDrive/Documents/NetBeansProjects/Battlistas/src/battlistas/pp/Field3Final.jpg").getImage();
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
 

