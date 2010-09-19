package com.uwe.canoe.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.uwe.canoe.client.login.LoginInfo;
import com.uwe.canoe.client.login.LoginService;
import com.uwe.canoe.client.login.LoginServiceAsync;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class UWECanoe implements EntryPoint {

    /** Main M-V-P view. */
    private UWECanoeView view = null;
    
    /** Main M-V-P model. */
    private UWECanoeModel model = null;
    
    /** Main M-V-P controller. */
    private UWECanoeController controller = null;
    
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

	    // TODO fix css styles
	    
	    // Create main view and models
	    model = new UWECanoeModel();
	    view = new UWECanoeView(model);
	    controller = new UWECanoeController(view, model);
	    
	    controller.getContentController().loadContent("Home");
	    
	    // Query for login information
	    doLogin(); 
	    
	    // Attach the LayoutPanel to the RootLayoutPanel. The latter will listen for
	    // resize events on the window to ensure that its children are informed of
	    // possible size changes.
	    RootLayoutPanel rp = RootLayoutPanel.get();
	    rp.addStyleName("mainApp");
	    rp.add(view.getLayoutPanel());
	    
	    // Override overflow of main panel
        Element child = (Element) rp.getElement().getChild(1);
        DOM.setStyleAttribute(child, "overflow", "visible");  
	}
	
	
    /**
     * Query server for login information, returns a login info object which
     * details which user if any is logged in.
     */
    private void doLogin() {
        // Check login status using login service.
        LoginServiceAsync loginService = GWT.create(LoginService.class);
        loginService.login(GWT.getHostPageBaseURL(),
                new AsyncCallback<LoginInfo>() {
                    public void onFailure(Throwable error) {
                    }

                    public void onSuccess(LoginInfo result) {
                        model.getLoginModel().setLoginInfo(result);
                        view.updateView();  
                    }
                });
    }  
	

}
