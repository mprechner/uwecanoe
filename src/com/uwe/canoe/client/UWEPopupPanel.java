package com.uwe.canoe.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UWEPopupPanel extends PopupPanel {
    
    public UWEPopupPanel(String title, String content) {
        super(true);

        final GlassPanel glassPanel = new GlassPanel();
        glassPanel.show();
        
        this.setStyleName("UWEPopupPanel");
        VerticalPanel PopUpPanelContents = new VerticalPanel();
        this.setTitle(title);
        
        SimplePanel header = new SimplePanel();
        header.setStyleName("UWEPopupPanel-header");
        header.add(new Label(title));
        
        SimplePanel holder = new SimplePanel();
        holder.add(new HTML(content));
        
        PopUpPanelContents.add(header);
        PopUpPanelContents.add(holder);
        
        this.setWidget(PopUpPanelContents);
        
        this.addCloseHandler(new CloseHandler() {

            @Override
            public void onClose(CloseEvent event) {
               glassPanel.hide();
            }
            
        });
        this.show();

        this.setPopupPositionAndShow(new PosCallback());
    }
    
    
    public class GlassPanel extends Composite implements ResizeHandler {
        public static final String STYLE = "gcomp-GlassPanel";

        private SimplePanel panel = new SimplePanel();

        public GlassPanel() {
            initWidget(panel);

            panel.setStylePrimaryName(STYLE);
            Window.addResizeHandler(this);
            resize();
        }

        public void onResize(ResizeEvent event) {
            resize();
        }

        public void show() {
            // Override the styles explicitly, because it's needed
            // every time the widget is detached
            Element elem = panel.getElement();
            DOM.setStyleAttribute(elem, "left", "0");
            DOM.setStyleAttribute(elem, "top", "0");
            DOM.setStyleAttribute(elem, "position", "absolute");
            RootPanel.get().add(this);
        }

        public void hide() {
            RootPanel.get().remove(this);
        }

        private void resize() {
            panel.setSize(Window.getClientWidth() + "px",
                    getDocHeight() + "px");
        }
        
        private int getDocHeight() {
            
            return Math.max(Math.max(RootPanel.getBodyElement().getScrollHeight(),
                    RootPanel.getBodyElement().getOffsetHeight()),
                    RootPanel.getBodyElement().getClientHeight());
        } 
    }
    
    public class PosCallback implements PositionCallback {

        @Override
        public void setPosition(int offsetWidth, int offsetHeight) {
            int left = (Window.getClientWidth() - offsetWidth) / 3;
            int top = (Window.getClientHeight() - offsetHeight) / 3;
            UWEPopupPanel.this.setPopupPosition(left, top);
        }
        
    }

    
}


