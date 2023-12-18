import javax.swing.ImageIcon;
import java.awt.Image;

public class Player{
  //Atributes of each player
  private String character;

  private boolean move;
  private boolean shoot;
  private int health;
  private int xPos;
  private int yPos;
  private final static int width;
  private final static int height;
  private Weapon weapon;
  private Projectile projectile;
  private BufferedImage size = Image.IO(new File(//fileName));
  private Hitbox hitbox = new Hitbox(getCoordianteX(), getCoordinateY(), getWidth(), getHeight());

  //Image for Player GUI Representation
  private Image playerIcon;

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

  public void setMove(){
    if(move button clicked){
      move = true;
    }
    else{
      move = false;
    }
  }

  public void setShoot(){
    if(shoot button clicked){
      shoot = true;
    
    }
    else{
      shoot = false;
    }
  }

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

  public void setCoordinateY(int y){ 
      yPos = y;
  }

  public void setCoordinateX(int x){
        xPos = x;
  }

  public void setWidth(){
    width = size.getWidth();
  }

  public void setHeight(){
    height = size.getHeight();
  }

  public String getCharacter(){
    return character;
  }

  public boolean getMove(){
    return move;
  }

  public boolean getShoot(){
    return shoot;
  }

  public int getHealth(){
    return health;
  }

  public Image getImage() {
    return image;
  }

  public int getCoordinateX(){
    return xPos;
  }

  public int getCoordinateY(){
    return yPos;
  }

  public int getWidth(){
    return width;
  }

  public int getHeight(){
    return height;
  }
}
