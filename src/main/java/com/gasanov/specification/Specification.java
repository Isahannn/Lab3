package com.gasanov.specification;

import com.gasanov.entity.Figure;

public interface Specification<T> {
    boolean isSatisfiedBy(Figure figure);
}

