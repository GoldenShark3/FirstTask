package com.epam.jwd.model.polygonal;

import com.epam.jwd.model.simple.Point;
import com.epam.jwd.model.Figure;
import com.epam.jwd.strategy.MultiAngleStrategy;
import com.epam.jwd.strategy.TriangleStrategy;

import java.util.Arrays;
import java.util.LinkedList;

public class MultiAngleFigureFactory {
    private static final LinkedList<Figure> ALL_CREATED_POLYGONAL_FIGURE = new LinkedList<>();

    public Triangle createTriangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        for (Figure figure : ALL_CREATED_POLYGONAL_FIGURE) {
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                if (isTrianglesEquals(triangle, firstPoint, secondPoint, thirdPoint)) {
                    return triangle;
                }
            }
        }
        Triangle triangle = new Triangle(firstPoint, secondPoint, thirdPoint, TriangleStrategy.getInstance());
        ALL_CREATED_POLYGONAL_FIGURE.add(triangle);
        return triangle;
    }

    public MultiAngleFigure createMultiAngleFigure(Point[] points) {
        for (Figure figure : ALL_CREATED_POLYGONAL_FIGURE) {
            if (figure instanceof MultiAngleFigure) {
                MultiAngleFigure multiAngleFigure = (MultiAngleFigure) figure;
                if (Arrays.equals(multiAngleFigure.getPoints(), points)) {
                    return multiAngleFigure;
                }
            }
        }
        MultiAngleFigure multiAngleFigure = new MultiAngleFigure(points, MultiAngleStrategy.INSTANCE);
        ALL_CREATED_POLYGONAL_FIGURE.add(multiAngleFigure);
        return multiAngleFigure;
    }

    public Square createSquare(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        for (Figure figure : ALL_CREATED_POLYGONAL_FIGURE) {
            if (figure instanceof Square) {
                Square square = (Square) figure;
                if (isSquaresEquals(square, firstPoint, secondPoint, thirdPoint, fourthPoint)) {
                    return square;
                }
            }
        }
        Square square = new Square(firstPoint, secondPoint, thirdPoint, fourthPoint, MultiAngleStrategy.INSTANCE);
        ALL_CREATED_POLYGONAL_FIGURE.add(square);
        return square;
    }

    private boolean isTrianglesEquals(Triangle firstTriangle, Point firstPoint, Point secondPoint, Point thirdPoint) {
        return firstTriangle.getFirstPoint().equals(firstPoint)
                && firstTriangle.getSecondPoint().equals(secondPoint)
                && firstTriangle.getThirdPoint().equals(thirdPoint);
    }

    private boolean isSquaresEquals(Square square, Point firstPoint, Point secondPoint,
                                    Point thirdPoint, Point fourthPoint) {

        return square.getFirstPoint().equals(firstPoint) && square.getSecondPoint().equals(secondPoint)
                && square.getThirdPoint().equals(thirdPoint) && square.getFourthPoint().equals(fourthPoint);
    }
}
