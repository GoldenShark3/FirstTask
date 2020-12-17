package com.epam.jwd.shapes.decorator.impl;

import com.epam.jwd.shapes.decorator.api.FigureFactoryDecorator;
import com.epam.jwd.shapes.decorator.api.FigurePreProcessor;
import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.factory.api.FigureFactory;
import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigure;
import com.epam.jwd.shapes.model.simple.impl.Point;

public class PreProcessingDecorator extends FigureFactoryDecorator {

    private final FigurePreProcessor[] preProcessors = new FigurePreProcessor[]{SamePointPreProcessor.INSTANCE};

    public PreProcessingDecorator(FigureFactory figureFactory) {
        super(figureFactory);
    }

    @Override
    public PolygonalFigure createFigure(String figureType, Point... points) throws FigureException {
        for (FigurePreProcessor preProcessor : preProcessors){
            preProcessor.process(points);
        }
        return figureFactory.createFigure(figureType, points);
    }
}
