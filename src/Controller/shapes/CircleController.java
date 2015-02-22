/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.shapes;

import Model.shapes.Circle;
import Model.shapes.Point3D;

/**
 *
 * @author James
 */
public class CircleController {
        public static Circle moveShape(Point3D transVec, Circle s){
            Point3D p = null;
            double x = s.getCenter().x + transVec.x;
            double y = s.getCenter().y + transVec.y;
             p = new Point3D(x, y, 0);
            //s.setCenter(p);
            return s;
    }
}
