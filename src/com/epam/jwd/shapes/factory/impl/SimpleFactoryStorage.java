package com.epam.jwd.shapes.factory.impl;

import com.epam.jwd.shapes.factory.api.FactoryStorage;
import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.polygonal.MultiAngleFigure;
import com.epam.jwd.shapes.model.polygonal.Square;
import com.epam.jwd.shapes.model.polygonal.Triangle;

public class SimpleFactoryStorage implements FactoryStorage {
    private static Figure[] allCreatedFigures = new Figure[10];
    private static int numOfFigures = 0;
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
        if (numOfFigures == allCreatedFigures.length - 1) {
            increaseCacheSize();
        }

        if (figure instanceof Triangle) {
            return fetchTriangleFromCache(figure);
        } else if (figure instanceof Square) {
            return fetchSquareFromCache(figure);
        }
        return fetchMultiAngleFigureFromCache(figure);
    }

    private Figure fetchTriangleFromCache(Figure figure) {
        for (Figure figureFromCache : allCreatedFigures) {
            if (figureFromCache instanceof Triangle) {
                Triangle triangle = (Triangle) figureFromCache;
                if (triangle.equals(figure)) {
                    return triangle;
                }
            }
        }
        allCreatedFigures[numOfFigures] = figure;
        return figure;
    }

    private Figure fetchSquareFromCache(Figure figure) {
        for (Figure figureFromCache : allCreatedFigures) {
            if (figureFromCache instanceof Square) {
                Square square = (Square) figureFromCache;
                if (square.equals(figure)) {
                    return square;
                }
            }
        }
        allCreatedFigures[numOfFigures++] = figure;
        return figure;
    }

    private Figure fetchMultiAngleFigureFromCache(Figure figure) {
        for (Figure figureFromCache : allCreatedFigures) {
            if (figureFromCache instanceof MultiAngleFigure) {
                MultiAngleFigure multiAngleFigure = (MultiAngleFigure) figureFromCache;
                if (multiAngleFigure.equals(figure)) {
                    return multiAngleFigure;
                }
            }
        }
        allCreatedFigures[numOfFigures++] = figure;
        return figure;
    }

    private void increaseCacheSize() {
        Figure[] tempArr = allCreatedFigures;
        allCreatedFigures = new Figure[(int) (allCreatedFigures.length * 1.5)];
        System.arraycopy(tempArr, 0, allCreatedFigures, 0, tempArr.length);
    }
}
