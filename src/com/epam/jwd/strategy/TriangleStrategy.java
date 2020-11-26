package com.epam.jwd.strategy;

import com.epam.jwd.model.polygonal.Triangle;

public class TriangleStrategy implements MultiAngleFigureStrategy<Triangle> {

    @Override
    public double calcArea(Triangle figure) {
        double firstSideLength = distanceBetweenTwoPoints(figure.getFirstPoint(), figure.getSecondPoint());
        double secondSideLength = distanceBetweenTwoPoints(figure.getFirstPoint(), figure.getThirdPoint());
        double thirdSideLength = distanceBetweenTwoPoints(figure.getSecondPoint(), figure.getThirdPoint());
        double halfPerimeter = (firstSideLength + secondSideLength + thirdSideLength) / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - firstSideLength)
                * (halfPerimeter - secondSideLength)
                * (halfPerimeter - thirdSideLength));
    }

    @Override
    public double calcPerimeter(Triangle figure) {
        double firstSideLength = distanceBetweenTwoPoints(figure.getFirstPoint(), figure.getSecondPoint());
        double secondSideLength = distanceBetweenTwoPoints(figure.getFirstPoint(), figure.getThirdPoint());
        double thirdSideLength = distanceBetweenTwoPoints(figure.getSecondPoint(), figure.getThirdPoint());

        return firstSideLength + secondSideLength + thirdSideLength;
    }
}
