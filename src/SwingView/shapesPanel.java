package SwingView;

import Model.IShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class for shapesPanel. Contains all the shapes to be drawn on the panel.
 */
public class shapesPanel extends JPanel{
  private List<IShape> currentShapesList;
  private HashMap<String, List<IShape>> snapshotIDtoShapeListMap;

  /**
   * Default constructor for shapesPanel.
   */
  public shapesPanel(int xMax, int yMax) {
    this.setPreferredSize(new Dimension(xMax, yMax));
    this.currentShapesList = new ArrayList<>();
    this.snapshotIDtoShapeListMap = new HashMap<>();
  }

  /**
   * Constructor for shapesPanel that takes in a HashMap of snapshotID to shapeList and a snapshotID.
   *
   * @param snapshotIDtoShapeListMap HashMap of snapshotID to shapeList.
   */
  public shapesPanel(HashMap<String, List<IShape>> snapshotIDtoShapeListMap, String snapshotId, int xMax, int yMax) {
    this.snapshotIDtoShapeListMap = snapshotIDtoShapeListMap;
    this.setPreferredSize(new Dimension(xMax, yMax));
    this.currentShapesList = new ArrayList<>();
    // by default the currentShapesList should be list of shapes associated with snapshotID 0.
    this.currentShapesList = this.snapshotIDtoShapeListMap.get(snapshotId);
  }

  /**
   * getter method for shapesList.
   *
   * @return List<IShape>. The list of shapes to be drawn on the panel.
   */
  private List<IShape> getCurrentShapesList() {
    return this.currentShapesList;
  }

  /**
   * given an IShape, convert its color to Color object.
   *
   * @param shape IShape. The shape to convert the color of.
   */
  private Color convertColor(IShape shape) {
    int[] color = shape.getColor().getColorValues();
    return new Color(color[0], color[1], color[2]);
  }

  /**
   * given an IShape, convert its position and dimensions to int and return them in an array.
   *
   * @param shape IShape. The shape to convert the position and dimensions of.
   */
  private int[] convertPositionAndDimensions(IShape shape) {
    int[] positionAndDimensions = new int[4];
    positionAndDimensions[0] = (int) shape.getPositionX();
    positionAndDimensions[1] = (int) shape.getPositionY();
    positionAndDimensions[2] = (int) shape.getDimension1();
    positionAndDimensions[3] = (int) shape.getDimension2();
    return positionAndDimensions;
  }


  /**
   * method to draw all the shapes in the shapesList.
   *
   * @param g Graphics. The graphics object to draw the shapes.
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (IShape shape : this.getCurrentShapesList()) {
      // draw the shape based on its type.
      if (shape.getShapeType().equals("rectangle")) {
        g.setColor(convertColor(shape));
        int[] positionAndDimensions = convertPositionAndDimensions(shape);
        g.fillRect(positionAndDimensions[0], positionAndDimensions[1],
                positionAndDimensions[2], positionAndDimensions[3]);
      }
      else if (shape.getShapeType().equals("oval")) {
        g.setColor(convertColor(shape));
        int[] positionAndDimensions = convertPositionAndDimensions(shape);
        g.fillOval(positionAndDimensions[0], positionAndDimensions[1],
                positionAndDimensions[2], positionAndDimensions[3]);
      }
    }
  }
}
