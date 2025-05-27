package com.gasanov.fraction.factory;

import com.gasanov.fraction.entity.Circle;
import com.gasanov.fraction.entity.Figure;
import com.gasanov.fraction.entity.Triangle;
import com.gasanov.fraction.entity.Fraction;

public class FigureFactory {

    public static Figure createTriangle(Fraction sideA, Fraction sideB, Fraction sideC) {
        return new Triangle(sideA, sideB, sideC);
    }

    public static Figure createCircle(Fraction radius) {
        return new Circle(radius);
    }
}
