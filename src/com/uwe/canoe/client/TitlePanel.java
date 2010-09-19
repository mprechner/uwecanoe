package com.uwe.canoe.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.uwe.canoe.client.login.LoginInfo;
import com.uwe.canoe.client.login.LoginModel;

/**
 * Create the title panel, contains all components of the title bar.
 *
 * @author Matthew Prechner
 *
 */
public class TitlePanel extends Composite {

    /** Main title panel class name. */
    public static final String CLASS_TITLE_PANEL = "titlePanel";


    private static final String WELCOME_TEXT = "Welcome to UWE Canoe. Your passport to thrills " +
        "and spills on the water and the very best \"apres kayak\" socials Bristol has to offer.";
    
    /** Sign-in link. */
    private Anchor signInLink = new Anchor("Sign In");
    
    /** Sign-out link. */
    private Anchor signOutLink = new Anchor("Sign Out");
    
    /** Label displaying logged in user. */
    private Label loggedInLabel = new Label();
    
    private LayoutPanel layoutPanel = null;
    
    /** Login info. */
    private LoginModel loginModel = null;
    
    /**
     * Create title panel.
     */
    public TitlePanel(LoginModel loginModel) {
        this.loginModel = loginModel;
        
        // Create layout panel
        layoutPanel = new LayoutPanel();

        loggedInLabel.setStyleName("loggedInLabel");
        signOutLink.setStyleName("logLink");
        signInLink.setStyleName("logLink");
        
        // Create title logo image
        final Image titleLogoImg = new Image("title.png");
        layoutPanel.add(titleLogoImg);

        // Create title text logo and position
        final Image titleTextImg = new Image("titleTextLogo.png");
        layoutPanel.add(titleTextImg);
        layoutPanel.setWidgetLeftWidth(titleTextImg, 225, Unit.PX, 253, Unit.PX);
        layoutPanel.setWidgetTopHeight(titleTextImg, 18, Unit.PX, 38, Unit.PX);

        // Create welcome title label
        final Label titleWelcomeTextLabel = new Label(WELCOME_TEXT);
        layoutPanel.add(titleWelcomeTextLabel);
        titleWelcomeTextLabel.addStyleName("titleWelcomeTextLabel");
        layoutPanel.setWidgetLeftWidth(titleWelcomeTextLabel, 232, Unit.PX, 660, Unit.PX);
        layoutPanel.setWidgetTopHeight(titleWelcomeTextLabel, 65, Unit.PX, 50, Unit.PX);

        // Initialise widget with layout panel
        initWidget(layoutPanel);

        // Set style
        setStyleName(CLASS_TITLE_PANEL);
    }
    
    public void updateView() {
        updateLoginInfo();
    }
    
    
    /**
     * Update the login info in the title bar.
     * 
     * @param loginInfo
     */
    public void updateLoginInfo() {
        LoginInfo loginInfo = loginModel.getLoginInfo();
        if ((loginInfo != null) && (loginInfo.isLoggedIn())) {
            doUserValidInfo(loginInfo);
        } else {
            doUserInvalidInfo(loginInfo);
        }
    }
    
    
    /**
     * Add user info to title panel and add logout link
     * @param loginInfo
     */
    private void doUserValidInfo(LoginInfo loginInfo) {
        loggedInLabel.setText("Logged in as " + loginInfo.getNickname() + " |");
        layoutPanel.remove(signInLink);
        layoutPanel.add(loggedInLabel);
        layoutPanel.setWidgetRightWidth(loggedInLabel, 55, Unit.PX, 200, Unit.PX);
        layoutPanel.setWidgetTopHeight(loggedInLabel, 98, Unit.PX, 30, Unit.PX);
        
        // Set up sign out hyperlink.
        signOutLink.setHref(loginInfo.getLogoutUrl());
        layoutPanel.add(signOutLink);
        layoutPanel.setWidgetRightWidth(signOutLink, 5, Unit.PX, 50, Unit.PX);
        layoutPanel.setWidgetTopHeight(signOutLink, 98, Unit.PX, 30, Unit.PX);
        
        
        System.out.println("logged in");
    }
    
    /**
     * Add login in link to title bar as no user logged in
     * @param loginInfo
     */
    private void doUserInvalidInfo(LoginInfo loginInfo) {
        layoutPanel.remove(loggedInLabel);
        layoutPanel.remove(signOutLink);
        signInLink.setHref(loginInfo.getLoginUrl());
        layoutPanel.add(signInLink);
        layoutPanel.setWidgetRightWidth(signInLink, 5, Unit.PX, 50, Unit.PX);
        layoutPanel.setWidgetTopHeight(signInLink, 98, Unit.PX, 30, Unit.PX);
        System.out.println("not logged in");
    }

}
