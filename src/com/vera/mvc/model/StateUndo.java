/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.model;

/**
 *
 * @author Wera
 */
public enum StateUndo {

    EUndoERedo(true, true), DUndoDRedo(false, false), EUndoDRedo(true, false), DUndoERedo(false, true);
    public boolean undo;
    public boolean redo;

    StateUndo(boolean u, boolean r) {
        undo = u;
        redo = r;
    }
}

