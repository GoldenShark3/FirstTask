package com.epam.jwd.shapes.model.polygonal.api;

import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.strategy.api.MultiAngleFigureStrategy;

public abstract class PolygonalFigure extends Figure {
    private final MultiAngleFigureStrategy multiAngleFigureStrategy;
    private final int ID;
    private static int prevId = 0;
    private final PolygonalFigureType FIGURE_TYPE;

    public PolygonalFigure(MultiAngleFigureStrategy multiAngleFigureStrategy, PolygonalFigureType figureType) {
        this.multiAngleFigureStrategy = multiAngleFigureStrategy;
        this.FIGURE_TYPE = figureType;
        ID = prevId++;
    }

    public int getID() {
        return ID;
    }

    public PolygonalFigureType getFigureType() {
        return FIGURE_TYPE;
    }

    public MultiAngleFigureStrategy getPolygonalFigureStrategy() {
        return multiAngleFigureStrategy;
    }



}
