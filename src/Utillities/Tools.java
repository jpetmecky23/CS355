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
    public static double normalize(Point3D p1, Point3D p2){//This finds the norm
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
    public static AffineTransform obj2World(double angle, Point3D obj){
        // create a new transformation (defaults to identity)
        AffineTransform obj2World = new AffineTransform();
        // translate to its position in the world (last transformation)
        obj2World.translate(obj.x, obj.y);
        // rotate to its orientation (first transformation)
        obj2World.rotate(angle);
        return obj2World;
    }   
    public static Point3D world2Obj(Point3D worldCoord, Shape s){
        // create a new transformation (defaults to identity)
        AffineTransform world2Obj = new AffineTransform();
        // rotate back from its orientation (last transformation)
        world2Obj.rotate(- s.getAngle());
        // translate back from its position in the world (first transformation)
        world2Obj.translate(-s.getCenter().x, -s.getCenter().y);
        // and transform point from world to object
        return transform2Point(world2Obj, worldCoord);
    }   
    public static Point3D transform2Point(AffineTransform aff, Point3D p){
        Point2D w = new Point2D.Double(p.x, p.y);
        Point2D o = new Point2D.Double(0, 0);
        Point2D temp = aff.transform(w, o);
        Point3D q = new Point3D(temp.getX(), temp.getY(), 0);
        return q;
    }  
    public static Point3D findUpperLeftCornerSqu(Point3D cornerStart, Point3D cornerEnd, double size){
        if((cornerStart.y > cornerEnd.y) && (cornerStart.x > cornerEnd.x)){
            Point3D p = new Point3D(cornerStart.x - size, cornerStart.y - size, 0);
            return p;
        }
        
        else if((cornerStart.y < cornerEnd.y) && (cornerStart.x < cornerEnd.x)){
            return cornerStart;
        }
        
        else if((cornerStart.y > cornerEnd.y) && (cornerStart.x < cornerEnd.x)){
            Point3D p = new Point3D(cornerStart.x, cornerStart.y - size, 0);
            return p;
        }
        
        else {//if((cornerStart.y < cornerEnd.y) && (cornerStart.x > cornerEnd.x)){
            Point3D p = new Point3D(cornerStart.x - size, cornerStart.y, 0);
            return p;
        }  
    }     
    public static Point3D findUpperLeftCornerRec(Point3D cornerStart, Point3D cornerEnd){
    if((cornerStart.y > cornerEnd.y) && (cornerStart.x > cornerEnd.x)){
        return cornerEnd;
    }

    else if((cornerStart.y < cornerEnd.y) && (cornerStart.x < cornerEnd.x)){
        return cornerStart;
    }

    else if((cornerStart.y > cornerEnd.y) && (cornerStart.x < cornerEnd.x)){
        Point3D p = new Point3D(cornerStart.x, cornerEnd.y, 0);
         return p;
    }

    else {//if((cornerStart.y < cornerEnd.y) && (cornerStart.x > cornerEnd.x)){
        Point3D p = new Point3D(cornerEnd.x, cornerStart.y, 0);
        return p;
    }
    }
    public static Point3D findDelta(Point3D mousePrevLocation, Point3D mouseCurrentLocation){
        if(mouseCurrentLocation != null && mousePrevLocation != null){
        double x = mouseCurrentLocation.x - mousePrevLocation.x;
        double y = mouseCurrentLocation.y - mousePrevLocation.y;      
        Point3D mouseDelta = new Point3D(x, y, 0);
        return mouseDelta;
        }
        return null;
    }
}
