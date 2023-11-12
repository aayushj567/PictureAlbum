import Model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * JUnit test for Snapshot class
 */
public class testSnapshot {
  private ISnapshot testSnapshot;
  IShape testOval;
  IShape testRectangle;
  List<IShape> testShapesList;

  /**
   * setting up variables for testing.
   */
  @Before
  public void setUp() {
    testShapesList = new ArrayList<>();
    testOval = new Oval("Oval1", 100, 200, 50, 80, 255, 0, 0);
    testRectangle = new Rectangle("Rectangle1", 50, 50, 100, 100, 0, 255, 0);
    testShapesList.add(testOval);
    testShapesList.add(testRectangle);
    testSnapshot = Snapshot.takeSnapshot(testShapesList);
  }

  /**
   * test for getSnapshotID method.
   */
  @Test
  public void testGetSnapshotID() {
    assertNotEquals("", testSnapshot.getSnapshotID());
  }

  /**
   * test for getShapesList method.
   */
  @Test
  public void testGetShapesList() {
    assertEquals(testShapesList, testSnapshot.getShapesList());
  }
}
