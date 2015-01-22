/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Shell.GUIFunctions;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import Model.Model;
import Model.shapes.*;
import java.util.ArrayList;


/**
 *
 * @author James
 */
public class Controller implements CS355Controller{
    private static Controller instance;
    private Point3D mousePressed;
    private Point3D mouseReleased;
    private Point3D mouseCurrentLocation;  
    
            
    public static Controller inst()
    {
        if (instance == null)
        {
        	instance = createController();
        }
        
        return instance;
    }
    
       
    public static Controller createController()
    {
        instance = new Controller();
        return instance;
    }

	static boolean isInitialized() 
    {
        return (instance != null);
    } 

    public Controller() {
        this.mousePressed = null;
        this.mouseReleased = null;
        this.mouseCurrentLocation = null;
    }
    
 
    public void colorButtonHit(Color c){
        GUIFunctions.changeSelectedColor(c);
        Model.inst().setColor(c);
    }
    
    public void triangleButtonHit(){
        Model.inst().setCurrentShape(new Triangle(null, null, null, null));
        Model.inst().resetTriPoints();
    }
    
    public void squareButtonHit(){
        Model.inst().setCurrentShape(new Square(null, null, null));
    }
    
    public void rectangleButtonHit(){
        Model.inst().setCurrentShape(new Rectangle(null, null, null));
    }
    
    public void circleButtonHit(){
        Model.inst().setCurrentShape(new Circle(null, null, null));
    }
    
    public void ellipseButtonHit(){
        Model.inst().setCurrentShape(new Ellipses(null, null, null));
    }

    public void lineButtonHit(){
        Model.inst().setCurrentShape(new Line3D(null, null, null));// Blank shape placeholder
        
    }

    public void selectButtonHit(){
    }

    public void zoomInButtonHit(){
    }

    public void zoomOutButtonHit(){
        
    }

    public void hScrollbarChanged(int value){
        
    }

    public void vScrollbarChanged(int value){
        
    }

    public void toggle3DModelDisplay(){
        
    }

    public void keyPressed(Iterator<Integer> iterator){
        
    }

    public void doEdgeDetection(){
        
    }

    public void doSharpen(){
        
    }

    public void doMedianBlur(){
        
    }

    public void doUniformBlur(){
        
    }

    public void doChangeContrast(int contrastAmountNum){
        
    }

    public void doChangeBrightness(int brightnessAmountNum){
        
    }

    public void doLoadImage(BufferedImage openImage){
        
    }

    public void toggleBackgroundDisplay(){
        
    }

    public Point3D getMouseDown() {
        return mousePressed;
    }

    public void setMouseDown(Point3D mouseDown) {
        this.mousePressed = mouseDown;
        this.mouseReleased = null;
        addShape();
    }

    public Point3D getMouseUp() {
        return mouseReleased;
    }

    public void setMouseUp(Point3D mouseUp) {
        this.mouseReleased = mouseUp;
    } 

    public Point3D getMouseCurrentLocation() {
        return mouseCurrentLocation;
    }

    public void setMouseCurrentLocation(Point3D mouseCurrentLocation) {
        this.mouseCurrentLocation = mouseCurrentLocation;
        
        if(mouseReleased != null){//only update the shape if the mouse button is pressed down still
                                   //MouseReleased is set to null in mousedown function.
            this.updateShape();
        }
    }       
    
    public void addShape(){
         
           if(Model.inst().getCurrentShape() instanceof Circle){
               Circle c = new Circle(this.mousePressed, this.mousePressed, Model.inst().getColor());
               Model.inst().addShape(c);
           }
           
           else if(Model.inst().getCurrentShape() instanceof Ellipses){
               Ellipses c = new Ellipses(this.mousePressed, this.mousePressed, Model.inst().getColor());
               Model.inst().addShape(c);
           }
           
           else if(Model.inst().getCurrentShape() instanceof Line3D){
              //ds = processLine((Line3D) s);
               Line3D l = new Line3D(this.mousePressed, this.mousePressed, Model.inst().getColor());
               Model.inst().addShape(l);
           } 
           
           else if(Model.inst().getCurrentShape() instanceof Rectangle){
               Rectangle s = new Rectangle(this.mousePressed, this.mousePressed, Model.inst().getColor());
               Model.inst().addShape(s);
           }
           
           else if(Model.inst().getCurrentShape() instanceof Square){
               Square s = new Square(this.mousePressed, this.mousePressed, Model.inst().getColor());
               Model.inst().addShape(s);
           }
           
           else if(Model.inst().getCurrentShape() instanceof Triangle){
               if(Model.inst().getTriPointSize() == 3){
                Triangle t = new Triangle(Model.inst().getTriPoint(0), Model.inst().getTriPoint(1), Model.inst().getTriPoint(2), Model.inst().getColor());
                Model.inst().addShape(t);
                Model.inst().resetTriPoints();
                GUIFunctions.refresh();
               }
           }  
           
    }
    
    public void updateShape(){
            if(Model.inst().getCurrentShape() instanceof Circle){
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Circle circle = new Circle(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(circle, index);
           }
           
           else if(Model.inst().getCurrentShape() instanceof Ellipses){
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Ellipses e = new Ellipses(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(e, index);
           }
           
           else if(Model.inst().getCurrentShape() instanceof Line3D){
              //ds = processLine((Line3D) s);
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Line3D l = new Line3D(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(l, index);
           } 
           
           else if(Model.inst().getCurrentShape() instanceof Rectangle){
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Rectangle r = new Rectangle(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(r, index);
           }
           
           else if(Model.inst().getCurrentShape() instanceof Square){
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Square s = new Square(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(s, index); 
           }
           
           else if(Model.inst().getCurrentShape() instanceof Triangle){
              //ds = processTri((Triangle) s);
           }  
            GUIFunctions.refresh();
    }
}
