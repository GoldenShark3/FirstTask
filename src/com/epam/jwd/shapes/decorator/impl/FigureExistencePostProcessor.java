package com.epam.jwd.shapes.decorator.impl;

import com.epam.jwd.shapes.exception.FigureNotExistException;
import com.epam.jwd.shapes.model.Figure;
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
            if (!(TRIANGLE_SERVICE.isFigureExist(figure))) {
                throw new FigureNotExistException(figure + " - Figure can't exist");
            } else {
                return figure;
            }
        }

        if (figure instanceof Square) {
            if (!SQUARE_SERVICE.isFigureExist(figure)) {
                throw new FigureNotExistException(figure + " - Figure can't exist");
            } else {
                return figure;
            }
        }

        if (!MULTI_ANGLE_SERVICE.isFigureExist(figure)){
            throw new FigureNotExistException(figure + " - Figure can't exist");
        }else {
            return figure;
        }
    }
}
