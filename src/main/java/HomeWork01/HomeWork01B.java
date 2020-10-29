package HomeWork01;

import java.util.Collections;
import java.util.List;

public class HomeWork01B extends HomeworkParrent {
    public String name_child;
    public int number;

    public HomeWork01B(){
        super("HomeWork01B");
        System.out.println("Создан пустой экземпляр класса HomeWork01B");
    }

    HomeWork01B(String name, int number){
        super(name);
        this.number=number;
    }

    public void PrintList(List<String> inputlist){

        //Сортировака Листа
        Collections.sort(inputlist);

        for(int i = 0; i<inputlist.size(); i++){
            System.out.println(inputlist.get(i));
        }

    }
}
