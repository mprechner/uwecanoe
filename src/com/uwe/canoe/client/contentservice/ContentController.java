package com.uwe.canoe.client.contentservice;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.uwe.canoe.client.HTMLContentPanel;
import com.uwe.canoe.client.UWECanoeView;
import com.uwe.canoe.client.UWEPopupPanel;
import com.uwe.canoe.client.login.AuthException;

public class ContentController {

    private final ContentServiceAsync contentService = GWT.create(ContentService.class);
    
    private HTMLContentPanel contentPanel = null;
    
    private ContentModel contentModel = null;
    
    private UWECanoeView view = null;
    
    public ContentController(UWECanoeView view, ContentModel contentModel) {
        this.contentModel = contentModel;
        
        // Add edit label controller
        contentPanel = view.getContentPanel().getContentPanel();
        contentPanel.getEditLabel().addClickHandler(new EditLabelClickHandler());
        
        for (Tree tree : view.getMenuPanel().getMenuTrees()) {
            tree.addSelectionHandler(new MenuClickListener());
        }
        
        // Load the initial content
        //loadContent("Home");
    }
    
    class EditLabelClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            if (contentPanel.getEditLabel().getText().equals(HTMLContentPanel.EDIT_TEXT)) {
                contentPanel.editContent();
            } else {
                contentPanel.saveContent();
                contentModel.setHtml(contentPanel.getContent().toString());
                saveContent(contentModel.getId(), contentModel.getHtml());
            }
        }
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
        // Set loading cursor
        setCursor(true);
        
        contentModel.setId(id);
        
        if (id.equals("Registration")) {
            setRegistrationContent();
        } else {
            try {
                
                
                contentService.getContent(id, new AsyncCallback<String>() {
                    public void onFailure(Throwable error) {
                        setCursor(false);
                    }
                    public void onSuccess(String content) {
                        contentModel.setHtml(content);   
                        contentPanel.updateViewHTML();
                        setCursor(false);
                    }
                  });
            } catch (AuthException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    private void setRegistrationContent() {
        final TextBox emailTextBox = new TextBox();
        final PasswordTextBox passwordTextBox = new PasswordTextBox();
        final PasswordTextBox cfmPasswordTextBox = new PasswordTextBox();
        final RadioButton existingMemberRadioBtn = new RadioButton("radioGroup", "Returning Member");
        final RadioButton newMemberRadioBtn = new RadioButton("radioGroup", "New Member");
        final TextBox keywordTextBox = new TextBox(); 
        final Button registerButton = new Button("Register");
        
        existingMemberRadioBtn.setValue(true);
        keywordTextBox.setEnabled(false);
        
        Grid grid = new Grid(7, 3);
        grid.addStyleName("defaultText");
        
        grid.setWidget(0, 0, new Label("Email"));
        grid.setWidget(0, 1, emailTextBox);
        
        grid.setWidget(1, 0, new Label("Password"));
        grid.setWidget(1, 1, passwordTextBox);
        
        grid.setWidget(2, 0, new Label("Confirm Password"));
        grid.setWidget(2, 1, cfmPasswordTextBox);
        
        grid.setWidget(3, 1, existingMemberRadioBtn);
        grid.setWidget(4, 1, newMemberRadioBtn);
        
        grid.setWidget(5, 0, new Label("Secret Keyword"));
        grid.setWidget(5, 1, keywordTextBox);
        grid.setWidget(5, 2, new Label("(NOTE: only required for new members)"));
        
        
        grid.setWidget(6, 1, registerButton);
        
        newMemberRadioBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                keywordTextBox.setEnabled(true);
            }  
        });
        
        existingMemberRadioBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                keywordTextBox.setEnabled(false);
            }  
        });
        
        registerButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                String email = emailTextBox.getText();
                String password = passwordTextBox.getText();
                String cfmPassword = cfmPasswordTextBox.getText();
                String keyword = ((existingMemberRadioBtn.getValue()) ? keywordTextBox.getValue() : null);
                System.out.println("Register new user - " + emailTextBox.getText());
                
                registerNewMember(email, password, cfmPassword, keyword);
            }
            
        });
        
        
        contentModel.setPanel(grid);
        contentPanel.updateViewPanel();
        setCursor(false);
    }
    
    private void registerNewMember(String email, String password, String cfmPassword, String keyword) {
        if (!validateRegisterationDetails(email, password, cfmPassword, keyword)) {
        } 
    }
    
    private boolean validateRegisterationDetails(String email, String password, String cfmPassword, String keyword) {
        boolean success = true;
        
        // Check valid email
        if (email.equals("")) {
            new UWEPopupPanel("Invalid Email", "Invalid Email");
            success = false;
        }
        
        // Check valid password
        if (success && password.equals("")) {
            new UWEPopupPanel("Invalid Password", "Invalid Password");
            success = false;
        }
        
        // Check passwords match
        if (success && !password.equals(cfmPassword)) {
            new UWEPopupPanel("Invalid Password", "Invalid Password");
            success = false;
        }
        
        return success;
    }
    
    
    
    /**
     * Set body loading cursor
     */
    private void setCursor(boolean isLoading) {
        if (isLoading) {
            RootPanel.getBodyElement().addClassName("loading");
        } else {
            RootPanel.getBodyElement().removeClassName("loading");
        }
    }
    
    private void saveContent(String id, String html) {
        try {
            contentService.saveContent(id, html, new AsyncCallback<String>() {
                public void onFailure(Throwable error) {
                }
                public void onSuccess(String content) {
                }
              });
        } catch (AuthException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
