package IngredientTypeTests;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTests {
    private final String typeNameExpected;
    @Parameterized.Parameters
    public static Object[][] ingredientTypes() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"}
        };
    }
    public IngredientTypeParameterizedTests(String typeNameExpected) {
        this.typeNameExpected = typeNameExpected;
    }
    @Test
    public void ingredientTypeIsCorrectList() {

        MatcherAssert.assertThat(
                IngredientType.valueOf(typeNameExpected.toUpperCase()).toString(),
                equalTo(typeNameExpected));
    }
}