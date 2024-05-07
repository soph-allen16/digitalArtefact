package utils;

import model.entity.Ingredient;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TableHelperTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Test
    public void testPrintTableWithFailure(){
        assertThrows(IllegalArgumentException.class, ()-> TableHelper.printTwoColumnTable(null, new String[] {"header"}));
    }

    @Test
    public void testPrintTable(){
        TableHelper.printTwoColumnTable(null, new String[] {"header1", "header2"});
        assertNotNull(systemOutRule.getLog());
    }
}