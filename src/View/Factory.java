/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Model;
import Model.shapes.*;
import View.drawableShapes.*;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author James
 */
public class Factory {
    private static Factory instance;
	  
    public static Factory inst()
       {
           if (instance == null)
           {
               instance = createFactory();
           }

           return instance;
       }

       public static Factory createFactory()
       {
           instance = new Factory();
           return instance;
       }

           static boolean isInitialized() 
       {
           return (instance != null);
       } 

       public Factory() {

       }
       
       public ArrayList<DrawableShape> prepShapes(){
           ArrayList<DrawableShape> shapes = new ArrayList();
           
           int shapecount = Model.inst().getShapeCount();
           
           for(int i = 0; i < shapecount; i++){
                Shape s = Model.inst().getShape(i);;
                DrawableShape ds = processShape(s);
                shapes.add(ds);
           }
           return shapes;
       }
    
       public DrawableShape processShape(Shape s){
           DrawableShape ds = null;
           if(s instanceof Circle){
              ds = processCircle((Circle) s);
           }
           
           else if(s instanceof Ellipses){
              ds = processEllipses((Ellipses)s);
           }
           
           else if(s instanceof Line3D){
              ds = processLine((Line3D) s);
           } 
           
           else if(s instanceof Rectangle){
              ds = processRec((Rectangle) s);
           }
           
           else if(s instanceof Square){
              ds = processSquare((Square) s);
           }
           
           else if(s instanceof Triangle){
              ds = processTri((Triangle) s);
           }
           return ds;
       }
       
       public DrawableCircle processCircle(Circle s){
           double width =  s.getRadis() * 2;//Diameter is twice the radius
           double height = width;//Circles has the same height and width
           double x = (s.getCenter().x - s.getRadis());//Get upper left corner
           double y = (s.getCenter().y - s.getRadis());//Get upper left corner
           Color color = s.getColor();
           double angle = s.getAngle();
           boolean isSelected = s.isIsSelected();
           DrawableCircle  dc = new DrawableCircle(color, angle, isSelected, (int) x, (int) y,(int)  width, (int) height);
           return dc;
       }
       
       public DrawableCircle processEllipses(Ellipses s){
           double width = s.getWidth();
           double height = s.getHeight();
           double x = (s.getCenter().x - (width / 2));//Get upper left corner. See circle for why divide by 2
           double y = (s.getCenter().y - (height / 2));//Get upper left corner. See circle for why divide by 2
           Color color = s.getColor();
           double angle = s.getAngle();
           boolean isSelected = s.isIsSelected();
           DrawableCircle  dc = new DrawableCircle(color, angle, isSelected, (int) x, (int) y, (int) width, (int) height);
           return dc;
       }
       
       public DrawableLine processLine(Line3D s){
           int x1 = (int) s.getStart().x;
           int y1 = (int) s.getStart().y;
           int x2 = (int) s.getEnd().x;
           int y2 = (int) s.getEnd().y;
           Color color = s.getColor();
           double angle = s.getAngle();
           boolean isSelected = s.isIsSelected();
           DrawableLine  dl = new DrawableLine(color, angle, isSelected, x1, y1, x2, y2);
           return dl;
       }
       
       public DrawableQuad processRec(Rectangle s){
           double x = s.getUpperLeftCorner().x;
           double y = s.getUpperLeftCorner().y;
           double width = s.getWidth();
           double height = s.getHeight();
           Color color = s.getColor();
           double angle = s.getAngle();
           boolean isSelected = s.isIsSelected();
           DrawableQuad  dq= new DrawableQuad(color, angle, isSelected, (int) x, (int) y,(int) width, (int) height);
           return dq;
       }
       
       public DrawableQuad processSquare(Square s){

           double x = s.getUpperLeftCorner().x;
           double y = s.getUpperLeftCorner().y;
           double width = s.getSize();//Square same width and hight
           double height = s.getSize();
           Color color = s.getColor();
           double angle = s.getAngle();
           boolean isSelected = s.isIsSelected();
           DrawableQuad  dq= new DrawableQuad(color, angle, isSelected, (int) x, (int) y, (int) width, (int) height);
           return dq;
           
       }
       
       public DrawableTri processTri(Triangle s){//I included the conversion logic for the
                                                  //Triangle in the drawble object before I design the Factory
           Point3D p1 = s.getOne();
           Point3D p2 = s.getTwo();
           Point3D p3 = s.getThree();
           Color color = s.getColor();
           double angle = s.getAngle();
           boolean isSelected = s.isIsSelected();
           DrawableTri  dt= new DrawableTri(color, angle, isSelected, p1, p2, p3);
           return dt;
       }
}
