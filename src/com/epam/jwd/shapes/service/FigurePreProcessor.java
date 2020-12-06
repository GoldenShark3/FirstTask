package com.epam.jwd.shapes.service;

import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.model.simple.Point;

public interface FigurePreProcessor {
    void process(Point... points) throws FigureException;
}
