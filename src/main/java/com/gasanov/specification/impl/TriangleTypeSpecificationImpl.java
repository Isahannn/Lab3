package com.gasanov.specification.impl;

import com.gasanov.entity.Figure;
import com.gasanov.entity.Triangle;
import com.gasanov.specification.Specification;

public class TriangleTypeSpecificationImpl implements Specification {
    private final Triangle.TriangleType requiredType;

    public TriangleTypeSpecificationImpl(Triangle.TriangleType type) {
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

