/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utillities;

import Controller.Controller;
import Model.Model;
import Model.shapes.Point3D;
import Model.shapes.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author James
 */
public abstract class Tools {
    
    public static Point3D convert3DPoint(Point3D p){
        
        return p;
    }
    
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
        double mX0 = Math.cos(angle);
        double mY0 = Math.sin(angle);
        double mX1 = -Math.sin(angle);
        double mY1 = Math.cos(angle);
        double mX2 = obj.x;
        double mY2 = obj.y;
        // create a new transformation (defaults to identity)
        AffineTransform obj2World = new AffineTransform(mX0, mY0, mX1, mY1, mX2, mY2);
        return obj2World;
    }   
    public static AffineTransform world2Obj(double angle, Point3D center){
        double mX0 = Math.cos(angle);
        double mY0 = -Math.sin(angle);
        double mX1 = Math.sin(angle);
        double mY1 = Math.cos(angle);
        double mX2 = (-Math.cos(angle) * center.x) - (Math.sin(angle) * center.y);
        double mY2 = (Math.sin(angle) * center.x) - (Math.cos(angle) * center.y);
        // create a new transformation (defaults to identity)
        return  new AffineTransform(mX0, mY0, mX1, mY1, mX2, mY2);
    }
    public static AffineTransform world2View(double scale, Point3D offset){
        double mX0 = scale;
        double mY0 = 0;
        double mX1 = 0;
        double mY1 = scale;
        double mX2 = -offset.x * scale;
        double mY2 = -offset.y * scale;
        // create a new transformation
        return  new AffineTransform(mX0, mY0, mX1, mY1, mX2, mY2);
    }
    public static AffineTransform view2World(double scale, Point3D offset){
        double mX0 = 1 / scale;
        double mY0 = 0;
        double mX1 = 0;
        double mY1 = 1 / scale;
        double mX2 = offset.x;
        double mY2 = offset.y;
        // create a new transformation
        return  new AffineTransform(mX0, mY0, mX1, mY1, mX2, mY2);
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
        //mouseCurrentLocation = world2Obj();
        double x = mouseCurrentLocation.x - mousePrevLocation.x;
        double y = mouseCurrentLocation.y - mousePrevLocation.y;      
        Point3D mouseDelta = new Point3D(x, y, 0);
        return mouseDelta;
        }
        return null;
    }  
    public static double findAngleDelta(Point3D mouseCurrentLocation){
        Point3D mouseDown = Controller.inst().getMouseDown();
        double angle = Math.atan2(mouseDown.x - mouseCurrentLocation.x, mouseDown.y - mouseCurrentLocation.y);
        return angle;
    }
    
    public static Matrix translate3D(Matrix m){
        //create matrix
        Matrix transM = new Matrix();
        ArrayList<Double> row = new ArrayList();
        double angle = Math.toRadians(Model.inst().getRotationOffset());
        double x = Model.inst().getxOffset();
        double y = Model.inst().getyOffset();
        double z = Model.inst().getzOffset();
        double Cosine = Math.cos(angle);
        double Sine = Math.sin(angle);
        row.add(Cosine);
        row.add(0.0);
        row.add(Sine);
        row.add((-Cosine * x) + (-Sine * z));
        transM.addRow(0, row);
        
        row = new ArrayList();
        row.add(0.0);
        row.add(1.0);
        row.add(0.0);
        row.add(-y);
        transM.addRow(1, row);
        
        row = new ArrayList();
        row.add(-Sine);
        row.add(0.0);
        row.add(Cosine);
        row.add((Sine * x) + (-Cosine * z));
        transM.addRow(2, row);
        
        row = new ArrayList();
        row.add(0.0);
        row.add(0.0);
        row.add(0.0);
        row.add(1.0);
        transM.addRow(3, row);
        
        transM.multiply(m.getMatrix());
        return transM;
    }
    
    public static Matrix clip(Matrix m){
        //create matrix
        double fov = 60;
        Matrix proM = new Matrix();
        ArrayList<Double> row = new ArrayList();
        double zoomX = 1 / (Math.tan(Math.toRadians(fov / 2)));
        row.add(zoomX);
        row.add(0.0);
        row.add(0.0);
        row.add(0.0);
        proM.addRow(0, row);
        
        row = new ArrayList();
        double zoomY = 1 / (Math.tan(Math.toRadians(fov / 2)));
        row.add(0.0);
        row.add(zoomY);
        row.add(0.0);
        row.add(0.0);
        proM.addRow(1, row);
        
        row = new ArrayList();
        double f = 10;
        double n = 5;
        double value1 = (f + n) / (f - n);
        double value2 = (-2 * n * f) / (f - n);       
        row.add(0.0);
        row.add(0.0);
        row.add(value1);
        row.add(value2);
        proM.addRow(2, row);
        
        row = new ArrayList();
        row.add(0.0);
        row.add(0.0);
        row.add(0.0);
        row.add(1.0);
        proM.addRow(3, row);
        
        proM.multiply(m.getMatrix());
        return proM;
    }
    
    public static Point3D normilize3D(Matrix clip){
        Matrix temp = new Matrix();
        int arraySize = clip.getMatrix().size();
        for(int i = 0; i < arraySize; i++){
        ArrayList<Double> row = new ArrayList();
        row.add(clip.getMatrix().get(i).get(0) / clip.getMatrix().get(arraySize - 1).get(0));
        temp.addRow(i, row);
        }
        
        return new Point3D(temp.getMatrix().get(0).get(0), temp.getMatrix().get(1).get(0), 1);
    }
    
    public static Point3D toScreenSpace(Point3D p){
        double width = 128;
        double height = 128;
        double x = width * ((.5 * p.x) + .5);
        double y = (.5 * height) - (.5 * p.y * height);
        double z = 1;
        System.out.println("X: " + x + "Y: " + y + "Z:" + z);
        return new Point3D(x, y, z);
    }
    
}
