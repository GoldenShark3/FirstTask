package com.epam.jwd.service;
import com.epam.jwd.model.Line;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LineService {
    private final Logger LOGGER = LogManager.getLogger();

    public boolean isCorrectFigure(Line line) {
        return !line.getFirstPoint().equals(line.getSecondPoint());
    }

    public void displayInfoAboutArrOfLine(Line[] lines) {
        System.out.println("Logs about array of lines: ");
        for (Line line : lines) {
            if (isCorrectFigure(line)) {
                LOGGER.error("{} - is not line", line);
            } else {
                LOGGER.info("{}", line);
            }
        }
    }
}
