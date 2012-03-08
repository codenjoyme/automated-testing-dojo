package web.search;


import web.FunctionalTestCase;
import org.automation.dojo.web.bugs.NoResultWhenExpectedBug;
import org.automation.dojo.web.scenario.SearchByTextLevel1Scenario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = {"classpath:/org/automation/dojo/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchPageLevel1_Bug1 extends SearchPageLevel1 {

    @Override
    protected List<?> getMinorRelease() {
        return Arrays.asList(SearchByTextLevel1Scenario.class, NoResultWhenExpectedBug.class);
    }

    @Override
    @Test
    public void shouldAllListWhenFindEmptyString() {
        enterText("");
        submitSearchForm();

        try { // это баг делает
            assertPageContain("List:");
            throw new RuntimeException("Expected exception");
        } catch (AssertionError e) {
        }
        try { // это баг делает
            allElementsPresent();
            throw new RuntimeException("Expected exception");
        } catch (AssertionError e) {
        }
    }
}