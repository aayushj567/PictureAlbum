import Controller.ArgumentsChecker;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * JUnit test for ArgumentsChecker class.
 */
public class testArgumentsChecker {
  private String[] testArgs1;
  private String[] testArgs2;
  private String[] testArgs3;
  private String[] testArgs4;

  /**
   * Set up test arguments.
   */
  @Before
  public void setUp() {
    testArgs1 = new String[] {"-view", "web", "-in", "buildings.txt", "-out", "buildings.html"};
    testArgs2 = new String[] {"-in", "hoops.txt", "-view", "graphical", "800", "800"};
    testArgs3 = new String[] {"-v", "web", "-in", "teris_wallpaper.txt", "-out", "random.html", "1000", "1000"};
    testArgs4 = new String[] {"800", "-view", "graphical", "-in", "buildings.txt", "-out", "randomFile"};
  }

  /**
   * Test if the above test arguments are valid.
   * If the arguments are valid, we would get a hash map with the correct key-value pairs.
   */
  @Test
  public void testValidArguments() {
    HashMap<String, String> testMap1 = new HashMap<>();
    testMap1.put("viewType", "web");
    testMap1.put("inputFile", "buildings.txt");
    testMap1.put("outputFile", "buildings.html");
    testMap1.put("xMax", "1000");
    testMap1.put("yMax", "1000");
    assertEquals(testMap1, ArgumentsChecker.checkValidArguments(testArgs1));

    HashMap<String, String> testMap2 = new HashMap<>();
    testMap2.put("viewType", "graphical");
    testMap2.put("inputFile", "hoops.txt");
    testMap2.put("xMax", "800");
    testMap2.put("yMax", "800");
    assertEquals(testMap2, ArgumentsChecker.checkValidArguments(testArgs2));

    HashMap<String, String> testMap3 = new HashMap<>();
    testMap3.put("viewType", "web");
    testMap3.put("inputFile", "teris_wallpaper.txt");
    testMap3.put("outputFile", "random.html");
    testMap3.put("xMax", "1000");
    testMap3.put("yMax", "1000");
    assertEquals(testMap3, ArgumentsChecker.checkValidArguments(testArgs3));

    HashMap<String, String> testMap4 = new HashMap<>();
    testMap4.put("viewType", "graphical");
    testMap4.put("inputFile", "buildings.txt");
    // output file name does not matter if the view type is graphical
    testMap4.put("outputFile", "randomFile");
    // if only 1 number is provided, we use default canvas size of 1000x1000
    testMap4.put("xMax", "1000");
    testMap4.put("yMax", "1000");
    assertEquals(testMap4, ArgumentsChecker.checkValidArguments(testArgs4));
  }

  /**
   * test when too few or too many arguments are provided.
   */
  @Test
  public void testNumberOfArgs() {
    // too few arguments
    String[] invalidArgs1 = new String[] {"-view", "-in", "buildings.txt"};
    try {
      ArgumentsChecker.checkValidArguments(invalidArgs1);
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage().contains("Too many or too few arguments."));
    }

    // too many arguments
    String[] invalidArgs2 = new String[] {"-view", "web", "-in", "buildings.txt", "-out", "buildings.html", "800", "800", "graphical"};
    try {
      ArgumentsChecker.checkValidArguments(invalidArgs2);
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage().contains("Too many or too few arguments."));
    }
  }


  /**
   * Test for invalid input and output file names in the arguments.
   * If the arguments are invalid, we would get an IllegalArgumentException.
   */
  @Test
  public void testInvalidFileNames() {
    // invalid output file name
    String[] invalidArgs1 = new String[] {"-view", "web", "-in", "buildings.txt", "-out", "buildings"};
    try {
      ArgumentsChecker.checkValidArguments(invalidArgs1);
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage().contains("Invalid output file."));
    }

    // invalid input file name
    String[] invalidArgs2 = new String[] {"-view", "web", "-in", "buildings", "-out", "buildings.html"};
    try {
      ArgumentsChecker.checkValidArguments(invalidArgs2);
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage().contains("Input file does not exist."));
    }

    // no output file name provided for web view
    String[] invalidArgs3 = new String[] {"-in", "buildings.txt", "-view", "web"};
    try {
      ArgumentsChecker.checkValidArguments(invalidArgs3);
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage().contains("Invalid output file."));
    }

    // if the output file name is not provided
    String[] invalidArgs5 = new String[] {"-view", "web", "-in", "buildings.txt", "-out"};
    try {
      ArgumentsChecker.checkValidArguments(invalidArgs5);
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage().contains("Invalid output file."));
    }

    // if the input file name is not provided
    String[] invalidArgs4 = new String[] {"-view", "web", "-out", "buildings.html"};
    try {
      ArgumentsChecker.checkValidArguments(invalidArgs4);
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage().contains("Input file does not exist."));
    }
  }

  /**
   * Test for invalid view type in the arguments.
   * If the arguments are invalid, we would get an IllegalArgumentException.
   */
  @Test
  public void testInvalidView() {
    String[] invalidArgs1 = new String[] {"-view", "webb", "-in", "buildings.txt", "-out", "buildings.html"};
    try {
      ArgumentsChecker.checkValidArguments(invalidArgs1);
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage().contains("Invalid view type."));
    }

    // if the view type is not provided
    String[] invalidArgs2 = new String[] {"-in", "buildings.txt", "-out", "buildings.html"};
    try {
      ArgumentsChecker.checkValidArguments(invalidArgs2);
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage().contains("Invalid view type."));
    }

    // if the view type is blank
    String[] invalidArgs3 = new String[] {"-view", "", "-in", "buildings.txt", "-out", "buildings.html"};
    try {
      ArgumentsChecker.checkValidArguments(invalidArgs3);
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage().contains("Invalid view type."));
    }
  }

  /**
   * Test for invalid xMax and yMax in the arguments.
   */
  @Test
  public void testCanvasSize() {
    String[] invalidArgs1 = new String[] {"-view", "graphical", "-in", "buildings.txt", "-out", "buildings.html", "0", "0"};
    try {
      ArgumentsChecker.checkValidArguments(invalidArgs1);
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage().contains("Invalid canvas size."));
    }

    String[] invalidArgs2 = new String[] {"-view", "graphical", "-in", "buildings.txt", "-out", "buildings.html", "800", "0"};
    try {
      ArgumentsChecker.checkValidArguments(invalidArgs2);
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage().contains("Invalid canvas size."));
    }
  }
}
