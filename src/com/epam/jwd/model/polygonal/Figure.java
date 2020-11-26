package com.epam.jwd.model.polygonal;

import com.epam.jwd.strategy.MultiAngleFigureStrategy;

public abstract class Figure {
    private MultiAngleFigureStrategy<? extends Figure> multiAngleFigureStrategy;

    public Figure(MultiAngleFigureStrategy<? extends Figure> multiAngleFigureStrategy) {
        this.multiAngleFigureStrategy = multiAngleFigureStrategy;
    }

    public MultiAngleFigureStrategy<? extends Figure> getPolygonalFigureStrategy() {
        return multiAngleFigureStrategy;
    }

}
