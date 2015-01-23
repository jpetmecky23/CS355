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
    private Point3D mousePressed;
    private Point3D mouseReleased;
    private Point3D mouseCurrentLocation;  
    private Color shapeColor;
    private Shape currentShape;
            
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
        this.shapeColor = Color.BLACK; 
    }
    
 
    public void colorButtonHit(Color c){
        GUIFunctions.changeSelectedColor(c);
        Controller.inst().setColor(c);
    }
    
    public void triangleButtonHit(){
        Controller.inst().setCurrentShape(new Triangle(null, null));
    }
    
    public void squareButtonHit(){
        Controller.inst().setCurrentShape(new Square(null, null, null));
    }
    
    public void rectangleButtonHit(){
        Controller.inst().setCurrentShape(new Rectangle(null, null, null));
    }
    
    public void circleButtonHit(){
        Controller.inst().setCurrentShape(new Circle(null, null, null));
    }
    
    public void ellipseButtonHit(){
        Controller.inst().setCurrentShape(new Ellipses(null, null, null));
    }

    public void lineButtonHit(){
        Controller.inst().setCurrentShape(new Line3D(null, null, null));// Blank shape placeholder
        
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

    public Color getColor() {
        return shapeColor;
    }

    public void setColor(Color color) {
        this.shapeColor = color;
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
        if(mouseReleased != null){//only update the shape if the mouse button is pressed down still                       //MouseReleased is set to null in mousedown function.
            this.updateShape();
        }
    }       
    
    public void addShape(){
         
           if(Controller.inst().getCurrentShape() instanceof Circle){
               Circle c = new Circle(this.mousePressed, this.mousePressed, this.shapeColor);
               Model.inst().addShape(c);
           }
           
           else if(Controller.inst().getCurrentShape() instanceof Ellipses){
               Ellipses c = new Ellipses(this.mousePressed, this.mousePressed, this.shapeColor);
               Model.inst().addShape(c);
           }
           
           else if(Controller.inst().getCurrentShape() instanceof Line3D){
              //ds = processLine((Line3D) s);
               Line3D l = new Line3D(this.mousePressed, this.mousePressed, this.shapeColor);
               Model.inst().addShape(l);
           } 
           
           else if(Controller.inst().getCurrentShape() instanceof Rectangle){
               Rectangle s = new Rectangle(this.mousePressed, this.mousePressed, this.shapeColor);
               Model.inst().addShape(s);
           }
           
           else if(Controller.inst().getCurrentShape() instanceof Square){
               Square s = new Square(this.mousePressed, this.mousePressed, this.shapeColor);
               Model.inst().addShape(s);
           }
           
           else if(Controller.inst().getCurrentShape() instanceof Triangle){
               int index = Model.inst().getShapeCount() - 1;//last shape in array
               boolean updateShape = false;
               boolean isTriangle =  false;
                       
               if(index >= 0){
                isTriangle = (Model.inst().getShape(index)instanceof Triangle);//Check to see if the last shape in the arrat is a triangle
                if(isTriangle){
                    updateShape = ((Triangle)Model.inst().getShape(index)).isThreeNull(); //If it is a triangle is the third point null                   
                }
               }
               
               if(isTriangle && updateShape){//If the shape is a triangle and if the this point is null the update the shape with  mousePressed
                this.updateShape();
               }

               else{
                Triangle t = new Triangle(this.mousePressed, this.shapeColor);
                Model.inst().addShape(t);
               }
           }  
           
    }
    
    public void updateShape(){
            if(Controller.inst().getCurrentShape() instanceof Circle){
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Circle circle = new Circle(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(circle, index);
           }
           
           else if(Controller.inst().getCurrentShape() instanceof Ellipses){
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Ellipses e = new Ellipses(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(e, index);
           }
           
           else if(Controller.inst().getCurrentShape() instanceof Line3D){
              //ds = processLine((Line3D) s);
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Line3D l = new Line3D(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(l, index);
           } 
           
           else if(Controller.inst().getCurrentShape() instanceof Rectangle){
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Rectangle r = new Rectangle(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(r, index);
           }
           
           else if(Controller.inst().getCurrentShape() instanceof Square){
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Color c = Model.inst().getShape(index).getColor();
              Square s = new Square(this.mousePressed, this.mouseCurrentLocation, c);
              Model.inst().setShape(s, index); 
           }
           
           else if(Controller.inst().getCurrentShape() instanceof Triangle){
              int index = Model.inst().getShapeCount() - 1;//last shape in array
              Triangle tri = (Triangle)Model.inst().getShape(index);
              if(tri.isTwoNull()){
                  tri.setTwo(this.mousePressed);
               }
               else if(tri.isThreeNull()){
                   tri.setThree(this.mousePressed);
               }
              Model.inst().setShape(tri, index);
           }  
            //GUIFunctions.refresh();
    }
}
