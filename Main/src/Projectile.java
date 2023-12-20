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
}



