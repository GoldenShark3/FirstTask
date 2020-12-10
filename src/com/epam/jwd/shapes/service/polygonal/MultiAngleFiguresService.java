package com.epam.jwd.shapes.service.polygonal;

import com.epam.jwd.shapes.model.Figure;

import java.util.List;

public interface MultiAngleFiguresService<T extends Figure>{
    boolean isNotCorrectFigure(T figure);
    boolean isFigureExist(T figure);
    void displayInfoAboutListOfFigures(List<T> figures);
    double calcArea(T figure);
    double calcPerimeter(T figure);
    double[] calcFigureSidesLength(T figure);
}
