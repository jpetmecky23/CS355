package Model.shapes;



import Model.shapes.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Brennan Smith
 */
public class HouseModel extends WireFrame
{
    List<Line3D> lines = new ArrayList<>();
    
    public HouseModel(Color color)
    {
        //Make the object:
         //Floor
        lines.add(new Line3D(new Point3D(-5,0,-5), new Point3D(5,0,-5), color));
        lines.add(new Line3D(new Point3D(5,0,-5), new Point3D(5,0,5), color));
        lines.add(new Line3D(new Point3D(5,0,5), new Point3D(-5,0,5), color));
        lines.add(new Line3D(new Point3D(-5,0,5), new Point3D(-5,0,-5), color));
         //Ceiling
        lines.add(new Line3D(new Point3D(-5,5,-5), new Point3D(5,5,-5), color));
        lines.add(new Line3D(new Point3D(5,5,-5), new Point3D(5,5,5), color));
        lines.add(new Line3D(new Point3D(5,5,5), new Point3D(-5,5,5), color));
        lines.add(new Line3D(new Point3D(-5,5,5), new Point3D(-5,5,-5), color));
         //Walls
        lines.add(new Line3D(new Point3D(-5,5,-5), new Point3D(-5,0,-5), color));
        lines.add(new Line3D(new Point3D(5,5,-5), new Point3D(5,0,-5), color));
        lines.add(new Line3D(new Point3D(5,5,5), new Point3D(5,0,5), color));
        lines.add(new Line3D(new Point3D(-5,5,5), new Point3D(-5,0,5), color));        
         //Roof
        lines.add(new Line3D(new Point3D(-5,5,-5), new Point3D(0,8,-5), color));
        lines.add(new Line3D(new Point3D(0,8,-5), new Point3D(5,5,-5), color));
        lines.add(new Line3D(new Point3D(-5,5,5), new Point3D(0,8,5), color));
        lines.add(new Line3D(new Point3D(0,8,5), new Point3D(5,5,5), color));
        lines.add(new Line3D(new Point3D(0,8,-5), new Point3D(0,8,5), color));
         //Door
        lines.add(new Line3D(new Point3D(1,0,5), new Point3D(1,3,5), color));
        lines.add(new Line3D(new Point3D(-1,0,5), new Point3D(-1,3,5), color));
        lines.add(new Line3D(new Point3D(1,3,5), new Point3D(-1,3,5), color));
    }
    
    
    public Iterator<Line3D> getLines()
    {
        return lines.iterator();
    }
}
