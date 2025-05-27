package com.gasanov.factory;

import com.gasanov.fraction.entity.Circle;
import com.gasanov.fraction.entity.Figure;
import com.gasanov.fraction.entity.Fraction;
import com.gasanov.fraction.entity.Triangle;
import com.gasanov.fraction.factory.FigureFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigureFactoryTest {

    @Test
    void testCreateTriangleReturnsTriangleInstance() {
        Fraction sideA = new Fraction(3, 1);
        Fraction sideB = new Fraction(4, 1);
        Fraction sideC = new Fraction(5, 1);
        Figure figure = FigureFactory.createTriangle(sideA, sideB, sideC);

        assertAll(
                () -> assertNotNull(figure),
                () -> assertTrue(figure instanceof Triangle),
                () -> assertEquals(sideA, ((Triangle) figure).getSideA()),
                () -> assertEquals(sideB, ((Triangle) figure).getSideB()),
                () -> assertEquals(sideC, ((Triangle) figure).getSideC())
        );
    }

    @Test
    void testCreateTriangleInvalidSidesThrowsException() {
        Fraction sideA = new Fraction(1, 1);
        Fraction sideB = new Fraction(2, 1);
        Fraction sideC = new Fraction(10, 1);

        assertThrows(IllegalArgumentException.class, () ->
                FigureFactory.createTriangle(sideA, sideB, sideC));
    }

    @Test
    void testCreateCircleReturnsCircleInstance() {
        Fraction radius = new Fraction(7, 2);
        Figure figure = FigureFactory.createCircle(radius);

        assertAll(
                () -> assertNotNull(figure),
                () -> assertTrue(figure instanceof Circle),
                () -> assertEquals(radius, ((Circle) figure).getRadius())
        );
    }

    @Test
    void testCreateCircleWithZeroRadiusThrowsException() {
        Fraction radius = new Fraction(0, 1);
        assertThrows(IllegalArgumentException.class, () ->
                FigureFactory.createCircle(radius));
    }

    @Test
    void testCreateCircleWithNegativeRadiusThrowsException() {
        Fraction radius = new Fraction(-3, 1);
        assertThrows(IllegalArgumentException.class, () ->
                FigureFactory.createCircle(radius));
    }
}