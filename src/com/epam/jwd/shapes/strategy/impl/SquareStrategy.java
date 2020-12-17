package com.epam.jwd.shapes.strategy.impl;

import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigure;
import com.epam.jwd.shapes.model.polygonal.impl.Square;
import com.epam.jwd.shapes.service.simple.impl.PointService;
import com.epam.jwd.shapes.strategy.api.MultiAngleFigureStrategy;

public class SquareStrategy implements MultiAngleFigureStrategy {
    private final static PointService POINT_SERVICE = PointService.getInstance();
    private static SquareStrategy instance;

    private SquareStrategy() {
    }

    public static SquareStrategy getInstance() {
        if (instance == null) {
            return instance = new SquareStrategy();
        }
        return instance;
    }

    @Override
    public double calcArea(PolygonalFigure polygonalFigure) {
        Square square = (Square) polygonalFigure;
        double sideLength = POINT_SERVICE.calcLengthBetweenTwoPoints(square.getFirstPoint(), square.getSecondPoint());

        return Math.pow(sideLength, 2);
    }

    @Override
    public double calcPerimeter(PolygonalFigure polygonalFigure) {
        Square square = (Square) polygonalFigure;
        double sideLength = POINT_SERVICE.calcLengthBetweenTwoPoints(square.getFirstPoint(), square.getSecondPoint());

        return sideLength * 4;
    }
}
