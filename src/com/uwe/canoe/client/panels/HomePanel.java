package com.uwe.canoe.client.panels;


public class HomePanel extends HTMLContentPanel {

    public final static String HOME = "Home";
    
    public HomePanel() {
        super("defaultIcon.png", HOME);
        this.setEditable(true);
        
        this.addStyleName("mainContentWidget");
        this.lazyLoadContent();
        
        addImageUrls();
    }
    
    private void addImageUrls() {
        this.imageUrls.add("club_1.jpg");
        this.imageUrls.add("club_3.jpg");
        this.imageUrls.add("club_4.jpg");
        this.imageUrls.add("club_5.jpg");
        this.imageUrls.add("club_6.jpg");
        this.imageUrls.add("club_7.jpg");
        this.imageUrls.add("club_8.jpg");
        this.imageUrls.add("club_9.jpg");
        this.imageUrls.add("club_10.jpg");
    }
}
