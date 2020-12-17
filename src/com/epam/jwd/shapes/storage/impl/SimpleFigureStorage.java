package com.epam.jwd.shapes.storage.impl;

import com.epam.jwd.shapes.model.simple.api.SimpleFigure;
import com.epam.jwd.shapes.model.simple.impl.Line;
import com.epam.jwd.shapes.model.simple.impl.Point;
import com.epam.jwd.shapes.storage.api.FigureStorage;
import java.util.ArrayList;
import java.util.List;

public class SimpleFigureStorage implements FigureStorage<SimpleFigure>  {
    private static final List<SimpleFigure> ALL_CREATED_SIMPLE_FIGURES = new ArrayList<>();


    @Override
    public SimpleFigure fetchOrAddFigure(SimpleFigure figure) {
        if(figure instanceof Point){
            return checkPointInCache(figure);
        }else{
            return checkLineInCache(figure);
        }
    }

    private SimpleFigure checkPointInCache(SimpleFigure figure) {
        for (SimpleFigure figureFromCache : ALL_CREATED_SIMPLE_FIGURES) {
            if (figureFromCache instanceof Point) {
                Point point = (Point) figureFromCache;
                if (point.equals(figure)) {
                    return point;
                }
            }
        }
        ALL_CREATED_SIMPLE_FIGURES.add(figure);
        return figure;
    }

    private SimpleFigure checkLineInCache(SimpleFigure figure) {
        for (SimpleFigure figureFromCache : ALL_CREATED_SIMPLE_FIGURES) {
            if (figureFromCache instanceof Line) {
                Line line = (Line) figureFromCache;
                if (line.equals(figure)) {
                    return line;
                }
            }
        }
        ALL_CREATED_SIMPLE_FIGURES.add(figure);
        return figure;
    }
}
