package Controller;

import java.io.File;
import java.util.HashMap;

/**
 * This class checks if the command line arguments are valid.
 */
public class ArgumentsChecker {

  /**
   * Given a string, check if it is a valid integer.
   *
   * @param s the string to be checked. String
   * @return true if the string is a valid integer, false otherwise
   */
  private static boolean isInteger(String s) {
    try {
      Integer.parseInt(s);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  /**
   * check if xMax and yMax are valid. If either is below 500 they are invalid.
   *
   * @param xMax the xMax to be checked. String
   * @param yMax the yMax to be checked. String
   * @return true if xMax and yMax are valid, false otherwise
   */
  private static boolean validXMaxYMax(String xMax, String yMax) {
    if (xMax == null || yMax == null) {
      return false;
    }
    int x = Integer.parseInt(xMax);
    int y = Integer.parseInt(yMax);
    return x > 0 && y > 0;
  }

  /**
   * checks if input file exists.
   *
   * @param inputFile the input file to be checked. String
   * @return true if the file exists, false otherwise
   */
  private static boolean inputFileExists(String inputFile) {
    if (inputFile == null) {
      return false;
    }
    File file = new File(inputFile);
    return file.exists();
  }

  /**
   * check if view provided is valid. only "graphical" and "web" are valid.
   *
   * @param view the view to be checked. String
   * @return true if the view is valid, false otherwise
   */
  private static boolean validViewType(String view) {
    if (view == null) {
      return false;
    }
    return view.equals("graphical") || view.equals("web");
  }

  /**
   * Given a view type and output file, check if the output file is valid.
   * For web view, the output file must end with ".html".
   *
   * @param view the view type. String
   * @param outputFile the output file to be checked. String
   * @return true if the output file is valid, false otherwise
   */
  private static boolean validOutputFile(String view, String outputFile) {
    if (view.equals("web")) {
      if (outputFile == null || outputFile.isBlank()) {
        return false;
      }
      return outputFile.endsWith(".html");
    }
    return true;
  }

  /**
   * Given string[] args first make a hashmap of the arguments. Then return the hashmap.
   *
   * @param args the arguments.
   * @return a hashmap of the arguments.
   */
   public static HashMap<String, String> makeHashMap(String[] args) {
     HashMap<String, String> arguments = new HashMap<>();

     // first fill values in hashmap even if they are invalid
     for (int i = 0; i < args.length; i++) {
       if (args[i].equals("-in")) { // if the argument is -in
         // put the next argument as the value of the key "inputFile"
         try {
           arguments.put("inputFile", args[i + 1]);
           break;
         } catch (ArrayIndexOutOfBoundsException e) {
           break;
         }
       }
     }
      for (int i = 0; i < args.length; i++) {
        if (args[i].equals("-view") || args[i].equals("-v")) { // if the argument is -view or -v
          // put the next argument as the value of the key "viewType"
          try {
            arguments.put("viewType", args[i + 1]);
            i += 1; // increment i by 1.
          } catch (ArrayIndexOutOfBoundsException e) {
            break;
          }
        }
      }
      for (int i = 0; i < args.length; i++) {
        if (args[i].equals("-out")) {
          try {
            arguments.put("outputFile", args[i + 1]);
            break;
          } catch (ArrayIndexOutOfBoundsException e) {
            break;
          }
        }
      }
      for (int i =0; i < args.length; i++) {
        if (isInteger(args[i])) { // if the argument is an integer
          try {
            if (isInteger(args[i + 1])) { // if the next argument is an integer
              arguments.put("yMax", args[i + 1]); // put the argument as the value of the key "yMax"
              arguments.put("xMax", args[i]); // put the next argument as the value of the key "xMax"
              i += 2; // increment i by 2.
              break;
            }
          } catch (ArrayIndexOutOfBoundsException e) {
            break;
          }
        }
      }
     // if xMax or yMax is not in the arguments, add them with default values
     arguments.putIfAbsent("xMax", "1000");
     arguments.putIfAbsent("yMax", "1000");
     return arguments;
   }

  /**
   * Checks if the arguments are valid.
   *
   * @param args the arguments to be checked.
   * @return a hashmap of the arguments after validation.
   * @throws IllegalArgumentException if the arguments are invalid.
   */
  public static HashMap<String, String> checkValidArguments(String[] args) throws IllegalArgumentException {
    if (args.length < 4 || args.length > 8) {
      throw new IllegalArgumentException("Too many or too few arguments.");
    }
    HashMap<String, String> arguments = makeHashMap(args);
    if (!inputFileExists(arguments.get("inputFile"))) {
      throw new IllegalArgumentException("Input file does not exist.");
    }
    if (!validViewType(arguments.get("viewType"))) {
      throw new IllegalArgumentException("Invalid view type.");
    }
    if (!validOutputFile(arguments.get("viewType"), arguments.get("outputFile"))) {
      throw new IllegalArgumentException("Invalid output file.");
    }
    if (!validXMaxYMax(arguments.get("xMax"), arguments.get("yMax"))) {
      throw new IllegalArgumentException("Invalid canvas size.");
    }
    return arguments;
  }

  public static void main(String[] args) {
  }
}
