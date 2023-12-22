/*
Projectile Class (Not integrated)
Arnav Katoch
12/21/2023

Class which represents players in the game.
*/

import javax.swing.*;
import java.awt.*;

public class Projectile {

    private final Image projectileImage;
    private final int xCenterBall = 242;
    private final int yCenterBall = 94;
    Hitbox hitbox = new Hitbox(196, 48, 92, 92);
    // Attributes
    private final int weaponType;
    private int xPos;
    private int yPos;
    private int damage;
    private int direction;


    public Projectile(int weaponType_, int xPos_, int yPos_) {
        weaponType = weaponType_;
        xPos = 300;
        yPos = 300;
        ImageIcon tempIcon = new ImageIcon("C:\\Users\\kalew\\Documents\\GitHub\\ICS3UR\\Game Resources\\fireball.png");
        projectileImage = tempIcon.getImage();
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(int d) {
        damage = d;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int x) {
        xPos = x;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int y) {
        yPos = y;
    }

    public int getXCenterBall() {
        return xCenterBall;
    }

    public int getYCenterBall() {
        return yCenterBall;
    }


    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction_) {
        direction = direction_;
    }

    public Image getImage() {
        return projectileImage;
    }

    public Hitbox getHitbox() {
        return hitbox;

    }
}