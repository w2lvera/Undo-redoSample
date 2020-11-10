/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

/**
 *
 * @author Wera
 */
public class MyShape {
    Color color;
    RectangularShape shape;
    FillBehavior fb;

    public MyShape(RectangularShape shape) {
        this.shape = shape;
        color = Color.BLUE;
        fb = new NoFill();
       
    }

    public MyShape() {
        color = Color.BLUE;
        shape = new Rectangle2D.Double();
        fb = new Fill();
        
    }

    public MyShape(Color color, RectangularShape shape, FillBehavior fb) {
        this.color = color;
        this.shape = shape;
        this.fb = fb;
        
    }

    public void setFb(FillBehavior fb) {
        this.fb = fb;
        
    }

    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }
    
    public void setFrame(Point2D[]pd){
        shape.setFrameFromDiagonal(pd[0], pd[1]);
    }

    void draw(Graphics2D g) {
        fb.draw(g);
       
    }

    public MyShape.FillBehavior getFb() {
        return fb;
    }
    
    //////////////////////////////////////////////////////////
   public interface FillBehavior {
        void draw(Graphics2D g);
    }
   public class Fill implements FillBehavior {

    public Fill() {
        
    }
  
    @Override
    public void draw(Graphics2D g) {
        Paint paint = g.getPaint();
        g.setPaint(color);
        g.fill(shape);
        g.setPaint(paint);
    }

}
public class NoFill implements FillBehavior {

    public NoFill() {
    }

    @Override
    public void draw(Graphics2D g) {
        Paint paint = g.getPaint();
        g.setPaint(color);
        g.draw(shape);
        g.setPaint(paint);
    }

   
}

   
    
}


