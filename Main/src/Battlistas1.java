public class Background_1 {
    private int hitboxPlayer1x = 50;
    private int hitboxPlayer1y = 345;
    private int hitboxPlayer1W = 295;
    private int hitboxPlayer1L = 50;
    private int hitboxPlayer2x = 1075;
    private int hitboxPlayer2y = 360;
    private int hitboxPlayer2W = 250;
    private int hitboxPlayer2L = 35;
    private int ObstacleX = 603;
    private int ObstacleY = 330;
    private int ObstacleW = 227;
    private int ObstacleL = 65;
    private int GroundX = 1;
    private int GroundY = 391;
    private int GroundW = 1400;
    private int GroundL = 108;
    private int ResolWidth = 1400;
    private int ResolHeight = 500;

    private Hitbox stand1;
    private Hitbox stand2;
    private Hitbox obstacle;
    private Hitbox ground;

    private ImageIcon map1;



    public Background_1() {
        map1 = new ImageIcon("C:/users/lidan/OneDrive/Documents/NetBeansProjects/Battlistas/src/battlistas/pp/Field1Final.png");
        Image gamefield = map1.getImage();
        Image map1 = gamefield.getScaledInstance(ResolWidth, ResolHeight, Image.SCALE_SMOOTH);


    }

    public void setStand1Hitbox() {
        stand1 = new Hitbox(hitboxPlayer1x, hitboxPlayer1y, hitboxPlayer1W, hitboxPlayer1L);
    }

    public void setStand2Hitbox() {
        stand2 = new Hitbox(hitboxPlayer2x, hitboxPlayer2y, hitboxPlayer2W, hitboxPlayer2L);
    }

    public void setObstacleHitbox() {
        obstacle = new Hitbox(ObstacleX, ObstacleY, ObstacleW, ObstacleL);
    }

    public void setGroundHitbox() {
        ground = new Hitbox(GroundX, GroundY, GroundW, GroundL);
    }

    public Object getStand1Hitbox() {
        return stand1;
    }

    public Object getStand2Hitbox() {
        return stand2;
    }

    public Object getObstacleHitbox() {
        return obstacle;
    }

    public Object getGroundHitbox() {
        return ground;
    }

    public ImageIcon getMap1(){
        return map1;
    }
}