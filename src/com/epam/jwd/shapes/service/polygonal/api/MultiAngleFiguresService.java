package com.epam.jwd.shapes.service.polygonal.api;

import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigure;

import java.util.List;

public interface MultiAngleFiguresService<T extends PolygonalFigure>{
    boolean isNotCorrectFigure(T figure);
    boolean isFigureExist(T figure);
    void displayInfoAboutListOfFigures(List<T> figures);
    double calcArea(T figure);
    double calcPerimeter(T figure);
    double[] calcFigureSidesLength(T figure);
}
