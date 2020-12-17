package com.epam.jwd.shapes.strategy.impl;

import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigure;
import com.epam.jwd.shapes.model.polygonal.impl.MultiAngleFigure;
import com.epam.jwd.shapes.service.simple.impl.PointService;
import com.epam.jwd.shapes.strategy.api.MultiAngleFigureStrategy;

public enum MultiAngleStrategy implements MultiAngleFigureStrategy {
    INSTANCE;

    @Override
    public double calcArea(PolygonalFigure polygonalFigure) {
        MultiAngleFigure multiAngleFigure = (MultiAngleFigure) polygonalFigure;
        double[] figureSidesLength = calcSidesLength(polygonalFigure);
        double numOfFigurePoints = multiAngleFigure.getPoints().length;

        return (Math.pow(figureSidesLength[0], 2) * numOfFigurePoints) / (4 * Math.tan(Math.PI / numOfFigurePoints));
    }

    @Override
    public double calcPerimeter(PolygonalFigure polygonalFigure) {
        double[] figuresSidesLength = calcSidesLength(polygonalFigure);

        return figuresSidesLength[0] * figuresSidesLength.length;
    }

    private double[] calcSidesLength(PolygonalFigure polygonalFigure) {
        MultiAngleFigure multiAngleFigure = (MultiAngleFigure) polygonalFigure;
        final PointService POINT_SERVICE = PointService.getInstance();
        double[] figureSidesLength = new double[multiAngleFigure.getPoints().length];

        for (int i = 0; i < multiAngleFigure.getPoints().length - 1; i++) {
            figureSidesLength[i] = POINT_SERVICE.calcLengthBetweenTwoPoints(multiAngleFigure.getPoints()[i],
                    multiAngleFigure.getPoints()[i + 1]);
        }
        figureSidesLength[multiAngleFigure.getPoints().length - 1] = POINT_SERVICE.calcLengthBetweenTwoPoints(
                                                multiAngleFigure.getPoints()[0],
                                                multiAngleFigure.getPoints()[multiAngleFigure.getPoints().length - 1]);

        return figureSidesLength;
    }
}
