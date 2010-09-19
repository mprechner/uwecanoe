package com.uwe.canoe.client.panels;


public class FreshersPanel extends HTMLContentPanel {

    
    public FreshersPanel() {
        super("defaultIcon.png", "Freshers");
        this.setEditable(true);
        
        this.addStyleName("mainContentWidget");
        this.lazyLoadContent();
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
