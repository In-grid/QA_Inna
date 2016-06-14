package core.TestNG.homework;

import org.testng.annotations.Test;

/**
 * Created by Inna_Hrydiakina on 13.06.2016.
 *
 * Правильно расставить приоритеты и зависимости тестам:
 Написать 10 тестовых методов (Пустых (в них должен быть только вывод информации)). Зависимость и приоритетность следующая:

 (В примере используются цифры а не названия методов!)

 1 выполняется первый, от него зависит 2.
 3й выполняется после 2го.
 4, 5 выполняются после 3го.
 6 зависит от 4.
 7й зависит от 6.
 8й зависит от 2, 4, 6
 9й выполняется после 8го
 10й зависит от 7, 9 и должен выполнятся последним.

 */
public class TestNGPriority {

    // priority = 1  - указывает порядок выполнения
    // dependsOnMethods = "name" - зависит от выполения указанного метода (выполнится только после его выполнения)
    // alwaysRun = true  - выполнить в любом случае
    // invocationCount = 100  - метод выполнится 100 раз
    // enable = false   - метод выключен (не выполянется). Похоже на то, как будто мы его закомментировали
    // expectedExceptions = NoSuchElementException.class - выполнится, игнорируя ошибку



    @Test(priority = 1)
    public void test1(){
        System.out.println("Этот тестовый метод test1 с наивысшим приоритетом");
    }

    @Test(priority= 2, dependsOnMethods = "test1")
    public void test2(){
        System.out.println("Этот тестовый метод test2 зависит от 1-го");
    }


    @Test (priority = 3, dependsOnMethods = "test2")
    public void test3(){
        System.out.println("Этот тестовый метод test3 выполнится после 2-го");
    }

    @Test (priority = 4, dependsOnMethods = "test3")
    public void test4(){
        System.out.println("Этот тестовый метод test4 выполнится после 3-го");
    }

    @Test (priority = 4, dependsOnMethods = "test3")
    public void test5(){
        System.out.println("Этот тестовый метод test5 выполнится после 3-го");
    }

    @Test (priority = 5, dependsOnMethods = "test4")
    public void test6(){
        System.out.println("Этот тестовый метод test6 зависит от 4-го");
    }

    @Test(priority = 6, dependsOnMethods = "test6")
    public void test7(){
        System.out.println("Этот тестовый метод test7 зависит от 6-го");
    }

    @Test(priority = 7, dependsOnMethods = {"test2", "test4", "test6"})
    public void test8(){
        System.out.println("Этот тестовый метод test8 зависит от 2, 4, 6");
    }

    @Test(priority = 8, dependsOnMethods = "test8", alwaysRun = true)
    public void test9(){
        System.out.println("Этот тестовый метод test9 выполнится после 8-го");
    }

    @Test(priority = 9, dependsOnMethods = {"test7", "test9"})
    public void test10(){
        System.out.println("Этот тестовый метод test10 зависит от 7 и 9 и выполняется последним");
    }

}

