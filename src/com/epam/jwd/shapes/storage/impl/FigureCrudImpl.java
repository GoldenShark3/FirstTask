package com.epam.jwd.shapes.storage.impl;

import com.epam.jwd.shapes.builder.PolygonalFigureCriteria;
import com.epam.jwd.shapes.exception.FigureException;
import com.epam.jwd.shapes.factory.api.FigureFactory;
import com.epam.jwd.shapes.factory.impl.SimpleApplicationContext;
import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigureType;
import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigure;
import com.epam.jwd.shapes.model.simple.impl.Point;
import com.epam.jwd.shapes.storage.api.FigureCrud;
import java.util.List;

public class FigureCrudImpl implements FigureCrud {
    private static FigureCrudImpl instance;
    private final static FigureFactory POLYGONAL_FIGURE_FACTORY = SimpleApplicationContext.INSTANCE.createFigureFactory();
    private final static PolygonalFigureStorage POLYGONAL_FIGURE_STORAGE = PolygonalFigureStorage.getInstance();

    private FigureCrudImpl() {
    }

    public static FigureCrudImpl getInstance() {
        if (instance == null) {
            instance = new FigureCrudImpl();
        }
        return instance;
    }

    @Override
    public PolygonalFigure createFigure(String figureType, Point... points) throws FigureException {
        return POLYGONAL_FIGURE_FACTORY.createFigure(figureType, points);
    }

    @Override
    public void multiCreateFigure(String figureType, List<Point[]> listOfPoints) throws FigureException {
        if (figureType == null || listOfPoints == null || listOfPoints.isEmpty() || "".equals(figureType)) {
            throw new FigureException("List of points or figure type must be not null/empty");
        }
        switch (fetchFigureTypeFromLine(figureType)) {
            case TRIANGLE:
                multiCreateTriangles(listOfPoints);
                break;
            case SQUARE:
                multiCreateSquares(listOfPoints);
                break;
            case MULTI_ANGLE:
                multiCreateMultiAngleFigures(listOfPoints);
                break;
        }
    }

    @Override
    public void deleteFigure(int figureId) throws IllegalArgumentException {
        if (figureId < 0) {
            throw new IllegalArgumentException("Figure ID must be > 0");
        }
        POLYGONAL_FIGURE_STORAGE.removeFigure(figureId);
    }

    @Override
    public List<PolygonalFigure> findFiguresByType(String figureType) throws IllegalArgumentException {
        if (figureType == null || figureType.equals("")) {
            throw new IllegalArgumentException("The value passed must be not null");
        }
        PolygonalFigureType typeOfFigure = fetchFigureTypeFromLine(figureType);
        return POLYGONAL_FIGURE_STORAGE.fetchFiguresFromCache(typeOfFigure);
    }

    @Override
    public void updateFigure(int index, PolygonalFigure figure) throws IllegalArgumentException {
        if (index < 0 || figure == null) {
            throw new IllegalArgumentException("The value of ID and figure must be not null");
        }
        POLYGONAL_FIGURE_STORAGE.updateFigure(index, figure);
    }

    @Override
    public List<PolygonalFigure> findFiguresById(int figureId) throws IllegalArgumentException {
        if (figureId < 0) {
            throw new IllegalArgumentException("Figure ID must be > 0");
        }
        return POLYGONAL_FIGURE_STORAGE.findFigures(figureId);
    }

    public PolygonalFigure fetchFigureFromStorage(PolygonalFigure figure) {
        return POLYGONAL_FIGURE_STORAGE.fetchOrAddFigure(figure);
    }

    public List<? extends PolygonalFigure> findFiguresByCriteria(PolygonalFigureCriteria criteria) {
        if (criteria == null) {
            throw new IllegalArgumentException("Criteria must be not null");
        }
        return POLYGONAL_FIGURE_STORAGE.figuresByCriteria(criteria);
    }

    private PolygonalFigureType fetchFigureTypeFromLine(String figureType) throws IllegalArgumentException {
        figureType = figureType.toLowerCase().trim();
        switch (figureType) {
            case "triangle":
                return PolygonalFigureType.TRIANGLE;
            case "square":
                return PolygonalFigureType.SQUARE;
            case "multiangle":
                return PolygonalFigureType.MULTI_ANGLE;
            default:
                throw new IllegalArgumentException(figureType + "this type of figure does not exist");
        }
    }

    private void multiCreateTriangles(List<Point[]> listOfPoints) throws FigureException {
        for (Point[] arrOfPoints : listOfPoints) {
            POLYGONAL_FIGURE_FACTORY.createFigure("triangle", arrOfPoints);
        }
    }

    private void multiCreateSquares(List<Point[]> listOfPoints) throws FigureException {
        for (Point[] arrOfPoints : listOfPoints) {
            POLYGONAL_FIGURE_FACTORY.createFigure("square", arrOfPoints);
        }
    }

    private void multiCreateMultiAngleFigures(List<Point[]> listOfPoints) throws FigureException {
        for (Point[] arrOfPoints : listOfPoints) {
            POLYGONAL_FIGURE_FACTORY.createFigure("multiangle", arrOfPoints);
        }
    }
}
