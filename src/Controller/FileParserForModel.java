package Controller;

import Model.shapeAlbum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for FileParser.
 */
public class FileParserForModel {

  /**
   * read a .txt file and return each line as a String in a List.
   *
   * @param fileName String. The name of the file to read.
   * @return List<String>. The list of lines in the file.
   */
  private static List<String> readFile(String fileName) {
    List<String> lines = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = br.readLine()) != null) {
        lines.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return lines;
  }

  /**
   * given a String command, perform the action.
   *
   * @param line String.
   */
  public static void performAction(shapeAlbum currentAlbum, String line) {
    String[] lineArray = line.split("\\s+");

    if (line.startsWith("shape")) { //  if the line starts with "shape" add the shape to the album.
      String shapeName = lineArray[1];
      String shapeType = lineArray[2];
      double positionX = Double.parseDouble(lineArray[3]);
      double positionY = Double.parseDouble(lineArray[4]);
      double width = Double.parseDouble(lineArray[5]);
      double height = Double.parseDouble(lineArray[6]);
      int red = Integer.parseInt(lineArray[7]);
      int green = Integer.parseInt(lineArray[8]);
      int blue = Integer.parseInt(lineArray[9]);
      updateAlbum.addShape(currentAlbum, shapeType, shapeName, positionX, positionY, width, height,
              red, green, blue);
    }
    if (line.startsWith("move")) { // if the line starts with "move" update the shape's position.
      String shapeName = lineArray[1];
      double newPositionX = Double.parseDouble(lineArray[2]);
      double newPositionY = Double.parseDouble(lineArray[3]);
      updateAlbum.updateShapePosition(currentAlbum, shapeName, newPositionX, newPositionY);

    }
    if (line.startsWith("resize")) { // if the line starts with "resize" update the shape's size.
      String shapeName = lineArray[1];
      double newWidth = Double.parseDouble(lineArray[2]);
      double newHeight = Double.parseDouble(lineArray[3]);
      updateAlbum.updateShapeDimensions(currentAlbum, shapeName, newWidth, newHeight);
    }

    if (line.startsWith("color")) { // if the line starts with "color" update the shape's color.
      String shapeName = lineArray[1];
      int newRed = Integer.parseInt(lineArray[2]);
      int newGreen = Integer.parseInt(lineArray[3]);
      int newBlue = Integer.parseInt(lineArray[4]);
      updateAlbum.updateShapeColor(currentAlbum, shapeName, newRed, newGreen, newBlue);
    }

    if (line.startsWith("snapshot")) { // if the line starts with "snapshot" take a snapshot.
      // create a snapshot
      updateAlbum.takeSnapshot(currentAlbum);
    }
    if (line.startsWith("remove")) { // if the line starts with "remove" remove the shape.
      // remove a shape
      String shapeName = lineArray[1];
      updateAlbum.removeShape(currentAlbum, shapeName);
    }
  }

  /**
   * given a file, parse each line of the file and perform the action.
   *
   * @param currentAlbum shapeAlbum. The album to perform the action on.
   * @param fileName String. The name of the file to read.
   */
  public static void parseFile(shapeAlbum currentAlbum, String fileName) {
    List<String> lines = readFile(fileName);
    String firstLine = lines.get(0);
    if (firstLine.startsWith("canvas")) {
      lines.remove(0);
    }
    for (String line : lines) {
      performAction(currentAlbum, line);
    }
  }
}
