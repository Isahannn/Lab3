package com.gasanov.specification;

import com.gasanov.entity.Fraction;
import com.gasanov.entity.Triangle;
import com.gasanov.entity.Triangle.TriangleType;
import com.gasanov.entity.Figure;
import com.gasanov.specification.impl.TriangleTypeSpecificationImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class TriangleTypeSpecificationTest {

    @Test
    void testIsSatisfiedBy() {
        TriangleTypeSpecificationImpl specIsosceles = new TriangleTypeSpecificationImpl(TriangleType.ISOSCELES);
        TriangleTypeSpecificationImpl specEquilateral = new TriangleTypeSpecificationImpl(TriangleType.EQUILATERAL);
        TriangleTypeSpecificationImpl specScalene = new TriangleTypeSpecificationImpl(TriangleType.SCALENE);
        TriangleTypeSpecificationImpl specRight = new TriangleTypeSpecificationImpl(TriangleType.RIGHT);



        Triangle equilateral = new Triangle(
                new Fraction(1, 1),
                new Fraction(1, 1),
                new Fraction(1, 1)
        );

        Triangle isosceles = new Triangle(
                new Fraction(2, 1),
                new Fraction(2, 1),
                new Fraction(3, 1)
        );

        Triangle right = new Triangle(
                new Fraction(3, 1),
                new Fraction(4, 1),
                new Fraction(5, 1)
        );

        assertAll("triangle types",
                () -> assertEquals(TriangleType.EQUILATERAL, equilateral.getType()),
                () -> assertEquals(TriangleType.ISOSCELES, isosceles.getType()),
                () -> assertEquals(TriangleType.RIGHT, right.getType())
        );

        assertAll("specification satisfaction",
                () -> assertTrue(specEquilateral.isSatisfiedBy(equilateral)),
                () -> assertFalse(specEquilateral.isSatisfiedBy(isosceles)),
                () -> assertFalse(specEquilateral.isSatisfiedBy(right)),

                () -> assertFalse(specIsosceles.isSatisfiedBy(equilateral)),
                () -> assertTrue(specIsosceles.isSatisfiedBy(isosceles)),
                () -> assertFalse(specIsosceles.isSatisfiedBy(right)),

                () -> assertFalse(specScalene.isSatisfiedBy(equilateral)),
                () -> assertFalse(specScalene.isSatisfiedBy(isosceles)),
                () -> assertFalse(specScalene.isSatisfiedBy(right)),

                () -> assertFalse(specRight.isSatisfiedBy(equilateral)),
                () -> assertFalse(specRight.isSatisfiedBy(isosceles)),
                () -> assertTrue(specRight.isSatisfiedBy(right))
        );

        Figure nonTriangle = new Figure() {
            @Override
            public BigDecimal area() { return null; }
            @Override
            public BigDecimal perimeter() { return null; }
            @Override
            public BigDecimal volume() { return null; }
        };

        assertAll("null and non-triangle",
                () -> assertFalse(specEquilateral.isSatisfiedBy(null)),
                () -> assertFalse(specEquilateral.isSatisfiedBy(nonTriangle))
        );
    }
}

