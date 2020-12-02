package com.epam.jwd.shapes.strategy;

import com.epam.jwd.shapes.model.polygonal.MultiAngleFigure;
import com.epam.jwd.shapes.service.simple.PointService;

public enum MultiAngleStrategy implements MultiAngleFigureStrategy{
    INSTANCE;

    @Override
    public double calcArea(MultiAngleFigure figure) {
        double[] figureSidesLength = calcSidesLength(figure);
        double numOfFigurePoints = figure.getPoints().length;

        return (Math.pow(figureSidesLength[0], 2) * numOfFigurePoints) / (4 * Math.tan(Math.PI / numOfFigurePoints));
    }

    @Override
    public double calcPerimeter(MultiAngleFigure figure) {
        double[] figuresSidesLength = calcSidesLength(figure);

        return figuresSidesLength[0] * figuresSidesLength.length;
    }

    private double[] calcSidesLength(MultiAngleFigure figure) {
        final PointService POINT_SERVICE = PointService.getInstance();

        double[] figureSidesLength = new double[figure.getPoints().length];

        for (int i = 0; i < figure.getPoints().length - 1; i++) {
            figureSidesLength[i] = POINT_SERVICE.calcLengthBetweenTwoPoints(figure.getPoints()[i], figure.getPoints()[i + 1]);
        }
        figureSidesLength[figure.getPoints().length - 1] = POINT_SERVICE.calcLengthBetweenTwoPoints(figure.getPoints()[0],
                figure.getPoints()[figure.getPoints().length - 1]);

        return figureSidesLength;
    }
}
