package com.epam.jwd.shapes.decorator;

import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.factory.FigureFactory;
import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.simple.Point;

public class Factory extends FigureFactoryDecorator {
    private final static ApplicationContext APPLICATION_CONTEXT = new ApplicationContext();

    public Factory(FigureFactory figureFactory) {
        super(figureFactory);
    }

    @Override
    public Figure createFigure(String figureType, Point... points) throws FigureException {
        APPLICATION_CONTEXT.preProcessing(points);
        Figure figure = figureFactory.createFigure(figureType, points);
        return APPLICATION_CONTEXT.postProcessing(figure);
    }
}
