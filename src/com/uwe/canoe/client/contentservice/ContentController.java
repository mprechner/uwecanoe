package com.uwe.canoe.client.contentservice;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;
import com.uwe.canoe.client.UWECanoeView;
import com.uwe.canoe.client.VerticalPhotoPanel;
import com.uwe.canoe.client.panels.ContentPanel;
import com.uwe.canoe.client.panels.InvalidPanelException;

public class ContentController {

    private final ContentServiceAsync contentService = GWT.create(ContentService.class);
    
    private Panel contentPanel = null;
    
    private ContentModel contentModel = null;
    
    private UWECanoeView view = null;
    
    public ContentController(UWECanoeView view, ContentModel contentModel) {
        this.contentModel = contentModel;
        this.view = view;
        
        // Add edit label controller
        contentPanel = view.getContentPanel().getContentPanel();
        
        for (Tree tree : view.getMenuPanel().getMenuTrees()) {
            tree.addSelectionHandler(new MenuClickListener());
        }
        
        // Set photo panel click handler
        view.getVerticalPhotoPanel().setClickHandler(new PhotoClickListener());
        // Load the initial content
        //loadContent("Home");
    }
    
    
    
    class MenuClickListener implements SelectionHandler {

        @Override
        public void onSelection(SelectionEvent event) {
            Object selectedObject = event.getSelectedItem();
            if (!(selectedObject instanceof TreeItem)){
                return;
            }
            
            TreeItem selectedItem = (TreeItem) selectedObject;
            final String id = selectedItem.getHTML();
            
            loadContent(id);   
        } 
    }
    
    
    /**
     * Load main content panel with content
     * @param id
     */
    public void loadContent(String id) {
   
        try {
            Widget contentWidget = contentModel.getPanel(id);
        
            contentPanel.clear();
            contentPanel.add(contentWidget);
            
            if (contentWidget instanceof ContentPanel) {
                ContentPanel currentContentPanel = ((ContentPanel) contentWidget);
                
                // Set image url
                String url = currentContentPanel.getContentImageUrl();
                view.getContentPanel().setContentImageUrl(VerticalPhotoPanel.IMAGE_DIR + url);
                
                updatePhotoPanel(currentContentPanel);
            }
        } catch (InvalidPanelException e) {
            System.out.println("Panel does not exist");
        }
        
    }
    
    
    private void updatePhotoPanel(final ContentPanel contentPanel) {
     // Update vertical photo panel
        VerticalPhotoPanel photoPanel = view.getVerticalPhotoPanel();
        photoPanel.setImageUrls(contentPanel.getImageUrls());
        
        photoPanel.updateView();
    }
    
    class PhotoClickListener implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            Object source = event.getSource();
            if (source instanceof Image) {
                Image img = (Image) source;
                
                view.getContentPanel().setContentImageUrl(img.getUrl());
            }
        }

       
    }
}
