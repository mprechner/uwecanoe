package com.uwe.canoe.client.contentservice;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.ui.Widget;
import com.uwe.canoe.client.panels.CodeOfConductPanel;
import com.uwe.canoe.client.panels.CommitteePanel;
import com.uwe.canoe.client.panels.ForumPanel;
import com.uwe.canoe.client.panels.FreshersPanel;
import com.uwe.canoe.client.panels.HomePanel;
import com.uwe.canoe.client.panels.InvalidPanelException;
import com.uwe.canoe.client.panels.LinksPanel;
import com.uwe.canoe.client.panels.MediaPanel;
import com.uwe.canoe.client.panels.PoloPanel;
import com.uwe.canoe.client.panels.PoolPanel;
import com.uwe.canoe.client.panels.SlalomPanel;
import com.uwe.canoe.client.panels.SocialsPanel;
import com.uwe.canoe.client.panels.TripsPanel;
import com.uwe.canoe.client.panels.WhatToBringPanel;

public class ContentModel {

   private Map<String,Widget> contentPanels = new HashMap<String,Widget>();
    
    public ContentModel() {
        contentPanels.put(HomePanel.HOME, new HomePanel());
        contentPanels.put("Freshers", new FreshersPanel());
        contentPanels.put("Forum", new ForumPanel());
        contentPanels.put("Trips", new TripsPanel());
        contentPanels.put("Socials", new SocialsPanel());
        
        contentPanels.put("Pool Sessions", new PoolPanel());

        contentPanels.put("What To Bring", new WhatToBringPanel());
        contentPanels.put("Slalom", new SlalomPanel());
        contentPanels.put("Polo", new PoloPanel());
        contentPanels.put("Media", new MediaPanel());
        contentPanels.put("Committee", new CommitteePanel());
        contentPanels.put("Code of Conduct", new CodeOfConductPanel());
        contentPanels.put("Links", new LinksPanel());
    }
    
    public Widget getPanel(final String id) throws InvalidPanelException {
        if (!contentPanels.containsKey(id)) {
            throw new InvalidPanelException();
        }
        
        return contentPanels.get(id);
    }
   
}
