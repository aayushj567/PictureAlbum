package Model;

/**
 * IShape interface. Shapes have a unique name and shape type. They also have a color,
 * position, and dimension each with getter and setter.
 */
public interface IShape {

  /**
   * copy method for Shape.
   */
  public IShape copy();

  /**
   * getter for name.
   */
  public String getShapeName();

  /**
   * returns the type of shape. Ex: "circle", "rectangle", "triangle".
   *
   * @return String.
   */
  public String getShapeType();

  /**
   * getter for the x coordinate of shape's position.
   *
   * @return double.
   */
  public double getPositionX();

  /**
   * setter for Position X.
   *
   * @param newPositionX double. New x position.
   */
  public void setPositionX( double newPositionX);

  /**
   * getter for the y coordinate of shape's position.
   *
   * @return double.
   */
  public double getPositionY();

  /**
   * setter for Position Y.
   *
   * @param newPositionY double. New y position.
   */
  public void setPositionY(double newPositionY);

  /**
   * getter for first dimension of shape (like radius, width, height).
   */
  public double getDimension1();

  /**
   * setter for first dimension of shape (like radius, width, height).
   */
  public void setDimension1(double newDimension1);

  /**
   * getter for second dimension of shape (like radius, width, height).
   */
  public double getDimension2();

  /**
   * setter for second dimension of shape (like radius, width, height).
   */
  public void setDimension2(double newDimension2);

  /**
   * getter for color values of shape.
   */
  public shapeColor getColor();

  /**
   * setter for color values of shape.
   */
  public void setColor(int red, int green, int blue);
}
