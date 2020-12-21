package com.epam.jwd.shapes.storage.impl;

import com.epam.jwd.shapes.builder.PolygonalFigureCriteria;
import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigure;
import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigureType;
import com.epam.jwd.shapes.model.polygonal.impl.MultiAngleFigure;
import com.epam.jwd.shapes.model.polygonal.impl.Square;
import com.epam.jwd.shapes.model.polygonal.impl.Triangle;
import com.epam.jwd.shapes.storage.api.FigureStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class PolygonalFigureStorage implements FigureStorage<PolygonalFigure> {
    private static final List<PolygonalFigure> ALL_CREATED_FIGURES = new ArrayList<>();
    private static PolygonalFigureStorage instance;

    private PolygonalFigureStorage() {
    }

    public static PolygonalFigureStorage getInstance() {
        if (instance == null) {
            instance = new PolygonalFigureStorage();
        }
        return instance;
    }

    @Override
    public PolygonalFigure fetchOrAddFigure(PolygonalFigure polygonalFigure) {
        switch(polygonalFigure.getFigureType()) {
            case TRIANGLE:
                return checkTriangleInCache(polygonalFigure);
            case SQUARE:
                return checkSquareInCache(polygonalFigure);
            case MULTI_ANGLE:
                return checkMultiAngleFigureInCache(polygonalFigure);
            default:
                throw new IllegalArgumentException(polygonalFigure.getFigureType() + "this type does not exist");
        }
    }

    public void removeFigure(int figureId) {
        PolygonalFigure figure = ALL_CREATED_FIGURES.stream()
                .filter((figureFromStorage) -> figureFromStorage.getID() == figureId)
                .findFirst()
                .orElse(null);

        ALL_CREATED_FIGURES.remove(figure);
    }

    public List<PolygonalFigure> findFigures(int figureId) {
        return ALL_CREATED_FIGURES.stream()
                .filter((figureFromStorage) -> figureFromStorage.getID() == figureId)
                .collect(Collectors.toList());
    }

    public void updateFigure(int index, PolygonalFigure figure) {
        ALL_CREATED_FIGURES.set(index, figure);
    }

    public List<PolygonalFigure> fetchFiguresFromCache(PolygonalFigureType figureType) {
        return ALL_CREATED_FIGURES.stream()
                .filter((figureFromCache) -> figureFromCache.getFigureType().equals(figureType))
                .collect(Collectors.toList());
    }

    public List<? extends PolygonalFigure> figuresByCriteria(PolygonalFigureCriteria figureCriteria) {
        return ALL_CREATED_FIGURES.stream()
                .filter(figure -> figureCriteria.getFigureType() == null
                        || figureCriteria.getFigureType() == figure.getFigureType())
                .filter(figure -> figureCriteria.getFigureId() == -1
                        || figureCriteria.getFigureId() == figure.getID())
                .filter(figure -> figureCriteria.getFigurePerimeter() == -1
                        || figureCriteria.getFigurePerimeter() == figure.getPolygonalFigureStrategy().calcPerimeter(figure))
                .filter(figure -> figureCriteria.getFigureArea() == -1
                        || figureCriteria.getFigureArea() == figure.getPolygonalFigureStrategy().calcArea(figure))
                .collect(Collectors.toList());
    }

    private PolygonalFigure checkTriangleInCache(PolygonalFigure polygonalFigure) {
        for (PolygonalFigure polygonalFigureFromCache : ALL_CREATED_FIGURES) {
            if (polygonalFigureFromCache instanceof Triangle) {
                Triangle triangle = (Triangle) polygonalFigureFromCache;
                if (triangle.equals(polygonalFigure)) {
                    return triangle;
                }
            }
        }
        ALL_CREATED_FIGURES.add(polygonalFigure);
        return polygonalFigure;
    }

    private PolygonalFigure checkSquareInCache(PolygonalFigure polygonalFigure) {
        for (PolygonalFigure polygonalFigureFromCache : ALL_CREATED_FIGURES) {
            if (polygonalFigureFromCache instanceof Square) {
                Square square = (Square) polygonalFigureFromCache;
                if (square.equals(polygonalFigure)) {
                    return square;
                }
            }
        }
        ALL_CREATED_FIGURES.add(polygonalFigure);
        return polygonalFigure;
    }

    private PolygonalFigure checkMultiAngleFigureInCache(PolygonalFigure polygonalFigure) {
        for (PolygonalFigure polygonalFigureFromCache : ALL_CREATED_FIGURES) {
            if (polygonalFigureFromCache instanceof MultiAngleFigure) {
                MultiAngleFigure multiAngleFigure = (MultiAngleFigure) polygonalFigureFromCache;
                if (multiAngleFigure.equals(polygonalFigure)) {
                    return multiAngleFigure;
                }
            }
        }
        ALL_CREATED_FIGURES.add(polygonalFigure);
        return polygonalFigure;
    }
}
