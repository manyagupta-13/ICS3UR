import java.awt.Image;

public class Projectile{

    // Attributes
    private int isExp;
    private int fireDamage;
    private int xPos;
    private int yPos;
    private int turnsBurning;
    private int damage;
    Hitbox hitbox = new Hitbox(1,1,1,1);
    private Image displayImg;
    private int direction;


    // Default constructor
    public Projectile() {
        this(false); // Default values for damage and isExp
    }

    // Constructor with damage and special effect
    public Projectile(int isExp) {
        damage = -10;
        this.isExp = isExp;
        fireDamage = 1; // Default value for fire damage
        xPos = getXPos(); // Default value for X position
        yPos = getYPos(); // Default value for Y position
        turnsBurning = 0; //Default value for turns to burn
        direction = 0;
    }

    // Constructor with damage, special effect, and initial position
    public Projectile(boolean isExp, int xPos, int yPos) {
        this(isExp);
        this.xPos = xPos;
        this.yPos = yPos;
    }

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
    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

  public void setXPos(int x){
    xPos = x;
  }

  public void setYPos(int y){
    yPos = y;
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


