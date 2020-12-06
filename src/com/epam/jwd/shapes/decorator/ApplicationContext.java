package com.epam.jwd.shapes.decorator;

import com.epam.jwd.shapes.decorator.impl.FigureExistencePostProcessor;
import com.epam.jwd.shapes.decorator.impl.FigureExistencePreProcessor;
import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.exception.FigureNotExistException;
import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.simple.Point;

class ApplicationContext {
    private final static FigureExistencePreProcessor FIGURE_PRE_PROCESSING = FigureExistencePreProcessor.INSTANCE;
    private final static FigureExistencePostProcessor FIGURE_POST_PROCESSING = FigureExistencePostProcessor.INSTANCE;

    void preProcessing(Point... points) throws FigureException {
        FIGURE_PRE_PROCESSING.process(points);
    }

    Figure postProcessing(Figure figure) throws FigureNotExistException {
        return FIGURE_POST_PROCESSING.process(figure);
    }

}
