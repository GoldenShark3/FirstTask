package com.epam.jwd.model.polygonal;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.simple.Point;
import com.epam.jwd.strategy.MultiAngleFigureStrategy;
import com.epam.jwd.strategy.MultiAngleStrategy;

import java.util.Arrays;

public class MultiAngleFigure extends Figure {
    private Point[] points;

    MultiAngleFigure(Point[] points, MultiAngleStrategy multiAngleStrategy) {
        super(multiAngleStrategy);
        this.points = points;
    }

    @Override
    public MultiAngleFigureStrategy<MultiAngleFigure> getPolygonalFigureStrategy() {
        return (MultiAngleFigureStrategy<MultiAngleFigure>) super.getPolygonalFigureStrategy();
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
