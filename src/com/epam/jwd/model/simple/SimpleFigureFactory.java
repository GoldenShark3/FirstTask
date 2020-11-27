package com.epam.jwd.model.simple;

import com.epam.jwd.model.SimpleFigure;

import java.util.LinkedList;

public class SimpleFigureFactory {

    private static final LinkedList<SimpleFigure> ALL_CREATED_SIMPLE_FIGURE = new LinkedList<>();

    public Point createPoint(int x, int y) {
        for (SimpleFigure figure : ALL_CREATED_SIMPLE_FIGURE) {
            if (figure instanceof Point) {
                Point point = (Point) figure;
                if (point.getX() == x && point.getY() == y) {
                    return point;
                }
            }
        }
        final Point point = new Point(x, y);
        ALL_CREATED_SIMPLE_FIGURE.add(point);
        return point;
    }

    public Line createLine(Point firstPoint, Point secondPoint) {
        for (SimpleFigure figure : ALL_CREATED_SIMPLE_FIGURE) {
            if (figure instanceof Line) {
                Line line = (Line) figure;
                if (line.getFirstPoint().equals(firstPoint) && line.getSecondPoint().equals(secondPoint)) {
                    return line;
                }
            }
        }
        Line line = new Line(firstPoint, secondPoint);
        ALL_CREATED_SIMPLE_FIGURE.add(line);
        return line;
    }
}
