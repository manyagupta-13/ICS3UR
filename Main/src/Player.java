/*
Player Class
Manya Gupta
12/21/2023

Class which represents players in the game.
*/

import javax.swing.ImageIcon;
import java.awt.Image;

public class Player {
    private String character;

    private int health;
    private Weapons weapon;

    private int width = 0;
    private int height = 0;
    private int xPos;
    private int yPos;


    //Object to determine collision
    private Hitbox hitbox;

    //Image for Player GUI Representation
    private Image playerImage = null;

    public Player(String character_, int startingXPos, int startingYPos) {

        //TODO: Get image paths for positioning
        //Starting Coordinates

        //Character Dependent Starting Conditions
        character = character_;
        switch (character_) {
            case "wizard" -> {
                health = 100;
                weapon = new Weapons("wizard");

                //Load player Image
                String wizardImagePath = "C:\\Users\\kalew\\Documents\\GitHub\\ICS3UR\\Game Resources\\finalWizard.png";
                ImageIcon playerIcon = new ImageIcon(wizardImagePath);
                playerImage = playerIcon.getImage();
                width = playerIcon.getIconWidth();
                height = playerIcon.getIconHeight();


            }
            case "wizard1" -> {
                health = 100;
                weapon = new Weapons("wizard");

                //Load player Image
                String wizardImagePath = "C:\\Users\\kalew\\Documents\\GitHub\\ICS3UR\\Game Resources\\finalWizardFlipped.png";
                ImageIcon playerIcon = new ImageIcon(wizardImagePath);
                playerImage = playerIcon.getImage();
                width = playerIcon.getIconWidth();
                height = playerIcon.getIconHeight();

            }
            case "cannon" -> {
                health = 100;
                weapon = new Weapons("cannon");

                //loadImage('C:\\Users\\kalew\\Documents\\GitHub\\ICS3UR\\Game Resources\\Character.JPG')
                ImageIcon playerIcon = new ImageIcon("C:\\Users\\kalew\\Documents\\GitHub\\ICS3UR\\Game Resources\\Character.JPG");
                playerImage = playerIcon.getImage();
                width = playerIcon.getIconWidth();
                height = playerIcon.getIconHeight();
            }
        }


        setXPos(startingXPos);
        setYPos(startingYPos);

        //Set Hitbox
        hitbox = new Hitbox(xPos, yPos, getWidth(), getHeight());

    }


    //TODO: Create Shoot method which calls weapon

    public void setHealth(int health_) {
        health = health_;
    }

    public void setYPos(int y) {
        yPos = y;
        weapon.setYPos(y + weapon.getHeight());
    }

    public void setXPos(int x) {
        xPos = x;
        weapon.setXPos(x + (width) / 2 - (weapon.getWidth() / 2));
    }

    public int getYPos() {
        return yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public String getCharacter() {
        return character;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getHealth() {
        return health;
    }

    public Image getImage() {
        return playerImage;
    }

    public Hitbox getHitbox() {
        return hitbox;
    }
}
