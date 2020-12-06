package com.epam.jwd.shapes.decorator.impl;

import com.epam.jwd.shapes.exception.FigureNotExistException;
import com.epam.jwd.shapes.model.simple.Point;
import com.epam.jwd.shapes.service.FigurePreProcessor;

import java.util.Arrays;

public class FigureExistencePreProcessor implements FigurePreProcessor {
    public static final FigureExistencePreProcessor INSTANCE = new FigureExistencePreProcessor();

    private FigureExistencePreProcessor() {

    }

    @Override
    public void process(Point... points) throws FigureNotExistException {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++)
            if (points[i].equals(points[j])){
                throw new FigureNotExistException("Figure: " + Arrays.toString(points) + " - must have different points");
            }
        }
    }
}
