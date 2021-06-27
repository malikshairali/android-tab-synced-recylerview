package com.example.tabsyncedrecylerview;

public class HeaderModel {
    private String header;
    private int tabId;
//    private int position;

//    public HeaderModel(String header) {
//        this.header = header;
//    }

    public HeaderModel(String header, int tabId) {
        this.header = header;
        this.tabId = tabId;
//        this.position = position;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getTabId() {
        return tabId;
    }

    public void setTabId(int tabId) {
        this.tabId = tabId;
    }

//    public int getPosition() {
//        return position;
//    }
//
//    public void setPosition(int position) {
//        this.position = position;
//    }
}

