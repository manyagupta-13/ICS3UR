public class Background_1 {
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

    private Hitbox stand1n2 = new Hitbox(hitboxPlayer1x2, hitboxPlayer1y2, hitboxPlayer1W2, hitboxPlayer1L2);
    private Hitbox stand2n2 = new Hitbox(hitboxPlayer2x2, hitboxPlayer2y2, hitboxPlayer2W2, hitboxPlayer2L2);
    private Hitbox obstacle2 = new Hitbox(ObstacleX2, ObstacleY2, ObstacleW2, ObstacleL2);
    private Hitbox ground2 = new Hitbox(GroundX2, GroundY2, GroundW2, GroundL2);

    private ImageIcon map2;



    public Background_1() {
        map2 = new ImageIcon("C:/users/lidan/OneDrive/Documents/NetBeansProjects/Battlistas/src/battlistas/pp/Field1Final.png");
        Image gamefield2 = map2.getImage();
        Image map2 = gamefield.getScaledInstance(ResolWidth2, ResolHeight2, Image.SCALE_SMOOTH);
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
