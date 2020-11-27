package com.epam.jwd.model;

import java.util.LinkedList;

public class LineFactory {

    private final static LinkedList<Line> ALL_CREATED_LINES = new LinkedList<>();

    public Line createLine(Point firstPoint, Point secondPoint) {
        for (Line line : ALL_CREATED_LINES) {
            if (line.getFirstPoint().equals(firstPoint) && line.getSecondPoint().equals(secondPoint)) {
                return line;
            }
        }
        Line line = new Line(firstPoint, secondPoint);
        ALL_CREATED_LINES.add(line);
        return line;
    }

}
