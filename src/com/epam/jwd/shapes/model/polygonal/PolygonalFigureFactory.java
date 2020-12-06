package com.epam.jwd.shapes.model.polygonal;

import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.factory.FigureFactory;
import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.simple.Point;
import com.epam.jwd.shapes.service.simple.impl.PointService;

import java.util.Arrays;

public class PolygonalFigureFactory implements FigureFactory {
    private static Figure[] allMultiAngleFigures = new Figure[10];
    private static int numOfFigures = 0;
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
                return createTriangle(points);
            case "square":
                return createSquare(points);
            case "multiAngle":
                return createMultiAngleFigure(points);
            default:
                throw new FigureException(figureType + " - this type of shape does not exist");
        }
    }

    private Triangle createTriangle(Point... points) {
        if (numOfFigures == allMultiAngleFigures.length - 1) {
            increaseCacheSize();

        }

        for (Figure figure : allMultiAngleFigures) {
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                if (Arrays.equals(triangle.fetchArrOfPoints(), points)) {
                    return triangle;
                }
            }
        }
        Triangle triangle = new Triangle(points[0], points[1], points[2]);
        allMultiAngleFigures[numOfFigures++] = triangle;
        return triangle;
    }

    private Square createSquare(Point... points) {
        if (numOfFigures == allMultiAngleFigures.length - 1) {
            increaseCacheSize();
        }

        for (Figure figure : allMultiAngleFigures) {
            if (figure instanceof Square) {
                Square square = (Square) figure;
                if (Arrays.equals(square.fetchArrOfPoints(), points)) {
                    return square;
                }
            }
        }
        Square square = new Square(points[0], points[1], points[2], points[3]);
        allMultiAngleFigures[numOfFigures++] = square;
        return square;
    }

    private MultiAngleFigure createMultiAngleFigure(Point... points) {
        if (numOfFigures == allMultiAngleFigures.length - 1) {
            increaseCacheSize();
        }

        for (Figure figure : allMultiAngleFigures) {
            if (figure instanceof MultiAngleFigure) {
                MultiAngleFigure multiAngleFigure = (MultiAngleFigure) figure;
                if (Arrays.equals(multiAngleFigure.getPoints(), points)) {
                    return multiAngleFigure;
                }
            }
        }
        MultiAngleFigure multiAngleFigure = new MultiAngleFigure(points);
        allMultiAngleFigures[numOfFigures++] = multiAngleFigure;
        return multiAngleFigure;
    }

    private void increaseCacheSize() {
        Figure[] tempArr = allMultiAngleFigures;
        allMultiAngleFigures = new Figure[(int) (allMultiAngleFigures.length * 1.5)];
        System.arraycopy(tempArr, 0, allMultiAngleFigures, 0, tempArr.length);
    }

}
