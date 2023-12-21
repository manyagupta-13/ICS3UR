import javax.swing.*;
import java.lang.Math;
import java.awt.Image;


public class Weapons {
  private double G = 9.81;
  private int h = -1;
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
    h=500-yPos_;
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
    theta =-Math.atan2(my, mx)+Math.PI;
    mx/=3;
    my/=3;
    v0 = Math.sqrt(mx * mx + my * my);
    t = (2 * v0 * Math.sin(theta)) / G;
    // range = (v0 * v0 * Math.sin(2 * theta)) / G;
    range=(v0*Math.cos(theta)/G)*
    (v0*Math.sin(theta)+Math.sqrt(Math.pow(v0*Math.sin(theta), 2)+2*G*h));
    System.out.print("anLGE: ");
    System.out.println(theta*180/Math.PI);
    if (theta>Math.PI){
      theta*=-1;
      t=(-v0*Math.sin(theta)+Math.sqrt(Math.pow(v0*Math.sin(theta),2)+400*G))/G;
      range=v0*Math.cos(theta)*t;
    }
  }


  public double getSpeed() {
    return this.speedMod;
  }

  public int[][] getPathShort() {
    int[][] ret = new int[2][3];
    for (int i = 1; i < 4; i++) {
      if (theta<0){
        double temp = (range / 10) * i;
        ret[0][i - 1] = (int) temp;
        ret[1][i - 1] = (int) (temp * Math.tan(theta) - (G * temp * temp / (2 * v0 * v0 * Math.cos(theta) * Math.cos(theta))));
        if (theta<-Math.PI){ret[1][i-1]*=-1;}
      } else {
        double temp = (range/10)*i;
        ret[0][i-1]= (int) temp;
        ret[1][i-1]= (int) (h-G*temp*temp/(Math.pow(Math.cos(theta), 2)*2)-v0*temp*Math.tan(theta));
      }
    }
    return ret;
  }
  
  public int[][] getPathFull() {
    
    int[][] ret = new int[3][40];
    System.out.print("RNAGE: ");
    System.out.println(range);

    
    for (int i = 1; i < 41; i++) {
      double temp = (range / 40.0) * i;
      ret[0][i - 1] = (int) temp;
      ret[1][i - 1] = (int) (temp * Math.tan(theta) - (G * temp * temp / (2 * v0 * v0 * Math.cos(theta) * Math.cos(theta))));
      ret[2][i - 1] = (int) (180 * Math.atan(Math.tan(theta) - (2 * temp * G) / (2 * v0 * v0 * Math.pow(Math.cos(theta), 2))));
      if (theta<-Math.PI){ret[1][i-1]*=-1;}
    }
    return ret;
  }
}
