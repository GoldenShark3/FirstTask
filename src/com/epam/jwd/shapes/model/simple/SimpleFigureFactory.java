package com.epam.jwd.shapes.model.simple;

import com.epam.jwd.shapes.model.SimpleFigure;

public final class SimpleFigureFactory {
    private static int index = 0;
    private static SimpleFigure[] allCreatedSimpleFigure = new SimpleFigure[10];
    private static SimpleFigureFactory instance;

    private SimpleFigureFactory() {

    }

    public static SimpleFigureFactory getInstance() {
        if (instance == null) {
            return instance = new SimpleFigureFactory();
        }
        return instance;
    }

    public Point createPoint(int x, int y) {
        for (SimpleFigure figure : allCreatedSimpleFigure) {
            if (figure instanceof Point) {
                Point point = (Point) figure;
                if (point.getX() == x && point.getY() == y) {
                    return point;
                }
            }
        }
        return createNewPoint(x, y);
    }

    public Line createLine(Point firstPoint, Point secondPoint) {
        if (index == allCreatedSimpleFigure.length - 1) {
            increaseCacheSize();
        }

        for (SimpleFigure figure : allCreatedSimpleFigure) {
            if (figure instanceof Line) {
                Line line = (Line) figure;
                if (line.getFirstPoint().equals(firstPoint) && line.getSecondPoint().equals(secondPoint)) {
                    return line;
                }
            }
        }
        return createNewLine(firstPoint, secondPoint);
    }

    private Point createNewPoint(int x, int y) {
        if (index == allCreatedSimpleFigure.length - 1) {
            increaseCacheSize();
        }

        Point point = new Point(x, y);
        allCreatedSimpleFigure[index] = point;
        index++;

        return point;
    }

    private Line createNewLine(Point firstPoint, Point secondPoint) {
        if (index == allCreatedSimpleFigure.length - 1) {
            increaseCacheSize();
        }
        Line line = new Line(firstPoint, secondPoint);
        allCreatedSimpleFigure[index] = line;
        index++;
        return line;
    }

    private void increaseCacheSize() {
        SimpleFigure[] tempArr = allCreatedSimpleFigure;
        allCreatedSimpleFigure = new SimpleFigure[(int) (allCreatedSimpleFigure.length * 1.5)];

        System.arraycopy(tempArr, 0, allCreatedSimpleFigure, 0, tempArr.length);
    }
}
