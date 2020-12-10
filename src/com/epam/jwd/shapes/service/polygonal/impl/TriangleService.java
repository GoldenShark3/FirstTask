package com.epam.jwd.shapes.service.polygonal.impl;

import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.polygonal.MultiAngleFigure;
import com.epam.jwd.shapes.model.simple.Point;
import com.epam.jwd.shapes.model.polygonal.Triangle;
import com.epam.jwd.shapes.service.polygonal.MultiAngleFiguresService;
import com.epam.jwd.shapes.service.simple.impl.PointService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public final class TriangleService implements MultiAngleFiguresService<Triangle> {
    private final PointService POINT_SERVICE = PointService.getInstance();
    private final Logger LOGGER = LogManager.getLogger(TriangleService.class);
    public final static TriangleService INSTANCE = new TriangleService();

    private TriangleService() {

    }

    @Override
    public boolean isFigureExist(Triangle figure) {
        double[] arrOfSidesLength = calcFigureSidesLength(figure);

        return arrOfSidesLength[0] < (arrOfSidesLength[1] + arrOfSidesLength[2])
                && arrOfSidesLength[1] < (arrOfSidesLength[0] + arrOfSidesLength[2])
                && arrOfSidesLength[2] < (arrOfSidesLength[0] + arrOfSidesLength[1]);
    }

    @Override
    public void displayInfoAboutListOfFigures(List<Triangle> figures) {
        System.out.println("\nLogs about list of Triangles");
        for (Triangle triangle : figures) {
            LOGGER.info("{}\nPerimeter = {}\nArea = {}", triangle,
                    String.format("%.2f", calcPerimeter(triangle)),
                    String.format("%.2f", calcArea(triangle)));

        }
    }

    @Override
    public double calcArea(Triangle figure) {
        return figure.getPolygonalFigureStrategy().calcArea(figure);
    }

    @Override
    public double calcPerimeter(Triangle figure) {
        return figure.getPolygonalFigureStrategy().calcPerimeter(figure);
    }

    @Override
    public double[] calcFigureSidesLength(Triangle figure) {
        Point firstPoint = figure.getFirstPoint();
        Point secondPoint = figure.getSecondPoint();
        Point thirdPoint = figure.getThirdPoint();
        double[] arrOfSidesLength = new double[3];

        arrOfSidesLength[0] = POINT_SERVICE.calcLengthBetweenTwoPoints(firstPoint, secondPoint);
        arrOfSidesLength[1] = POINT_SERVICE.calcLengthBetweenTwoPoints(firstPoint, thirdPoint);
        arrOfSidesLength[2] = POINT_SERVICE.calcLengthBetweenTwoPoints(secondPoint, thirdPoint);

        return arrOfSidesLength;
    }

    @Override
    public boolean isNotCorrectFigure(Triangle figure) {
        return figure.getFirstPoint().equals(figure.getSecondPoint())
                || figure.getFirstPoint().equals(figure.getThirdPoint())
                || figure.getSecondPoint().equals(figure.getThirdPoint());
    }


}
