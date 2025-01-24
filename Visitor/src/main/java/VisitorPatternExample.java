import com.i2i.designpattern.visitor.AreaCalculator;
import com.i2i.designpattern.visitor.Circle;
import com.i2i.designpattern.visitor.Rectangle;


public class VisitorPatternExample
{
    public static void main( String[] args )
    {
        AreaCalculator areaCalculator = new AreaCalculator();

        Rectangle rectangle = new Rectangle(2,3);
        areaCalculator.visit(rectangle);

        Circle circle = new Circle(2);
        areaCalculator.visit(circle);
    }
}
