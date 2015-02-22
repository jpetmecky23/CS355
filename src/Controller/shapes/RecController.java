/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.shapes;

import Model.shapes.Point3D;
import Model.shapes.Rectangle;

/**
 *
 * @author James
 */
public class RecController {
        public static Rectangle move(Rectangle r, Point3D transVec) {
        if(r.getUpperLeftCorner() != null){
        double x = r.getUpperLeftCorner().x + transVec.x;
        double y = r.getUpperLeftCorner().y + transVec.y;
        Point3D p = new Point3D(x, y, 0);
        r.setUpperLeftCorner(p);
        }
        return r;
    }
    public static Rectangle resize(Rectangle r, int width, int hieght){
        return r;
    }       
}
