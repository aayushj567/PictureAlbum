package WebView;

import Model.IShape;
import java.io.IOException;

public class shapeDrawerSVG {
  public static void drawShape(StringBuilder htmlText, IShape shape) throws IOException {
    String shapeType = shape.getShapeType();
    int shapePositionX = (int) shape.getPositionX();
    int shapePositionY = (int) shape.getPositionY();
    int shapeWidth = (int) shape.getDimension1();
    int shapeHeight = (int) shape.getDimension2();
    int redValue = shape.getColor().getColorValues()[0];
    int greenValue = shape.getColor().getColorValues()[1];
    int blueValue = shape.getColor().getColorValues()[2];

    if (shapeType.equals("rectangle")) { // if the shape is a rectangle, append the rectangle to the htmlText
      htmlText.append("<rect x=\"").append(shapePositionX).append("\" y=\"").append(shapePositionY).append("\" width=\"").append(shapeWidth).append("\" height=\"").append(shapeHeight).append("\" style=\"fill:rgb(").append(redValue).append(",").append(greenValue).append(",").append(blueValue).append(")\" />\n");
    } else if (shapeType.equals("oval")) { // if the shape is an oval, append the oval to the htmlText
      int xRadius = shapeWidth / 2;
      int yRadius = shapeHeight / 2;
      htmlText.append("<ellipse cx=\"").append(shapePositionX).append("\" cy=\"").append(shapePositionY).append("\" rx=\"").append(xRadius).append("\" ry=\"").append(yRadius).append("\" style=\"fill:rgb(").append(redValue).append(",").append(greenValue).append(",").append(blueValue).append(")\" />\n");
    } else { // if the shape is not a rectangle or an oval, do not draw it
      return;
    }
  }
}

