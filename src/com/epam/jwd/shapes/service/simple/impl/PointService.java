package com.epam.jwd.shapes.service.simple.impl;
import com.epam.jwd.shapes.model.SimpleFigure;
import com.epam.jwd.shapes.model.simple.Point;
import com.epam.jwd.shapes.service.simple.SimpleFigureService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class PointService implements SimpleFigureService {
    private static final Logger LOGGER = LogManager.getLogger(PointService.class);
    private static PointService instance;

    private PointService() {

    }

    public static PointService getInstance() {
        if (instance == null) {
            return instance = new PointService();
        }
        return instance;
    }


    public double calcLengthBetweenTwoPoints(Point firstPoint, Point secondPoint) {
        int deltaX = secondPoint.getX() - firstPoint.getX();
        int deltaY = secondPoint.getY() - firstPoint.getY();

        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    @Override
    public void displayInfoAboutArrOfFigures(SimpleFigure[] simpleFigures) {
        int index = 0;
        System.out.println("\nLogs about array of points: ");
        do {
            LOGGER.info("The {} point{}", (index + 1), simpleFigures[index]);
            index++;
        } while (index < simpleFigures.length);
    }
}
