package com.epam.jwd.model;

import com.epam.jwd.strategy.MultiAngleFigureStrategy;

public abstract class Figure {
    private MultiAngleFigureStrategy<?> multiAngleFigureStrategy;

    public Figure(MultiAngleFigureStrategy<?> multiAngleFigureStrategy) {
        this.multiAngleFigureStrategy = multiAngleFigureStrategy;
    }

    public MultiAngleFigureStrategy<?> getPolygonalFigureStrategy() {
        return multiAngleFigureStrategy;
    }

}
