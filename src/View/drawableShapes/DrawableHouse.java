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
        double screenWidth = 512;
        double screenHieght = 512;
        Point3D start = new Point3D(250, 250, 0);
        Point3D end = new Point3D(500, 500, 0);
        Line3D line = new Line3D(start, end, Color.GREEN); //it.next();
        DrawableLine dLine = Factory.inst().processLine(line);
         dLine.drawShape(g2d);
        //for(Iterator<Line3D> it = house.getLines(); it.hasNext();){

            if(line.getStart().z > -1 && line.getEnd().z > -1){
                
            }
        //}
    }
}
