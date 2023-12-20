import javax.swing.*;
import java.lang.Math;
import java.awt.Image;


public class Weapons {
  private final double G = 9.81;
  // private double damageMod; //damage modifier
  // private int power; //base power
  private double speedMod; // speed modifier
  private Image displayImg;
  //private Projectile proj;
  // TODO: scale mx,my to fit screen
  private double v0, theta, t, range;
  private int xPos, yPos;
  private int width, height;

  // public Weapons(double dmg, int power, double speed, Image img){

  public Weapons(String weapon) {
    xPos = 0;
    yPos = 0;
    speedMod = 2;
    ImageIcon tempIcon = new ImageIcon("C:\\Users\\kalew\\IdeaProjects\\ICS3UR - Group Project Bowmasters\\src\\WizardWeaponStandin.JPG");
    width = tempIcon.getIconWidth();
    height = tempIcon.getIconHeight();
    displayImg = tempIcon.getImage();
  }

  public Image getDisplayImg() {
    return displayImg;
  }

  public double getRange(){return range;}

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public void setXPos(int xPos_) {
    xPos = xPos_;
  }

  public void setYPos(int yPos_) {
    yPos = yPos_;
  }

  public int getXPos() {
    return xPos;
  }

  public int getYPos() {
    return yPos;
  }

  public double getTheta() {
    return theta;
  }

  public void setCoords(int mx, int my) {
    mx -= xPos;
    my = yPos-my;
    theta = (-Math.atan2(my, mx) + Math.PI)%(2*Math.PI);
    v0 = Math.sqrt(mx * mx + my * my);
    t = (2 * v0 * Math.sin(theta)) / G;
    range = (v0 * v0 * Math.sin(2 * theta)) / G;
  }


  public double getSpeed() {
    return this.speedMod;
  }

  public int[][] getPathShort() {
    int[][] ret = new int[2][3];
    for (int i = 1; i < 4; i++) {
      double temp = (range / 10) * i;
      ret[0][i - 1] = (int) temp;
      ret[1][i - 1] = (int) (temp * Math.tan(theta) - (G * temp * temp / (2 * v0 * v0 * Math.cos(theta) * Math.cos(theta))));
    }
    return ret;
  }

  public int[][] getPathFull() {
    int[][] ret = new int[3][20];
    for (int i = 1; i < 21; i++) {
      double temp = (range / 20) * i;
      ret[0][i - 1] = (int) (xPos + temp);
      ret[1][i - 1] = (int) (yPos + temp * Math.tan(theta) - (G * temp * temp / (2 * v0 * v0 * Math.cos(theta) * Math.cos(theta))));
      ret[2][i - 1] = (int) (180 * Math.atan(Math.tan(theta) - (2 * temp * G) / (2 * v0 * v0 * Math.pow(Math.cos(theta), 2))));
    }
    return ret;
  }
}
