package Controller;

import Model.IShape;
import Model.ISnapshot;
import Model.shapeAlbum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class for talkToView. This class is used to pass data from the model to the view.
 * The static method getSnapshotIDtoShapeListMap(), given a shapeAlbum, returns a HashMap that maps
 * each snapshotID in the shapeAlbum to the list of shapes in that snapshot.
 */
public class talkToView {

  /**
   * given a shapeAlbum, return a HashMap that maps each snapshotID in the shapeAlbum to the list of
   * shapes in that snapshot.
   *
   * @param currentAlbum shapeAlbum. The shapeAlbum to get the HashMap from.
   * @return HashMap<String, List<IShape>>. The HashMap that maps each snapshotID in the shapeAlbum
   * to the list of shapes in that snapshot.
   */
  public static HashMap<String, List<IShape>> getSnapshotIDtoShapeListMap(shapeAlbum currentAlbum) {
    HashMap<String, List<IShape>> snapshotIDtoShapeList = new HashMap<>();
    for (ISnapshot snapshot : currentAlbum.getSnapshotList()) {
      snapshotIDtoShapeList.put(snapshot.getSnapshotID(), snapshot.getShapesList());
    }
    return snapshotIDtoShapeList;
  }

  /**
   * given a shapeAlbum, return a list of snapshotIDs.
   *
   * @param currentAlbum shapeAlbum. The shapeAlbum to get the snapshotIDs from.
   * @return List<String>. The list of snapshotIDs.
   */
  public static List<String> getSnapshotIDList(shapeAlbum currentAlbum) {
    List<String> snapshotIDList = new ArrayList<>();
    for (ISnapshot snapshot : currentAlbum.getSnapshotList()) {
      snapshotIDList.add(snapshot.getSnapshotID());
    }
    return snapshotIDList;
  }

  public static void main(String[] args) {
    String buildingFile = "/Users/aayushjaiswal/Desktop/STUDY/ObjOriented/IdeaProjects/Homework/hw9/buildings.txt";
    shapeAlbum testAlbum = new shapeAlbum();
    FileParserForModel.parseFile(testAlbum, buildingFile);
    HashMap<String, List<IShape>> snapshotIDtoShapeListMap = talkToView.getSnapshotIDtoShapeListMap(testAlbum);
    // print the snapshotID present in the hashmap
  }
}
