package Controller;

import Model.IShape;
import Model.Oval;
import Model.Rectangle;
import Model.shapeAlbum;

/**
 * controller for updating a shapeAlbum.
 */
public class updateAlbum {

  /**
   * take a snapshot of the current album.
   *
   * @param currentAlbum shapeAlbum.
   */
  public static void takeSnapshot(shapeAlbum currentAlbum) {
    currentAlbum.takeSnapshotOfAlbum();
  }

  /**
   * adding a shape to the album.
   *
   * @param currentAlbum shapeAlbum.
   * @param shapeType type of the shape to be added.
   * @param shapeName name of the shape to be added.
   * @param positionX x position of the shape.
   * @param positionY y position of the shape.
   * @param width width of the shape.
   * @param height height of the shape.
   */
  public static void addShape(shapeAlbum currentAlbum, String shapeType, String shapeName,
                              double positionX, double positionY, double width, double height,
                              int red, int green, int blue) {
    IShape shape;
    if (shapeType.equals("rectangle")) {
      shape = new Rectangle(shapeName, positionX, positionY, width, height, red, green, blue);
    } else if (shapeType.equals("oval")) {
      shape = new Oval(shapeName, positionX, positionY, width, height, red, green, blue);
    } else {
      throw new IllegalArgumentException("Invalid shape type.");
    }
    currentAlbum.addShape(shape);
  }

  /**
   * removing a shape from the album.
   *
   * @param currentAlbum shapeAlbum.
   * @param shapeName name of the shape to be removed.
   */
  public static void removeShape(shapeAlbum currentAlbum, String shapeName) {
    currentAlbum.removeShape(shapeName);
  }

  /**
   * updating the position of a shape on the album.
   *
   * @param currentAlbum shapeAlbum.
   * @param shapeName name of the shape to be updated.
   * @param x new x position.
   * @param y new y position.
   */
  public static void updateShapePosition(shapeAlbum currentAlbum, String shapeName, double x, double y) {
    currentAlbum.updateShapePosition(shapeName, x, y);
  }

  /**
   * updating the color of a shape on the album.
   *
   * @param currentAlbum shapeAlbum.
   * @param shapeName name of the shape to be updated.
   * @param red new red value.
   * @param green new green value.
   * @param blue new blue value.
   */
  public static void updateShapeColor(shapeAlbum currentAlbum, String shapeName, int red, int green, int blue) {
    currentAlbum.updateShapeColor(shapeName, red, green, blue);
  }

  /**
   * updating the shape's dimensions on the album.
   *
   * @param currentAlbum shapeAlbum.
   * @param shapeName name of the shape to be updated.
   * @param newDimension1 new value of the first dimension.
   * @param newDimension2 new value of the second dimension.
   */
  public static void updateShapeDimensions(shapeAlbum currentAlbum, String shapeName, double newDimension1, double newDimension2) {
    currentAlbum.updateShapeDimensions(shapeName, newDimension1, newDimension2);
  }
}
