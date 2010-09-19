package com.uwe.canoe.client.panels;

import com.google.gwt.user.client.ui.Label;

public class ForumPanel extends ContentPanel {

    
    public ForumPanel() {
        super("defaultIcon.png", "Forum");
        
        this.addStyleName("mainContentWidget");
        
        layoutPanel.add(new Label("This page is under construction"));

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
