package com.epam.jwd.app;

import com.epam.jwd.model.simple.Line;
import com.epam.jwd.model.simple.Point;
import com.epam.jwd.model.polygonal.MultiAngleFigure;
import com.epam.jwd.model.polygonal.MultiAngleFigureFactory;
import com.epam.jwd.model.polygonal.Square;
import com.epam.jwd.model.polygonal.Triangle;
import com.epam.jwd.model.simple.SimpleFigureFactory;
import com.epam.jwd.service.simple.LineService;
import com.epam.jwd.service.simple.PointService;
import com.epam.jwd.service.polygonal.MultiAngleService;
import com.epam.jwd.service.polygonal.SquareService;
import com.epam.jwd.service.polygonal.TriangleService;

public class Main {
    private final static PointService POINT_SERVICE = new PointService();
    private final static LineService LINE_SERVICE = new LineService();
    private final static TriangleService TRIANGLE_SERVICE = new TriangleService();
    private final static SquareService SQUARE_SERVICE = new SquareService();
    private final static MultiAngleService MULTI_ANGLE_SERVICE = new MultiAngleService();

    private final static SimpleFigureFactory SIMPLE_FIGURE_FACTORY = new SimpleFigureFactory();
    private final static MultiAngleFigureFactory MULTI_ANGLE_FIGURE_FACTORY = new MultiAngleFigureFactory();

    private final static Point[] ARR_OF_POINTS = new Point[4];
    private final static Line[] ARR_OF_LINES = new Line[2];
    private final static Triangle[] ARR_OF_TRIANGLES = new Triangle[2];
    private final static Square[] ARR_OF_SQUARES = new Square[1];
    private final static MultiAngleFigure[] ARR_OF_MULTI_ANGLE_FIGURE = new MultiAngleFigure[1];

    private static void initArrOfPoints() {
        ARR_OF_POINTS[0] = SIMPLE_FIGURE_FACTORY.createPoint(-5, 0);
        ARR_OF_POINTS[1] = SIMPLE_FIGURE_FACTORY.createPoint(-5, 5);
        ARR_OF_POINTS[2] = SIMPLE_FIGURE_FACTORY.createPoint(0, 5);
        ARR_OF_POINTS[3] = SIMPLE_FIGURE_FACTORY.createPoint(0, 0);
    }

    private static void initArrOfLines() {
        ARR_OF_LINES[0] = SIMPLE_FIGURE_FACTORY.createLine(
                SIMPLE_FIGURE_FACTORY.createPoint(0, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(5, 0));

        ARR_OF_LINES[1] = SIMPLE_FIGURE_FACTORY.createLine(
                SIMPLE_FIGURE_FACTORY.createPoint(0, 5),
                SIMPLE_FIGURE_FACTORY.createPoint(0, 5));
    }

    private static void initArrOfTriangles() {
        ARR_OF_TRIANGLES[0] = MULTI_ANGLE_FIGURE_FACTORY.createTriangle(
                SIMPLE_FIGURE_FACTORY.createPoint(0, -2),
                SIMPLE_FIGURE_FACTORY.createPoint(3, 3),
                SIMPLE_FIGURE_FACTORY.createPoint(0, 3));

        ARR_OF_TRIANGLES[1] = MULTI_ANGLE_FIGURE_FACTORY.createTriangle(
                SIMPLE_FIGURE_FACTORY.createPoint(0, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(-1, 1),
                SIMPLE_FIGURE_FACTORY.createPoint(1, -1));
    }

    private static void initArrOfSquares() {
        ARR_OF_SQUARES[0] = MULTI_ANGLE_FIGURE_FACTORY.createSquare(
                ARR_OF_POINTS[0],
                ARR_OF_POINTS[1],
                ARR_OF_POINTS[2],
                ARR_OF_POINTS[3]);
    }

    private static void initArrOfMultiAngleFigures() {
        ARR_OF_MULTI_ANGLE_FIGURE[0] = MULTI_ANGLE_FIGURE_FACTORY.createMultiAngleFigure(
                new Point[]{
                        SIMPLE_FIGURE_FACTORY.createPoint(3, 0),
                        SIMPLE_FIGURE_FACTORY.createPoint(0, 4),
                        SIMPLE_FIGURE_FACTORY.createPoint(-5, 4),
                        SIMPLE_FIGURE_FACTORY.createPoint(-8, 0),
                        SIMPLE_FIGURE_FACTORY.createPoint(-5, -4),
                        SIMPLE_FIGURE_FACTORY.createPoint(-0, -4)});
    }

    public static void main(String[] args) {
        initArrOfPoints();
        initArrOfLines();
        initArrOfTriangles();
        initArrOfSquares();
        initArrOfMultiAngleFigures();

        POINT_SERVICE.displayInfoAboutArrOfPoints(ARR_OF_POINTS);
        LINE_SERVICE.displayInfoAboutArrOfLine(ARR_OF_LINES);
        TRIANGLE_SERVICE.displayInfoAboutArrOfFigures(ARR_OF_TRIANGLES);
        SQUARE_SERVICE.displayInfoAboutArrOfFigures(ARR_OF_SQUARES);
        MULTI_ANGLE_SERVICE.displayInfoAboutArrOfFigures(ARR_OF_MULTI_ANGLE_FIGURE);
    }
}
