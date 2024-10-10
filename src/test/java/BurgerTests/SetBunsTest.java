package BurgerTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;

@RunWith(MockitoJUnitRunner.class)
public class SetBunsTest {
    @Mock
    private Bun bunMock;

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        Assert.assertEquals(bunMock, burger.bun);
    }
}
