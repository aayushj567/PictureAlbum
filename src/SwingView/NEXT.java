package SwingView;

import Model.IShape;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class for nextButton. This class is the next button of the SwingView of shapes photo album viewer.
 */
public class NEXT extends JButton implements ActionListener {
  private List<String> snapshotIDList;
  private JPanel snapshotInfoPanel;
  private HashMap<String, List<IShape>> snapshotIDtoShapeListMap;
  private int index = 0;
  shapesPanel drawings;
  List<shapesPanel> drawingsList;

  /**
   * Constructor for nextButton.
   *
   * @param snapshotIDList List of snapshotID.
   * @param snapshotInfoPanel JPanel to display snapshotID.
   * @param drawings shapesPanel to display shapes related to the snapshotID.
   * @param snapshotIDtoShapeListMap HashMap of snapshotID to shapeList.
   */
  public NEXT(List<String> snapshotIDList, JPanel snapshotInfoPanel, shapesPanel drawings, HashMap<String, List<IShape>> snapshotIDtoShapeListMap, int xMax, int yMax) {
    // setting up the next button
    this.snapshotIDList = snapshotIDList;
    this.setBounds(900, 100, 50, 50);
    this.setText("NEXT");
    this.addActionListener(this);
    this.snapshotInfoPanel = snapshotInfoPanel;
    this.snapshotInfoPanel.add(new JLabel(snapshotIDList.get(index)));

    this.drawings = drawings;
    this.drawings.add(new shapesPanel(snapshotIDtoShapeListMap, snapshotIDList.get(index), xMax, yMax));
    this.drawingsList = new ArrayList<shapesPanel>();
    for (String snapshotID : snapshotIDList) {
      this.drawingsList.add(new shapesPanel(snapshotIDtoShapeListMap, snapshotID, xMax, yMax));
    }
  }

  /**
   * getter for snapshotIDList.
   *
   * @return snapshotIDList
   */
  public List<String> getSnapshotIDList() {
    return this.snapshotIDList;
  }

  /**
   * getter for current snapshotID.
   */
  public String getCurrentSnapshotID() {
    return this.snapshotIDList.get(this.index);
  }

  /**
   * getter for snapshotInfoPanel.
   */
  public JPanel getSnapshotInfoPanel() {
    return this.snapshotInfoPanel;
  }

  /**
   * getter for index.
   * @return index
   */
  public int getIndex() {
    return this.index;
  }

  /**
   * setter for index.
   */
  public void setIndex(int index) {
    this.index = index;
  }

  /**
   * update the shapesPanel.
   */
  public void updateShapesPanel() {
    this.drawings.removeAll();
    this.drawings.add(this.drawingsList.get(this.index));
    this.drawings.revalidate();
    this.drawings.repaint();
  }

  /**
   * update the snapshotInfoPanel.
   */
  public void updateSnapshotInfoPanel() {
    this.snapshotInfoPanel.removeAll();
    this.snapshotInfoPanel.add(new JLabel(this.snapshotIDList.get(this.index)));
    this.snapshotInfoPanel.revalidate();
    this.snapshotInfoPanel.repaint();
  }

  /**
   * method to change the snapshotInfoPanel to the next snapshotID.
   */
  private void updateDisplayPanels() {
    // if we are not at the end of the list, then we can go to the next snapshotID
    if (this.index < snapshotIDList.size() - 1) {
      // increment the index
      this.index++;
      // update the snapshotInfoPanel
      this.updateSnapshotInfoPanel();
      // update the drawings
      this.updateShapesPanel();
    }
  }

  /**
   * Invoked when an action occurs.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    updateDisplayPanels();
  }
}
