package org.automation.dojo.web.bugs;

import org.automation.dojo.web.model.Record;
import org.automation.dojo.web.servlet.RequestWorker;

import java.util.Arrays;

/**
 * Добавлять существующий продукт ТОЛЬКО если результат поиска пуст
 */
// TODO написать юнит тест
public class FoundNotExistsProductBug extends Bug<RequestWorker> {

    public FoundNotExistsProductBug(int id) {
        super(id);
    }

    @Override
    public RequestWorker apply(RequestWorker result) {
        if (result.isNoResultsFound()) {
            result.setRecords(Arrays.asList(new Record(100500, result.getSearchText(), 100500)));
            result.clearNoResultsFound();
        }
        return result;
    }

}
