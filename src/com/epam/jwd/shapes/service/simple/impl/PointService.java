package com.epam.jwd.shapes.service.simple.impl;
import com.epam.jwd.shapes.model.simple.impl.Point;
import com.epam.jwd.shapes.service.simple.api.SimpleFigureService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;


public final class PointService implements SimpleFigureService<Point> {
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

    @Override
    public void displayInfoAboutListOfFigures(List<Point> figures) {
        int index = 0;
        System.out.println("\nLogs about list of points: ");
        do {
            LOGGER.info("The {} point{}", (index + 1), figures.get(index));
            index++;
        } while (index < figures.size());
    }

    public double calcLengthBetweenTwoPoints(Point firstPoint, Point secondPoint) {
        int deltaX = secondPoint.getX() - firstPoint.getX();
        int deltaY = secondPoint.getY() - firstPoint.getY();

        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
}
