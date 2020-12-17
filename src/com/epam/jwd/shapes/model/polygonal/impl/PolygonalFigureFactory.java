package com.epam.jwd.shapes.model.polygonal.impl;

import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.factory.api.FigureFactory;
import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigure;
import com.epam.jwd.shapes.model.simple.impl.Point;

public class PolygonalFigureFactory implements FigureFactory {
    private static PolygonalFigureFactory instance;

    private PolygonalFigureFactory() {
    }

    public static PolygonalFigureFactory getInstance(){
        if (instance == null) {
            return instance = new PolygonalFigureFactory();
        }
        return instance;
    }

    @Override
    public PolygonalFigure createFigure(String figureType, Point... points) throws FigureException {
        figureType = figureType.toLowerCase().trim();
        switch (figureType) {
            case "triangle":
                return new Triangle(points);
            case "square":
                return new Square(points);
            case "multiangle":
                return new MultiAngleFigure(points);
            default:
                throw new FigureException(figureType + " - this type of shape does not exist");
        }
    }


}
