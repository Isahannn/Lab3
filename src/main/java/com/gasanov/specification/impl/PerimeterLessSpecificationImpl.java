package com.gasanov.specification.impl;

import com.gasanov.entity.Figure;
import com.gasanov.specification.Specification;

import java.math.BigDecimal;

public class PerimeterLessSpecificationImpl implements Specification {
    private final BigDecimal threshold;

    public PerimeterLessSpecificationImpl(BigDecimal threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean isSatisfiedBy(Figure figure) {
        if (figure == null || figure.perimeter() == null) {
            return false;
        }
        return figure.perimeter().compareTo(threshold) < 0;
    }

    public PerimeterLessSpecificationImpl(double threshold) {
        this.threshold = BigDecimal.valueOf(threshold);
    }
}
