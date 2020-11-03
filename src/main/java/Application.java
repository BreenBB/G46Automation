import HomeWork01.HomeWork01A;
import HomeWork01.HomeWork01B;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Application {

    private final static Logger LOG = LogManager.getLogger("Класс Application");

    public static void main(String[] args) {
        //Домашнее задание №1
        //Задание А
        HomeWork01A hw01a = new HomeWork01A();
        hw01a.List();

        //Задание Б
        LOG.info("Отсортированый Лист:");
        HomeWork01B hw01b = new HomeWork01B();
        hw01b.PrintList(hw01a.List());

        //Домашнее задание №2
        LOG.info("Вызов из экземпляра класса А, null");
        hw01a.SplitList(null);
        LOG.info("Вызов из экземпляра класса B, лист из экземпляра класса А");
        hw01b.SplitList(hw01a.List());
        LOG.info("Вызов из экземпляра класса B, new ArrayList<String>()");
        List<String> inputlist = new ArrayList<String>();
        hw01b.SplitList(inputlist);
    }
}
