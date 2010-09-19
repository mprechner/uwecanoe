package com.uwe.canoe.client.panels;

import com.google.gwt.user.client.ui.Label;

public class DevelopmentPanel extends ContentPanel {

    
    public DevelopmentPanel() {
        super("defaultIcon.png", "Home");
        
        this.addStyleName("mainContentWidget");
        
        layoutPanel.add(new Label("This page is under construction"));

        addImageUrls();
    }
    
    private void addImageUrls() {
        this.imageUrls.add("Trips.jpg");
        this.imageUrls.add("3.jpg");
        this.imageUrls.add("4.jpg");
        this.imageUrls.add("5.jpg");
        this.imageUrls.add("6.jpg");
        this.imageUrls.add("7.jpg");
        this.imageUrls.add("8.jpg");
        this.imageUrls.add("9.jpg");
        this.imageUrls.add("10.jpg");
    }
}
