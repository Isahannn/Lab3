package com.gasanov.specification;

import com.gasanov.entity.Figure;
import com.gasanov.entity.Triangle;

public class TriangleTypeSpecification implements Specification {
    private final Triangle.TriangleType requiredType;

    public TriangleTypeSpecification(Triangle.TriangleType type) {
        this.requiredType = type;
    }

    @Override
    public boolean isSatisfiedBy(Figure figure) {
        if (figure instanceof Triangle) {
            Triangle triangle = (Triangle) figure;
            return triangle.getType() == requiredType;
        }
        return false;
    }
}

