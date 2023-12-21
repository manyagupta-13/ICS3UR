   public class Game{
    private int hitboxPlayer1x2 = 10;
    private int hitboxPlayer1y2 = 320;
    private int hitboxPlayer1W2 = 200;
    private int hitboxPlayer1L2 = 160;
    private int hitboxPlayer2x2 = 1190;
    private int hitboxPlayer2y2 = 320;
    private int hitboxPlayer2W2 = 200;
    private int hitboxPlayer2L2 = 160;
    private int ObstacleX2 = 440;
    private int ObstacleY2 = 450;
    private int ObstacleW2 = 575;
    private int ObstacleL2 = 50;
    private int GroundX2 = 10;
    private int GroundY2 = 490;
    private int GroundW2 = 1400;
    private int GroundL2 = 10 ;
    private int ResolWidth2 = 1400;
    private int ResolHeight2 = 500;

    private Hitbox stand1n2;
    private Hitbox stand2n2;
    private Hitbox obstacle2;
    private Hitbox ground2;

    private ImageIcon map2;



    public Background_1() {
        map2 = new ImageIcon("C:/users/lidan/OneDrive/Documents/NetBeansProjects/Battlistas/src/battlistas/pp/Field1Final.png");
        Image gamefield2 = map2.getImage();
        Image map2 = gamefield.getScaledInstance(ResolWidth2, ResolHeight2, Image.SCALE_SMOOTH);
    }

    public void setStand1Hitbox2() {
        stand1n2 = new Hitbox(hitboxPlayer1x2, hitboxPlayer1y2, hitboxPlayer1W2, hitboxPlayer1L2);
    }

    public void setStand2Hitbox2() {
        stand2n2 = new Hitbox(hitboxPlayer2x2, hitboxPlayer2y2, hitboxPlayer2W2, hitboxPlayer2L2);
    }

    public void setObstacleHitbox2() {
        obstacle2 = new Hitbox(ObstacleX2, ObstacleY2, ObstacleW2, ObstacleL2);
    }

    public void setGroundHitbox2() {
        ground2 = new Hitbox(GroundX2, GroundY2, GroundW2, GroundL2);
    }

    public Object getStand1Hitbox2() {
        return stand1n2;
    }

    public Object getStand2Hitbox2() {
        return stand2n2;
    }

    public Object getObstacleHitbox2() {
        return obstacle2;
    }

    public Object getGroundHitbox2() {
        return ground2;
    }
    public ImageIcon getMap2(){
        return map2;
    }
}