/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.Controller;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import com.vera.mvc.model.Model;
import com.vera.mvc.model.MyShape;
import com.vera.mvc.view.MyFrame;
import com.vera.mvc.view.MyPanel;

/**
 *
 * @author Wera
 */
public class Controller {
    Model model;
    MyFrame frame;
    MyPanel panel;
    Point2D [] pd;
    MyShape shape;
    public Controller() {
        model = new Model();
        shape = new MyShape(new Rectangle2D.Double());
        shape.setFb(shape.new NoFill());
     //   MyShape.FillBehavior fb = shape.getFb();
        model.setMyShape(shape);
        panel = new MyPanel();
        panel.setController(this);
        model.addObserver(panel);
        frame = new MyFrame();
        frame.setPanel(panel);
        pd = new Point2D[2];
    }
    public void getPointOne(Point2D p){
        pd[0] = p;
    }
    public void getPointTwo(Point2D p){
        pd[1] = p;
        model.changeShape(pd);
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
}
