package HomeWork01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class HomeWork01A extends HomeworkParrent {

    private final Logger LOG = LogManager.getLogger(this.name);

    //Массив для Задания А
    public String[] sArray = {"F", "D", "Alpha", "C", "Beta", "E"};

    public int number;

    public HomeWork01A(){
        super("HomeWork01A");
        LOG.info("Создан пустой экземпляр класса HomeWork01A");
    }

    HomeWork01A(String name, int number){
        super(name);
        this.number=number;
    }


    public List<String> List() {

        int i = 0;
        List<String> list = new ArrayList<>();

        //System.out.println("Лист из Задания A:");

        while (i < 5) {
            list.add(sArray[i]);
            //System.out.println(list.get(i)); //вывод Листа А для проверки
            i++;
        }
        return list;

    }
}
