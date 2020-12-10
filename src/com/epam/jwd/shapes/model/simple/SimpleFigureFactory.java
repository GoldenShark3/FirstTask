package com.epam.jwd.shapes.model.simple;

import com.epam.jwd.shapes.model.SimpleFigure;
import java.util.ArrayList;
import java.util.List;

public final class SimpleFigureFactory {
    private static final List<SimpleFigure> ALL_CREATED_SIMPLE_FIGURES = new ArrayList<>();
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
        for (SimpleFigure figure : ALL_CREATED_SIMPLE_FIGURES) {
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
        for (SimpleFigure figure : ALL_CREATED_SIMPLE_FIGURES) {
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
        Point point = new Point(x, y);
        ALL_CREATED_SIMPLE_FIGURES.add(point);
        return point;
    }

    private Line createNewLine(Point firstPoint, Point secondPoint) {
        Line line = new Line(firstPoint, secondPoint);
        ALL_CREATED_SIMPLE_FIGURES.add(line);
        return line;
    }
}
