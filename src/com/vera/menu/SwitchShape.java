/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.menu;


import com.vera.mvc.Controller.State;
import java.awt.geom.RectangularShape;

/**
 *
 * @author Wera
 */
public class SwitchShape implements Command{
    State state;
    RectangularShape rs;

    public SwitchShape(State state, RectangularShape rs) {
        this.state = state;
        this.rs = rs;
    }
    
    @Override
    public void execute() {
        state.setRectangularShape(rs);
    }
    
}
