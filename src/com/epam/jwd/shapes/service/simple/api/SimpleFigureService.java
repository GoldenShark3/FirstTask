package com.epam.jwd.shapes.service.simple.api;

import com.epam.jwd.shapes.model.simple.api.SimpleFigure;
import java.util.List;

public interface SimpleFigureService<T extends SimpleFigure> {
    void displayInfoAboutListOfFigures(List<T> simpleFigures);
}
