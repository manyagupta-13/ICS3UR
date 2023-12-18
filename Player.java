public class Player{
  private String characters;
  private boolean move;
  private boolean shoot;
  private static int health = 100;
  private Projectile projectile = new Projectile();
  private int posX;
  private int posY;


  public Player(String c, boolean m, boolean s){
    characters = c;
    move = m;
    shoot = s;
    getHealth();
  }

  public void setCharacter(){
    if(ballista button clicked)){
      characters = "ballista";
    }
    else{
      characters = "wizard";
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
      if(player.getCharacter() == "ballista"){
        health -= weapon.getDamage(); //change number later
      }
      else{
        health -= weapon.getDamage(); //change number later
      }
    }
  }

  public void setCoordinateY(float y){ 
      posY = y;
  }

  public void setCoordinateX(float x){
      if(move button clicked){
        //random coordinate x (have to ask size of screen) posX = 
      }
      else{
        posX = x;
      }
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
}
