package Model;

/**
 * Class for shape color.
 */
public class shapeColor {
  private int[] colorValues;

  /**
   * another constructor for shapeColor which takes in 3 doubles for red, green, blue.
   *
   * @param red double. range 0 to 255.
   * @param green double. range 0 to 255.
   * @param blue double. range 0 to 255.
   */
  private shapeColor(int red, int green, int blue) throws IllegalArgumentException {
    if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Invalid color values");
    }
    this.colorValues = new int[3];
    this.colorValues[0] = red;
    this.colorValues[1] = green;
    this.colorValues[2] = blue;
  }

  /**
   * factory method for shapeColor.
   */
  public static shapeColor createShapeColor(int red, int green, int blue) {
    return new shapeColor(red, green, blue);
  }

  /**
   * method to get the color values.
   *
   * @return int[]. the array of color values.
   */
  public int[] getColorValues() {
    return this.colorValues;
  }

  /**
   * method to reset the color values.
   */
  public void resetColorValues() {
    this.colorValues[0] = 0;
    this.colorValues[1] = 0;
    this.colorValues[2] = 0;
  }

  /**
   * method to set the color values.
   *
   * @param red int. range 0 to 255.
   * @param green int. range 0 to 255.
   * @param blue int. range 0 to 255.
   */
  public void setColorValues(int red, int green, int blue) {
    if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Invalid color values");
    }
    if (this.colorValues[0] != red) {
      this.colorValues[0] = red;
    }
    if (this.colorValues[1] != green) {
      this.colorValues[1] = green;
    }
    if (this.colorValues[2] != blue) {
      this.colorValues[2] = blue;
    }
  }

  /**
   * copy constructor for shapeColor.
   */
  public shapeColor(shapeColor other) {
    this.colorValues = new int[3];
    this.colorValues[0] = other.getColorValues()[0];
    this.colorValues[1] = other.getColorValues()[1];
    this.colorValues[2] = other.getColorValues()[2];
  }

  /**
   * method to return a copy of the shapeColor.
   */
  public shapeColor copy() {
    return new shapeColor(this);
  }

  /**
   * toString method.
   */
  @Override
  public String toString() {
    return "Color: (" + this.colorValues[0] + ", " + this.colorValues[1] + ", " + this.colorValues[2] + ")";
  }

  /**
   * equals method.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    shapeColor that = (shapeColor) o;
    return this.colorValues[0] == that.colorValues[0] &&
        this.colorValues[1] == that.colorValues[1] &&
        this.colorValues[2] == that.colorValues[2];
  }
}
