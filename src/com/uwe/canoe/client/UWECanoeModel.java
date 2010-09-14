package com.uwe.canoe.client;

import com.uwe.canoe.client.contentservice.ContentModel;
import com.uwe.canoe.client.login.LoginModel;

public class UWECanoeModel {

    /** Login info model. */
    private LoginModel loginModel = null;
    
    /** Main panel content model. */
    private ContentModel contentModel = null;
    
    /**
     * Default constructor, inializes all models
     */
    public UWECanoeModel() {
        loginModel = new LoginModel();
        contentModel = new ContentModel();
    }

    
    /**
     * Get login info model
     * @return
     *      LoginModel - login info model
     */
    public LoginModel getLoginModel() {
        return loginModel;
    }
    
    public ContentModel getContentModel() {
        return contentModel;
    }
}
