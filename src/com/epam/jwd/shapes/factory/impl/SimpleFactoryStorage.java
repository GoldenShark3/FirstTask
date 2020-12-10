package com.epam.jwd.shapes.factory.impl;

import com.epam.jwd.shapes.factory.api.FactoryStorage;
import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.polygonal.MultiAngleFigure;
import com.epam.jwd.shapes.model.polygonal.Square;
import com.epam.jwd.shapes.model.polygonal.Triangle;
import java.util.ArrayList;
import java.util.List;

public class SimpleFactoryStorage implements FactoryStorage {
    private static final List<Figure> ALL_CREATED_FIGURES = new ArrayList<>();
    private static SimpleFactoryStorage instance;

    private SimpleFactoryStorage() {
    }

    public static SimpleFactoryStorage getInstance() {
        if (instance == null) {
            instance = new SimpleFactoryStorage();
        }
        return instance;
    }

    @Override
    public Figure fetchOrAddFigure(Figure figure) {
        if (figure instanceof Triangle) {
            return checkTriangleInCache(figure);
        } else if (figure instanceof Square) {
            return checkSquareInCache(figure);
        }
        return checkMultiAngleFigureInCache(figure);
    }

    private Figure checkTriangleInCache(Figure figure) {
        for (Figure figureFromCache : ALL_CREATED_FIGURES) {
            if (figureFromCache instanceof Triangle) {
                Triangle triangle = (Triangle) figureFromCache;
                if (triangle.equals(figure)) {
                    return triangle;
                }
            }
        }
        ALL_CREATED_FIGURES.add(figure);
        return figure;
    }

    private Figure checkSquareInCache(Figure figure) {
        for (Figure figureFromCache : ALL_CREATED_FIGURES) {
            if (figureFromCache instanceof Square) {
                Square square = (Square) figureFromCache;
                if (square.equals(figure)) {
                    return square;
                }
            }
        }
        ALL_CREATED_FIGURES.add(figure);
        return figure;
    }

    private Figure checkMultiAngleFigureInCache(Figure figure) {
        for (Figure figureFromCache : ALL_CREATED_FIGURES) {
            if (figureFromCache instanceof MultiAngleFigure) {
                MultiAngleFigure multiAngleFigure = (MultiAngleFigure) figureFromCache;
                if (multiAngleFigure.equals(figure)) {
                    return multiAngleFigure;
                }
            }
        }
        ALL_CREATED_FIGURES.add(figure);
        return figure;
    }
}
