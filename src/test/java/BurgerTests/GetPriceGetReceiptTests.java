package BurgerTests;

import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class GetPriceGetReceiptTests {

    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient ingredientMock;

    @Test
    public void getPriceMethodReturnsRightCalculation() {
        Burger burger = new Burger();
        Random random = new Random();
        float price = random.nextFloat();
        Mockito.when(bunMock.getPrice()).thenReturn(price);
        Mockito.when(ingredientMock.getPrice()).thenReturn(price);
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        Assert.assertEquals(price * 2 + price, burger.getPrice(), 0);
        System.out.println("Возвращается правильный результат суммы заказа");

    }
@Test
    public void getReceiptMethodReturnsRightCalculation() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        Random random = new Random();
        float price = random.nextFloat();
        String name = RandomStringUtils.randomAlphanumeric(2, 15);
        Mockito.when(bunMock.getName()).thenReturn(name);
        Mockito.when(bunMock.getPrice()).thenReturn(price);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Плоды Фалленианского дерева", 8999F));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 12.3E3F));
    float finalPrice = burger.getPrice();
    String result = String.format("%.6f", finalPrice);
        String expectedReceipt = "(==== " + name + " ====)\r\n" + "= " +
                                 burger.ingredients.get(0).getType().toString().toLowerCase() + " " +
                                 burger.ingredients.get(0).name + " =\r\n= " +
                                 burger.ingredients.get(1).getType().toString().toLowerCase() + " " +
                                 burger.ingredients.get(1).name + " =\r\n" + "(==== " + name + " ====)\r\n" + "\r\nPrice: " + result + "\r\n";

        MatcherAssert.assertThat(
            "Возвращается некорректная строка с чеком",
            burger.getReceipt(),
            equalTo(expectedReceipt)
    );
      System.out.println("Возвращается верная строка с чеком");
    }
}