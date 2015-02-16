/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utillities;

import Model.shapes.Point3D;
import Model.shapes.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

/**
 *
 * @author James
 */
public abstract class Tools {
    public static double dotProd(Point3D p1, Point3D p2){
        return (p1.x * p2.x) + (p1.y * p2.y);
    }
    
    public static Point3D subPoints(Point3D p1, Point3D p2){
        return new Point3D((p1.x - p2.x),(p1.y - p2.y), 0);
    }
    
    public static Point3D perpVec(Point3D p){
        return new Point3D(-p.y,p.x, 0);
    }
    
    public static double normalize(Point3D p1, Point3D p2){
    double X = p2.x - p1.x;
    X = X * X;
    double Y = p2.y - p1.y;
    Y = Y * Y;
    double normal = Math.sqrt(X + Y); 
    return normal;
    }
    
    public static Point3D unitVector(Point3D p1, Point3D p2){
    double X = p2.x - p1.x;
    double Y = p2.y - p1.y;
    double magnitude = normalize(p1, p2);
    Point3D p = new Point3D(X / magnitude, Y / magnitude, 0);
    return p;
    }
    
    public static Point3D rotate(Point3D p, double angle){
      return null;  
    }
    
    public static Point3D translate(Point3D p, Point3D transVec){
      return null;  
    }
    
    public static Point3D scale(Point3D p, double scaler){
      return null;  
    }
    public static AffineTransform obj2World(double angle, Point3D obj){
        // create a new transformation (defaults to identity)
        AffineTransform obj2World = new AffineTransform();
        // translate to its position in the world (last transformation)
        obj2World.translate(obj.x, obj.y);
        // rotate to its orientation (first transformation)
        obj2World.rotate(angle);
        return obj2World;
    }
    
    public static Point3D world2Obj(Point3D worldCoord, Point3D objCoord){

        return null;
    }
}
