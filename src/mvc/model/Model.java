/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 *
 * @author Wera
 */
public class Model {
    MyShape currentShape;

    public Model() {
    }

    public void setMyShape(MyShape myShape) {
        this.currentShape = myShape;
    }
    public void changeShape(Point2D[]pd){
        currentShape.setFrame(pd);
    }
    public void draw(Graphics2D g){
        currentShape.draw(g);
    }

    
}
