package com.epam.jwd.shapes.service.polygonal;

import com.epam.jwd.shapes.model.polygonal.MultiAngleFigure;
import com.epam.jwd.shapes.service.simple.PointService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class MultiAngleService implements MultiAngleFiguresService {
    private final static Logger LOGGER = LogManager.getLogger(MultiAngleService.class);
    private final static PointService POINT_SERVICE = PointService.getInstance();
    public final static MultiAngleService INSTANCE = new MultiAngleService();

    private MultiAngleService() {

    }

    @Override
    public boolean isNotCorrectFigure(MultiAngleFigure figure) {
        if (figure.getPoints().length > 6 || figure.getPoints().length < 4) {
            return true;
        }
        for (int i = 0; i < figure.getPoints().length - 1; i++) {
            if (figure.getPoints()[i].equals(figure.getPoints()[i + 1])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isFigureExist(MultiAngleFigure figure) {
        double[] sidesLength = calcFigureSidesLength(figure);

        for (int i = 0; i < sidesLength.length - 1; i++) {
            if (sidesLength[i] != sidesLength[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void displayInfoAboutArrOfFigures(MultiAngleFigure[] figures) {
        System.out.println("\nLogs about array of MultiAngleFigure: ");
        for (MultiAngleFigure figure : figures) {
            if (isNotCorrectFigure(figure)) {
                LOGGER.error("{} - is not figure", figure);
            } else {
                if (isFigureExist(figure)) {
                    LOGGER.info("{}\nPerimeter = {}\nArea = {}",figure,
                                       String.format("%.2f", calcPerimeter(figure)),
                                       String.format("%.2f", calcArea(figure)));
                } else {
                    LOGGER.error("{} - is not correct figure", figure);
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
        double[] sidesLength = new double[figure.getPoints().length ];

        for (int i = 0; i < figure.getPoints().length - 1; i++) {
            sidesLength[i] = POINT_SERVICE.calcLengthBetweenTwoPoints(figure.getPoints()[i], figure.getPoints()[i + 1]);
        }
        sidesLength[figure.getPoints().length - 1] = POINT_SERVICE.calcLengthBetweenTwoPoints(figure.getPoints()[0],
                figure.getPoints()[figure.getPoints().length - 1]);

        return sidesLength;
    }
}