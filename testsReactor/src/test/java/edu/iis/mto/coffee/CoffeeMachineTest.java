package edu.iis.mto.coffee;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CoffeeMachineTest {

    @Test
    void itCompiles() {
        MatcherAssert.assertThat(true, equalTo(true));
    }

    @Test
    void shouldThrowExceptionWhenReceipeIsUnknown(){

    }
    @Test
    void whenCoffeeWithoutMilkReceipeShouldBeCheckedThreeTimes(){

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
