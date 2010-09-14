package com.uwe.canoe.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.uwe.canoe.client.contentservice.ContentModel;

public class HTMLContentPanel extends ContentPanel {

    public static final String EDIT_TEXT = "Edit";
    
    public static final String SAVE_TEXT = "Save";
    
    private Label editLabel = new Label (EDIT_TEXT);
    
    private RichTextArea editTextArea = new RichTextArea();
        
    private RichTextToolbar toolBar = new RichTextToolbar(editTextArea);
    
    private ContentModel contentModel = null;
    
    public HTMLContentPanel(String iconUrl, String titleText, ContentModel contentModel) {
        super(iconUrl, titleText);
      
        this.contentModel = contentModel;
        
        // Initialise edit label
        editLabel.setStyleName("editLabel");
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
        editTextArea.setHTML(content.getHTML());
        
        layoutPanel.remove(content);
        layoutPanel.add(toolBar);
        layoutPanel.add(editTextArea);
    }
    
    public void saveContent() {
        editLabel.setText(EDIT_TEXT);
        content.setHTML(editTextArea.getHTML());
        
        layoutPanel.remove(toolBar);
        layoutPanel.remove(editTextArea);
        layoutPanel.add(content);
    }
    
    public void updateViewHTML() {
        if (contentModel.getPanel() != null) {
            layoutPanel.remove(contentModel.getPanel());
        }
        
        content.setVisible(true);

        this.setContent(contentModel.getHtml());
        this.setTitleLabelText(contentModel.getId());
    }
    
    public void updateViewPanel() {
        this.setEditable(false);
        
        content.setVisible(false);
        //layoutPanel.remove(content);
        layoutPanel.add(contentModel.getPanel());
        this.setTitleLabelText(contentModel.getId());
    }
    
    
    
}
