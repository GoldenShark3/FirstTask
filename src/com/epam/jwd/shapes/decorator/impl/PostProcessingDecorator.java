package com.epam.jwd.shapes.decorator.impl;

import com.epam.jwd.shapes.decorator.api.FigureFactoryDecorator;
import com.epam.jwd.shapes.decorator.api.FigurePostProcessor;
import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.factory.api.FigureFactory;
import com.epam.jwd.shapes.factory.impl.SimpleFactoryStorage;
import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.simple.Point;

public class PostProcessingDecorator extends FigureFactoryDecorator {
    private final FigurePostProcessor[] postProcessors = new FigurePostProcessor[]{FigureExistencePostProcessor.INSTANCE};
    private final static SimpleFactoryStorage SIMPLE_FACTORY_STORAGE = SimpleFactoryStorage.getInstance();

    public PostProcessingDecorator(FigureFactory figureFactory) {
        super(figureFactory);
    }

    @Override
    public Figure createFigure(String figureType, Point... points) throws FigureException {
        Figure figure = figureFactory.createFigure(figureType, points);

        figure = SIMPLE_FACTORY_STORAGE.fetchOrAddFigure(figure);

        for (FigurePostProcessor postProcessor : postProcessors){
            postProcessor.process(figure);
        }
        return figure;
    }
}
