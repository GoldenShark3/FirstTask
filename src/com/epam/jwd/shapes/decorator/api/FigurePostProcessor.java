package com.epam.jwd.shapes.decorator.api;

import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.model.Figure;

public interface FigurePostProcessor {
    Figure process(Figure figure) throws FigureException;
}
