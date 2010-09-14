package com.uwe.canoe.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.uwe.canoe.client.contentservice.ContentModel;
import com.uwe.canoe.client.login.LoginInfo;
import com.uwe.canoe.client.login.LoginModel;

public class CentreContentPanel extends Composite {
	
    /** Center content panel class name. */
    public static final String CLASS_CENTER_CONTENT_PANEL = "centerConentPanel";
    
    
    /** Login info. */
    private LoginModel loginModel = null;
    
    private HTMLContentPanel mainContent = null;
    
	public CentreContentPanel(LoginModel loginModel, ContentModel contentModel) {
	    this.loginModel = loginModel;
	    
	    ScrollPanel scrollPanel = new ScrollPanel();
	    
	    Image image = new Image("title2.png");
	    image.addStyleName("centreImage");
	    FlowPanel flowPanel = new FlowPanel();
	    flowPanel.add(new ContentPanel("poolIcon.png", "Upcoming Pool Sessions"));
	    flowPanel.add(new ContentPanel("socialIcon.png", "Upcoming Socials"));
	    flowPanel.add(new ContentPanel("tripIcon.png", "Upcoming Trips"));
	    flowPanel.add(image);


	    mainContent = new HTMLContentPanel("defaultIcon.png", "Welcome", contentModel);
	    mainContent.addStyleName("mainContent");
	    mainContent.setContent("sdfsdfsdfsdfsdfsd\nsfsewer\n");
	    
	    
	    flowPanel.add(mainContent);
	   // flowPanel.add(new RightContentPanel());
        scrollPanel.add(flowPanel);
	    initWidget(scrollPanel);
	      
	    setStyleName(CLASS_CENTER_CONTENT_PANEL);
	    
	}
	
	public HTMLContentPanel getContentPanel() {
	    return mainContent;
	}
	
	private void updateEditLabel() {
	    LoginInfo loginInfo = loginModel.getLoginInfo();
	    mainContent.setEditable(((loginInfo != null) && (loginInfo.isLoggedIn())));
	}
	
	public void updateView() {
	    updateEditLabel();
	}

}
