package com.epam.jwd.shapes.storage.api;

import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigure;
import com.epam.jwd.shapes.model.simple.impl.Point;
import java.util.List;

public interface FigureCrud {
    PolygonalFigure createFigure(String figureType, Point... points) throws FigureException;
    void multiCreateFigure(String figureType, List<Point[]> listOfPoints) throws FigureException;
    void deleteFigure(int figureId);
    List<PolygonalFigure> findFiguresByType(String figureType);
    void updateFigure(int index, PolygonalFigure figure);
    List<PolygonalFigure> findFiguresById(int figureId);

}
