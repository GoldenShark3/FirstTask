package com.epam.jwd.shapes;

import com.epam.jwd.shapes.decorator.Factory;
import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.exception.FigureNotExistException;
import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.polygonal.PolygonalFigureFactory;
import com.epam.jwd.shapes.model.simple.Line;
import com.epam.jwd.shapes.model.simple.Point;
import com.epam.jwd.shapes.model.polygonal.MultiAngleFigure;
import com.epam.jwd.shapes.model.polygonal.Square;
import com.epam.jwd.shapes.model.polygonal.Triangle;
import com.epam.jwd.shapes.model.simple.SimpleFigureFactory;
import com.epam.jwd.shapes.service.simple.impl.LineService;
import com.epam.jwd.shapes.service.simple.impl.PointService;
import com.epam.jwd.shapes.service.polygonal.impl.MultiAngleService;
import com.epam.jwd.shapes.service.polygonal.impl.SquareService;
import com.epam.jwd.shapes.service.polygonal.impl.TriangleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    private final static PointService POINT_SERVICE = PointService.getInstance();
    private final static LineService LINE_SERVICE = LineService.INSTANCE;
    private final static TriangleService TRIANGLE_SERVICE = TriangleService.INSTANCE;
    private final static SquareService SQUARE_SERVICE = SquareService.INSTANCE;
    private final static MultiAngleService MULTI_ANGLE_SERVICE = MultiAngleService.INSTANCE;

    private final static SimpleFigureFactory SIMPLE_FIGURE_FACTORY = SimpleFigureFactory.getInstance();
    private final static Factory MULTI_ANGLE_FIGURE_FACTORY = new Factory(PolygonalFigureFactory.getInstance());

    private final static Point[] ARR_OF_POINTS = new Point[4];
    private final static Line[] ARR_OF_LINES = new Line[2];
    private final static Figure[] ARR_OF_TRIANGLES = new Triangle[2];
    private final static Figure[] ARR_OF_SQUARES = new Square[2];
    private final static Figure[] ARR_OF_MULTI_ANGLE_FIGURE = new MultiAngleFigure[2];

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

    private static void initArrOfTriangles() throws FigureException {
        ARR_OF_TRIANGLES[0] = MULTI_ANGLE_FIGURE_FACTORY.createFigure("triangle",
                SIMPLE_FIGURE_FACTORY.createPoint(0, -2),
                SIMPLE_FIGURE_FACTORY.createPoint(3, 3),
                SIMPLE_FIGURE_FACTORY.createPoint(0, 3));

        ARR_OF_TRIANGLES[1] = MULTI_ANGLE_FIGURE_FACTORY.createFigure("triangle",
                SIMPLE_FIGURE_FACTORY.createPoint(0, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(-1, 1),
                SIMPLE_FIGURE_FACTORY.createPoint(1, -1));
    }

    private static void initArrOfSquares() throws FigureException {
        ARR_OF_SQUARES[0] = MULTI_ANGLE_FIGURE_FACTORY.createFigure("square", ARR_OF_POINTS);
        ARR_OF_SQUARES[1] = MULTI_ANGLE_FIGURE_FACTORY.createFigure("square",
                SIMPLE_FIGURE_FACTORY.createPoint(0, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(4, 5),
                SIMPLE_FIGURE_FACTORY.createPoint(1, 1),
                SIMPLE_FIGURE_FACTORY.createPoint(3,4));
    }

    private static void initArrOfMultiAngleFigures() throws FigureException {
        ARR_OF_MULTI_ANGLE_FIGURE[0] = MULTI_ANGLE_FIGURE_FACTORY.createFigure("multiAngle",
                SIMPLE_FIGURE_FACTORY.createPoint(3, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(0, 4),
                SIMPLE_FIGURE_FACTORY.createPoint(-5, 4),
                SIMPLE_FIGURE_FACTORY.createPoint(-8, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(-5, -4),
                SIMPLE_FIGURE_FACTORY.createPoint(0, -4));

        ARR_OF_MULTI_ANGLE_FIGURE[1] = MULTI_ANGLE_FIGURE_FACTORY.createFigure("multiAngle",
                SIMPLE_FIGURE_FACTORY.createPoint(0, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(0, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(-5, 4),
                SIMPLE_FIGURE_FACTORY.createPoint(-3, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(10, -4),
                SIMPLE_FIGURE_FACTORY.createPoint(0, -4));
    }

    public static void main(String[] args) {
        initArrOfPoints();
        initArrOfLines();
        try {
            initArrOfTriangles();
        } catch (FigureException exception) {
            LOGGER.error(exception.getMessage());
        }
        try {
            initArrOfSquares();
        } catch (FigureException exception) {
            LOGGER.error(exception.getMessage());
        }
        try {
            initArrOfMultiAngleFigures();
        } catch (FigureException exception) {
            LOGGER.error(exception.getMessage());
        }

        POINT_SERVICE.displayInfoAboutArrOfFigures(ARR_OF_POINTS);
        LINE_SERVICE.displayInfoAboutArrOfFigures(ARR_OF_LINES);
        TRIANGLE_SERVICE.displayInfoAboutArrOfFigures(ARR_OF_TRIANGLES);
        SQUARE_SERVICE.displayInfoAboutArrOfFigures(ARR_OF_SQUARES);
        MULTI_ANGLE_SERVICE.displayInfoAboutArrOfFigures(ARR_OF_MULTI_ANGLE_FIGURE);
    }
}
