package com.epam.jwd.shapes.decorator.impl;

import com.epam.jwd.shapes.exception.FigureNotExistException;
import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigure;
import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigureType;
import com.epam.jwd.shapes.model.polygonal.impl.MultiAngleFigure;
import com.epam.jwd.shapes.model.polygonal.impl.Square;
import com.epam.jwd.shapes.model.polygonal.impl.Triangle;
import com.epam.jwd.shapes.decorator.api.FigurePostProcessor;
import com.epam.jwd.shapes.service.polygonal.impl.MultiAngleService;
import com.epam.jwd.shapes.service.polygonal.impl.SquareService;
import com.epam.jwd.shapes.service.polygonal.impl.TriangleService;

public final class FigureExistencePostProcessor implements FigurePostProcessor {
    public final static FigureExistencePostProcessor INSTANCE = new FigureExistencePostProcessor();
    private final static MultiAngleService MULTI_ANGLE_SERVICE = MultiAngleService.INSTANCE;
    private final static TriangleService TRIANGLE_SERVICE = TriangleService.INSTANCE;
    private final static SquareService SQUARE_SERVICE = SquareService.INSTANCE;

    private FigureExistencePostProcessor() {

    }

    @Override
    public PolygonalFigure process(PolygonalFigure polygonalFigure) throws FigureNotExistException {
        if (polygonalFigure.getFigureType() == PolygonalFigureType.TRIANGLE) {
            Triangle triangle = (Triangle) polygonalFigure;
            if (!(TRIANGLE_SERVICE.isFigureExist(triangle))) {
                throw new FigureNotExistException(triangle + " - Figure can't exist");
            } else {
                return polygonalFigure;
            }
        }

        if (polygonalFigure.getFigureType() == PolygonalFigureType.SQUARE) {
            Square square = (Square) polygonalFigure;
            if (!SQUARE_SERVICE.isFigureExist(square)) {
                throw new FigureNotExistException(square + " - Figure can't exist");
            } else {
                return polygonalFigure;
            }
        }

        MultiAngleFigure multiAngleFigure = (MultiAngleFigure) polygonalFigure;
        if (!MULTI_ANGLE_SERVICE.isFigureExist(multiAngleFigure)){
            throw new FigureNotExistException(multiAngleFigure + " - Figure can't exist");
        }else {
            return polygonalFigure;
        }
    }
}
