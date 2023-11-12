package Model;

/**
 * Abstract class for Shape that implements IShape.
 */
public abstract class Shape implements IShape {
  private String shapeName;
  private String shapeType;
  private double positionX;
  private double positionY;
  private shapeColor color;
  private double dimension1;
  private double dimension2;

  /**
   * arguments checker for the second constructor. Private helper method.
   *
   * @param shapeName String.
   * @param shapeType String.
   * @param positionX double.
   * @param positionY double.
   * @param dimension1 double.
   * @param dimension2 double.
   * @param red double.
   * @param green double.
   * @param blue double.
   */
  private static boolean areParametersValid(String shapeName, String shapeType, double positionX,
                                     double positionY, double dimension1, double dimension2, int red, int green, int blue) {
    // check if the name, type, or dimensions are null.
    if (shapeName == null || shapeType == null) {
      return false;
    }
    // check if the name, type, or colors are empty or blank.
    if (shapeName.isBlank() || shapeType.isBlank()) {
      return false;
    }
    // check if only 2 dimensions are given.
    if (dimension1 <= 0 || dimension2 <= 0) {
      return false;
    }
    // check if the color values are negative or greater than 255.
    if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
      return false;
    }
    return true;
  }

  /**
   * another constructor for Shape which takes in three doubles for the color values.
   */
  public Shape(String shapeName, String shapeType, double positionX, double positionY,
               double dimension1, double dimension2, int red, int green, int blue) throws IllegalArgumentException {
    if (areParametersValid(shapeName, shapeType, positionX, positionY,dimension1, dimension2, red, green, blue)) {
      this.shapeName = shapeName;
      this.shapeType = shapeType;
      this.positionX = positionX;
      this.positionY = positionY;
      this.dimension1 = dimension1;
      this.dimension2 = dimension2;
      this.color = shapeColor.createShapeColor(red, green, blue);
    }
    else {
      throw new IllegalArgumentException("Invalid shape parameters");
    }
  }

  /**
   * constructor to create a copy of a shape.
   */
  public Shape(Shape other) {
    this.shapeName = other.getShapeName();
    this.shapeType = other.getShapeType();
    this.positionX = other.getPositionX();
    this.positionY = other.getPositionY();
    this.dimension1 = other.getDimension1();
    this.dimension2 = other.getDimension2();
    this.color = other.getColor().copy();
  }

  /**
   * method to get the shape name.
   *
   * @return String. The name of the shape.
   */
  public String getShapeName() {
    return this.shapeName;
  }

  /**
   * method to get the shape type.
   *
   * @return String. The type of the shape.
   */
  public String getShapeType() {
    return this.shapeType;
  }

  /**
   * method to get the x position.
   *
   * @return double. The x position of the shape.
   */
  public double getPositionX() {
    return this.positionX;
  }

  /**
   * setter for Position X.
   *
   * @param newPositionX double. New x position.
   */
  public void setPositionX( double newPositionX) {
    if (this.getPositionX() != newPositionX) {
      this.positionX = newPositionX;
    }
  }

  /**
   * method to get the y position.
   *
   * @return double. The y position of the shape.
   */
  public double getPositionY() {
    return this.positionY;
  }

  /**
   * setter for Position Y.
   *
   * @param newPositionY double. New y position.
   */
  public void setPositionY(double newPositionY) {
    if (this.getPositionY() != newPositionY) {
      this.positionY = newPositionY;
    }
  }

  /**
   * method to get the first dimension.
   *
   * @return double. The first dimension of the shape.
   */
  public double getDimension1() {
    return this.dimension1;
  }

  /**
   * setter for Dimension 1.
   *
   * @param newDimension1 double. New first dimension.
   */
  public void setDimension1(double newDimension1) {
    if (newDimension1 <= 0) {
      throw new IllegalArgumentException("Invalid dimension");
    }
    if (this.getDimension1() != newDimension1) {
      this.dimension1 = newDimension1;
    }
  }

  /**
   * method to get the second dimension.
   *
   * @return double. The second dimension of the shape.
   */
  public double getDimension2() {
    return this.dimension2;
  }

  /**
   * setter for Dimension 2.
   *
   * @param newDimension2 double. New second dimension.
   */
  public void setDimension2(double newDimension2) {
    if (newDimension2 <= 0) {
      throw new IllegalArgumentException("Invalid dimension");
    }
    if (this.getDimension2() != newDimension2) {
      this.dimension2 = newDimension2;
    }
  }

  /**
   * method to get the color values.
   */
  public shapeColor getColor() {
    return this.color;
  }

  /**
   * setter for color values.
   *
   * @param red int. Red value.
   * @param green int. Green value.
   * @param blue int. Blue value.
   */
  @Override
  public void setColor(int red, int green, int blue) {
    this.color.setColorValues(red, green, blue);
  }

  /**
   * equals method for Shape.
   */
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (other == this) {
      return true;
    }
    if (other.getClass() != this.getClass()) {
      return false;
    }
    Shape otherShape = (Shape) other;
    return this.shapeName.equals(otherShape.getShapeName())
        && this.shapeType.equals(otherShape.getShapeType());
  }
}
