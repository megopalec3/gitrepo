package com.megopalec3.entities;

import com.megopalec3.interfaces.Knight;
import com.megopalec3.interfaces.Quest;

/**
 * Created by Megopalec3 on 19.11.2015.
 */
public class BraveKnight implements Knight {
    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
