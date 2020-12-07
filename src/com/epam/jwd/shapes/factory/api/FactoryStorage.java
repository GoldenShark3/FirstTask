package com.epam.jwd.shapes.factory.api;

import com.epam.jwd.shapes.model.Figure;

public interface FactoryStorage {
   Figure fetchOrAddFigure(Figure figure);
}
