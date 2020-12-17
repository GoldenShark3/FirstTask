package com.epam.jwd.shapes.decorator.impl;

import com.epam.jwd.shapes.decorator.api.FigureFactoryDecorator;
import com.epam.jwd.shapes.decorator.api.FigurePostProcessor;
import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.factory.api.FigureFactory;
import com.epam.jwd.shapes.storage.impl.FigureCrudImpl;
import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigure;
import com.epam.jwd.shapes.model.simple.impl.Point;

public class PostProcessingDecorator extends FigureFactoryDecorator {
    private final FigurePostProcessor[] postProcessors = new FigurePostProcessor[]{FigureExistencePostProcessor.INSTANCE};
    private final static FigureCrudImpl FIGURE_CRUD = FigureCrudImpl.getInstance();

    public PostProcessingDecorator(FigureFactory figureFactory) {
        super(figureFactory);
    }

    @Override
    public PolygonalFigure createFigure(String figureType, Point... points) throws FigureException {
        PolygonalFigure polygonalFigure = figureFactory.createFigure(figureType, points);
        for (FigurePostProcessor postProcessor : postProcessors){
            postProcessor.process(polygonalFigure);
        }
        polygonalFigure = FIGURE_CRUD.fetchFigureFromStorage(polygonalFigure);
        return polygonalFigure;
    }
}
