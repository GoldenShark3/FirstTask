package com.epam.jwd.shapes.service.simple;
import com.epam.jwd.shapes.model.simple.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class PointService {
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

    public void displayInfoAboutArrOfPoints(Point[] points) {
        int index = 0;
        System.out.println("Logs about array of points: ");
        do {
            LOGGER.info("The {} point{}", (index + 1), points[index]);
            index++;
        } while (index < points.length);
    }
}
