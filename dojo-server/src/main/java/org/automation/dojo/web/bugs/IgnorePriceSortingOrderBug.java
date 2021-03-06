package org.automation.dojo.web.bugs;

import org.automation.dojo.ApplicationContextLocator;
import org.automation.dojo.web.model.ShopService;
import org.automation.dojo.web.servlet.RequestWorker;

/**
 * Каким бы мы не выбрали порядок сортировки, он всеравно проигнорируется
 */
public class IgnorePriceSortingOrderBug extends Bug<RequestWorker> {

    public IgnorePriceSortingOrderBug(int id) {
        super(id);
    }

    @Override
    public RequestWorker apply(RequestWorker result) {
        result.setPriceSortingOrderOption(RequestWorker.ASC);
        ShopService service = ApplicationContextLocator.getBean("shopService");
        result.setRecords(service.sortByPrice(result.getRecords(), RequestWorker.ASC));
        return result;
    }

}
