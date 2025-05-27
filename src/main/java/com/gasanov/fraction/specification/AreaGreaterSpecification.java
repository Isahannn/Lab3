package com.gasanov.fraction.specification;

import com.gasanov.fraction.entity.Figure;

import java.math.BigDecimal;

public class AreaGreaterSpecification implements Specification {
    private final BigDecimal threshold;

    public AreaGreaterSpecification(BigDecimal threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean isSatisfiedBy(Figure figure) {
        if (figure == null || figure.area() == null) {
            return false;
        }
        return figure.area().compareTo(threshold) > 0;
    }
}
