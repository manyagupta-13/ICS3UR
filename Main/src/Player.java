import javax.swing.ImageIcon;
import java.awt.Image;

public class Player{
  private String character;

  private int health;
  private static Weapons weapons = null;

  private int width = 0;
  private int height = 0;
  private int xPos;
  private int yPos;


  //Object to determine collision
  private Hitbox hitbox = new Hitbox(getXPos(), getYPos(), getWidth(), getHeight());

  //Image for Player GUI Representation
  private Image playerImage = null;

  public Player(String character_, int startingXPos,  int startingYPos){

    //TODO: Get image paths for positioning
    //Starting Coordinates
    setXPos(startingXPos);
    setYPos(startingYPos);

    //Character Dependent Starting Conditions
    character = character_;
      switch (character_) {
          case "wizard" -> {
              health = 75;
              weapons = new Weapons("wizard");

              //Load player Image
              ImageIcon playerIcon = new ImageIcon(wizardImagePath);
              playerImage = playerIcon.getImage();
              width = playerIcon.getIconWidth();
              height = playerIcon.getIconHeight();
          }
          case "cannon" -> {
              health = 125;
              weapons = new Weapons("canon");

              //loadImage('C:\\Users\\kalew\\Documents\\GitHub\\ICS3UR\\Game Resources\\Character.JPG')
              ImageIcon playerIcon = new ImageIcon(cannonImagePath);
              playerImage = playerIcon.getImage();
              width = playerIcon.getIconWidth();
              height = playerIcon.getIconHeight();
          }
      }
  }



  //TODO: Create Shoot method which calls weapon

  public void setHealth(int health_){
    health = health_;
  }

  public void setYPos(int y){
    yPos = y;
    weapons.setYPos(y+weapons.getHeight());
  }

  public void setXPos(int x){
    xPos = x;
    weapons.setXPos(x+(width)/2-(weapons.getWidth()/2));
  }

  public int getYPos(){
    return yPos;
  }

  public int getXPos(){
    return xPos;
  }

  public Weapons getWeapon() {
    return weapons;
  }

  public String getCharacter(){
    return character;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getHealth(){
    return health;
  }

  public Image getImage() {
    return playerImage;
  }
}
