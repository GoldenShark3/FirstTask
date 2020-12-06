package com.epam.jwd.shapes.decorator;

import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.factory.FigureFactory;
import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.simple.Point;

public abstract class FigureFactoryDecorator implements FigureFactory {
    FigureFactory figureFactory;

    public FigureFactoryDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    public abstract Figure createFigure(String figureType, Point... points) throws FigureException;
}
