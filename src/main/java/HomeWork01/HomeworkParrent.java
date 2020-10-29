package HomeWork01;

import java.util.List;

public class HomeworkParrent {
    protected String name;

    HomeworkParrent(String name) {
        this.name=name;
    }

    //Метод принимает List<String> и через split() разделяет слова на отдельые массивы и при помощи второго цикла выводит каждый элемент массивов слов.
    public void SplitList(List<String> inputlist){
        try {
            for(int i = 0; i<inputlist.size(); i++){

                System.out.println("Элемент №" + i + ":");

                String str = inputlist.get(i);
                String[] split = str.split("");

                for(String number : split){
                    System.out.println(number);
                };
            }
        } catch(Exception e){
            if (e instanceof NullPointerException) {
                System.out.println("Массив не определён. Пожалуйста проверьте корректность вводимых значений");
            } else {
                System.out.println("Произошла неизвестная ошибка. Подробнее: " + e);
            }
        }
    }

    public void PrintText(){
        System.out.println(name+ " :Выведен текст");
    }

}
