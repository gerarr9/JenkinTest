package tests;

import extensions.SelenideExtensions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SelenideExtensions.class)
@Tag("ui")
@Tag("all")
public class First {


    @Test
    public void firstTest() {
    }

    @Test
    public void badTest() {
        Assertions.assertTrue(true);
    }
}
