package com.epam.jwd.service.polygonal;

public abstract class MultiAngleFiguresService<T> {
    public abstract boolean isNotCorrectFigure(T figure);
    public abstract boolean isFigureExist(T figure);
    public abstract void displayInfoAboutArrOfFigures(T[] figures);
    public abstract double calcArea(T figure);
    public abstract double calcPerimeter(T figure);
    public abstract double[] calcFigureSidesLength(T figure);
}
