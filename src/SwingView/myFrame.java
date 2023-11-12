package SwingView;

import Model.IShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

/**
 * Class for myFrame. This class is the main frame of the program.
 */
public class myFrame extends JFrame implements ActionListener{
  private JPanel snapshotInfoPanel;
  private JPanel buttonPanel;
  private shapesPanel drawings;
  private HashMap<String, List<IShape>> snapshotIDtoShapeListMap;
  private List<String> snapshotIDList;
  private NEXT nextButton;
  private PREV prevButton;
  private JButton selectButton;
  private JButton quitButton;

  /**
   * Constructor for myFrame.
   *
   * @param snapshotIDtoShapeListMap HashMap of snapshotID to shapeList
   */
  public myFrame(HashMap<String, List<IShape>> snapshotIDtoShapeListMap, List<String> snapshotIDList, int xMax, int yMax) {
    this.snapshotIDtoShapeListMap = snapshotIDtoShapeListMap;
    this.snapshotIDList = snapshotIDList;
    // set up the frame
    this.setTitle("cs5004 shapes photo album viewer");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    int frameWidth = xMax + 200;
    int frameHeight = yMax + 200;
    this.setSize(frameWidth, frameHeight);
    this.setVisible(true);
    this.setResizable(false);

    // panel to display snapshotID
    this.snapshotInfoPanel = new JPanel();
    this.snapshotInfoPanel.setBackground(new Color(0xF59494));
    snapshotInfoPanel.setPreferredSize(new Dimension(800, 50));

    // panel to display buttons
    buttonPanel = new JPanel();
    buttonPanel.setBackground(new Color(0xA29797));
    buttonPanel.setPreferredSize(new Dimension(100, 800));

    // panel to display shapes
    this.drawings = new shapesPanel(xMax, yMax);

    // next and prev buttons
    this.nextButton = new NEXT(this.snapshotIDList, this.snapshotInfoPanel, this.drawings, this.snapshotIDtoShapeListMap, xMax, yMax);
    this.prevButton = new PREV(this.nextButton);

    selectButton = new JButton();
    addSelectButtonListener();

    quitButton = new JButton();
    addQuitButtonListener();

    // Add the next, prev, select and quit buttons to the button panel.
    buttonPanel.add(this.nextButton);
    buttonPanel.add(this.prevButton);
    buttonPanel.add(selectButton);
    buttonPanel.add(quitButton);

    // Add the panels to the frame using BorderLayout and add buttons to panel.
    this.add(snapshotInfoPanel, BorderLayout.NORTH);
    this.add(buttonPanel, BorderLayout.EAST);
    this.add(drawings, BorderLayout.CENTER);
    this.pack();
  }

  /**
   * method to add an action listener to the select button.
   */
  public void addSelectButtonListener() {
    // designing the select button
    selectButton.setBounds(900, 200, 50, 55);
    selectButton.setText("SELECT");
    // adding action listener to the select button
    selectButton.addActionListener(this);
  }

  /**
   * Method to perform action when SELECT button is clicked.
   * This method makes use of the action performed method of next and prev buttons.
   */
  public void selectButtonClicked() {
    // first make an array of snapshotIDs which will be used to create a drop-down menu.
    String[] snapshotIDArray = new String[this.snapshotIDList.size()];
    for (int i = 0; i < this.snapshotIDList.size(); i++) {
      snapshotIDArray[i] = this.snapshotIDList.get(i);
    }
    // show a drop-down menu to select a snapshotID.
    String selectedSnapshotID = (String) JOptionPane.showInputDialog(null, "Select a snapshotID",
            "SnapshotID Selection", JOptionPane.QUESTION_MESSAGE, null, snapshotIDArray, snapshotIDArray[0]);
    if (selectedSnapshotID == null) { // if the user clicks cancel
      return;
    }
    if (selectedSnapshotID.equals(this.nextButton.getCurrentSnapshotID())) { // if the user selects the current snapshotID
      return;
    } else { // if the user selects a different snapshotID
      int index = this.snapshotIDList.indexOf(selectedSnapshotID); // get the index of the selected snapshotID
      int currentIndex = this.snapshotIDList.indexOf(this.nextButton.getCurrentSnapshotID()); // get the index of the current snapshotID from the nextButton
      if (index > currentIndex) { // if the selected snapshotID is after the current snapshotID
        for (int i = 0; i < index - currentIndex; i++) {
          this.nextButton.actionPerformed(null); // perform the next button action for the difference in indices
        }
      } else { // if the selected snapshotID is before the current snapshotID
        for (int i = 0; i < currentIndex - index; i++) {
          this.prevButton.actionPerformed(null); // perform the prev button action for the difference in indices
        }
      }
    }
  }

  /**
   * method to add an action listener to the quit button.
   */
  public void addQuitButtonListener() {
    // design the quit button
    quitButton.setBounds(900, 300, 50, 50);
    quitButton.setText("QUIT");
    quitButton.setFont(new Font("Arial", Font.PLAIN, 15));
    quitButton.setForeground(new Color(0x8B0000));
    quitButton.setBackground(new Color(0xF9F0F0));
    // add action listener to the quit button
    quitButton.addActionListener(this);
  }

  /**
   * Invoked when an action occurs.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == nextButton) { // if next button is clicked
      //
    }
     if (e.getSource() == selectButton) { // if select button is clicked
      selectButtonClicked();
    } else if (e.getSource() == quitButton) { // if quit button is clicked
      System.exit(0); // quit the program
    }
  }

  /**
   * printer for the snapshotIDList
   */
  public void printSnapshotIDList() {
    for (String snapshotID : this.snapshotIDList) {
      System.out.println(snapshotID);
    }
  }
}

