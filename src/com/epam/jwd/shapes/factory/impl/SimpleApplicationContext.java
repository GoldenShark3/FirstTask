package com.epam.jwd.shapes.factory.impl;

import com.epam.jwd.shapes.decorator.impl.PostProcessingDecorator;
import com.epam.jwd.shapes.decorator.impl.PreProcessingDecorator;
import com.epam.jwd.shapes.factory.api.ApplicationContext;
import com.epam.jwd.shapes.factory.api.FigureFactory;
import com.epam.jwd.shapes.model.polygonal.impl.PolygonalFigureFactory;

public enum SimpleApplicationContext implements ApplicationContext {
    INSTANCE;

    @Override
    public FigureFactory createFigureFactory() {
        return new PostProcessingDecorator(new PreProcessingDecorator(PolygonalFigureFactory.getInstance()));
    }
}
