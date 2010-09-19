package com.uwe.canoe.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.uwe.canoe.client.menu.MenuPanel;

public class UWECanoeView {
    
    /** Main M-V-P model. */
    private UWECanoeModel model = null;
    
    /* PANELS */
    
    /** Title panel view. */
    private TitlePanel titlePanel = null;
    
    /** Menu panel view. */
    private MenuPanel menuPanel = null;
    
    /** Vertical photo panel view. */
    private VerticalPhotoPanel verticalPhotoPanel = null;
    
    /** Centre content panel view. */
    private CentreContentPanel centreContentPanel = null;
    
    /** Main Dock layout panel. */
    private  HorizontalPanel verticalPanel = null;
    
    private VerticalPanel horizontalPanel = null;
    
    /**
     * Default constructor
     * @param model
     *      UWECanoeModel - main M-V-P model, contains all sub models
     */
    public UWECanoeView(UWECanoeModel model) {
        this.model = model;
        
        // Configure panels
        initializePanels();
        
        // Configure main layout panel
        initializeLayoutPanel();
    }
    
    private void initializePanels() {
        titlePanel = new TitlePanel(model.getLoginModel());
        menuPanel = new MenuPanel();
        verticalPhotoPanel = new VerticalPhotoPanel();
        centreContentPanel = new CentreContentPanel(model.getLoginModel(), model.getContentModel());
    }
    
    
    /**
     * 
     */
    private void initializeLayoutPanel() {
        horizontalPanel = new VerticalPanel();
        horizontalPanel.add(titlePanel);
        
        verticalPanel = new HorizontalPanel();
        verticalPanel.add(menuPanel);
        verticalPanel.add(verticalPhotoPanel);
        verticalPanel.add(centreContentPanel);
        
       horizontalPanel.add(verticalPanel);
    }
    
    public Panel getLayoutPanel() {
        return horizontalPanel;
    }
    
    public CentreContentPanel getContentPanel() {
        return centreContentPanel;
    }
    
    public MenuPanel getMenuPanel() {
        return menuPanel;
    }
    
    public VerticalPhotoPanel getVerticalPhotoPanel() {
        return verticalPhotoPanel;
    }
    
    public void updateView() {
        titlePanel.updateView();
    }
}
