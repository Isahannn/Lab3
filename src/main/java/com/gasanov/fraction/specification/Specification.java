package com.gasanov.fraction.specification;

import com.gasanov.fraction.entity.Figure;

public interface Specification<T> {
    boolean isSatisfiedBy(Figure figure);
}

