import javax.swing.*;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Player {
  //Player's character choice
  private final String character;
  //Player's choice to shoot or move
  private boolean move;
  private boolean shoot;
  //Player's health
  private int health;
  //Coordinates of top left corner of character image
  private int xImagePos;
  private int yImagePos;
  //Coordiantes of top right corner of weapon image
  private int xWeaponPos;
  private int yWeaponPos;
  //Width and height of character image
  private final static int width;
  private final static int height;
  //Objects to determine health and other attributed
  private Weapons weapon;
  private Projectile projectile;

  //Object to determine collision
  private Hitbox hitbox = new Hitbox(getCoordinateX(), getCoordinateY(), getWidth(), getHeight());

  //Image for Player GUI Representation
  private Image playerImage;

  public Player(String character_, int startingXPos,  int startingYPos){
    //TODO: Get image paths for positioning
    String wizardImagePath = "";
    String cannonImagePath = "";


    //Starting Coordinates
    xImagePos = startingXPos;
    yImagePos = startingYPos;

    //Character Dependent Starting Conditions
    character = character_;
      switch (character_) {
          case "wizard" -> {
              health = 75;
              weapon = new Weapons(8);

              //Load player Image
              ImageIcon playerIcon = new ImageIcon(wizardImagePath);
              playerImage = playerIcon.getImage();
              width = playerIcon.getIconWidth();
              height = playerIcon.getIconHeight();
          }
          case "cannon" -> {
              health = 125;
              weapon = new Weapons(7);

              //loadImage('C:\\Users\\kalew\\Documents\\GitHub\\ICS3UR\\Game Resources\\Character.JPG')
              ImageIcon playerIcon = new ImageIcon(cannonImagePath);
              playerImage = playerIcon.getImage();
              width = playerIcon.getIconWidth();
              height = playerIcon.getIconHeight();
          }
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
  public void setHealth(int health_){
    health = health_;
  }

  //Set top left coordinates of character image
  public void setImageCoordinateY(int y){ 
      yImagePos = y;
  }

  public void setImageCoordinateX(int x){
      xImagePos = x;
  }

  //Set top left coordinated or wepon image
  public void setWeaponCoordinateY(int y){
    yWeaponPos = y;
  }

  public void setWeaponCoordinateX(int x){
    xWeaponPos = x;
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
    return playerImage;
  }

  //Return top left coordinates of image character
  public int getXPos(){
    return xPos;
  }

  public int getYPos(){
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
