package Model;

/**
 * Rectangle class.
 */
public class Rectangle extends Shape {
  private static final String RECTANGLE_SHAPE = "rectangle";

  /**
   * another constructor for Rectangle.
   *
   * @param name String. Name of the rectangle.
   * @param cornerX double. X Coordinate of the left bottom corner of the rectangle.
   * @param cornerY double. Y Coordinate of the left bottom corner of the rectangle.
   * @param width double. Width of the rectangle.
   * @param height double. Height of the rectangle.
   * @param red double. Red value of the color.
   * @param green double. Green value of the color.
   * @param blue double. Blue value of the color.
   */
  public Rectangle(String name, double cornerX, double cornerY, double width, double height,
                   int red, int green, int blue) throws IllegalArgumentException {
    super(name, RECTANGLE_SHAPE, cornerX, cornerY, width, height, red, green, blue);
  }

  /**
   * copy constructor method for Rectangle.
   */
  private Rectangle(Rectangle original) {
    super(original);
  }

  /**
   * method to return a copy of the rectangle.
   */
  @Override
  public Rectangle copy() {
    return new Rectangle(this);
  }

  /**
   * toString method.
   */
  @Override
  public String toString() {
    return "Name: " + this.getShapeName() + "\nType: " + this.getShapeType() + "\nMin. corner: " + "(" + this.getPositionX() + ", "
        + this.getPositionY() + "), " + "Width: " + this.getDimension1() + ", Height: " + this.getDimension2()
        + ", " + this.getColor().toString();
  }
}

