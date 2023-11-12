package Model;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * takeSnapshot class takes a snapshot of the current state of shapeAlbum.
 */
public class Snapshot implements ISnapshot{
  private String snapshotID;
  private String timestamp;
  private List<IShape> shapesList;

  /**
   * method to get time and date.
   *
   * @return String.
   */
  private static String getNewSnapshotID() {
    return java.time.LocalDateTime.now().toString();
  }

  /**
   * method to get timestamp for snapshot.
   *
   * @return String.
   */
  private static String getNewTimestamp() {
    return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
  }

  /**
   * private constructor for takeSnapshot.
   *
   * @param shapesListCopy List<IShape>. The list of shapes tied to the snapshot.
   */
  private Snapshot(List<IShape> shapesListCopy) {
    this.snapshotID = getNewSnapshotID();
    this.timestamp = getNewTimestamp();
    this.shapesList = new ArrayList<>();
    this.shapesList.addAll(shapesListCopy);
  }

  /**
   * factory method for takeSnapshot.
   *
   * @param shapesListCopy List<IShape>. The list of shapes that goes into the snapshot.
   * @return Snapshot.
   */
  public static Snapshot takeSnapshot(List<IShape> shapesListCopy) {
    return new Snapshot(shapesListCopy);
  }

  /**
   * getter method for snapshotID.
   *
   * @return String. The snapshotID.
   */
  @Override
  public String getSnapshotID() {
    return this.snapshotID;
  }

  /**
   * getter method for shapesList.
   *
   * @return List<IShape>. The list of shapes in the snapshot.
   */
  @Override
  public List<IShape> getShapesList() {
    return this.shapesList;
  }

  /**
   * toString method for the shapesList.
   *
   * @return String. The string representation of the list of shapes in the snapshot.
   */
  private String shapesListToString() {
    StringBuilder sb = new StringBuilder();
    for (IShape shape : this.shapesList) {
      sb.append(shape.toString());
      sb.append("\n\n");
    }
    return sb.toString();
  }

  /**
   * toString method.
   *
   * @return String. The string representation of the whole snapshot.
   */
  @Override
  public String toString() {
    return "SNAPSHOT ID: " + this.snapshotID + "\nTimestamp: " + this.timestamp
            + "\nShape(s) Information:\n\n" + this.shapesListToString();
  }

  /**
   * equals method.
   *
   * @param obj Object. The object to compare to.
   * @return boolean.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Snapshot)) {
      return false;
    }
    Snapshot other = (Snapshot) obj;
    return this.snapshotID.equals(other.snapshotID);
  }

  /**
   * hashCode method.
   *
   * @return int. The hashcode of the snapshotID.
   */
  @Override
  public int hashCode() {
    return this.snapshotID.hashCode();
  }
}
