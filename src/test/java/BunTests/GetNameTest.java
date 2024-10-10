package BunTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import java.util.Collections;

@RunWith(Parameterized.class)
public class GetNameTest {
    private final String name;

    public GetNameTest(String name) {
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] NameData() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3"},
                //Проверка для названия булки, содержащее буквы кириллицы, латиницы и цифры
                {"         "},
                //Проверка для названия булки, которое содержит только пробелы
                {null},
                //Проверка для названия булки, значение которого равно null
                {"*)*(Q*&$$Q((#*%&"},
                //Проверка специальных символов в строке
                {String.join("", Collections.nCopies(100, "sesquipedal bun name"))},
                //Проверка очень длинного названия
        };
    }

    @Test
    public void getNameMethodReturnsCorrectName() {
        float price = 1F;
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Метод getName класса Bun возвращает неправильное значение", name, bun.getName());
        System.out.println("Метод getName класса Bun возвращает верное значение");
    }
}
