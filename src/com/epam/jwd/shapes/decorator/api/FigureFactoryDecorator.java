package com.epam.jwd.shapes.decorator.api;

import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.factory.api.FigureFactory;
import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.simple.Point;

public abstract class FigureFactoryDecorator implements FigureFactory {
    public final FigureFactory figureFactory;

    public FigureFactoryDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    public abstract Figure createFigure(String figureType, Point... points) throws FigureException;
}