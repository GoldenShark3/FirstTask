package com.epam.jwd.shapes.service;

import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.model.Figure;

public interface FigurePostProcessor {
    Figure process(Figure figure) throws FigureException;
}
