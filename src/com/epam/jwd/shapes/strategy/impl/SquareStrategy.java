package com.epam.jwd.shapes.strategy.impl;

import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.polygonal.Square;
import com.epam.jwd.shapes.service.simple.impl.PointService;
import com.epam.jwd.shapes.strategy.MultiAngleFigureStrategy;

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
    public double calcArea(Figure figure) {
        Square square = (Square) figure;
        double sideLength = POINT_SERVICE.calcLengthBetweenTwoPoints(square.getFirstPoint(), square.getSecondPoint());

        return Math.pow(sideLength, 2);
    }

    @Override
    public double calcPerimeter(Figure figure) {
        Square square = (Square) figure;
        double sideLength = POINT_SERVICE.calcLengthBetweenTwoPoints(square.getFirstPoint(), square.getSecondPoint());

        return sideLength * 4;
    }
}
