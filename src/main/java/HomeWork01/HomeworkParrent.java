package HomeWork01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class HomeworkParrent {

    private final Logger LOG = LogManager.getLogger(HomeworkParrent.name);

    protected static String name;

    HomeworkParrent(String name) {
        HomeworkParrent.name=name;
    }

    public void splitList(List<String> inputlist){
            LOG.debug("Метод splitList принимает List<String> и через split() разделяет слова на отдельые массивы и при помощи второго цикла выводит каждый элемент массивов слов.");
        try {
            for(int i = 0; i<inputlist.size(); i++){

                LOG.debug("Получаем элемент " + inputlist.get(i) + " из листа " + inputlist);
                String str = inputlist.get(i);
                LOG.debug("Делаем из слова " + inputlist.get(i) + " массив с каждым симолом ввиде отдельного элемента при помощи String.split()" );
                String[] split = str.split("");

                LOG.info("Элемент №" + i + ":");
                for(String number : split){
                    LOG.info(number);
                }
            }
        } catch(Exception e){
            if (e instanceof NullPointerException) {
                LOG.error("Массив не определён. Пожалуйста проверьте корректность вводимых значений.");
            } else {
                LOG.error("Произошла неизвестная ошибка. Подробнее: " + e);
            }
        }
    }

    public void printText(){
        LOG.info(name + " :Выведен текст.");
    }

}
