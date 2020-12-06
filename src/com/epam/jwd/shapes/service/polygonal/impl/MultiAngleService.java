package com.epam.jwd.shapes.service.polygonal.impl;

import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.polygonal.MultiAngleFigure;
import com.epam.jwd.shapes.service.polygonal.MultiAngleFiguresService;
import com.epam.jwd.shapes.service.simple.impl.PointService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class MultiAngleService implements MultiAngleFiguresService {
    private final static Logger LOGGER = LogManager.getLogger(MultiAngleService.class);
    private final static PointService POINT_SERVICE = PointService.getInstance();
    public final static MultiAngleService INSTANCE = new MultiAngleService();

    private MultiAngleService() {

    }

    @Override
    public boolean isNotCorrectFigure(Figure figure) {
        MultiAngleFigure multiAngleFigure = (MultiAngleFigure) figure;
        if (multiAngleFigure.getPoints().length > 6 || multiAngleFigure.getPoints().length < 4) {
            return true;
        }
        for (int i = 0; i < multiAngleFigure.getPoints().length - 1; i++) {
            if (multiAngleFigure.getPoints()[i].equals(multiAngleFigure.getPoints()[i + 1])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isFigureExist(Figure figure) {
        double[] sidesLength = calcFigureSidesLength(figure);

        for (int i = 0; i < sidesLength.length - 1; i++) {
            if (sidesLength[i] != sidesLength[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void displayInfoAboutArrOfFigures(Figure[] figures) {
        System.out.println("\nLogs about array of MultiAngleFigure: ");
        for (Figure figure : figures) {
            if (figure != null && isNotCorrectFigure(figure)) {
                LOGGER.error("{} - is not figure", figure);
            } else {
                if (figure != null && isFigureExist(figure)) {
                    LOGGER.info("{}\nPerimeter = {}\nArea = {}",figure,
                                       String.format("%.2f", calcPerimeter(figure)),
                                       String.format("%.2f", calcArea(figure)));
                }
            }
        }
    }

    @Override
    public double calcArea(Figure figure) {
        return figure.getPolygonalFigureStrategy().calcArea(figure);
    }

    @Override
    public double calcPerimeter(Figure figure) {
        return figure.getPolygonalFigureStrategy().calcPerimeter(figure);
    }

    @Override
    public double[] calcFigureSidesLength(Figure figure) {
        MultiAngleFigure multiAngleFigure = (MultiAngleFigure) figure;
        double[] sidesLength = new double[multiAngleFigure.getPoints().length ];

        for (int i = 0; i < multiAngleFigure.getPoints().length - 1; i++) {
            sidesLength[i] = POINT_SERVICE.calcLengthBetweenTwoPoints(multiAngleFigure.getPoints()[i], multiAngleFigure.getPoints()[i + 1]);
        }
        sidesLength[multiAngleFigure.getPoints().length - 1] = POINT_SERVICE.calcLengthBetweenTwoPoints(multiAngleFigure.getPoints()[0],
                multiAngleFigure.getPoints()[multiAngleFigure.getPoints().length - 1]);

        return sidesLength;
    }
}
