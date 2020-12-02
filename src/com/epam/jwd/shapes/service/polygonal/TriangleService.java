package com.epam.jwd.shapes.service.polygonal;

import com.epam.jwd.shapes.model.polygonal.MultiAngleFigure;
import com.epam.jwd.shapes.model.simple.Point;
import com.epam.jwd.shapes.model.polygonal.Triangle;
import com.epam.jwd.shapes.service.simple.PointService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class TriangleService implements MultiAngleFiguresService {
    private final PointService POINT_SERVICE = PointService.getInstance();
    private final Logger LOGGER = LogManager.getLogger(TriangleService.class);
    public final static TriangleService INSTANCE = new TriangleService();

    private TriangleService() {

    }

    @Override
    public boolean isFigureExist(MultiAngleFigure figure) {
        double[] arrOfSidesLength = calcFigureSidesLength(figure);

        return arrOfSidesLength[0] < (arrOfSidesLength[1] + arrOfSidesLength[2])
                && arrOfSidesLength[1] < (arrOfSidesLength[0] + arrOfSidesLength[2])
                && arrOfSidesLength[2] < (arrOfSidesLength[0] + arrOfSidesLength[1]);
    }

    @Override
    public void displayInfoAboutArrOfFigures(MultiAngleFigure[] figures) {
        System.out.println("\nLogs about array of Triangles");
        for (MultiAngleFigure triangle : figures) {
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
    public double calcArea(MultiAngleFigure figure) {
        return figure.getPolygonalFigureStrategy().calcArea(figure);
    }

    @Override
    public double calcPerimeter(MultiAngleFigure figure) {
        return figure.getPolygonalFigureStrategy().calcPerimeter(figure);
    }

    @Override
    public double[] calcFigureSidesLength(MultiAngleFigure figure) {
        Triangle triangle = (Triangle) figure;
        Point firstPoint = triangle.getFirstPoint();
        Point secondPoint = triangle.getSecondPoint();
        Point thirdPoint = triangle.getThirdPoint();
        double[] arrOfSidesLength = new double[3];

        arrOfSidesLength[0] = POINT_SERVICE.calcLengthBetweenTwoPoints(firstPoint, secondPoint);
        arrOfSidesLength[1] = POINT_SERVICE.calcLengthBetweenTwoPoints(firstPoint,thirdPoint);
        arrOfSidesLength[2] = POINT_SERVICE.calcLengthBetweenTwoPoints(secondPoint, thirdPoint);

        return arrOfSidesLength;
    }

    @Override
    public boolean isNotCorrectFigure(MultiAngleFigure figure) {
        Triangle triangle = (Triangle) figure;
        return triangle.getFirstPoint().equals(triangle.getSecondPoint())
                || triangle.getFirstPoint().equals(triangle.getThirdPoint())
                || triangle.getSecondPoint().equals(triangle.getThirdPoint()) ;
    }


}
