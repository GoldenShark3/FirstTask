package com.epam.jwd.shapes.builder;

import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigureType;

public class PolygonalFigureCriteria {
    private final int figureId;
    private final PolygonalFigureType figureType;
    private final double figureArea;
    private final double figurePerimeter;

    private PolygonalFigureCriteria(int figureId, double figureArea, double figurePerimeter, PolygonalFigureType figureType){
        this.figureId = figureId;
        this.figureArea = figureArea;
        this.figurePerimeter = figurePerimeter;
        this.figureType = figureType;
    }

    public double getFigureArea() {
        return figureArea;
    }

    public double getFigurePerimeter() {
        return figurePerimeter;
    }

    public int getFigureId() {
        return figureId;
    }

    public PolygonalFigureType getFigureType() {
        return figureType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int figureId = -1;
        private PolygonalFigureType figureType;
        private double figureArea = -1;
        private double figurePerimeter = -1;


        public Builder figuresWithId(int figureId) {
            this.figureId = figureId;
            return this;
        }


        public Builder figuresWithType(PolygonalFigureType figureType) {
            this.figureType = figureType;
            return this;
        }

        public Builder figuresWithPerimeter(double figurePerimeter){
            this.figurePerimeter = figurePerimeter;
            return this;
        }

        public Builder figuresWithArea(double figureArea){
            this.figureArea = figureArea;
            return this;
        }

        public PolygonalFigureCriteria build() {
            return new PolygonalFigureCriteria(this.figureId, this.figureArea, this.figurePerimeter, this.figureType);
        }
    }
}
