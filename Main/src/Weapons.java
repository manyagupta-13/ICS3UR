import java.lang.Math;
import java.awt.Image;


public class Weapons { 
  private final double G=9.81;
  // private double damageMod; //damage modifier
  // private int power; //base power
  private double speedMod; // speed modifier
  private Image displayImg;
  private Projectile proj = new Projectile();
  private int x,y;
  // TODO: scale mx,my to fit screen
  private double v0, theta, t, range;

  // public Weapons(double dmg, int power, double speed, Image img){
  public Weapons(double speed, Image img){
    // this.damageMod=dmg;
    // this.power=power;
    this.speedMod=speed;
    this.displayImg=img;
  }

  public double getDmg(){
    return proj.getDamage();
  }
  public void setWeaponCoords(int x, int y){
    this.x=x;
    this.y=y;
  }


  public void setMouseCoords(int mx, int my){
    theta = -Math.atan(my*my/mx/mx);
    v0=Math.sqrt(mx*mx+my*my);
    t=(2*v0*Math.sin(theta))/G;
    range=(v0*v0*Math.sin(2*theta))/G;
  }


  public double getSpeed(){
    return this.speedMod;
  }

  public double getFlightTime(){
    return t;
  }

  
  public double[][] getPathShort(){
    double[][] ret = new double[2][20];
    for (int i = 1; i < 4; i++){
      double temp = (range/10)*i;
      ret[0][i-1]=x+temp;
      ret[1][i-1]=y+temp*Math.tan(theta)-(G*temp*temp/(2*v0*v0*Math.cos(theta)*Math.cos(theta)));
    }
    return ret;
  }
  
  public double[][] getPathFull(){
    double[][] ret = new double[3][20];
    for (int i = 1; i < 21; i++){
      double temp = (range/20)*i;
      ret[0][i-1]=x+temp;
      ret[1][i-1]=y+temp*Math.tan(theta)-(G*temp*temp/(2*v0*v0*Math.cos(theta)*Math.cos(theta)));
      ret[2][i-3]=180*Math.atan(
        Math.tan(theta)-
        (2*temp*G)
        /
        (2*v0*v0*Math.pow(Math.cos(theta),2))
      )/(2*Math.PI);
    }
    return ret;
  }
}