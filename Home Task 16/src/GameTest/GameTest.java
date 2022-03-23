package GameTest;

import GameServise.AiService;
import  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    @RepeatedTest(1000)
    void aiTest(){
        int result = new AiService().aiMove();
        System.out.println(result);
        assertTrue(result >= 0);
        assertTrue(result <= 2);
    }

}
