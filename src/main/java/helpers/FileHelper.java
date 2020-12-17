package helpers;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FileHelper {

    private final static Logger LOG = LogManager.getLogger("Помошник работы с файлами");

    public static List<String> readLinesFromFile(String path){
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            LOG.error(String.format("Проблема с файлом %s: %s", path, e.getMessage()));
            return new ArrayList<>();
        }
    }

    @Step("Считываем данные из текстового файла")
    public static Collection<Object[]> readIssuesDataFromFile(String path){
        Collection<Object[]> result = new ArrayList<>();
        List<String> lines = readLinesFromFile(path);
        LOG.info("Начинаем считывать данные в текстовом файле");
        for (String line : lines){
            LOG.debug("считываем рядок");
            String[] testData = line.split(", ");
            List<String> labels = new ArrayList<>();
            LOG.debug("Цикл считывания данных из рядка: ");
            for (String label: testData){
                LOG.debug("Данные: " + label);
                if (!testData[0].equals(label) || !testData[1].equals(label)){
                    labels.add(label);
                }
            }
            LOG.debug("Добавляем результат");
            result.add(new Object[]{testData[0], testData[1], labels});
        }
        LOG.debug("Заканчиваем считывание");
        return result;
    }
}
