package ru.geekbrains.springhw6.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class MyLoggingAspect {
    private final Logger logger = Logger.getLogger(MyLoggingAspect.class.getName());

    @AfterReturning(value = "@annotation(TrackUserAction))", returning = "returnedValue")
    public void log(JoinPoint joinPoint, Object returnedValue) {
        // Получаем информацию о методе
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        Object[] methodArgs = joinPoint.getArgs();

        /* Подсказки для будущих проектов)
        // Цвета текста
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_WHITE = "\u001B[37m";

        // Цвета фона
        String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        String ANSI_RED_BACKGROUND = "\u001B[41m";
        String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        String ANSI_WHITE_BACKGROUND = "\u001B[47m";
         */

        // ANSI Escape Code для сброса цвета
        String ANSI_RESET = "\u001B[0m";

        String myColorStart = "\u001B[43;30m";  // Черный текст на жёлтом фоне
        String myColor1 = "\u001B[32m";
        String myColor2 = "\u001B[35m";
        String myColor3 = "\u001B[36m";
        String myColor4 = "\u001B[34m";
        String myColorEND = "\u001B[43;30m";

        // Выводим нужную информацию в консоль в виде loga
        logger.info(myColorStart + "Информация логирования: " + ANSI_RESET);
        logger.info(myColor1 + "Вызванный метод: " + ANSI_RESET + methodName);
        logger.info(myColor2 + "Класс: " + ANSI_RESET + className);
        logger.info(myColor3 + "Аргументы: " + ANSI_RESET + Arrays.toString(methodArgs));
        logger.info(myColor4 + "Метод отработал и вернул значение: " + ANSI_RESET + returnedValue);
        logger.info(myColorEND + "Конец блока логирования. " + ANSI_RESET);
    }

}
