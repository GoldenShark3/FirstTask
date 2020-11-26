package com.epam.jwd.app;

import com.epam.jwd.model.Line;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.polygonal.MultiAngleFigure;
import com.epam.jwd.model.polygonal.Square;
import com.epam.jwd.model.polygonal.Triangle;
import com.epam.jwd.service.LineService;
import com.epam.jwd.service.PointService;
import com.epam.jwd.service.polygonal.MultiAngleService;
import com.epam.jwd.service.polygonal.SquareService;
import com.epam.jwd.service.polygonal.TriangleService;
import com.epam.jwd.strategy.MultiAngleStrategy;
import com.epam.jwd.strategy.SquareStrategy;
import com.epam.jwd.strategy.TriangleStrategy;

public class Main {
    private final static PointService POINT_SERVICE = new PointService();
    private final static LineService LINE_SERVICE = new LineService();
    private final static TriangleService TRIANGLE_SERVICE = new TriangleService();
    private final static SquareService SQUARE_SERVICE = new SquareService();
    private final static MultiAngleService MULTI_ANGLE_SERVICE = new MultiAngleService();

    private final static Point[] ARR_OF_POINTS = new Point[4];
    private final static Line[] ARR_OF_LINES = new Line[2];
    private final static Triangle[] ARR_OF_TRIANGLES = new Triangle[2];
    private final static Square[] ARR_OF_SQUARES = new Square[1];
    private final static MultiAngleFigure[] ARR_OF_MULTI_ANGLE_FIGURE = new MultiAngleFigure[1];

    private static void initArrOfPoints() {
        ARR_OF_POINTS[0] = new Point(-5, 0);
        ARR_OF_POINTS[1] = new Point(-5, 5);
        ARR_OF_POINTS[2] = new Point(0, 0);
        ARR_OF_POINTS[3] = new Point(0, 5);
    }

    private static void initArrOfLines() {
        ARR_OF_LINES[0] = new Line(new Point(0, 0),
                                   new Point(5, 0));

        ARR_OF_LINES[1] = new Line(new Point(0, 5),
                                   new Point(0, 5));
    }

    private static void initArrOfTriangles() {
        ARR_OF_TRIANGLES[0] = new Triangle(new Point(0, -2),
                                           new Point(3, 3),
                                           new Point(0, 3),
                                           TriangleStrategy.getInstance());

        ARR_OF_TRIANGLES[1] = new Triangle(new Point(0, 0),
                                           new Point(-1, 1),
                                           new Point(1, -1),
                                           TriangleStrategy.getInstance());
    }

    private static void initArrOfSquares() {
        ARR_OF_SQUARES[0] = new Square(ARR_OF_POINTS[0],
                                       ARR_OF_POINTS[1],
                                       ARR_OF_POINTS[2],
                                       ARR_OF_POINTS[3],
                                       SquareStrategy.getInstance());
    }

    private static void initArrOfMultiAngleFigures() {
        ARR_OF_MULTI_ANGLE_FIGURE[0] = new MultiAngleFigure(new Point[] {new Point(3 ,0),
                                                                         new Point(0, 4),
                                                                         new Point(-5, 4),
                                                                         new Point(-8 ,0),
                                                                         new Point(-5, -4),
                                                                         new Point(-0, -4)},
                                                                     MultiAngleStrategy.INSTANCE);
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
