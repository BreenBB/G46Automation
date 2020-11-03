package HomeWork01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class HomeWork01B extends HomeworkParrent {
    private final Logger LOG = LogManager.getLogger(this.name);

    public int number;

    public HomeWork01B(){
        super("HomeWork01B");
        LOG.info("Создан пустой экземпляр класса HomeWork01B");
    }

    HomeWork01B(String name, int number){
        super(name);
        this.number=number;
    }

    public void PrintList(List<String> inputlist){
        //Сортировака Листа
        LOG.debug("Метод PrintList для вывода элементов из листа " + inputlist + " в отсортированном порялке");
        LOG.debug("Сортировка inputlist");
        Collections.sort(inputlist);

        for(int i = 0; i<inputlist.size(); i++){
            LOG.info("Элемент №" + i + ":" + inputlist.get(i));
        }

    }
}
