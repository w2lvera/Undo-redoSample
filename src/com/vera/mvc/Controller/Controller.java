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
import com.vera.mvc.model.UndoMachine;
import com.vera.mvc.model.activity.Activity;
import com.vera.mvc.view.MyFrame;
import com.vera.mvc.view.MyPanel;
import java.awt.Color;

/**
 *
 * @author Wera
 */
public class Controller {
    Model model;
    UndoMachine undoMachine;
    MyFrame frame;
    MyPanel panel;
    Point2D [] pd;
    State state;
    MyShape shape;
    public Controller() {
        model = new Model();
        undoMachine = new UndoMachine();
        state = new State(model);
        state.setShape(new MyShape(new Rectangle2D.Double()));
        state.setColor(Color.yellow);
        panel = new MyPanel();
        panel.setController(this);
        model.addObserver(panel);
        frame = new MyFrame(state,undoMachine);
        frame.setPanel(panel);
        pd = new Point2D[2];
    }
    public void getPointOne(Point2D p){
        Activity activity = state.getActivity();
        activity.getPointOne(p);
        undoMachine.add(activity.clone());
        
    }
    public void getPointTwo(Point2D p){
        state.getActivity().getPointTwo(p);
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
}
