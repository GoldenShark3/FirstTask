package com.epam.jwd.app;

import com.epam.jwd.model.Line;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.Square;
import com.epam.jwd.model.Triangle;
import com.epam.jwd.service.LineService;
import com.epam.jwd.service.PointService;
import com.epam.jwd.service.SquareService;
import com.epam.jwd.service.TriangleService;

public class Main {
    private final static PointService POINT_SERVICE = new PointService();
    private final static LineService LINE_SERVICE = new LineService();
    private final static TriangleService TRIANGLE_SERVICE = new TriangleService();
    private final static SquareService SQUARE_SERVICE = new SquareService();

    private final static Point[] ARR_OF_POINTS = new Point[4];
    private final static Line[] ARR_OF_LINES = new Line[2];
    private final static Triangle[] ARR_OF_TRIANGLES = new Triangle[2];
    private final static Square[] ARR_OF_SQUARES = new Square[1];

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
                                           new Point(4, 0),
                                           new Point(0, 3));

        ARR_OF_TRIANGLES[1] = new Triangle(new Point(0, 0),
                                           new Point(-1, 1),
                                           new Point(1, -1));
    }

    private static void initArrOfSquares() {
        ARR_OF_SQUARES[0] = new Square(ARR_OF_POINTS[0],
                                       ARR_OF_POINTS[1],
                                       ARR_OF_POINTS[2],
                                       ARR_OF_POINTS[3]);
    }

    public static void main(String[] args) {
        initArrOfPoints();
        initArrOfLines();
        initArrOfTriangles();
        initArrOfSquares();

        POINT_SERVICE.displayInfoAboutArrOfPoints(ARR_OF_POINTS);
        LINE_SERVICE.displayInfoAboutArrOfLine(ARR_OF_LINES);
        TRIANGLE_SERVICE.displayInfoAboutArrOfTriangles(ARR_OF_TRIANGLES);
        SQUARE_SERVICE.displayInfoAboutArrOfSquares(ARR_OF_SQUARES);
    }
}
