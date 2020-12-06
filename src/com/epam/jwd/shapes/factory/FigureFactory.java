package com.epam.jwd.shapes.factory;

import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.simple.Point;

public interface FigureFactory {
    Figure createFigure(String figureType, Point... points) throws FigureException;
}
