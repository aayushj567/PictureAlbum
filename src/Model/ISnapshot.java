package Model;

import java.util.List;

/**
 * Interface for Snapshot.
 */
public interface ISnapshot {

  /**
   * getter method for snapshotID.
   *
   * @return String. The snapshotID.
   */
  public String getSnapshotID();

  /**
   * getter method for shapesList.
   *
   * @return List<IShape>. The list of shapes tied to the snapshot.
   */
  public List<IShape> getShapesList();
}
