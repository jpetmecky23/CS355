package Model.shapes;



import Model.shapes.Line3D;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Brennan Smith
 */
public class WireFrame 
{
    public Iterator<Line3D> getLines()
    {
        return new ArrayList<Line3D>().iterator();
    }
}
