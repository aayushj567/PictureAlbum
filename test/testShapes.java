import Model.IShape;
import Model.Oval;
import Model.Rectangle;
import Model.shapeColor;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for IShape and its subclasses
 */
public class testShapes {
  private IShape testOval;
  private IShape testRectangle;
  private double delta = 0.001;

  /**
   * Set up for testing.
   */
  @Before
  public void setUp() {
    testOval = new Oval("Oval1", 100, 200, 50, 80, 255, 0, 0);
    testRectangle = new Rectangle("Rectangle1", 50, 50, 100, 100, 0, 255, 0);
  }

  /**
   * Test for getShapeName.
   */
  @Test
  public void testGetShapeName() {
    assertEquals("Oval1", testOval.getShapeName());
    assertEquals("Rectangle1", testRectangle.getShapeName());
  }

  /**
   * Test for getShapeType.
   */
  @Test
  public void testGetShapeType() {
    assertEquals("oval", testOval.getShapeType());
    assertEquals("rectangle", testRectangle.getShapeType());
  }

  /**
   * Test for getPositionX.
   */
  @Test
  public void testGetPositionX() {
    assertEquals(100, testOval.getPositionX(), delta);
    assertEquals(50, testRectangle.getPositionX(), delta);
  }

  /**
   * Test for setPositionX.
   */
  @Test
  public void testSetPositionX() {
    testOval.setPositionX(200);
    assertEquals(200, testOval.getPositionX(), delta);
    testRectangle.setPositionX(100);
    assertEquals(100, testRectangle.getPositionX(), delta);
  }

  /**
   * Test for getPositionY.
   */
  @Test
  public void testGetPositionY() {
    assertEquals(200, testOval.getPositionY(), delta);
    assertEquals(50, testRectangle.getPositionY(), delta);
  }

  /**
   * Test for setPositionY.
   */
  @Test
  public void testSetPositionY() {
    testOval.setPositionY(300);
    assertEquals(300, testOval.getPositionY(), delta);
    testRectangle.setPositionY(100);
    assertEquals(100, testRectangle.getPositionY(), delta);
  }

  /**
   * Test for getDimension1 (xRadius for oval, width for rectangle).
   */
  @Test
  public void testGetDimension1() {
    assertEquals(50, testOval.getDimension1(), delta);
    assertEquals(100, testRectangle.getDimension1(), delta);
  }

  /**
   * Test for setDimension1 (xRadius for oval, width for rectangle).
   */
  @Test
  public void testSetDimension1() {
    testOval.setDimension1(100);
    assertEquals(100, testOval.getDimension1(), delta);
    testRectangle.setDimension1(200);
    assertEquals(200, testRectangle.getDimension1(), delta);
  }

  /**
   * Test for getDimension2 (yRadius for oval, height for rectangle).
   */
  @Test
  public void testGetDimension2() {
    assertEquals(80, testOval.getDimension2(), delta);
    assertEquals(100, testRectangle.getDimension2(), delta);
  }

  /**
   * Test for setDimension2 (yRadius for oval, height for rectangle).
   */
  @Test
  public void testSetDimension2() {
    testOval.setDimension2(100);
    assertEquals(100, testOval.getDimension2(), delta);
    testRectangle.setDimension2(200);
    assertEquals(200, testRectangle.getDimension2(), delta);
  }

  /**
   * test for getColor.
   */
  @Test
public void testGetColor() {
    shapeColor expectedOvalColor = shapeColor.createShapeColor(255, 0, 0);
    shapeColor expectedRectangleColor = shapeColor.createShapeColor(0, 255, 0);
    assertEquals(expectedOvalColor, testOval.getColor());
    assertEquals(expectedRectangleColor, testRectangle.getColor());
  }

  /**
   * Test for setColor.
   */
  @Test
  public void testSetColor() {
    testOval.setColor(0, 0, 255);
    shapeColor expectedOvalColor = shapeColor.createShapeColor(0, 0, 255);
    assertEquals(expectedOvalColor, testOval.getColor());
    testRectangle.setColor(255, 0, 0);
    shapeColor expectedRectangleColor = shapeColor.createShapeColor(255, 0, 0);
    assertEquals(expectedRectangleColor, testRectangle.getColor());
  }

  /**
   * test toString.
   */
  @Test
  public void testToString() {
    String expectedOvalString = "Name: Oval1\n"
            + "Type: oval\n"
            + "Center: (100.0, 200.0), X radius: 50.0, Y radius: 80.0, Color: (255, 0, 0)";
    String expectedRectangleString = "Name: Rectangle1\n"
            + "Type: rectangle\n"
            + "Min. corner: (50.0, 50.0), Width: 100.0, Height: 100.0, Color: (0, 255, 0)";
    assertEquals(expectedOvalString, testOval.toString());
    assertEquals(expectedRectangleString, testRectangle.toString());
  }
}
