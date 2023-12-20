
import java.awt.Image;

public class Projectile{

    // Attributes
    private int isExp;
    private int fireDamage;
    private int xPos;
    private int yPos;
    private int turnsBurning;
    private int damage;
    Hitbox hitbox = new Hitbox();
    private Image fireball = new Image(fireball.png);
    private int direction;
    private xCenterBall;
    private yCenterBall;


    // Default constructor
//    public Projectile() {
//        this(0); // Default values for isExp
//    }

    // Constructor with damage and special effect
//    public Projectile(int isExp) {
//        damage = -10;
//        this.isExp = isExp;
//        fireDamage = 1; // Default value for fire damage
//        turnsBurning = 0; //Default value for turns to burn
//        direction = 0;
//    }

    // Getter methods
    public double getDamage() {
        return damage;
    }

    /*public String getSpecEff() {
        return specEff;
    }

    public boolean getIsExplosive() {
        return isExp;
    }

    public int getFireDamage() {
        return fireDamage;
    }

    public int getTurnsBurning(){
        return turnsBurning;
    }
*/

public class Projectile {

    // Attributes
    private int weaponType;
    private int xPos;
    private int yPos;
    private int damage;


    // Default constructor
    public Projectile(int weaponType_, int xPos_, int yPos_) {
        weaponType = weaponType_;
        xPos = 300;
        yPos = 300;
    }

    // Getter methods


    // Setter methods
    public void setDamage(int d) {
        damage = d;
    }

/*
    public void setSpecEff(String se) {
        specEff = se;
    }

    public void setIsExplosive(boolean e) {
        isExp = e;
    }

    public void setFireDamage(int fd) {
        fireDamage = fd;
    }

    public void setTurnsBurning(int t){
        turnsBurning = t;
    }
*/
    // Coordinate interface methods
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
/*
    // Additional methods
    public boolean explode() {
        if(isExp == true){
            return true; //true can trigger the explosion image to spawn,
                         // then if the explosion image intersects with a player it deals damage to the player
        }
        return false;
    }

    public void removeBurn(){
        turnsBurning--;
    }

    public boolean isBurning() {
        if(turnsBurning > 0){ //every turn you will need to check if a player is burning
            return true;      //if someone is burning, the next turn -1 to the turns burning by calling removeBurn()
        }
        return false; 
    }


    }

    public void changeXPos(){
        xPos += weapon.calcRange();
    }*/
}
}



//public class Projectile{
//
//    // Attributes
//    private boolean isExp;
//    private int xCenterPos;
//    private int yCenterPos;
//    private int canonDamage;
//    private int wizardDamage;
//    private int direction;
//    private Hitbox rectangle = new Hitbox(;

//    //DO NOT KNOW ITS PURPOSE
//    private int fireDamage;
//    private int turnsBurning;
//
//    // Constructor with damage, special effect, and initial position
//    public Projectile(boolean isExp, int xPos, int yPos) {
//        this(isExp);
//        this.xPos = xPos;
//        this.yPos = yPos;
//    }
//
//    // Getter methods
//    public int getCanonDamage() {
//        return canonDamage;
//    }

//    public int getWizardDamage(){
//        return wizardDamage;
//    }
//
//    public String getSpecEff() {
//        return specEff;
//    }
//
//    public boolean getIsExplosive() {
//        return isExp;
//    }
//
//    public int getDirection(){
//        return direction;
//    }

//    // Setter methods
//    public void setDamage(int d) {
//        canonDamge = 10;
//        wizardDamage = 15;
//    }
//
//    public void setSpecEff(String se) {
//        specEff = se;
//    }
//
//    public void setXCenterPos(int x){
//        xCenterPos = x;
//     }
//
//    public void setWCenterPos(int y){
//        yCenterPos = y;
//    }
//
//    public void setDirection(int d){
//        damage = d;
//    }


//    // ADDITIONAL METHODS
//    public boolean explode() {
//        if(isExp == true){
//            return true; //true can trigger the explosion image to spawn,
//                         // then if the explosion image intersects with a player it deals damage to the player
//        }
//        return false;
//    }
//
//    public void removeBurn(){
//        turnsBurning--;
//    }
//
//    public boolean isBurning() {
//        if(turnsBurning > 0){ //every turn you will need to check if a player is burning
//            return true;      //if someone is burning, the next turn -1 to the turns burning by calling removeBurn()
//        }
//        return false;
//    }
//
//    /*public int dealDamage(){
//        //work in progress, need to see others stuff to get an idea of how to do this
//    }*/
//
//    public void changeXPos(){
//        xPos += weapon.calcRange();
//    }
//}
//    public void setIsExplosive(boolean e) {
//        isExp = e;
//    }
//
//    public void setFireDamage(int fd) {
//        fireDamage = fd;
//    }
//
//    public void setTurnsBurning(int t){
//        turnsBurning = t;
//    }
//    public int getTurnsBurning(){
//        return turnsBurning;
//    }
//    // Coordinate interface methods
//    public int getX() {
//        return xPos;
//    }
//
//    public int getY() {
//        return yPos;
//    }
////    public float getExplosionArea() {
//        return expArea;
//    }
