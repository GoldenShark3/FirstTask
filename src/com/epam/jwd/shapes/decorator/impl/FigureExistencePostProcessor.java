package com.epam.jwd.shapes.decorator.impl;

import com.epam.jwd.shapes.exception.FigureNotExistException;
import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.polygonal.MultiAngleFigure;
import com.epam.jwd.shapes.model.polygonal.Square;
import com.epam.jwd.shapes.model.polygonal.Triangle;
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
    public Figure process(Figure figure) throws FigureNotExistException {
        if (figure instanceof Triangle) {
            Triangle triangle = (Triangle) figure;
            if (!(TRIANGLE_SERVICE.isFigureExist(triangle))) {
                throw new FigureNotExistException(triangle + " - Figure can't exist");
            } else {
                return figure;
            }
        }

        if (figure instanceof Square) {
            Square square = (Square) figure;
            if (!SQUARE_SERVICE.isFigureExist(square)) {
                throw new FigureNotExistException(square + " - Figure can't exist");
            } else {
                return figure;
            }
        }

        MultiAngleFigure multiAngleFigure = (MultiAngleFigure) figure;
        if (!MULTI_ANGLE_SERVICE.isFigureExist(multiAngleFigure)){
            throw new FigureNotExistException(multiAngleFigure + " - Figure can't exist");
        }else {
            return figure;
        }
    }
}
