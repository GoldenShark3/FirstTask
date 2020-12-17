package com.epam.jwd.shapes.decorator.api;

import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigure;

public interface FigurePostProcessor {
    PolygonalFigure process(PolygonalFigure polygonalFigure) throws FigureException;
}
