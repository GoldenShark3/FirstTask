package com.epam.jwd.shapes.strategy;

import com.epam.jwd.shapes.model.Figure;

public interface MultiAngleFigureStrategy{
    double calcArea(Figure figure);
    double calcPerimeter(Figure figure);
}
