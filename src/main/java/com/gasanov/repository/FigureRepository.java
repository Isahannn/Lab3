package com.gasanov.repository;

import com.gasanov.entity.Figure;
import com.gasanov.observer.FigureObserver;
import com.gasanov.warehouse.Warehouse;
import com.gasanov.specification.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.gasanov.util.FigureComparators.*;

public class FigureRepository {
    private final List<Figure> figures = new ArrayList<>();

    public void addFigure(Figure figure) {
        figure.addObserver(new FigureObserver());
        figures.add(figure);
        figure.notifyObservers();
    }

    public void removeFigure(Figure figure) {
        figures.remove(figure);
        Warehouse.getInstance().removeMetrics(figure.getId());
    }

    public List<Figure> query(Specification<Figure> spec) {
        return figures.stream()
                .filter(spec::isSatisfiedBy)
                .collect(Collectors.toList());
    }

    public void sortByArea() {
        figures.sort(BY_AREA);
    }

    public void sortByPerimeter() {
        figures.sort(BY_PERIMETER);
    }

    public void sortByVolume() {
        figures.sort(BY_VOLUME);
    }

    public void sortById() {
        figures.sort(BY_ID);
    }

    public List<Figure> getFigures() {
        return new ArrayList<>(figures);
    }
}
