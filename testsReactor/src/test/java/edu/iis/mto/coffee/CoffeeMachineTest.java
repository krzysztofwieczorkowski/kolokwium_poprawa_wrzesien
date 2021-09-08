package edu.iis.mto.coffee;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import edu.iis.mto.coffee.machine.*;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class CoffeeMachineTest {
    @Mock
    private CoffeeGrinder coffeeGrinder;
    @Mock
    private MilkProvider milkProvider;
    @Mock
    private CoffeeReceipes coffeeReceipes;

    private CoffeeMachine coffeeMachine;
    private static final Map<CoffeeSize, Integer> SAMPLE_WATER_AMOUNTS = new HashMap<>();

    private static final CoffeeReceipe SAMPLE_RECEPIE_WITH_MILK = CoffeeReceipe.builder()
            .withMilkAmount(2)
            .withWaterAmounts(SAMPLE_WATER_AMOUNTS)
            .build();

    private static final CoffeeOrder SAMPLE_COFFEE_ORDER = CoffeeOrder.builder()
            .withSize(CoffeeSize.DOUBLE)
            .withType(CoffeeType.LATTE)
            .build();

    private static final CoffeeReceipe SAMPLE_RECEPIE_WITHOUT_MILK = CoffeeReceipe.builder()
            .withMilkAmount(0)
            .withWaterAmounts(SAMPLE_WATER_AMOUNTS)
            .build();

    @BeforeEach
    void setup(){
        coffeeMachine = new CoffeeMachine(coffeeGrinder, milkProvider, coffeeReceipes);
        SAMPLE_WATER_AMOUNTS.put(CoffeeSize.DOUBLE, 2);
    }
    

    @Test
    void shouldSetErrorStatusWhenRecipeIsUnknown(){
        when(coffeeReceipes.getReceipe(any(CoffeeType.class))).thenReturn(null);
        assertEquals(Status.ERROR, coffeeMachine.make(SAMPLE_COFFEE_ORDER).getStatus());
    }
    @Test
    void whenCoffeeWithoutMilkReceipeShouldBeCheckedThreeTimes(){
        when(coffeeGrinder.grind(any(CoffeeSize.class))).thenReturn(true);
        when(coffeeReceipes.getReceipe(any(CoffeeType.class))).thenReturn(SAMPLE_RECEPIE_WITHOUT_MILK);
        coffeeMachine.make(SAMPLE_COFFEE_ORDER);
        verify(coffeeReceipes, times(3)).getReceipe(any(CoffeeType.class));
    }

    @Test
    void whenCoffeeWithMilkReceipeShouldBeCheckedFourTimes(){

    }

    @Test
    void throwExceptionWhenGrinderReturnFalse(){

    }

    @Test
    void shouldNotInvokeMilkProviderWhenThereIsNoMilk(){

    }

    @Test
    void shouldNotInvokeMilkProviderWhenMilkIisNotInTheReceipe(){

    }

    @Test
    void shouldReturnCoffeeWithCorrectAmountOfMilkAndWater() {

    }


}
