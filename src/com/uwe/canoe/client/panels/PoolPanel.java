package com.uwe.canoe.client.panels;


public class PoolPanel extends HTMLContentPanel {

    
    public PoolPanel() {
        super("defaultIcon.png", "Pool Directions");
        this.setEditable(true);
        
        this.addStyleName("mainContentWidget");
        this.lazyLoadContent();
        addImageUrls();
    }
    
    private void addImageUrls() {
        this.imageUrls.add("pool.png");
    }
}
