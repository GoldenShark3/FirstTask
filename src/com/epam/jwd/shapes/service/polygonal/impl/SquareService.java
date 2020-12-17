package com.epam.jwd.shapes.service.polygonal.impl;

import com.epam.jwd.shapes.model.simple.impl.Point;
import com.epam.jwd.shapes.model.polygonal.impl.Square;
import com.epam.jwd.shapes.service.polygonal.api.MultiAngleFiguresService;
import com.epam.jwd.shapes.service.simple.impl.PointService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.List;

public final class SquareService implements MultiAngleFiguresService<Square> {
    private final PointService POINT_SERVICE = PointService.getInstance();
    private final Logger LOGGER = LogManager.getLogger(SquareService.class);
    public final static SquareService INSTANCE = new SquareService();

    private SquareService() {

    }

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
    public void displayInfoAboutListOfFigures(List<Square> figures) {
        System.out.println("\nLogs about array of Squares");
        for (Square square : figures) {
            LOGGER.info("{}\nPerimeter = {}\nArea = {}", square,
                    String.format("%.2f", calcPerimeter(square)),
                    String.format("%.2f", calcArea(square)));

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
