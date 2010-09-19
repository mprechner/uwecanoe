package com.uwe.canoe.client.panels;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.uwe.canoe.client.contentservice.ContentService;
import com.uwe.canoe.client.contentservice.ContentServiceAsync;
import com.uwe.canoe.client.login.AuthException;

public class ContentPanel extends Composite {

    private final ContentServiceAsync contentService = GWT.create(ContentService.class);
    
    /* STYLES */
    public final static String STYLE_CONTENT_WIDGET = "contentWidget";

    /** Layout panel containing content panel widgets. */
    public final FlowPanel layoutPanel = new FlowPanel();
    
    public final FlowPanel contentPanel = new FlowPanel(); 
    
    private Image titleIcon = null;
    
    private Label titleLabel = null;
    
    protected String contentId = null;
    
    /** List of url images to display */
    protected List<String> imageUrls = new ArrayList<String>();
    
    public ContentPanel(String iconUrl, String contentId) {
        this.contentId = contentId;

        // initialise default icon
        setIcon(iconUrl);
        
        // Initialise default title
        setTitleLabelText(contentId);

        // Add main content panel
        layoutPanel.add(contentPanel);
        
        initWidget(layoutPanel);
        
        // Set style
        setStyleName("contentPanel");
       
    }
    
    
    /**
     * Set title icon url
     * 
     * @param url
     *      String - url of icon image
     */
    public void setIcon(String url) {
        if (titleIcon == null) {
            titleIcon = new Image(url);
            titleIcon.setStyleName("contentWidgetIcon");
            layoutPanel.add(titleIcon);
        } else {
            titleIcon.setUrl(url);
        } 
    }
    

    /**
     * Set title label text
     * 
     * @param title
     *      String - title text
     */
    public void setTitleLabelText(String title) {
        if (titleLabel == null) {
            titleLabel = new Label(title);
            titleLabel.setStyleName("contentWidgetLabel");
            layoutPanel.add(titleLabel);
        } else {
            titleLabel.setText(title);
        }
    }
    
    /**
     * Get main content image displayed above content
     * @return
     */
    public String getContentImageUrl() {
        String imgUrl = imageUrls.get(0);
        
        if (imgUrl == null) {
            imgUrl = "Home.jpg";
        }
        return imgUrl;
    }
    
    public List<String> getImageUrls() {
        return this.imageUrls;
    }
    
}
