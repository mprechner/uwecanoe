package com.uwe.canoe.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.uwe.canoe.client.contentservice.ContentModel;
import com.uwe.canoe.client.login.LoginModel;
import com.uwe.canoe.client.panels.ContentPanel;

public class CentreContentPanel extends Composite {
	
    /** Center content panel class name. */
    public static final String CLASS_CENTER_CONTENT_PANEL = "centerConentPanel";
    
    private Image contentImage = null;
    
    /** Login info. */
    private LoginModel loginModel = null;
    
    private Panel mainContent = new FlowPanel();
    
	public CentreContentPanel(LoginModel loginModel, ContentModel contentModel) {
	    this.loginModel = loginModel;
	    
	    ScrollPanel scrollPanel = new ScrollPanel();
	    
	    contentImage = new Image("title2.png");
	    contentImage.addStyleName("centreImage");
	    FlowPanel flowPanel = new FlowPanel();
	    
	    ContentPanel poolSessionsPanel = new ContentPanel("poolIcon.png", "Upcoming Pool Sessions");
	    poolSessionsPanel.addStyleName("quickLinkPanel");
	    ContentPanel tripsPanel = new ContentPanel("socialIcon.png", "Upcoming Socials");
	    tripsPanel.addStyleName("quickLinkPanel");
        ContentPanel socialsPanel = new ContentPanel("tripIcon.png", "Upcoming Trips");
        socialsPanel.addStyleName("quickLinkPanel");
        
	    
	    flowPanel.add(poolSessionsPanel);
	    flowPanel.add(tripsPanel);
	    flowPanel.add(socialsPanel);
	    flowPanel.add(contentImage);

	    mainContent.addStyleName("mainContent");
	    
	    flowPanel.add(mainContent);

        scrollPanel.add(flowPanel);
	    initWidget(scrollPanel);
	      
	    setStyleName(CLASS_CENTER_CONTENT_PANEL);
	    
	}
	
	public Panel getContentPanel() {
	    return mainContent;
	}
	
	
	public void setContentImageUrl(final String url) {
	    this.contentImage.setUrl(url);
	}
}
