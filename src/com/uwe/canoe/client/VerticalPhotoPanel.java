package com.uwe.canoe.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;

/**
 * Panel containing vertical small picture icons.
 *
 * @author Matthew Prechner
 *
 */
public class VerticalPhotoPanel extends Composite {

    /** vertical photo panel class name. */
    public static final String CLASS_VERTICAL_PHOTO_PANEL = "verticalPhotoPanel";

    /** List of url images to display */
    private List<String> imageUrls = new ArrayList<String>();
    
    public final static String IMAGE_DIR = "/media/images/";
    
    private FlowPanel flowPanel = new FlowPanel();
    
    private ClickHandler clickHandler = null;
    
    /**
     * Create panel containing vertical picture icons.
     */
    public VerticalPhotoPanel() {
        imageUrls.add("media/images/Trips.jpg");
        
        // All composites must call initWidget() in their constructors.
        initWidget(flowPanel);

        setStyleName(CLASS_VERTICAL_PHOTO_PANEL);
    }
    
    public void updateView() {
        flowPanel.clear();
        for (String url : imageUrls) {
            Image img = new Image(IMAGE_DIR + url);
            img.addClickHandler(clickHandler);
            img.addStyleName("photoNoFocus");
            img.addMouseOverHandler(new MouseOverHandler() {

                @Override
                public void onMouseOver(MouseOverEvent event) {
                    ((Image) event.getSource()).addStyleName("photoFocus");
                }
                
            });
            
            img.addMouseOutHandler(new MouseOutHandler() {

                @Override
                public void onMouseOut(MouseOutEvent event) {
                    ((Image) event.getSource()).removeStyleName("photoFocus");
                }
                
            });
            
            flowPanel.add(img);
        }
    }
    
    public void setImageUrls(final List<String> urls) {
        imageUrls.clear();
        imageUrls.addAll(urls);
    }
    
    public void setClickHandler(ClickHandler clickHandler) {
        this.clickHandler = clickHandler;
    }
}
