package com.epam.jwd.shapes.model;

import com.epam.jwd.shapes.strategy.MultiAngleFigureStrategy;

public abstract class Figure {
    private final MultiAngleFigureStrategy multiAngleFigureStrategy;

    public Figure(MultiAngleFigureStrategy multiAngleFigureStrategy) {
        this.multiAngleFigureStrategy = multiAngleFigureStrategy;
    }

    public MultiAngleFigureStrategy getPolygonalFigureStrategy() {
        return multiAngleFigureStrategy;
    }

}
