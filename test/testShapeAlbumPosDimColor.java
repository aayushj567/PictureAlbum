import Model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * JUnit test for the shapeAlbum class methods to update the position, dimension, and color of a shape.
 */
public class testShapeAlbumPosDimColor {
  private IShape testOval;
  private IShape testRectangle;
  private shapeAlbum testAlbum;
  private double delta = 0.001;

  /**
   * setting up variables for testing.
   */
  @Before
  public void setUp() {
    testAlbum = new shapeAlbum();
    testOval = new Oval("Oval1", 100, 200, 50, 80, 255, 0, 0);
    testRectangle = new Rectangle("Rectangle1", 50, 50, 100, 100, 0, 255, 0);
    testAlbum.addShape(testOval);
    testAlbum.addShape(testRectangle);
  }

  /**
   * test for the updatePosition method.
   */
  @Test
  public void testUpdateShapePosition() {
    testAlbum.updateShapePosition("Oval1", 200, 200);
    testAlbum.updateShapePosition("Rectangle1", 100, 100);
    assertEquals(200, testAlbum.getShapesList().get(0).getPositionX(), delta);
    assertEquals(200, testAlbum.getShapesList().get(0).getPositionY(), delta);
    assertEquals(100, testAlbum.getShapesList().get(1).getPositionX(), delta);
    assertEquals(100, testAlbum.getShapesList().get(1).getPositionY(), delta);
  }

  /**
   * test for the updateDimension method for valid inputs.
   */
  @Test
  public void testUpdateShapeDimension() {
    testAlbum.updateShapeDimensions("Oval1", 100, 100);
    testAlbum.updateShapeDimensions("Rectangle1", 200, 200);
    assertEquals(100, testAlbum.getShapesList().get(0).getDimension1(), delta);
    assertEquals(100, testAlbum.getShapesList().get(0).getDimension2(), delta);
    assertEquals(200, testAlbum.getShapesList().get(1).getDimension1(), delta);
    assertEquals(200, testAlbum.getShapesList().get(1).getDimension2(), delta);
  }

  /**
   * test for the updateDimension method for invalid inputs including edge case of 0.
   */
  @Test
  public void testUpdateShapeDimensionInvalid() {
    try {
      testAlbum.updateShapeDimensions("Oval1", -100, 100);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid dimension", e.getMessage());
    }
    try {
      testAlbum.updateShapeDimensions("Oval1", 0, -100);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid dimension", e.getMessage());
    }

    try {
      testAlbum.updateShapeDimensions("Rectangle1", 200, -200);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid dimension", e.getMessage());
    }
    try {
      testAlbum.updateShapeDimensions("Rectangle1", 200, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid dimension", e.getMessage());
    }
  }

  /**
   * test for the updateColor method for valid inputs.
   */
  @Test
  public void testUpdateShapeColor() {
    shapeColor expectedOvalColor = shapeColor.createShapeColor(0, 0, 255);
    shapeColor expectedRectangleColor = shapeColor.createShapeColor(255, 255, 255);

    testAlbum.updateShapeColor("Oval1", 0, 0, 255);
    testAlbum.updateShapeColor("Rectangle1", 255, 255, 255);

    assertEquals(expectedOvalColor, testAlbum.getShapesList().get(0).getColor());
    assertEquals(expectedRectangleColor, testAlbum.getShapesList().get(1).getColor());
  }

  /**
   * test for the updateColor method for invalid inputs including edge cases of -1 and 256.
   */
  @Test
  public void testUpdateShapeColorInvalid() {
    try {
      testAlbum.updateShapeColor("Oval1", -1, 0, 255);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid color values", e.getMessage());
    }
    try {
      testAlbum.updateShapeColor("Oval1", 0, 256, 255);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid color values", e.getMessage());
    }
    try {
      testAlbum.updateShapeColor("Oval1", 0, 0, 256);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid color values", e.getMessage());
    }
    try {
      testAlbum.updateShapeColor("Rectangle1", 256, 255, 255);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid color values", e.getMessage());
    }
    try {
      testAlbum.updateShapeColor("Rectangle1", 255, -1, 255);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid color values", e.getMessage());
    }
    try {
      testAlbum.updateShapeColor("Rectangle1", 255, 255, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid color values", e.getMessage());
    }
  }
}
