package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.polygonal.Figure;

public interface MultiAngleFigureStrategy<T extends Figure> {

    double calcArea(T figure);
    double calcPerimeter(T figure);

    default double distanceBetweenTwoPoints(Point firstPoint, Point secondPoint) {
        double deltaX = secondPoint.getX() - firstPoint.getX();
        double deltaY = secondPoint.getY() - firstPoint.getY();

        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
}
