package com.epam.jwd.model;
import java.util.LinkedList;

public class PointFactory {

    private final static LinkedList<Point> ALL_CREATED_POINTS = new LinkedList<>();

    public Point createPoint(int x, int y) {
        for (Point point : ALL_CREATED_POINTS) {
            if (point.getX() == x && point.getY() == y) {
                return point;
            }
        }
        final Point point = new Point(x, y);
        ALL_CREATED_POINTS.add(point);
        return point;
    }

}
