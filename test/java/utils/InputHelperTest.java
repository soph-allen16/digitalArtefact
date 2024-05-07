package utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.jupiter.api.AfterAll;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InputHelperTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Test
    public void testGetIntegerInput(){
        systemIn.provideLines("1");
        assertEquals(InputHelper.getIntegerInput("get input"), 1);
    }

    @Test
    public void getIntegerInputWithFailure(){
        systemIn.provideLines("q");
        InputHelper.getIntegerInput("Input");
        assertNotNull(systemOutRule.getLog());
    }

    @Test
    public void testGetPositiveIntegerInput(){
        systemIn.provideLines("-4", "1");
        assertNotNull(systemOutRule.getLog());
        assertEquals(1, InputHelper.getPositiveIntegerInput("input"));
    }

    @Test
    public void testGetMenuInput(){
        systemIn.provideLines("10", "1");
        assertNotNull(systemOutRule.getLog());
        assertEquals(1, InputHelper.getMenuInput(2));
    }

    @Test
    public void testGetStringInput(){
        systemIn.provideLines(" ", "test");
        assertNotNull(systemOutRule.getLog());
        assertEquals("test", InputHelper.getStringInput("string"));
    }

    @Test
    public void testGetCommaSeparatedInput(){
        systemIn.provideLines("one, two");
        ArrayList<String> output = InputHelper.getCommaSeparatedInput("prompts");
        assertEquals("one", output.get(0));
        assertEquals("two", output.get(1));
    }
}