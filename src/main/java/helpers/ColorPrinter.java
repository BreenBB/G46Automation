package helpers;

import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;

import static helpers.ConsoleColors.*;

public class ColorPrinter {

    @Step("Выводим открашенный текст")
    public static void printMessageInColor(String message, String color){
        System.out.println(color + message + RESET);
    }

    @Step("Выводим открашенный текст")
    public static void printMessageInColor(String message, String color, Logger logger){
        logger.info(color + message + RESET);
    }

    public static void printColorMessage(String message, Logger logger, Level level){
        switch (level){
            case INFO:
                logger.info(GREEN + message + RESET);
                break;
            case DEBUG:
                logger.debug(BLUE + message + RESET);
                break;
            case ERROR:
                logger.error(RED + message + RESET);
        }
    }

}
