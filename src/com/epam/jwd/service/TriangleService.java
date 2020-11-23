package com.epam.jwd.service;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleService {
    private final PointService POINT_SERVICE = new PointService();
    private final Logger LOGGER = LogManager.getLogger(TriangleService.class);

    public boolean isCorrectFigure(Triangle triangle) {
        return !(triangle.getFirstPoint().equals(triangle.getSecondPoint()) ||
               triangle.getFirstPoint().equals(triangle.getThirdPoint()) ||
               triangle.getSecondPoint().equals(triangle.getThirdPoint())) ;
    }

    private double[] calcTriangleSidesLength(Triangle triangle) {
        Point firstPoint = triangle.getFirstPoint();
        Point secondPoint = triangle.getSecondPoint();
        Point thirdPoint = triangle.getThirdPoint();
        double[] arrOfSidesLength = new double[3];

        arrOfSidesLength[0] = POINT_SERVICE.calcLengthBetweenTwoPoints(firstPoint, secondPoint);
        arrOfSidesLength[1] = POINT_SERVICE.calcLengthBetweenTwoPoints(firstPoint,thirdPoint);
        arrOfSidesLength[2] = POINT_SERVICE.calcLengthBetweenTwoPoints(secondPoint, thirdPoint);

        return arrOfSidesLength;
    }

    public boolean isTriangleExist(Triangle triangle) {
        double[] arrOfSidesLength = calcTriangleSidesLength(triangle);

        return arrOfSidesLength[0] < (arrOfSidesLength[1] + arrOfSidesLength[2]) &&
                arrOfSidesLength[1] < (arrOfSidesLength[0] + arrOfSidesLength[2]) &&
                arrOfSidesLength[2] < (arrOfSidesLength[0] + arrOfSidesLength[1]);
    }

    public void displayInfoAboutArrOfTriangles(Triangle[] triangles) {
        System.out.println("Logs about array of Triangles");
        for (Triangle triangle : triangles) {
            if (isCorrectFigure(triangle)) {
                LOGGER.error("{} - is not triangle", triangle);
            } else {
                if (isTriangleExist(triangle)) {
                    LOGGER.info("{}", triangle);
                } else {
                    LOGGER.error("{} - can't exist", triangle);
                }
            }
        }
    }
}
