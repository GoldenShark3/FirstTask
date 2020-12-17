package com.epam.jwd.shapes.model.simple.impl;

import com.epam.jwd.shapes.storage.impl.SimpleFigureStorage;

public final class SimpleFigureFactory {
    private static SimpleFigureFactory instance;
    private static final SimpleFigureStorage SIMPLE_FIGURE_STORAGE = new SimpleFigureStorage();

    private SimpleFigureFactory() {

    }

    public static SimpleFigureFactory getInstance() {
        if (instance == null) {
            return instance = new SimpleFigureFactory();
        }
        return instance;
    }

    public Point createPoint(int x, int y) {
        Point point = new Point(x ,y);
        point = (Point) SIMPLE_FIGURE_STORAGE.fetchOrAddFigure(point);
        return point;
    }

    public Line createLine(Point firstPoint, Point secondPoint) {
        Line line = new Line(firstPoint, secondPoint);
        line = (Line) SIMPLE_FIGURE_STORAGE.fetchOrAddFigure(line);
        return line;
    }

}
