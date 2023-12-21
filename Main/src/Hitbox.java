public class Hitbox {

    private int xPos, yPos;
    private int width, height;

    //Accessor Methods
    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Hitbox(int xPos, int yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    public void set(int xPos, int yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    public boolean intersects(Hitbox h) {
        return xPos + width >= h.xPos && h.xPos + h.width >= xPos && yPos + height >= h.yPos && h.yPos + h.height >= yPos;
    }
}
