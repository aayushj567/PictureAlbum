package SwingView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Class for PREV. This class is the prev button of the program.
 */
public class PREV extends JButton implements ActionListener {
  private List<String> snapshotIDList;
  private JPanel snapshotInfoPanel;
  private NEXT nextButton;
  private int index;

  public PREV( NEXT nextButton) {
    // setting up the prev button
    this.nextButton = nextButton;
    this.snapshotIDList = nextButton.getSnapshotIDList();
    this.setBounds(900, 150, 50, 50);
    this.setText("PREV");
    this.addActionListener(this);
    this.snapshotInfoPanel = nextButton.getSnapshotInfoPanel();
    this.index = nextButton.getIndex();
  }

  /**
   * method to update the snapshotInfoPanel and shapesPanel whe the prev button is clicked.
   */
  private void updateDisplayPanels() {
    // get the current index
    this.index = this.nextButton.getIndex();
    // if we are not at the beginning of the list we can go to the previous snapshot
    if (this.index != 0 ) {
      // lower the index by 1
      this.index--;
      // set the index of the next button to the current index
      this.nextButton.setIndex(this.index);
      // update the snapshotInfoPanel
      this.nextButton.updateSnapshotInfoPanel();
      // update the shapes panel
      this.nextButton.updateShapesPanel();
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
