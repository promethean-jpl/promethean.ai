package ai.promethean.LoggerTest;

import ai.promethean.API.*;
import ai.promethean.DataModel.BooleanProperty;
import ai.promethean.Logger.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTest {

    @Test
    void testErrorLogging(){

        BooleanProperty bp = new BooleanProperty("bool", true);
        BooleanProperty impact = new BooleanProperty("impact", false);

        // Trying to read the files after throwing an error led to nasty race conditions
        // But I can still check if logging the errors affects how errors are thrown
        for (int i = 0; i < 2; i++) {
            assertThrows(CLIError.class, () ->{
                API.throwCLIError("test CLI error");
            });

            assertThrows(OutputError.class, () -> {
                API.throwOutputError("test output error");
            });

            assertThrows(ParserError.class, () ->{
                API.throwParserError("test parser error");
            });

            assertThrows(PlannerError.class, () -> {
                API.throwPlannerError("test planner error");
            });

            assertThrows(IllegalArgumentException.class, () ->{
                bp.applyImpact(impact);
            });

            Logger.logFlag = !Logger.logFlag;
        }

        Logger.logFlag = false;
    }
}
