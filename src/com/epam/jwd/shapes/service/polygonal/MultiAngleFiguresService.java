package com.epam.jwd.shapes.service.polygonal;

import com.epam.jwd.shapes.model.polygonal.MultiAngleFigure;

public interface MultiAngleFiguresService{
    boolean isNotCorrectFigure(MultiAngleFigure figure);
    boolean isFigureExist(MultiAngleFigure figure);
    void displayInfoAboutArrOfFigures(MultiAngleFigure[] figures);
    double calcArea(MultiAngleFigure figure);
    double calcPerimeter(MultiAngleFigure figure);
    double[] calcFigureSidesLength(MultiAngleFigure figure);
}
