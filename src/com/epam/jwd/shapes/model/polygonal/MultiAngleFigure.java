package com.epam.jwd.shapes.model.polygonal;

import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.simple.Point;
import com.epam.jwd.shapes.strategy.MultiAngleFigureStrategy;
import com.epam.jwd.shapes.strategy.impl.MultiAngleStrategy;

import java.util.Arrays;

public class MultiAngleFigure extends Figure {
    private final Point[] points;

    MultiAngleFigure(Point[] points) {
        super(MultiAngleStrategy.INSTANCE);
        this.points = points;
    }

    @Override
    public MultiAngleFigureStrategy getPolygonalFigureStrategy() {
        return super.getPolygonalFigureStrategy();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiAngleFigure that = (MultiAngleFigure) o;
        return Arrays.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }

    @Override
    public String toString() {
        return "MultiAngleFigure{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    public Point[] getPoints() {
        return points;
    }
}
