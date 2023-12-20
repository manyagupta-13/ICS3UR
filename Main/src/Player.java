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

    //private Hitbox hitbox;

    //Image for Player GUI Representation
    private final Image playerImage;

    public Player(String character_, int startingXPos,  int startingYPos){
        //Image Path variables (to be deleted later - currently implemented for testing)
        String wizardImagePath = "C:\\Users\\kalew\\IdeaProjects\\ICS3UR - Group Project Bowmasters\\src\\WizardStandIn.JPG";
        String cannonImagePath = "";

        health = 75;
        weapon = new Weapons("cannon");
        System.out.println(weapon.getXPos());
        ImageIcon playerIcon = new ImageIcon(wizardImagePath);
        playerImage = playerIcon.getImage();

        //Starting Coordinates
        setXPos(startingXPos);
        setYPos(startingYPos);

        width = playerIcon.getIconWidth();
        height = playerIcon.getIconHeight();

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
