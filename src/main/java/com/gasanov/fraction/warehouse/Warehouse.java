package com.gasanov.fraction.warehouse;

import com.gasanov.fraction.entity.Figure;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Warehouse {
    private static Warehouse instance;

    private final Map<Integer, FigureMetrics> storage = new ConcurrentHashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void updateMetrics(Figure figure) {
        storage.put(figure.getId(),
                new FigureMetrics(figure.area(), figure.perimeter(), figure.volume()));
    }

    public FigureMetrics getMetrics(int figureId) {
        return storage.get(figureId);
    }

    public void removeMetrics(int figureId) {
        storage.remove(figureId);
    }

    public static class FigureMetrics {
        private final BigDecimal area;
        private final BigDecimal perimeter;
        private final BigDecimal volume;

        public FigureMetrics(BigDecimal area, BigDecimal perimeter, BigDecimal volume) {
            this.area = area;
            this.perimeter = perimeter;
            this.volume = volume;
        }

        public BigDecimal getArea() {
            return area;
        }

        public BigDecimal getPerimeter() {
            return perimeter;
        }

        public BigDecimal getVolume() {
            return volume;
        }

        @Override
        public String toString() {
            return String.format("Area=%s, Perimeter=%s, Volume=%s",
                    area.toPlainString(), perimeter.toPlainString(), volume.toPlainString());
        }
    }
}
