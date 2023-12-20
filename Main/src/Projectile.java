
import java.awt.Image;

public class Projectile{

    // Attributes
    private int weaponType;
    private int xPos;
    private int yPos;
    private int damage;
    Hitbox hitbox = new Hitbox(196, 48, 92, 92);
    private Image fireball;
    private int direction;
    private int xCenterBall = 242;
    private int yCenterBall = 94;


    public Projectile(int weaponType_, int xPos_, int yPos_) {
        weaponType = weaponType_;
        xPos = 300;
        yPos = 300;
        fireball = new Image();
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

    public int getYPos() {
        return yPos;
    }

    public void setXPos(int x){
        xPos = x;
    }

    public void setYPos(int y){
        yPos = y;
    }

    public int getXCenterBall() {
        return xCenterBall;
    }

    public int getYCenterBall() {
        return yCenterBall;
    }

  public void setXCenterBall(int x){
    xCenterBall = x;
  }

  public void setYCenterBall(int y){
    yCenterBall = y;
  }

  public int getDirection() {
        return direction;
    }

  public void setDirection(int direction){
    direction = d;
  }
}
