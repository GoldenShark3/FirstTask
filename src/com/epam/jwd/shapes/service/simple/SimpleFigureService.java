package com.epam.jwd.shapes.service.simple;

import com.epam.jwd.shapes.model.SimpleFigure;
import java.util.List;

public interface SimpleFigureService<T extends SimpleFigure> {
    void displayInfoAboutListOfFigures(List<T> simpleFigures);
}
