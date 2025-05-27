package com.gasanov.observer;

import com.gasanov.entity.Figure;
import com.gasanov.warehouse.Warehouse;

public class FigureObserver implements Observer {

    @Override
    public void update(Observable o) {
        if (o instanceof Figure) {
            Figure figure = (Figure) o;
            Warehouse.getInstance().updateMetrics(figure);
        }
    }
}
