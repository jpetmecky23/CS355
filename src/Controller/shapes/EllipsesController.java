/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.shapes;

import Model.shapes.Ellipses;
import Model.shapes.Point3D;

/**
 *
 * @author James
 */
public class EllipsesController {
    
    public Ellipses move(Ellipses e, Point3D transVec) {
        if(e.getUpperLeftCorner() != null){
        double x = e.getUpperLeftCorner().x + transVec.x;
        double y = e.getUpperLeftCorner().y + transVec.y;
        Point3D p = new Point3D(x, y, 0);
        e.setUpperLeftCorner(p);
        }
        return e;
    }
    
    public Ellipses resize(Ellipses e, double width, double hieght){
        return e;
    }
}
