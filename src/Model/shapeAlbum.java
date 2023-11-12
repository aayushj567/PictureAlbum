package Model;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for shapeAlbum.
 */
public class shapeAlbum {
  private List<IShape> shapesList; // list of shapes on the album.
  private List<ISnapshot> snapshotList; // list of snapshots on the album.

  /**
   * Constructor for shapeAlbum.
   */
  public shapeAlbum() {
    this.shapesList = new ArrayList<>();
    this.snapshotList = new ArrayList<>();
  }

  /**
   * getter method for shapesList.
   *
   * @return List<IShape>. The list of shapes on the album.
   */
  public List<IShape> getShapesList() {
    return this.shapesList;
  }

  /**
   * getter method for snapshotList.
   *
   * @return List<ISnapshot>. The list of snapshots on the album.
   */
  public List<ISnapshot> getSnapshotList() {
    return this.snapshotList;
  }

  /**
   * find a shape in the shapesList given the name of the shape and return it.
   *
   * @param shapeName String. The name of the shape to find.
   * @return IShape. The shape with the given name.
   */
  public IShape findShape(String shapeName) {
    for (IShape shape : this.shapesList) {
      if (shape.getShapeName().equals(shapeName)) {
        return shape;
      }
    }
    return null;
  }

  /**
   * method to take a snapshot of the current state of album.
   * Each snapshot has a unique ID and maps to a list of shapes present on the album
   * at the time of snapshot .
   * The list of shapes is a deep copy of the shapesList.
   * The snapshot is added to the snapshotList.
   * The snapshotToShapesMap is updated with the new snapshot and the list of shapes.
   */
  public void takeSnapshotOfAlbum() {
    // create a new list of shapes to store a deep copy of the shapesList.
    List<IShape> shapesListCopy = new ArrayList<>();
    // iterate through the shapesList and add a deep copy of each shape to the new list.
    for (IShape shape : this.getShapesList()) {
      shapesListCopy.add(shape.copy());
    }
    // create a new snapshot.
    ISnapshot currentSnapshot = Snapshot.takeSnapshot(shapesListCopy);
    // add the snapshot to the snapshotList.
    this.snapshotList.add(currentSnapshot);
  }

  /**
   * method to check if a shape is present inside album.
   */
  private boolean containsShape(IShape shape) {
    return this.shapesList.contains(shape);
  }

  /**
   * method to add a shape to the album.
   *
   * @param shape IShape.
   */
  public void addShape(IShape shape) throws IllegalArgumentException {
    if (this.containsShape(shape)) {
      throw new IllegalArgumentException("Shape already present in album.");
    }
    this.shapesList.add(shape);
  }

  /**
   * method to remove a shape from the album. Duplicate shapes are not allowed.
   * A shape is considered to be duplicate if it has the same shapeType and name.
   *
   * @param shapeName String.
   */
  public void removeShape(String shapeName) {
    IShape shape = this.findShape(shapeName);
    if (shape != null) {
      this.shapesList.remove(shape);
    }
  }

  /**
   * method to update the album if a shape's position is changed.
   *
   * @param shapeName String. The name of the shape to update.
   * @param newPositionX double. The new value of x position.
   * @param newPositionY double. The new value of y position.
   */
  public void updateShapePosition(String shapeName, double newPositionX, double newPositionY) {
    IShape shape = this.findShape(shapeName);
    if (shape != null) {
      // check if the new positions are different from the current position and change them.
      if (shape.getPositionX() != newPositionX) {
        shape.setPositionX(newPositionX);
      }
      if (shape.getPositionY() != newPositionY) {
        shape.setPositionY(newPositionY);
      }
    }
  }

  /**
   * method to update the album if a shape's color is changed.
   *
   * @param shapeName String. The name of the shape to update.
   * @param red int. The new value of red.
   * @param green int. The new value of green.
   * @param blue int. The new value of blue.
   */
  public void updateShapeColor(String shapeName, int red, int green, int blue) {
    IShape shape = this.findShape(shapeName);
    if (shape != null) {
      shape.setColor(red, green, blue);
    }
  }

  /**
   * method to update the album if a shape's dimensions are changed.
   *
   * @param shapeName String. The name of the shape to update.
   * @param newDimension1 double. The new value of the first dimension.
   * @param newDimension2 double. The new value of the second dimension.
   */
  public void updateShapeDimensions(String shapeName, double newDimension1, double newDimension2) {
    IShape shape = this.findShape(shapeName);
    if (shape != null) {
      // check if the dimensions are different from the current dimensions.
      if (shape.getDimension1() != newDimension1) {
        shape.setDimension1(newDimension1);
      }
      if (shape.getDimension2() != newDimension2) {
        shape.setDimension2(newDimension2);
      }
    }
  }

  /**
   * method to reset the album to the initial state.
   */
  public void resetAlbum() {
    this.shapesList.clear();
    this.snapshotList.clear();
  }

  /**
   * method to print the state of the album at each snapshot.
   */
  public void printAlbumState() {
    for (ISnapshot snapshot : this.getSnapshotList()) {
      System.out.println(snapshot.toString());
    }
  }
}