package com.epam.jwd.shapes.storage.api;

import com.epam.jwd.shapes.model.Figure;

public interface FigureStorage<T extends Figure> {
   T fetchOrAddFigure(T figure);
}
