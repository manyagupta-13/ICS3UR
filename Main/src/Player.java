import javax.swing.ImageIcon;
import java.awt.Image;

public class Player{
  private String character;

  private int health;
  private static Weapons weapon = null;

  private final int width;
  private final int height;
  private int xPos;
  private int yPos;
<<<<<<< Updated upstream

  //private Hitbox hitbox;
=======
  //Width and height of character image
  private final int width;
  private final int height;
  //Objects to determine health and other attributed
  private Weapons weapon;


  //Object to determine collision
  private Hitbox hitbox = new Hitbox(getXPos(), getYPos(), getWidth(), getHeight());
>>>>>>> Stashed changes

  //Image for Player GUI Representation
  private final Image playerImage;

  public Player(String character_, int startingXPos,  int startingYPos){
<<<<<<< Updated upstream
    //Image Path variables (to be deleted later - currently implemented for testing)
    String wizardImagePath = "C:\\Users\\kalew\\IdeaProjects\\ICS3UR - Group Project Bowmasters\\src\\WizardStandIn.JPG";
=======
    int width1;
    int height1;
    //TODO: Get image paths for positioning
    String wizardImagePath = "";
>>>>>>> Stashed changes
    String cannonImagePath = "";

    health = 75;
    weapon = new Weapons("cannon");
    System.out.println(weapon.getXPos());
    ImageIcon playerIcon = new ImageIcon(wizardImagePath);
    playerImage = playerIcon.getImage();

    //Starting Coordinates
    setXPos(startingXPos);
    setYPos(startingYPos);

<<<<<<< Updated upstream
    width = playerIcon.getIconWidth();
    height = playerIcon.getIconHeight();

=======
    width1 = 0;
    height1 = 0;

    //Character Dependent Starting Conditions
    character = character_;
      switch (character_) {
          case "wizard" -> {
              health = 75;
              //weapon = new Weapons(8);

              //Load player Image
              ImageIcon playerIcon = new ImageIcon(wizardImagePath);
              playerImage = playerIcon.getImage();
              width1 = playerIcon.getIconWidth();
              height1 = playerIcon.getIconHeight();
          }
          case "cannon" -> {
              health = 125;
              //weapon = new Weapons(7);

              //loadImage('C:\\Users\\kalew\\Documents\\GitHub\\ICS3UR\\Game Resources\\Character.JPG')
              ImageIcon playerIcon = new ImageIcon(cannonImagePath);
              playerImage = playerIcon.getImage();
              width1 = playerIcon.getIconWidth();
              height1 = playerIcon.getIconHeight();
          }
      }
    width = width1;
    height = height1;
>>>>>>> Stashed changes
  }



  //TODO: Create Shoot method which calls weapon

  public void setHealth(int health_){
    health = health_;
  }

  public void setYPos(int y){
    yPos = y;
    weapon.setYPos(y+weapon.getHeight());
  }

  public void setXPos(int x){
    xPos = x;
    weapon.setXPos(x+(width)/2-(weapon.getWidth()/2));
  }

  public int getYPos(){
    return yPos;
  }

  public int getXPos(){
    return xPos;
  }

  public Weapons getWeapon() {
    return weapon;
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
