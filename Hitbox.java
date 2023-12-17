public class Hitbox {

  private float x, y;
  private float width, height;


  public Hitbox(float x, float y, float width, float height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public void set(float x, float y, float width, float height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
  }

  public boolean intersects(Hitbox h) {
      return x + width >= h.x && h.x + h.width >= x && y + height >= h.y && h.y + h.height >= y;
  }
}