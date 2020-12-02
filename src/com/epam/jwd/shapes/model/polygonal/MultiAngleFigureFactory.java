package com.epam.jwd.shapes.model.polygonal;

import com.epam.jwd.shapes.model.simple.Point;
import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.strategy.MultiAngleStrategy;
import java.util.Arrays;

public final class MultiAngleFigureFactory {
    private static Figure[] allCreatedPolygonalFigure = new Figure[10];
    private static int index = 0;
    private static MultiAngleFigureFactory instance;

    private MultiAngleFigureFactory() {

    }

    public static MultiAngleFigureFactory getInstance() {
        if (instance == null) {
            return instance = new MultiAngleFigureFactory();
        }
        return instance;
    }

    public Triangle createTriangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        for (Figure figure : allCreatedPolygonalFigure) {
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                if (isTrianglesEquals(triangle, firstPoint, secondPoint, thirdPoint)) {
                    return triangle;
                }
            }
        }
        return createNewTriangle(firstPoint, secondPoint, thirdPoint);
    }

    public MultiAngleFigure createMultiAngleFigure(Point[] points) {
        if (index == allCreatedPolygonalFigure.length - 1){
            increaseCacheSize();
        }

        for (Figure figure : allCreatedPolygonalFigure) {
            if (figure instanceof MultiAngleFigure) {
                MultiAngleFigure multiAngleFigure = (MultiAngleFigure) figure;
                if (Arrays.equals(multiAngleFigure.getPoints(), points)) {
                    return multiAngleFigure;
                }
            }
        }
        return createNewMultiAngleFigure(points);
    }

    public Square createSquare(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        if (index == allCreatedPolygonalFigure.length - 1){
            increaseCacheSize();
        }

        for (Figure figure : allCreatedPolygonalFigure) {
            if (figure instanceof Square) {
                Square square = (Square) figure;
                if (isSquaresEquals(square, firstPoint, secondPoint, thirdPoint, fourthPoint)) {
                    return square;
                }
            }
        }
        return createNewSquare(firstPoint, secondPoint, thirdPoint, fourthPoint);
    }

    private Triangle createNewTriangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        if (index == allCreatedPolygonalFigure.length - 1) {
            increaseCacheSize();
        }

        Triangle triangle = new Triangle(firstPoint, secondPoint, thirdPoint);
        allCreatedPolygonalFigure[index] = triangle;
        index++;

        return triangle;
    }

    private Square createNewSquare(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        if (index == allCreatedPolygonalFigure.length - 1) {
            increaseCacheSize();
        }

        Square square = new Square(firstPoint, secondPoint, thirdPoint, fourthPoint);
        allCreatedPolygonalFigure[index] = square;
        index++;

        return square;
    }

    private MultiAngleFigure createNewMultiAngleFigure(Point[] points) {
        if (index == allCreatedPolygonalFigure.length - 1){
            increaseCacheSize();
        }

        MultiAngleFigure multiAngleFigure = new MultiAngleFigure(points, MultiAngleStrategy.INSTANCE);
        allCreatedPolygonalFigure[index] = multiAngleFigure;
        index++;
        return multiAngleFigure;
    }

    private void increaseCacheSize() {
        Figure[] tempArr = allCreatedPolygonalFigure;
        allCreatedPolygonalFigure = new Figure[(int) (allCreatedPolygonalFigure.length * 1.5)];
        System.arraycopy(tempArr, 0, allCreatedPolygonalFigure, 0, tempArr.length);
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
