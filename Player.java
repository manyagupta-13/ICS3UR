import javax.swing.ImageIcon;
import java.awt.Image;

public class Player{
  //Player's character choice
  private String character;
  //Player's choise to shoot or move
  private boolean move;
  private boolean shoot;
  //Player's helth
  private int health;
  //Coordinates of top left corner of character image
  private int xPos;
  private int yPos;
  //Width and height of character image
  private final static int width;
  private final static int height;
  //Objects to determine health and other attributed
  private Weapon weapon;
  private Projectile projectile;
  //Object to determine width and height of character image
  private BufferedImage size = ImageIO(new File(//fileName));
  //Object to determine collision
  private Hitbox hitbox = new Hitbox(getCoordianteX(), getCoordinateY(), getWidth(), getHeight());

  //Image for Player GUI Representation
  private Image playerImage;

  public Player(String character_, int startingXPos,  int startingYPos){
    //Image Path variables (to be deleted later - currently implemented for testing)
    String wizardImagePath = "C:\\Users\\kalew\\Documents\\GitHub\\ICS3UR\\Game Resources\\Character.JPG";
    String cannonImagePath = "C:\\Users\\kalew\\Documents\\GitHub\\ICS3UR\\Game Resources\\Character.JPG";

    //Starting Coordinates
    xPos = startingXPos;
    yPos = startingYPos;

    //Character Dependent Starting Conditions
    character = character_;
    switch(character_) {
      case "wizard":
        health = 75;
        weapon = new Weapon("[Weapon Here]");
        ImageIcon playerIcon = new ImageIcon(wizardImagePath);
        image = playerIcon.getImage();

      case "cannon":
        health = 125;
        weapon = new Weapon("[Weapon Here]");
        //loadImage('C:\\Users\\kalew\\Documents\\GitHub\\ICS3UR\\Game Resources\\Character.JPG')
    }
  }

  //Return boolean if player decides to move
  public void setMove(){
    if(move button clicked){
      move = true;
    }
    else{
      move = false;
    }
  }

  //Return boolean if player decides to shoot
  public void setShoot(){
    if(shoot button clicked){
      shoot = true;
    
    }
    else{
      shoot = false;
    }
  }

  //Reduce health if player gets hit
  public void setHealth(){
    if(hitbox.intersects() == true){
      if(player.getCharacter() == "cannon"){
        health -= weapon.getDamage(); //change number later
      }
      else{
        health -= weapon.getDamage(); //change number later
      }
    }
  }

  //Set top left coordinates of image character
  public void setCoordinateY(int y){ 
      yPos = y;
  }

  public void setCoordinateX(int x){
        xPos = x;
  }

  //Set width and height of image character
  public void setWidth(){
    width = size.getWidth();
  }

  public void setHeight(){
    height = size.getHeight();
  }

  //Return character chosen by player
  public String getCharacter(){
    return character;
  }

  //Return if player decides to move
  public boolean getMove(){
    return move;
  }

  //Return if player decides to shoot
  public boolean getShoot(){
    return shoot;
  }

  //Return player's health
  public int getHealth(){
    return health;
  }

  //Return character image
  public Image getImage() {
    return image;
  }

  //Return top left coordinates of image character
  public int getCoordinateX(){
    return xPos;
  }

  public int getCoordinateY(){
    return yPos;
  }

  //Return width and height of image character
  public int getWidth(){
    return width;
  }

  public int getHeight(){
    return height;
  }
}
