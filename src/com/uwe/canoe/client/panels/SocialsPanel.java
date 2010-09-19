package com.uwe.canoe.client.panels;


public class SocialsPanel extends HTMLContentPanel {

    
    public SocialsPanel() {
        super("defaultIcon.png", "Socials");
        this.setEditable(true);
        
        this.addStyleName("mainContentWidget");
        this.lazyLoadContent();
        addImageUrls();
    }
    
    private void addImageUrls() {
        this.imageUrls.add("social_1.jpg");
        this.imageUrls.add("social_2.jpg");
        this.imageUrls.add("social_3.jpg");
        this.imageUrls.add("social_4.jpg");
        this.imageUrls.add("social_5.jpg");
        this.imageUrls.add("social_6.jpg");
        this.imageUrls.add("social_7.jpg");
        this.imageUrls.add("social_8.jpg");
        this.imageUrls.add("social_9.jpg");
        this.imageUrls.add("social_10.jpg");
        this.imageUrls.add("social_11.jpg");
        this.imageUrls.add("social_12.jpg");
    }
}
