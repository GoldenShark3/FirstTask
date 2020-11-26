package com.epam.jwd.strategy;

import com.epam.jwd.model.polygonal.Square;

public class SquareStrategy implements MultiAngleFigureStrategy<Square> {

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
    public double calcArea(Square figure) {
        return Math.pow(distanceBetweenTwoPoints(figure.getFirstPoint(), figure.getSecondPoint()), 2);
    }

    @Override
    public double calcPerimeter(Square figure) {
        return distanceBetweenTwoPoints(figure.getFirstPoint(), figure.getSecondPoint()) * 4;
    }
}
