package com.epam.jwd.shapes.service.polygonal;

import com.epam.jwd.shapes.model.polygonal.MultiAngleFigure;
import com.epam.jwd.shapes.model.simple.Point;
import com.epam.jwd.shapes.model.polygonal.Square;
import com.epam.jwd.shapes.service.simple.PointService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public final class SquareService implements MultiAngleFiguresService {
    private final PointService POINT_SERVICE = PointService.getInstance();
    private final Logger LOGGER = LogManager.getLogger(SquareService.class);
    public final static SquareService INSTANCE = new SquareService();

    private SquareService() {

    }


    @Override
    public boolean isNotCorrectFigure(MultiAngleFigure figure) {
        Square square = (Square) figure;
        return square.getFirstPoint().equals(square.getSecondPoint())
                || square.getFirstPoint().equals(square.getThirdPoint())
                || square.getFirstPoint().equals(square.getFourthPoint())
                || square.getSecondPoint().equals(square.getThirdPoint())
                || square.getSecondPoint().equals(square.getFourthPoint())
                || square.getThirdPoint().equals(square.getFourthPoint());
    }

    @Override
    public double[] calcFigureSidesLength(MultiAngleFigure figure) {
        Square square = (Square) figure;
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

    @Override
    public boolean isFigureExist(MultiAngleFigure figure) {
        double[] arrOfSidesLength = calcFigureSidesLength(figure);
        Arrays.sort(arrOfSidesLength);

        return arrOfSidesLength[0] == arrOfSidesLength[3]
                && arrOfSidesLength[4] == arrOfSidesLength[5];
    }

    @Override
    public void displayInfoAboutArrOfFigures(MultiAngleFigure[] figures) {
        System.out.println("\nLogs about array of Squares");
        for (MultiAngleFigure square : figures) {
            if (isNotCorrectFigure(square)) {
                LOGGER.error("{} - is not square", square);
            } else {
                if (isFigureExist(square)) {
                    LOGGER.info("{}\nPerimeter = {}\nArea = {}", square,
                                                         String.format("%.2f", calcPerimeter(square)),
                                                         String.format("%.2f", calcArea(square)));
                } else {
                    LOGGER.error("{} - can't exist", square);
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

}
