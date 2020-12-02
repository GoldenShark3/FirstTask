package com.epam.jwd.shapes.strategy;

import com.epam.jwd.shapes.model.polygonal.MultiAngleFigure;

public interface MultiAngleFigureStrategy{
    double calcArea(MultiAngleFigure figure);
    double calcPerimeter(MultiAngleFigure figure);
}
