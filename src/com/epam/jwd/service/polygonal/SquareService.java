package com.epam.jwd.service.polygonal;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.polygonal.Square;
import com.epam.jwd.service.PointService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class SquareService extends MultiAngleFiguresService<Square> {
    private final PointService POINT_SERVICE = new PointService();
    private final Logger LOGGER = LogManager.getLogger(SquareService.class);

    @Override
    public boolean isNotCorrectFigure(Square figure) {
        return figure.getFirstPoint().equals(figure.getSecondPoint())
                || figure.getFirstPoint().equals(figure.getThirdPoint())
                || figure.getFirstPoint().equals(figure.getFourthPoint())
                || figure.getSecondPoint().equals(figure.getThirdPoint())
                || figure.getSecondPoint().equals(figure.getFourthPoint())
                || figure.getThirdPoint().equals(figure.getFourthPoint());
    }

    @Override
    public double[] calcFigureSidesLength(Square figure) {
        Point firstPoint = figure.getFirstPoint();
        Point secondPoint = figure.getSecondPoint();
        Point thirdPoint = figure.getThirdPoint();
        Point fourthPoint = figure.getFourthPoint();
        double[] arrOfSidesLength = new double[6];

        arrOfSidesLength[0] = POINT_SERVICE.calcLengthBetweenTwoPoints(firstPoint, secondPoint);
        arrOfSidesLength[1] = POINT_SERVICE.calcLengthBetweenTwoPoints(firstPoint, thirdPoint);
        arrOfSidesLength[2] = POINT_SERVICE.calcLengthBetweenTwoPoints(firstPoint, fourthPoint);
        arrOfSidesLength[3] = POINT_SERVICE.calcLengthBetweenTwoPoints(secondPoint, thirdPoint);
        arrOfSidesLength[4] = POINT_SERVICE.calcLengthBetweenTwoPoints(secondPoint, fourthPoint);
        arrOfSidesLength[5] = POINT_SERVICE.calcLengthBetweenTwoPoints(thirdPoint, fourthPoint);

        return arrOfSidesLength;
    }

    @Override
    public boolean isFigureExist(Square figure) {
        double[] arrOfSidesLength = calcFigureSidesLength(figure);
        Arrays.sort(arrOfSidesLength);

        return arrOfSidesLength[0] == arrOfSidesLength[3]
                && arrOfSidesLength[4] == arrOfSidesLength[5];
    }

    @Override
    public void displayInfoAboutArrOfFigures(Square[] figures) {
        System.out.println("Logs about array of Squares");
        for (Square square : figures) {
            if (isNotCorrectFigure(square)) {
                LOGGER.error("{} - is not square", square);
            } else {
                if (isFigureExist(square)) {
                    LOGGER.info("{}\nPerimeter = {}\nArea = {}", square,
                                                         calcPerimeter(square),
                                                         calcArea(square));
                } else {
                    LOGGER.error("{} - can't exist", square);
                }
            }
        }
    }

    @Override
    public double calcArea(Square figure) {
        return figure.getPolygonalFigureStrategy().calcArea(figure);
    }

    @Override
    public double calcPerimeter(Square figure) {
        return figure.getPolygonalFigureStrategy().calcPerimeter(figure);
    }

}
