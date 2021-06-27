package com.example.tabsyncedrecylerview;


public class LayoutModel {
    private String item;
    private int tabId;

    public LayoutModel(String header, int tabId) {
        this.item = header;
        this.tabId = tabId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String header) {
        this.item = header;
    }

    public int getTabId() {
        return tabId;
    }

    public void setTabId(int tabId) {
        this.tabId = tabId;
    }
}

