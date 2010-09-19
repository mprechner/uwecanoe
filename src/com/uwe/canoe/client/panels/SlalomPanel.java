package com.uwe.canoe.client.panels;


public class SlalomPanel extends HTMLContentPanel {

    
    public SlalomPanel() {
        super("defaultIcon.png", "Slalom");
        this.setEditable(true);
        
        this.addStyleName("mainContentWidget");
        this.lazyLoadContent();
        addImageUrls();
    }
    
    private void addImageUrls() {
        this.imageUrls.add("slalom_1.jpg");
        this.imageUrls.add("slalom_2.jpg");
        this.imageUrls.add("slalom_3.jpg");
        this.imageUrls.add("slalom_4.jpg");
        this.imageUrls.add("slalom_5.jpg");
        this.imageUrls.add("slalom_6.jpg");
        this.imageUrls.add("slalom_7.jpg");
        this.imageUrls.add("slalom_8.jpg");
    }
}
