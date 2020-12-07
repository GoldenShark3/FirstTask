package com.epam.jwd.shapes.decorator.api;

import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.model.simple.Point;

public interface FigurePreProcessor {
    void process(Point... points) throws FigureException;
}
