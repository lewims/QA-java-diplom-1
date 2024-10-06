package BurgerTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class IngredientMethodsTest {

   private  final Burger burger = new Burger();

    @Mock
    private Ingredient ingredientMock;

    @Mock
    private Ingredient ingredientMock2;



    @Test
    public void addIngredientMethodAddsNewIngredient(){
        burger.addIngredient(ingredientMock);
        Assert.assertTrue(burger.ingredients.contains(ingredientMock));
       System.out.println("Метод addIngredient добавляет новый элемент в список «ingredients»");
    }

    @Test
    public void removeIngredientMethodRemovesIngredient(){
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);
        burger.removeIngredient(1);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredientMock));
        Assert.assertFalse(burger.ingredients.contains(ingredientMock2));
        System.out.println("Метод removeIngredient удаляет элемент списока «ingredients» с заданным в него индексом");

    }

    @Test
    public void moveIngredientMethodChangesIndex(){
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);
        burger.moveIngredient(0,1);
        Assert.assertEquals(ingredientMock, burger.ingredients.get(1));
        Assert.assertEquals(ingredientMock2, burger.ingredients.get(0));
        System.out.println("Метод moveIngredient присваевает новый, заданный в методе индекс, элементу в списоке «ingredients»");
    }
}
