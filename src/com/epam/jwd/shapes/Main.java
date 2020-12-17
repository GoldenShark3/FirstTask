package com.epam.jwd.shapes;

import com.epam.jwd.shapes.factory.impl.SimpleApplicationContext;
import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.factory.api.FigureFactory;
import com.epam.jwd.shapes.model.simple.impl.Line;
import com.epam.jwd.shapes.model.simple.impl.Point;
import com.epam.jwd.shapes.model.polygonal.impl.MultiAngleFigure;
import com.epam.jwd.shapes.model.polygonal.impl.Square;
import com.epam.jwd.shapes.model.polygonal.impl.Triangle;
import com.epam.jwd.shapes.model.simple.impl.SimpleFigureFactory;
import com.epam.jwd.shapes.service.simple.impl.LineService;
import com.epam.jwd.shapes.service.simple.impl.PointService;
import com.epam.jwd.shapes.service.polygonal.impl.MultiAngleService;
import com.epam.jwd.shapes.service.polygonal.impl.SquareService;
import com.epam.jwd.shapes.service.polygonal.impl.TriangleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    private final static PointService POINT_SERVICE = PointService.getInstance();
    private final static LineService LINE_SERVICE = LineService.INSTANCE;
    private final static TriangleService TRIANGLE_SERVICE = TriangleService.INSTANCE;
    private final static SquareService SQUARE_SERVICE = SquareService.INSTANCE;
    private final static MultiAngleService MULTI_ANGLE_SERVICE = MultiAngleService.INSTANCE;

    private final static SimpleFigureFactory SIMPLE_FIGURE_FACTORY = SimpleFigureFactory.getInstance();
    private final static FigureFactory MULTI_ANGLE_FIGURE_FACTORY = SimpleApplicationContext.INSTANCE.createFigureFactory();

    private final static List<Point> POINT_LIST = new ArrayList<>(4);
    private final static List<Line> LINE_LIST = new ArrayList<>(2);
    private final static List<Triangle> TRIANGLE_LIST = new ArrayList<>(2);
    private final static List<Square> SQUARE_LIST = new ArrayList<>(2);
    private final static List<MultiAngleFigure> MULTI_ANGLE_FIGURE_LIST = new ArrayList<>(2);

    private static void initArrOfPoints() {
        POINT_LIST.add(SIMPLE_FIGURE_FACTORY.createPoint(-5, 0));
        POINT_LIST.add(SIMPLE_FIGURE_FACTORY.createPoint(-5, 5));
        POINT_LIST.add(SIMPLE_FIGURE_FACTORY.createPoint(0, 5));
        POINT_LIST.add(SIMPLE_FIGURE_FACTORY.createPoint(0, 0));
    }

    private static void initArrOfLines() {
        LINE_LIST.add(SIMPLE_FIGURE_FACTORY.createLine(
                SIMPLE_FIGURE_FACTORY.createPoint(0, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(5, 0)));

        LINE_LIST.add(SIMPLE_FIGURE_FACTORY.createLine(
                SIMPLE_FIGURE_FACTORY.createPoint(0, 5),
                SIMPLE_FIGURE_FACTORY.createPoint(0, 5)));

    }

    private static void initArrOfTriangles() throws FigureException {
        TRIANGLE_LIST.add((Triangle) MULTI_ANGLE_FIGURE_FACTORY.createFigure("triangle",
                SIMPLE_FIGURE_FACTORY.createPoint(0, -2),
                SIMPLE_FIGURE_FACTORY.createPoint(3, 3),
                SIMPLE_FIGURE_FACTORY.createPoint(0, 3)));

        TRIANGLE_LIST.add((Triangle) MULTI_ANGLE_FIGURE_FACTORY.createFigure("triangle",
                SIMPLE_FIGURE_FACTORY.createPoint(0, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(0, -3),
                SIMPLE_FIGURE_FACTORY.createPoint(0, -3)));

    }

    private static void initArrOfSquares() throws FigureException {
        SQUARE_LIST.add((Square) MULTI_ANGLE_FIGURE_FACTORY.createFigure("square",
                POINT_LIST.get(0),
                POINT_LIST.get(1),
                POINT_LIST.get(2),
                POINT_LIST.get(3)));

        SQUARE_LIST.add((Square) MULTI_ANGLE_FIGURE_FACTORY.createFigure("square",
                SIMPLE_FIGURE_FACTORY.createPoint(0, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(4, 5),
                SIMPLE_FIGURE_FACTORY.createPoint(1, 1),
                SIMPLE_FIGURE_FACTORY.createPoint(3,4)));
    }

    private static void initArrOfMultiAngleFigures() throws FigureException {
        MULTI_ANGLE_FIGURE_LIST.add((MultiAngleFigure) MULTI_ANGLE_FIGURE_FACTORY.createFigure("multiAngle",
                SIMPLE_FIGURE_FACTORY.createPoint(3, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(0, 4),
                SIMPLE_FIGURE_FACTORY.createPoint(-5, 4),
                SIMPLE_FIGURE_FACTORY.createPoint(-8, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(-5, -4),
                SIMPLE_FIGURE_FACTORY.createPoint(0, -4)));

        MULTI_ANGLE_FIGURE_LIST.add((MultiAngleFigure) MULTI_ANGLE_FIGURE_FACTORY.createFigure("multiAngle",
                SIMPLE_FIGURE_FACTORY.createPoint(0, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(0, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(-5, 4),
                SIMPLE_FIGURE_FACTORY.createPoint(-3, 0),
                SIMPLE_FIGURE_FACTORY.createPoint(10, -4),
                SIMPLE_FIGURE_FACTORY.createPoint(0, -4)));

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

        POINT_SERVICE.displayInfoAboutListOfFigures(POINT_LIST);
        LINE_SERVICE.displayInfoAboutListOfFigures(LINE_LIST);
        TRIANGLE_SERVICE.displayInfoAboutListOfFigures(TRIANGLE_LIST);
        SQUARE_SERVICE.displayInfoAboutListOfFigures(SQUARE_LIST);
        MULTI_ANGLE_SERVICE.displayInfoAboutListOfFigures(MULTI_ANGLE_FIGURE_LIST);
    }
}
