package com.epam.jwd.shapes.strategy.api;

import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigure;

public interface MultiAngleFigureStrategy{
    double calcArea(PolygonalFigure polygonalFigure);
    double calcPerimeter(PolygonalFigure polygonalFigure);
}
