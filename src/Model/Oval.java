package Model;

/**
 * Oval class.
 */
public class Oval extends Shape {
  private static final String OVAL_SHAPE = "oval";

  /**
   * Constructor for Oval.
   *
   * @param name String. Name of the oval.
   * @param centerX double. X Coordinate of the center of the oval.
   * @param centerY double. Y Coordinate of the center of the oval.
   * @param xRadius double. X radius of the oval.
   * @param yRadius double. Y radius of the oval.
   * @param red double. Red value of the color.
   * @param green double. Green value of the color.
   * @param blue double. Blue value of the color.
   */
  public Oval(String name, double centerX, double centerY, double xRadius, double yRadius,
              int red, int green, int blue) throws IllegalArgumentException {
    super(name, OVAL_SHAPE, centerX, centerY, xRadius, yRadius ,red, green, blue);
  }


  /**
   * copy constructor method for Oval.
   */
  private Oval(Oval original) {
    super(original);
  }

  /**
   * method to return a copy of the oval.
   *
   * @return Oval. A copy of the oval.
   */
  @Override
  public Oval copy() {
    return new Oval(this);
  }

  /**
   * toString method.
   *
   * @return String. String representation of the oval.
   */
  @Override
  public String toString() {
    return "Name: " + this.getShapeName() + "\nType: " + this.getShapeType() + "\nCenter: " + "(" + this.getPositionX() + ", "
        + this.getPositionY() + "), " + "X radius: " + this.getDimension1() +", Y radius: " + this.getDimension2()
        + ", " + this.getColor().toString();
  }
}
