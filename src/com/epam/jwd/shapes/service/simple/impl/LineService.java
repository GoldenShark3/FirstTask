package com.epam.jwd.shapes.service.simple.impl;
import com.epam.jwd.shapes.model.SimpleFigure;
import com.epam.jwd.shapes.model.simple.Line;
import com.epam.jwd.shapes.service.simple.SimpleFigureService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LineService implements SimpleFigureService {
    private final Logger LOGGER = LogManager.getLogger(LineService.class);
    public final static LineService INSTANCE = new LineService();

    private LineService() {

    }

    public boolean isNotCorrectFigure(Line line) {
        return line.getFirstPoint().equals(line.getSecondPoint());
    }

    @Override
    public void displayInfoAboutArrOfFigures(SimpleFigure[] simpleFigures) {
        System.out.println("\nLogs about array of lines: ");
        for (SimpleFigure line : simpleFigures) {
            if (isNotCorrectFigure( (Line)line)) {
                LOGGER.error("{} - is not line", line);
            } else {
                LOGGER.info("{}", line);
            }
        }
    }
}
