package com.gasanov.fraction.observer;

import com.gasanov.fraction.entity.Figure;
import com.gasanov.fraction.warehouse.Warehouse;

public class FigureObserver implements Observer {

    @Override
    public void update(Observable o) {
        if (o instanceof Figure) {
            Figure figure = (Figure) o;
            Warehouse.getInstance().updateMetrics(figure);
        }
    }
}
