import AverageNumbers.AverageNumbers;
import Filter.Filter;
import Pairs.Pairs;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
//import org.junit.jupiter.api.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;

public class StreamTest {
    @Before
    public void setUp(){
        AverageNumbers averageNumbers = new AverageNumbers();

    }

//    @Test
//    void givenStaticMethodWithNoArgs_whenMocked_thenReturnsMockSuccessfully() {
//        assertThat(StaticUtils.name()).isEqualTo("Baeldung");
//
//        try (MockedStatic<StaticUtils> utilities = Mockito.mockStatic(StaticUtils.class)) {
//            utilities.when(StaticUtils::name).thenReturn("Eugen");
//            assertThat(StaticUtils.name()).isEqualTo("Eugen");
//        }
//
//        assertThat(StaticUtils.name()).isEqualTo("Baeldung");
//    }
    
}
