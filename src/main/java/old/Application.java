package old;

import old.HomeWork01.HomeWork01A;
import old.HomeWork01.HomeWork01B;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Application {

    private final static Logger LOG = LogManager.getLogger("Класс Аpplication");

    public static void main(String[] args) {
        //Домашнее задание №1
        LOG.info("==Старт Программы==");
        //Задание А
        HomeWork01A hw01a = new HomeWork01A();

        //Задание Б
        LOG.info("Отсортированый Лист:");
        HomeWork01B hw01b = new HomeWork01B();
        hw01b.printList(hw01a.list());

        //Домашнее задание №2
        LOG.info("Вызов из экземпляра класса А, null");
        hw01a.splitList(null);
        LOG.info("Вызов из экземпляра класса B, лист из экземпляра класса А");
        hw01b.splitList(hw01a.list());
        LOG.info("Вызов из экземпляра класса B, new ArrayList<String>()");
        List<String> inputlist=new ArrayList<>();
        hw01b.splitList(inputlist);
        LOG.info("==Конец==");
    }
}
