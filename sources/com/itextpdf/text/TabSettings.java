package com.itextpdf.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TabSettings {
    public static final float DEFAULT_TAB_INTERVAL = 36.0f;
    private float tabInterval;
    private List<TabStop> tabStops;

    public static TabStop getTabStopNewInstance(float f, TabSettings tabSettings) {
        if (tabSettings != null) {
            return tabSettings.getTabStopNewInstance(f);
        }
        return TabStop.newInstance(f, 36.0f);
    }

    public TabSettings() {
        this.tabStops = new ArrayList();
        this.tabInterval = 36.0f;
    }

    public TabSettings(List<TabStop> list) {
        new ArrayList();
        this.tabInterval = 36.0f;
        this.tabStops = list;
    }

    public TabSettings(float f) {
        this.tabStops = new ArrayList();
        this.tabInterval = f;
    }

    public TabSettings(List<TabStop> list, float f) {
        new ArrayList();
        this.tabStops = list;
        this.tabInterval = f;
    }

    public List<TabStop> getTabStops() {
        return this.tabStops;
    }

    public void setTabStops(List<TabStop> list) {
        this.tabStops = list;
    }

    public float getTabInterval() {
        return this.tabInterval;
    }

    public void setTabInterval(float f) {
        this.tabInterval = f;
    }

    public TabStop getTabStopNewInstance(float f) {
        TabStop tabStop;
        List<TabStop> list = this.tabStops;
        if (list != null) {
            Iterator<TabStop> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TabStop next = it.next();
                if (((double) (next.getPosition() - f)) > 0.001d) {
                    tabStop = new TabStop(next);
                    break;
                }
            }
        }
        tabStop = null;
        return tabStop == null ? TabStop.newInstance(f, this.tabInterval) : tabStop;
    }
}
