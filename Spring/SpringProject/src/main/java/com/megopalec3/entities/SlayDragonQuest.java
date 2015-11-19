package com.megopalec3.entities;

import com.megopalec3.interfaces.Quest;

/**
 * Created by Megopalec3 on 19.11.2015.
 */
public class SlayDragonQuest implements Quest{
    @Override
    public void embark() {
        System.out.println("Slay Dragon Quest");
    }
}
