package com.epam.jwd.shapes.model.polygonal;

import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.factory.api.FigureFactory;
import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.simple.Point;

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
    public Figure createFigure(String figureType, Point... points) throws FigureException {
        switch (figureType) {
            case "triangle":
                return new Triangle(points[0], points[1], points[2]);
            case "square":
                return new Square(points[0], points[1], points[2], points[3]);
            case "multiAngle":
                return new MultiAngleFigure(points);
            default:
                throw new FigureException(figureType + " - this type of shape does not exist");
        }
    }


}
