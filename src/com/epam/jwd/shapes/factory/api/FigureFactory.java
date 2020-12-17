package com.epam.jwd.shapes.factory.api;

import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigure;
import com.epam.jwd.shapes.model.simple.impl.Point;

public interface FigureFactory {
    PolygonalFigure createFigure(String figureType, Point... points) throws FigureException;
}
