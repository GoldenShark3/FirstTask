package com.epam.jwd.strategy;

import com.epam.jwd.model.polygonal.MultiAngleFigure;

public enum MultiAngleStrategy implements MultiAngleFigureStrategy<MultiAngleFigure>{
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
        double[] figureSidesLength = new double[figure.getPoints().length];

        for (int i = 0; i < figure.getPoints().length - 1; i++) {
            figureSidesLength[i] = distanceBetweenTwoPoints(figure.getPoints()[i], figure.getPoints()[i + 1]);
        }
        figureSidesLength[figure.getPoints().length - 1] = distanceBetweenTwoPoints(figure.getPoints()[0],
                figure.getPoints()[figure.getPoints().length - 1]);

        return figureSidesLength;
    }
}
