package com.epam.jwd.model.polygonal;

import com.epam.jwd.model.simple.Point;
import com.epam.jwd.strategy.MultiAngleFigureStrategy;
import com.epam.jwd.strategy.MultiAngleStrategy;

public class Square extends MultiAngleFigure {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Point fourthPoint;

    Square(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint, MultiAngleStrategy multiAngleStrategy) {
        super(new Point[]{firstPoint, secondPoint, thirdPoint, fourthPoint}, multiAngleStrategy);
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.fourthPoint = fourthPoint;
    }

    @Override
    public MultiAngleFigureStrategy<MultiAngleFigure> getPolygonalFigureStrategy() {
        return super.getPolygonalFigureStrategy();
    }

    @Override
    public String toString() {
        return "Square{" +
                "firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                ", thirdPoint=" + thirdPoint +
                ", fourthPoint=" + fourthPoint +
                '}';
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public Point getFourthPoint() {
        return fourthPoint;
    }

}
