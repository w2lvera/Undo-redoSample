/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vera.mvc.model;

import com.vera.mvc.model.activity.Activity;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Wera
 */
public class UndoMachine extends Observable {

    private class StateDUndoDRedo extends Undouble {

        @Override
        public void undo() {
        }

        @Override
        public void redo() {
        }

        @Override
        void goToEUndoERedo() {
        }

        @Override
        void deleteHistory() {
        }
    }

    private class StateDUndoERedo extends Undouble {

        @Override
        public void undo() {
        }
    }

    private class StateEUndoDRedo extends Undouble {

        @Override
        public void redo() {
        }

        @Override
        void deleteHistory() {
        }
    }

    private class StateEUndoERedo extends Undouble {

        @Override
        void goToEUndoERedo() {
        }
    }

    private class Undouble {

        void undo() {
            activityList.get(undoIterator).unexecute();
            undoIterator--;
            if (undoIterator == -1) {
                state = stateDUndoERedo;
                stateUndo = StateUndo.DUndoERedo;
                notifyMenu();
            } else {
                goToEUndoERedo();
            }
        }

        void redo() {
            undoIterator++;
            activityList.get(undoIterator).execute();
            if (undoIterator == activityList.size() - 1) {
                state = stateEUndoDRedo;
                stateUndo = StateUndo.EUndoDRedo;
                notifyMenu();
            } else {
                goToEUndoERedo();
            }
        }

        final void add(Activity action) {
            deleteHistory();
            activityList.add(action);
            undoIterator++;
            stateUndo = StateUndo.EUndoDRedo;
            state = stateEUndoDRedo;
            notifyMenu();
        }

        void goToEUndoERedo() {
            state = stateEUndoERedo;
            stateUndo = StateUndo.EUndoERedo;
            notifyMenu();
        }

        void deleteHistory() {
            if (!activityList.isEmpty()) {
                for (int i = undoIterator; i < activityList.size(); i++) {
                    activityList.remove(i);
                }
            }
        }
    }
    ArrayList<Activity> activityList;
    StateUndo stateUndo;
    Undouble stateDUndoDRedo;
    Undouble stateEUndoERedo;
    Undouble stateDUndoERedo;
    Undouble stateEUndoDRedo;
    Undouble state;
    int undoIterator;

    public UndoMachine() {

        activityList = new ArrayList<Activity>();
        this.stateUndo = StateUndo.DUndoDRedo;
        stateDUndoDRedo = new StateDUndoDRedo();
        stateEUndoERedo = new StateEUndoERedo();
        stateDUndoERedo = new StateDUndoERedo();
        stateEUndoDRedo = new StateEUndoDRedo();
        state = stateDUndoDRedo;
        undoIterator = -1;
    }

    public void add(Activity action) {
        state.add(action);
    }

    public void execute() {
        state.redo();
    }

    public void unexecute() {
        state.undo();
    }

    public int getUndoIterator() {
        return undoIterator;
    }

    void notifyMenu() {
        setChanged();
        notifyObservers(stateUndo);
    }
}
