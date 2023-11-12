package WebView;

import Model.IShape;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Class for HtmlGenerator. This class is used to generate the HTML file that will be used to display
 * the shapes in the shapeAlbum.
 */
public class HtmlGenerator {

  /**
   * function to generate an HTML file that will write contents of a StringBuilder to it.
   * Assume that output file name is valid.
   *
   * @param htmlText StringBuilder. The StringBuilder that contains the contents of the HTML file.
   */
  public static void createHTMLFile(StringBuilder htmlText, String outputFileName) {
    File testOutput = new File(outputFileName);
    boolean append = false;
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(testOutput, append));
      writer.write(htmlText.toString());
      writer.close();
    } catch (IOException e) {
      throw new IllegalArgumentException("Cannot create output file.");
    }
  }

  /**
   * function to generate the HTML code to display the shapes in the shapeAlbum.
   *
   * @param SnapshotIDToShapeListMap HashMap<String, IShape>. The HashMap that maps each snapshotID
   *                                 in the shapeAlbum to the list of shapes in that snapshot.
   * @return
   * @throws IOException if the file cannot be created.
   */
  public static StringBuilder generateWebView(HashMap<String, List<IShape>> SnapshotIDToShapeListMap, List<String> snapshotIDList,
                                              String outputFileName, int xMax, int yMax) throws IOException {
    StringBuilder htmlText = new StringBuilder();
    htmlText.append("<!DOCTYPE html>\n");
    htmlText.append("<html>\n");
    htmlText.append("<head>\n");
    htmlText.append("<style>\n");
    htmlText.append(".myDiv {\n");
    htmlText.append(" background-color: lightgrey;\n");
    htmlText.append(" text-align: center;\n");
    int divWidth = xMax + 100;
    int divHeight = yMax + 100;
    htmlText.append(" width: ").append(divWidth).append("px;\n");
    htmlText.append(" height: ").append(divHeight).append("px;\n");
    htmlText.append("}\n");
    htmlText.append(".myParagraph {\n");
    htmlText.append("font-family: \"Arial\", sans-serif;\n");
    htmlText.append(" font-size: 15px;\n");
    htmlText.append(" font-weight: bold;\n");
    htmlText.append(" color: #063970;\n");
    htmlText.append("}\n");
    htmlText.append("<title>CS5004 Shapes Album Viewer</title>\n");
    htmlText.append("</style>\n");
    htmlText.append("</head>\n");
    htmlText.append("<body>\n");
    htmlText.append("<header>\n");
    htmlText.append("<h1>CS5004 Shapes Album Viewer</h1>\n");
    htmlText.append("</header>\n");
    for (String snapshotId : snapshotIDList) {
      // make a div for each snapshot ID.
      htmlText.append("<div class=\"myDiv\">\n");
      List<IShape> currentShapeList = SnapshotIDToShapeListMap.get(snapshotId);
      // write the HTML code to display Snapshot ID.
      htmlText.append("<p>" + "Snapshot ID: ").append(snapshotId).append("</p>\n");
      // display shapes related to the snapshot ID in an xMax by yMax canvas.
      htmlText.append("<svg width = ").append(xMax).append(" height = ").append(yMax).append(">\n");
      for (IShape shape : currentShapeList) {
        shapeDrawerSVG.drawShape(htmlText, shape);
      }
      htmlText.append("</svg>\n");
      htmlText.append("</div>\n");
    }
    htmlText.append("</body>\n");
    htmlText.append("</html>\n");
    createHTMLFile(htmlText, outputFileName);
    return htmlText;
  }

  public static void main(String[] args) {
  }
}


