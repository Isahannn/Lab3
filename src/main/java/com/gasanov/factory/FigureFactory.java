package com.gasanov.factory;

import com.gasanov.entity.Circle;
import com.gasanov.entity.Figure;
import com.gasanov.entity.Triangle;
import com.gasanov.entity.Fraction;

public class FigureFactory {

    public static Figure createTriangle(Fraction sideA, Fraction sideB, Fraction sideC) {
        return new Triangle(sideA, sideB, sideC);
    }

    public static Figure createCircle(Fraction radius) {
        return new Circle(radius);
    }
}
