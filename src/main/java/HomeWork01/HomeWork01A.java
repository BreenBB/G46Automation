package HomeWork01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class HomeWork01A extends HomeworkParrent {

    private final Logger LOG = LogManager.getLogger(HomeWork01A.name);

    //Массив для Задания А
    public String[] sArray = {"F", "D", "Alpha", "C", "Beta", "E"};

    public int number;

    public HomeWork01A(){
        super("Класс А");
        LOG.info("Создан пустой экземпляр класса HomeWork01A");
    }

    HomeWork01A(String name, int number){
        super(name);
        this.number=number;
    }


    public List<String> list() {

        LOG.debug("Метод list переносящий элементы из массива sArray в лист list, выход из цикла когда i == 4." );
        int i = 0;
        List<String> list = new ArrayList<>();

        while (i < 5) {
            LOG.debug("Элемент " + i + " перенесен." );
            list.add(sArray[i]);
            i++;
        }
        return list;

    }
}
