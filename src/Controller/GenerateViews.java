package Controller;

import Model.IShape;
import Model.shapeAlbum;
import SwingView.myFrame;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static Controller.ArgumentsChecker.checkValidArguments;

/**
 * This class generates views.
 */
public class GenerateViews {

  /**
   * Given an input file, create a shapeAlbum.
   *
   * @param inputFile the input file. String
   * @return the shapeAlbum created
   */
  public static shapeAlbum createAlbum(String inputFile) {
    shapeAlbum testAlbum = new shapeAlbum();
    FileParserForModel.parseFile(testAlbum, inputFile);
    return testAlbum;
  }

  /**
   * Given a shapeAlbum, generate a graphical view.
   *
   * @param testAlbum the shapeAlbum. shapeAlbum.
   */
  public static void produceSwingView(shapeAlbum testAlbum, int xMax, int yMax) {
    HashMap<String, List<IShape>> snapshotIDtoShapeListMap = talkToView.getSnapshotIDtoShapeListMap(testAlbum);
    List<String> snapshotIDList = talkToView.getSnapshotIDList(testAlbum);
    myFrame frame = new myFrame(snapshotIDtoShapeListMap, snapshotIDList, xMax, yMax);
    System.out.println(snapshotIDList);
  }

  /**
   * Given a shapeAlbum, generate a web view.
   *
   * @param testAlbum the shapeAlbum. shapeAlbum.
   * @throws IOException if the output file cannot be created
   */
  public static void produceWebView(shapeAlbum testAlbum, String outputFileName, int xMax, int yMax) throws IOException {
    HashMap<String, List<IShape>> snapshotIDtoShapeListMap = talkToView.getSnapshotIDtoShapeListMap(testAlbum);
    List<String> snapshotIDList = talkToView.getSnapshotIDList(testAlbum);
    WebView.HtmlGenerator.generateWebView(snapshotIDtoShapeListMap, snapshotIDList, outputFileName, xMax, yMax);
  }

  /**
   * given a string of command line arguments, generate the appropriate view.
   *
   * @param args String[]
   */
  public static void runMyProgram(String[] args) {
    try {
      HashMap<String, String> validArguments = checkValidArguments(args);
      String inputFile = validArguments.get("inputFile");
      String view = validArguments.get("viewType");
      String outputFile = validArguments.get("outputFile");
      int xMax = Integer.parseInt(validArguments.get("xMax"));
      int yMax = Integer.parseInt(validArguments.get("yMax"));
      shapeAlbum testAlbum = createAlbum(inputFile);
      if (view.equals("graphical")) {
        produceSwingView(testAlbum, xMax, yMax);
      } else if (view.equals("web")) {
        produceWebView(testAlbum, outputFile, xMax, yMax);
      }
    } catch (IllegalArgumentException | IOException e) {
      String message = e.getMessage();
      System.out.println(message);
    } catch (Exception e) {
      System.out.println("Something went wrong. Please try again.");
    }
  }

  public static void main(String[] args) throws IOException {
    String[] args1 = {"-view", "web", "-in", "buildings.txt", "-out", "buildingsOut.html"};
    runMyProgram(args1);
  }
  }
