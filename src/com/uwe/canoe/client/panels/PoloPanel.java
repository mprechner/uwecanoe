package com.uwe.canoe.client.panels;


public class PoloPanel extends HTMLContentPanel {

    
    public PoloPanel() {
        super("defaultIcon.png", "Polo");
        this.setEditable(true);
        
        this.addStyleName("mainContentWidget");
        this.lazyLoadContent();
        addImageUrls();
    }
    
    private void addImageUrls() {
        this.imageUrls.add("pony_1.jpg");
        this.imageUrls.add("pony_2.jpg");
        this.imageUrls.add("pony_3.jpg");
        this.imageUrls.add("pony_4.jpg");
        this.imageUrls.add("pony_5.jpg");
        this.imageUrls.add("pony_6.jpg");
        this.imageUrls.add("pony_7.jpg");
        this.imageUrls.add("pony_8.jpg");
        this.imageUrls.add("pony_9.jpg");
        this.imageUrls.add("pony_10.jpg");
    }
}
