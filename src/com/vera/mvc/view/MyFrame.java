/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.view;

import com.vera.menu.SwitchActivity;
import com.vera.menu.SwitchColor;
import com.vera.menu.SwitchFill;
import com.vera.menu.SwitchShape;
import com.vera.menu.SwitchState;
import com.vera.mvc.Controller.State;
import com.vera.mvc.model.Activity;
import com.vera.mvc.model.Activity.ActivityBehavior;
import com.vera.mvc.model.MyShape;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Wera
 */
public class MyFrame extends JFrame {

    MyPanel panel;
    State state;

    public MyFrame(State state) {
        this.state = state;
        JMenuBar bar;
        bar = new JMenuBar();
        this.setJMenuBar(bar);
        ArrayList<Action> menuItems = new ArrayList<>();
        menuItems.add(new SwitchState("прямоугольник", null,
                new SwitchShape(state, new Rectangle2D.Double())));
        menuItems.add(new SwitchState("овал", null,
                new SwitchShape(state, new Ellipse2D.Double())));
        menuItems.add(new SwitchState("незалитый", null,
                new SwitchFill(state, MyShape.FillBehavior.NO_FILL)));
        menuItems.add(new SwitchState("залитый", null,
                new SwitchFill(state, MyShape.FillBehavior.FILL)));
        menuItems.add(new SwitchState("рисовать", null,
                new SwitchActivity(state, Activity.ActivityBehavior.DRAW)));
        menuItems.add(new SwitchState("двигать", null,
                new SwitchActivity(state, Activity.ActivityBehavior.MOVE)));
        menuItems.add(new SwitchState("выбор цвета", null,
                new SwitchColor(state)));

        ArrayList<JMenu> menus = new ArrayList<>();
        menus.add(new JMenu("фигура"));
        menus.add(new JMenu("заливка"));
        menus.add(new JMenu("действие"));
        menus.add(new JMenu("цвет"));
        int i = 0;
        int k = menuItems.size()-2;
        for (JMenu m : menus) {
            bar.add(m);
            
            if (i < k) {
                m.add(menuItems.get(i));
                m.add(menuItems.get(i + 1));
                i += 2;
            } else {
                m.add(menuItems.get(i));
            }
        }

//        
        /////////////////////////////////////////////////////////////////
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public void setPanel(MyPanel panel) {
        this.panel = panel;
        add(panel);
    }

}
