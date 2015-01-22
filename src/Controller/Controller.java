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


/**
 *
 * @author James
 */
public class Controller implements CS355Controller{
    private static Controller instance;
    private Shape currentShape;
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
        this.currentShape = new Line3D(null, null, null);
        this.mousePressed = null;
        this.mouseReleased = null;
        this.mouseCurrentLocation = null;
    }
    
 
    public void colorButtonHit(Color c){
        GUIFunctions.changeSelectedColor(c);
        Model.inst().setColor(c);
    }
    
    public void triangleButtonHit(){
        //Pass the selected shape to the model.
    }
    
    public void squareButtonHit(){
        this.currentShape = new Square(null, null, null);
    }
    
    public void rectangleButtonHit(){
        
    }
    
    public void circleButtonHit(){
        
    }
    
    public void ellipseButtonHit(){
        
    }

    public void lineButtonHit(){
        this.currentShape = new Line3D(null, null, null);// Blank shape placeholder
        
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
    

    public Shape getCurrentShape() {
        return currentShape;
    }

    public void setCurrentShape(Shape currentShape) {
            this.currentShape = currentShape;
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
         
           if(this.currentShape instanceof Circle){
              //ds = processCircle((Circle) s);
           }
           
           else if(this.currentShape instanceof Ellipses){
              //ds = processEllipses((Ellipses)s);
           }
           
           else if(this.currentShape instanceof Line3D){
              //ds = processLine((Line3D) s);
               Line3D l = new Line3D(this.mousePressed, this.mousePressed, Model.inst().getColor());
               Model.inst().addShape(l);
           } 
           
           else if(this.currentShape instanceof Rectangle){
              //ds = processRec((Rectangle) s);
           }
           
           else if(this.currentShape instanceof Square){
               Square s = new Square(this.mousePressed, this.mousePressed, Model.inst().getColor());
               Model.inst().addShape(s);
           }
           
           else if(this.currentShape instanceof Triangle){
              //ds = processTri((Triangle) s);
           }   
    }
    
    public void updateShape(){
            if(this.currentShape instanceof Circle){
              //ds = processCircle((Circle) s);
           }
           
           else if(this.currentShape instanceof Ellipses){
              //ds = processEllipses((Ellipses)s);
           }
           
           else if(this.currentShape instanceof Line3D){
              //ds = processLine((Line3D) s);
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Line3D l = new Line3D(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(l, index);
              GUIFunctions.refresh();
              
           } 
           
           else if(this.currentShape instanceof Rectangle){
              //ds = processRec((Rectangle) s);
           }
           
           else if(this.currentShape instanceof Square){
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Square s = new Square(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(s, index);
              GUIFunctions.refresh();
           }
           
           else if(this.currentShape instanceof Triangle){
              //ds = processTri((Triangle) s);
           }        
    }
}
