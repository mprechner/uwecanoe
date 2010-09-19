package com.uwe.canoe.client.panels;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.uwe.canoe.client.RichTextToolbar;
import com.uwe.canoe.client.contentservice.ContentService;
import com.uwe.canoe.client.contentservice.ContentServiceAsync;
import com.uwe.canoe.client.login.AuthException;

public class HTMLContentPanel extends ContentPanel {

    private final ContentServiceAsync contentService = GWT.create(ContentService.class);
    
    public static final String EDIT_TEXT = "Edit";
    
    public static final String SAVE_TEXT = "Save";
    
    private Label editLabel = new Label (EDIT_TEXT);
    
    private RichTextArea editTextArea = new RichTextArea();
        
    private RichTextToolbar toolBar = new RichTextToolbar(editTextArea);
    
    private HTML HTMLContent = new HTML();
    
    public HTMLContentPanel(String iconUrl, String titleText) {
        super(iconUrl, titleText);
      
        // Initialise edit label
        editLabel.setStyleName("editLabel");
        
        HTMLContent.setStyleName("htmlContent");
        
        editLabel.addClickHandler(new EditLabelClickHandler());
    }
    

    class EditLabelClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            if (editLabel.getText().equals(HTMLContentPanel.EDIT_TEXT)) {
                editContent();
            } else {
                saveContent();
            }
        }
    }
    

    
    public void setEditable(boolean isEditable) {
        if (isEditable) {
            layoutPanel.add(editLabel);
        } else {
            layoutPanel.remove(editLabel);
        }
    }

    
    public Label getEditLabel() {
        return editLabel;
    }
    
    public RichTextArea getEditTextArea() {
        return editTextArea;
    }
    

    public void editContent() {
        editLabel.setText(SAVE_TEXT);

        editTextArea.setWidth("90%");
        editTextArea.setHTML(HTMLContent.getHTML());
        
        layoutPanel.remove(HTMLContent);
        layoutPanel.add(toolBar);
        layoutPanel.add(editTextArea);
    }
    
    public void saveContent() {
        editLabel.setText(EDIT_TEXT);
        HTMLContent.setHTML(editTextArea.getHTML());
        
        layoutPanel.remove(toolBar);
        layoutPanel.remove(editTextArea);
        layoutPanel.add(HTMLContent);
        saveToServer();
    }
    
    
    protected void lazyLoadContent() {
        
        try {
            contentService.getContent(contentId, new AsyncCallback<String>() {
                public void onFailure(Throwable error) {
                    System.out.println("Failed to lazy load content");
                }

                public void onSuccess(String content) {
                    if (layoutPanel.getWidgetIndex(HTMLContent) < 0 ) {
                        layoutPanel.add(HTMLContent);
                    }
                    
                    HTMLContent.setHTML(content);

                }
            });
        } catch (AuthException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    private void saveToServer() {
        
        try {
            contentService.saveContent(contentId, HTMLContent.getHTML(), new AsyncCallback<String>() {
                public void onFailure(Throwable error) {
                    System.out.println("Failed to save content");
                }

                public void onSuccess(String content) {
                    System.out.println("Saved content ok");
                }
            });
        } catch (AuthException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}

