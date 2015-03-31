/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.drawableShapes;

import Model.shapes.HouseModel;
import Model.shapes.Line3D;
import Model.shapes.Point3D;
import View.Factory;
import java.awt.Color;
import java.awt.Graphics2D;
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
            if(line.getStart().z > -1 && line.getEnd().z > -1){
                double screenWidth = 64;
                double screenHieght = 64;
                double scale = 10;
                Point3D start = new Point3D(scale * (line.getStart().x + (screenWidth / 2)), scale * ((screenHieght / 2) - line.getStart().y), 0);
                Point3D end = new Point3D(scale * (line.getEnd().x + (screenWidth / 2)), scale * ((screenHieght / 2) - line.getEnd().y), 0);
                line = new Line3D(start, end, Color.GREEN);
               System.out.println("Line: " + i);
               dLine = Factory.inst().processLine(line);
               dLine.drawShape(g2d);
            }
            i++;
        }
    }
}
