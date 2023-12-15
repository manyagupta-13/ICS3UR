import java.lang.Math;


public class Weapons { 
  private final double G=9.81;
  private double damageMod; //damage modifier
  private int power; //base power
  private double speedMod; // speed modifier
  // private img displayImg;
  // private projectile proj;
  private int mx,my; //mouseX, mouseY
  // TODO: scale mx,my to fit screen

  public Weapons(double dmg, int power, double speed){
    this.damageMod=dmg;
    this.power=power;
    this.speedMod=speed;
  }

  public double calcDamage(){
    return this.power*this.damageMod;
    // this.projectile.getDamage();
  }
  
  public double calcTime(){
    double t = my/G*2;
    return t;
  }

  public double calcRange(){
    double range;
    range = this.calcTime()*-mx;
    return range;
  }

  public double calcDirection(){
    double theta = -Math.atan(my*my*mx*mx);
    return theta;
  }


}