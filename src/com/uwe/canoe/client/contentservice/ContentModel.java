package com.uwe.canoe.client.contentservice;

import com.google.gwt.user.client.ui.Panel;

public class ContentModel {

    private String html = null;
    
    private Panel panel = null;
    
    private String id = null;
    
    /** True if using html content rather than a panel. */
    private boolean isHtml = true;
    
    
    public ContentModel() {
    }
    
    public void setHtml(String html) {
        this.isHtml = true;
        this.html = html;
    }
    
    public String getHtml() {
        return this.html;
    }
    
    public void setPanel(Panel panel) {
        this.isHtml = false;
        this.panel = panel;
    }
    
    public Panel getPanel() {
        return this.panel;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return this.id;
    }
    
    public boolean isHtml() {
        return isHtml;
    }
}
