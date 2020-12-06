package com.epam.jwd.shapes.service.polygonal;

import com.epam.jwd.shapes.model.Figure;

public interface MultiAngleFiguresService{
    boolean isNotCorrectFigure(Figure figure);
    boolean isFigureExist(Figure figure);
    void displayInfoAboutArrOfFigures(Figure[] figures);
    double calcArea(Figure figure);
    double calcPerimeter(Figure figure);
    double[] calcFigureSidesLength(Figure figure);
}
