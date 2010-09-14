package com.uwe.canoe.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;

public class ContentPanel extends Composite {

    /* STYLES */
    public final static String STYLE_CONTENT_WIDGET = "contentWidget";

    /** Layout panel containing content panel widgets. */
    public final FlowPanel layoutPanel = new FlowPanel();
    
    private Image titleIcon = null;
    
    private Label titleLabel = null;
  
    protected HTML content = null;
    
    public ContentPanel(String iconUrl, String titleText) {
        
        // initialise default icon
        setIcon(iconUrl);
        
        // Initialise default title
        setTitleLabelText(titleText);

        content = new HTML("<strong>test</strong><p>test</p>");
        content.setStyleName("contentWidgetHTML");
        layoutPanel.add(content);
        initWidget(layoutPanel);
        
        // Set style
        setStyleName("contentPanel");
       
    }
    
    
    public void setContent(String text) {
        content.setHTML(text);
    }
    
    public HTML getContent() {
        return this.content;
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
    
}
