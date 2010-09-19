package com.uwe.canoe.client.panels;


public class WhatToBringPanel extends HTMLContentPanel {

    public final static String HOME = "What To Bring";
    
    public WhatToBringPanel() {
        super("defaultIcon.png", HOME);
        this.setEditable(true);
        
        this.addStyleName("mainContentWidget");
        this.lazyLoadContent();
        
        addImageUrls();
    }
    
    private void addImageUrls() {
        this.imageUrls.add("trips_1.jpg");
        this.imageUrls.add("trips_2.jpg");
        this.imageUrls.add("trips_3.jpg");
        this.imageUrls.add("trips_4.jpg");
        this.imageUrls.add("trips_5.jpg");
        this.imageUrls.add("trips_6.jpg");
        this.imageUrls.add("trips_7.jpg");
        this.imageUrls.add("trips_8.jpg");
        this.imageUrls.add("trips_9.jpg");
        this.imageUrls.add("trips_10.jpg");
        this.imageUrls.add("trips_11.jpg");
        this.imageUrls.add("trips_12.jpg");
        this.imageUrls.add("trips_13.jpg");
        this.imageUrls.add("trips_14.jpg");
        this.imageUrls.add("trips_15.jpg");
        this.imageUrls.add("trips_16.jpg");
        this.imageUrls.add("trips_17.jpg");
        this.imageUrls.add("trips_18.jpg");
    }
}
