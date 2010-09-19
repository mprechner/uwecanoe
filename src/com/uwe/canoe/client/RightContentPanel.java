package com.uwe.canoe.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.uwe.canoe.client.panels.ContentPanel;

public class RightContentPanel extends Composite {
	
    /** Right content panel class name. */
    public static final String CLASS_RIGHT_CONTENT_PANEL = "rightContentPanel";
    
	public RightContentPanel() {
	    // All composites must call initWidget() in their constructors.

	    FlowPanel flowPanel = new FlowPanel();
	    flowPanel.add(new ContentPanel("poolIcon.png", "Upcoming Pool Sessions"));
	    flowPanel.add(new ContentPanel("socialIcon.png", "Upcoming Socials"));
	    
	    
	    initWidget(flowPanel);
	    
        setStyleName("rightContentPanel");
	}

}
