public class Hitbox {

  private int x, y;
  private int width, height;


  public Hitbox(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public void set(int x, int y, int width, int height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
  }

  public boolean intersects(Hitbox h) {
      return x + width >= h.x && h.x + h.width >= x && y + height >= h.y && h.y + h.height >= y;
  }
}
