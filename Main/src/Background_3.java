import javax.swing.*;
import java.awt.*;

public class Background_3 {
    private int hitboxPlayer1x3 = 200;
    private int hitboxPlayer1y3 = 426;
    private int hitboxPlayer1W3 = 150;
    private int hitboxPlayer1L3 = 10;
    private int hitboxPlayer2x3 = 1200;
    private int hitboxPlayer2y3 = 426;
    private int hitboxPlayer2W3 = 150;
    private int hitboxPlayer2L3 = 10;
    private int ObstacleX3 = 700;
    private int ObstacleY3 = 270;
    private int ObstacleW3 = 235;
    private int ObstacleL3 = 158;
    private int GroundX3 = 1;
    private int GroundY3 = 428;
    private int GroundW3 = 1400;
    private int GroundL3 = 71;
    private int ResolWidth3 = 1400;
    private int ResolHeight3 = 500;

    private Hitbox stand1n3 = new Hitbox(hitboxPlayer1x3, hitboxPlayer1y3, hitboxPlayer1W3, hitboxPlayer1L3);
    private Hitbox stand2n3 = new Hitbox(hitboxPlayer2x3, hitboxPlayer2y3, hitboxPlayer2W3, hitboxPlayer2L3);
    private Hitbox obstaclen3 = new Hitbox(ObstacleX3, ObstacleY3, ObstacleW3, ObstacleL3);
    private Hitbox ground3 = new Hitbox(GroundX3, GroundY3, GroundW3, GroundL3);

    private ImageIcon map3;

    public Background_3() {
        map3 = new ImageIcon("C:/users/lidan/OneDrive/Documents/NetBeansProjects/Battlistas/src/battlistas/pp/Field1Final.png");
        Image gamefield3 = map3.getImage();
        Image map3 = gamefield3.getScaledInstance(ResolWidth3, ResolHeight3, Image.SCALE_SMOOTH);

    }

    public Object getStand1Hitbox3() {
        return stand1n3;
    }

    public Object getStand2Hitbox3() {
        return stand2n3;
    }

    public Object getObstacleHitbox3() {
        return obstaclen3;
    }

    public Object getGroundHitbox3() {
        return ground3;
    }
    public ImageIcon getMap3(){
        return map3;
    }
} 
