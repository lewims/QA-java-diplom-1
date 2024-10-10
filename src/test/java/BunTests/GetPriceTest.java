package BunTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class GetPriceTest {
    private final float price;

    public GetPriceTest(float price) {
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] PriceData() {
        return new Object[][]{
                //Проверка для цены, которая равна отрицательному значению
                {-3245.02F},
                //Проверка для цены, которая равна нулю
                {0},
                //Проверка для цены, которая равна максимально возможному значению
                {Float.MAX_VALUE},
                //Проверка для цены, которая равна минимально возможному значению
                {Float.MIN_VALUE},
                //Проверка для цены, которая содержит нечисловое значение
                {Float.NaN},
                //Проверка для цены, которая содержит значение с плавающей точкой близкое к минимально возможному значению
                {1.399999999999999E-45F},
                //Проверка для цены, которая содержит значение с плавающей точкой близкое к максимально возможному значению
                {3.40282346E38F},
        };
    }

    @Test
    public void getNameMethodReturnsCorrectName() {
        String name ="Флюоресцентная булка R2-D3";
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Метод getPrice класса Bun возвращает неправильное значение", name, bun.getName());
        System.out.println("Метод getPrice класса Bun возвращает верное значение");
    }
}

