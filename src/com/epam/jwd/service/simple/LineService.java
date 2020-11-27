package com.epam.jwd.service.simple;
import com.epam.jwd.model.simple.Line;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LineService {
    private final Logger LOGGER = LogManager.getLogger(LineService.class);

    public boolean isNotCorrectFigure(Line line) {
        return line.getFirstPoint().equals(line.getSecondPoint());
    }

    public void displayInfoAboutArrOfLine(Line[] lines) {
        System.out.println("\nLogs about array of lines: ");
        for (Line line : lines) {
            if (isNotCorrectFigure(line)) {
                LOGGER.error("{} - is not line", line);
            } else {
                LOGGER.info("{}", line);
            }
        }
    }
}
