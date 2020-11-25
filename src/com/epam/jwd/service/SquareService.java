package com.epam.jwd.service;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.Square;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SquareService {
    private final PointService POINT_SERVICE = new PointService();
    private final Logger LOGGER = LogManager.getLogger(SquareService.class);

    public boolean isNotCorrectFigure (Square square) {
        return square.getFirstPoint().equals(square.getSecondPoint())
                || square.getFirstPoint().equals(square.getThirdPoint())
                || square.getFirstPoint().equals(square.getFourthPoint())
                || square.getSecondPoint().equals(square.getThirdPoint())
                || square.getSecondPoint().equals(square.getFourthPoint())
                || square.getThirdPoint().equals(square.getFourthPoint());
    }

    private double[] calcSquareSidesLength(Square square) {
        Point firstPoint = square.getFirstPoint();
        Point secondPoint = square.getSecondPoint();
        Point thirdPoint = square.getThirdPoint();
        Point fourthPoint = square.getFourthPoint();
        double[] arrOfSidesLength = new double[6];

        arrOfSidesLength[0] = POINT_SERVICE.calcLengthBetweenTwoPoints(firstPoint, secondPoint);
        arrOfSidesLength[1] = POINT_SERVICE.calcLengthBetweenTwoPoints(firstPoint, thirdPoint);
        arrOfSidesLength[2] = POINT_SERVICE.calcLengthBetweenTwoPoints(firstPoint, fourthPoint);
        arrOfSidesLength[3] = POINT_SERVICE.calcLengthBetweenTwoPoints(secondPoint, thirdPoint);
        arrOfSidesLength[4] = POINT_SERVICE.calcLengthBetweenTwoPoints(secondPoint, fourthPoint);
        arrOfSidesLength[5] = POINT_SERVICE.calcLengthBetweenTwoPoints(thirdPoint, fourthPoint);

        return arrOfSidesLength;
    }

    public boolean isSquareExist(Square square) {
        double[] arrOfSidesLength = calcSquareSidesLength(square);
        Arrays.sort(arrOfSidesLength);

        return arrOfSidesLength[0] == arrOfSidesLength[3]
                && arrOfSidesLength[4] == arrOfSidesLength[5];
    }

    public void displayInfoAboutArrOfSquares(Square[] squares) {
        System.out.println("Logs about array of Squares");
        for (Square square : squares) {
            if (isNotCorrectFigure(square)) {
                LOGGER.error("{} - is not square", square);
            } else {
                if (isSquareExist(square)) {
                    LOGGER.info("{}", square);
                } else {
                    LOGGER.error("{} - can't exist", square);
                }
            }
        }
    }
}
