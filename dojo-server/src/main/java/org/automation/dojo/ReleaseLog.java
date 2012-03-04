package org.automation.dojo;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.apache.commons.collections.CollectionUtils;
import org.automation.dojo.web.scenario.BasicScenario;
import org.automation.dojo.web.scenario.Release;

import java.util.ArrayList;
import java.util.List;

/**
 * @author serhiy.zelenin
 */
public class ReleaseLog {
    private Release release;
    
    private List<PlayerRecord> records = new ArrayList<PlayerRecord>();
    
    public ReleaseLog(Release release) {
        this.release = release;
    }

    public void putRecord(PlayerRecord record) {
        records.add(record);
    }

    public List<PlayerRecord> getRecordsFor(final String playerName, final BasicScenario scenario) {
        ArrayList<PlayerRecord> result = new ArrayList<PlayerRecord>();
        for (PlayerRecord playerRecord : records) {
            if (playerRecord.getPlayerName().equals(playerName) && playerRecord.getScenario().equals(scenario)) {
                result.add(playerRecord);
            }
        }
        return result;
    }

    public Release getRelease() {
        return release;
    }

    public List<PlayerRecord> getRecordsForPlayer(String player) {
        ArrayList<PlayerRecord> result = new ArrayList<PlayerRecord>();
        for (PlayerRecord playerRecord : records) {
            if (playerRecord.getPlayerName().equals(player)) {
                result.add(playerRecord);
            }
        }
        return result;
    }
}
