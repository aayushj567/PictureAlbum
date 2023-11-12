import Controller.talkToView;
import Model.shapeAlbum;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Controller.GenerateViews.createAlbum;
import static org.junit.Assert.assertEquals;

/**
 * JUnit test for HTMLGenerator which generates html text for web view of shapesAlbum.
 */
public class testHTMLGenerator {
  private StringBuilder htmlTextBuildings;

  @Before
  public void setup() throws IOException {
    String inputFileName = "buildings.txt";
    String outputFileName = "buildingsTest.html";
    int xMax = 1000;
    int yMax = 1000;

    shapeAlbum testAlbum = createAlbum(inputFileName);
    htmlTextBuildings = WebView.HtmlGenerator.generateWebView(talkToView.getSnapshotIDtoShapeListMap(testAlbum),
        talkToView.getSnapshotIDList(testAlbum), outputFileName, xMax, yMax);
  }

  /**
   * method to read the generated html file.
   */
  private static String readHTMLFile(String fileName) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    StringBuilder htmlText = new StringBuilder();
    String line = reader.readLine();
    while (line != null) {
      htmlText.append(line);
      line = reader.readLine();
    }
    return htmlText.toString();
  }

  /**
   * given a String remove any instances of <p>SnapshotID: </p> from it.
   *
   * @param input the input String
   */
  public static String removeSnapshotID(String input) {
    Pattern pattern = Pattern.compile("<p>SnapshotID:.*?</p>");
    Matcher matcher = pattern.matcher(input);
    return matcher.replaceAll("");
  }

  /**
   * Compare the generated html text with the expected html text stored in htmlTextBuildings.
   */
  @Test
  public void testHTMLGenerator() throws IOException {
    String expectedHTMLText = readHTMLFile("myWeb.html");
    expectedHTMLText = expectedHTMLText.replaceAll("\\s+", "");
    expectedHTMLText = removeSnapshotID(expectedHTMLText);

    String actualHTMLText = htmlTextBuildings.toString();
    actualHTMLText = actualHTMLText.replaceAll("\\s+", "");
    actualHTMLText = removeSnapshotID(actualHTMLText);
    assertEquals(expectedHTMLText, actualHTMLText);
  }
}
