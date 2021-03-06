package org.automation.dojo.web.scenario;

import org.automation.dojo.ApplicationContextLocator;
import org.automation.dojo.BugsQueue;
import org.automation.dojo.web.bugs.*;
import org.automation.dojo.web.model.Record;
import org.automation.dojo.web.model.ShopService;
import org.automation.dojo.web.servlet.RequestWorker;

import java.util.List;

public class SearchByTextScenario extends BasicScenario<RequestWorker> {

    public static final int SEARCH_TEXT_MAX_LENGTH = 200;

    public SearchByTextScenario(int id, String description, BugsQueue bugsQueue) {
        super(id, description, bugsQueue);
    }

    @Override
    public boolean activate(RequestWorker request) {
        return request.isSearchAction();
    }

    @Override
    public String process(RequestWorker request) {
        ShopService service = ApplicationContextLocator.getBean("shopService");

        request.saveSearchTextState();
        request.setSearchTextMaxLength(SEARCH_TEXT_MAX_LENGTH);

        String foundString = request.getSearchText();
        if (foundString != null) {
            List<Record> result = service.selectByText(foundString);

            if (result.isEmpty()) {
                result = service.selectByText("");
                request.noResultsFound();
            }

            request.setRecords(result);
        }

        bug.apply(request);
        return null;
    }

    public List<? extends Bug> getPossibleBugs() {
        return BugsFactory.getBugs(NoResultWhenExpectedBug.class,
                AddSomeOtherElementIfListNotEmptyBug.class,
                FoundNotExistsProductBug.class,
                NoSearchTextMaxLengthBug.class);
    }

}
