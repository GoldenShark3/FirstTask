package com.epam.jwd.shapes.strategy.impl;

import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.polygonal.Triangle;
import com.epam.jwd.shapes.service.simple.impl.PointService;
import com.epam.jwd.shapes.strategy.MultiAngleFigureStrategy;

public class TriangleStrategy implements MultiAngleFigureStrategy {
    private static final TriangleStrategy INSTANCE = new TriangleStrategy();
    private static final PointService POINT_SERVICE = PointService.getInstance();

    private TriangleStrategy() {
    }

    public static TriangleStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public double calcArea(Figure figure) {
        Triangle triangle = (Triangle) figure;
        double firstSideLength = POINT_SERVICE.calcLengthBetweenTwoPoints(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSideLength = POINT_SERVICE.calcLengthBetweenTwoPoints(triangle.getFirstPoint(), triangle.getThirdPoint());
        double thirdSideLength = POINT_SERVICE.calcLengthBetweenTwoPoints(triangle.getSecondPoint(), triangle.getThirdPoint());
        double halfPerimeter = (firstSideLength + secondSideLength + thirdSideLength) / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - firstSideLength)
                * (halfPerimeter - secondSideLength)
                * (halfPerimeter - thirdSideLength));
    }

    @Override
    public double calcPerimeter(Figure figure) {
        Triangle triangle = (Triangle) figure;
        double firstSideLength = POINT_SERVICE.calcLengthBetweenTwoPoints(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSideLength = POINT_SERVICE.calcLengthBetweenTwoPoints(triangle.getFirstPoint(), triangle.getThirdPoint());
        double thirdSideLength = POINT_SERVICE.calcLengthBetweenTwoPoints(triangle.getSecondPoint(), triangle.getThirdPoint());

        return firstSideLength + secondSideLength + thirdSideLength;
    }


}
