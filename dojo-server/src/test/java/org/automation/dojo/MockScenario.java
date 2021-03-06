package org.automation.dojo;

import org.automation.dojo.web.bugs.Bug;
import org.automation.dojo.web.scenario.BasicScenario;

import java.util.List;

public class MockScenario extends BasicScenario {
    public MockScenario(int id, String description, BugsQueue bugsQueue) {
        super(id, description, bugsQueue);
    }

    @Override
    public String process(Object request) {
        return null;
    }

    @Override
    public boolean activate(Object request) {
        return false;
    }

    @Override
    public List<? extends Bug> getPossibleBugs() {
        return null;
    }

    @Override
    public String toString() {
        return "Mock Scenario id: " + getId();
    }
}
