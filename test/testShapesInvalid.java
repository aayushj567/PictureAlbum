import Model.IShape;
import Model.Oval;
import Model.Rectangle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * JUnit test class for the IShape interface for invalid shapes.
 */
public class testShapesInvalid {
  private IShape invalidOval;
  private IShape invalidRectangle;

  /**
   * setting up variables for testing.
   */
  @Before
  public void setUp() {
//    invalidOval = new Oval("Oval1", 200, 200, null, 60, 30);
//    invalidRectangle = new Rectangle("Rectangle1", 50, 100, null, 60, 30);
  }

  /**
   * testing Oval and Rectangle constructor with blank or null shape name.
   */
  @Test
public void testOvalInvalidName() {
    // testing Oval with blank name.
    try {
      new Oval("", 200, 200, 50, 60, 30,255,90);
      throw new IllegalArgumentException("test failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid shape parameters", e.getMessage());
    }
    // testing Oval with blank name.
    try {
      new Oval("   ", 200, 200, 50, 60, 30,255,90);
      throw new IllegalArgumentException("test failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid shape parameters", e.getMessage());
    }
    // testing Rectangle with null name.
    try {
      new Rectangle(null, 50, 100, 60, 30,255,90, 255);
      throw new IllegalArgumentException("test failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid shape parameters", e.getMessage());
    }
    // testing Rectangle with empty name.
    try {
      new Rectangle(null, 50, 100, 60, 30,255,90,0);
      throw new IllegalArgumentException("test failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid shape parameters", e.getMessage());
    }
  }



  /**
   * test Oval and Rectangle constructor with 0 and negative radius, width, and height.
   */
  @Test
  public void testOvalInvalidDimensions() {
    // testing Oval with negative X radius.
    try {
      new Oval("Oval1", 200, 200, -50, -60, 30,255,90);
      throw new IllegalArgumentException("test failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid shape parameters", e.getMessage());
    }
    // testing Oval with negative Y radius.
    try {
      new Oval("Oval1", 200, 200, -50, 60, -30,255,90);
      throw new IllegalArgumentException("test failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid shape parameters", e.getMessage());
    }
    // testing 0val with zero radius.
    try {
      new Oval("Oval1", 200, 200, 50, 0, 30,255,90);
      throw new IllegalArgumentException("test failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid shape parameters", e.getMessage());
    }
    // testing rectangle with negative width.
    try {
      new Rectangle("Rectangle1", 50, 100, -60, 30,255,255, 255);
      throw new IllegalArgumentException("test failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid shape parameters", e.getMessage());
    }
    // testing rectangle with negative height.
    try {
      new Rectangle("Rectangle1", 50, 100, 60, -30,255,255, 255);
      throw new IllegalArgumentException("test failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid shape parameters", e.getMessage());
    }
    // testing rectangle with 0 height.
    try {
      new Rectangle("Rectangle1", 50, 100, 60, 0,255,255, 255);
      throw new IllegalArgumentException("test failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid shape parameters", e.getMessage());
    }
    // testing rectangle with 0 width.
    try {
      new Rectangle("Rectangle1", 50, 100, 0, 30,255,255, 255);
      throw new IllegalArgumentException("test failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid shape parameters", e.getMessage());
    }
  }

  /**
   * testing Oval and Rectangle constructor with out-of-range RGB values.
   */
  @Test
  public void testOvalInvalidRGB() {
    // testing Oval with out-of-range RGB values.
    try {
      new Oval("Oval1", 200, 200, 50, 60, 30, 300, 90);
      throw new IllegalArgumentException("test failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid shape parameters", e.getMessage());
    }
    // testing with edge case of 256.
    try {
      new Rectangle("Rectangle1", 50, 100, 60, 30, 256, 90, 255);
      throw new IllegalArgumentException("test failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid shape parameters", e.getMessage());
    }
    // testing with edge case of -1.
    try {
      new Rectangle("Rectangle1", 50, 100, 60, 30, -1, 1, 45);
      throw new IllegalArgumentException("test failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid shape parameters", e.getMessage());
    }
  }
}
