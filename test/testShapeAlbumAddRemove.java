import Model.IShape;
import Model.Oval;
import Model.Rectangle;
import Model.shapeAlbum;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * JUnit test for the shapeAlbum class addShape and removeShape methods.
 */
public class testShapeAlbumAddRemove {
  private IShape testOval;
  private IShape testRectangle;
  private shapeAlbum testAlbum;

  /**
   * setting up variables for testing.
   */
  @Before
  public void setUp() {
    testAlbum = new shapeAlbum();
    testOval = new Oval("Oval1", 100, 200, 50, 80, 255, 0, 0);
    testRectangle = new Rectangle("Rectangle1", 50, 50, 100, 100, 0, 255, 0);
  }

  /**
   * test addShape method.
   */
  @Test
  public void testAddShape() {
    assertEquals(0, testAlbum.getShapesList().size());

    testAlbum.addShape(testOval);
    assertEquals(1, testAlbum.getShapesList().size());

    testAlbum.addShape(testRectangle);
    assertEquals(2, testAlbum.getShapesList().size());

    List<IShape> expectedShapesList = new ArrayList<>();
    expectedShapesList.add(testOval);
    expectedShapesList.add(testRectangle);

    assertEquals(expectedShapesList, testAlbum.getShapesList());
  }

  /**
   * test adding duplicate shape.
   * A duplicate shape is a shape with the same name as another shape on the album.
   */
  @Test
  public void testAddDuplicateShape() {
    testAlbum.addShape(testOval);
    testAlbum.addShape(testRectangle);

    IShape duplicateOval = new Oval("Oval1", 100, 100, 50, 80, 255, 230, 0);
    IShape duplicateShape = new Rectangle("Rectangle1", 0, 50, 10, 10, 0, 255, 0);

    try{
      testAlbum.addShape(duplicateOval);
    } catch (IllegalArgumentException e) {
      assertEquals("Shape already present in album.", e.getMessage());
    }

    try{
      testAlbum.addShape(duplicateShape);
    } catch (IllegalArgumentException e) {
      assertEquals("Shape already present in album.", e.getMessage());
    }
  }

  /**
   * test removeShape method.
   */
  @Test
  public void testRemoveShape() {
    testAlbum.addShape(testOval);
    testAlbum.addShape(testRectangle);
    assertEquals(2, testAlbum.getShapesList().size());

    testAlbum.removeShape("Oval1");
    assertEquals(1, testAlbum.getShapesList().size());

    testAlbum.removeShape("Rectangle1");
    assertEquals(0, testAlbum.getShapesList().size());
  }
}
