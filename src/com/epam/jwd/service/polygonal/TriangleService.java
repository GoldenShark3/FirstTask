package com.epam.jwd.service.polygonal;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.polygonal.Triangle;
import com.epam.jwd.service.PointService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleService extends MultiAngleFiguresService<Triangle> {
    private final PointService POINT_SERVICE = new PointService();
    private final Logger LOGGER = LogManager.getLogger(TriangleService.class);

    @Override
    public boolean isFigureExist(Triangle figure) {
        double[] arrOfSidesLength = calcFigureSidesLength(figure);

        return arrOfSidesLength[0] < (arrOfSidesLength[1] + arrOfSidesLength[2])
                && arrOfSidesLength[1] < (arrOfSidesLength[0] + arrOfSidesLength[2])
                && arrOfSidesLength[2] < (arrOfSidesLength[0] + arrOfSidesLength[1]);
    }

    @Override
    public void displayInfoAboutArrOfFigures(Triangle[] figures) {
        System.out.println("Logs about array of Triangles");
        for (Triangle triangle : figures) {
            if (isNotCorrectFigure(triangle)) {
                LOGGER.error("{} - is not triangle", triangle);
            } else {
                if (isFigureExist(triangle)) {
                    LOGGER.info("{}\nPerimeter = {}\nArea = {}", triangle,
                                                          String.format("%.2f" ,calcPerimeter(triangle)),
                                                          String.format("%.2f", calcArea(triangle)));
                } else {
                    LOGGER.error("{} - can't exist", triangle);
                }
            }
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
        arrOfSidesLength[1] = POINT_SERVICE.calcLengthBetweenTwoPoints(firstPoint,thirdPoint);
        arrOfSidesLength[2] = POINT_SERVICE.calcLengthBetweenTwoPoints(secondPoint, thirdPoint);

        return arrOfSidesLength;
    }

    @Override
    public boolean isNotCorrectFigure(Triangle figure) {
        return figure.getFirstPoint().equals(figure.getSecondPoint())
                || figure.getFirstPoint().equals(figure.getThirdPoint())
                || figure.getSecondPoint().equals(figure.getThirdPoint()) ;
    }


}
