/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.drawableShapes;

import Model.shapes.HouseModel;
import Model.shapes.Line3D;
import Model.shapes.Point3D;
import Utillities.Matrix;
import Utillities.Tools;
import View.Factory;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author James
 */
public class DrawableHouse {
    private HouseModel house;
    
    public DrawableHouse(HouseModel house) {
        this.house = house;
    }
    
    
    
    public void draw(Graphics2D g2d){
        //Used to draw the house at the center of the screen

        Line3D line = null;//new Line3D(start, end, Color.GREEN); //it.next();
        DrawableLine dLine = null;//Factory.inst().processLine(line);
       //  dLine.drawShape(g2d);
         int i = 0;
         Iterator<Line3D> it = house.getLines();
        while(it.hasNext()){
            line = it.next();
                Point3D start = new Point3D(line.getStart().x, line.getStart().y, line.getStart().z);
                Point3D end = new Point3D(line.getEnd().x , line.getEnd().y,line.getEnd().z);
                start = this.convertPoint(start);
                end = this.convertPoint(end);
              // System.out.println("Line: " + i);
                if(start != null && end != null){
                    line = new Line3D(start, end, line.getColor());
                    dLine = Factory.inst().processLine(line);
                    dLine.drawShape(g2d);
                }
            i++;
        }
    }
    
    private boolean testPoint(double xValue, double yValue, double w){
        boolean xTest = equalityTest(xValue, w);
        boolean yTest = equalityTest(yValue, w);
        if(xTest && yTest){
            return true;
        }
        return false;
    }
    
    private boolean equalityTest(double x, double w){
        if(-w <= x && x <= w){
            return true;
        }
        return false;
    }
    
    private Point3D convertPoint(Point3D p){
        Matrix m = prepMatrix(p);
        //Trans/Rotate
        m = Tools.translate3D(m);
        m = Tools.clip(m);
        Point3D point = Tools.normilize3D(m);
        double w = m.getMatrix().get(3).get(0);
        double xValue = m.getMatrix().get(0).get(0);
        double yValue = m.getMatrix().get(1).get(0);
        boolean pass = testPoint(xValue, yValue, w);
        //if(pass){
            return Tools.toScreenSpace(point);
        //}
       // return null;
    }
    
    private Matrix prepMatrix(Point3D p){
        Matrix m = new Matrix();
        ArrayList<Double> row = new ArrayList();
        row.add(p.x);
        m.addRow(0, row);
        
        row = new ArrayList();
        row.add(p.y);
        m.addRow(1, row);
        
        row = new ArrayList();
        row.add(p.z);
        m.addRow(2, row);
        
        row = new ArrayList();
        row.add(1.0);
        m.addRow(3, row);
        
        return m;
    }
}
