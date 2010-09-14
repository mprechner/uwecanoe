package com.uwe.canoe.client;

import com.uwe.canoe.client.contentservice.ContentController;

public class UWECanoeController {

    /* MAIN MODEL/VIEW INSTANCES */
    
    /** Main view class. */
    private UWECanoeView view = null;
    
    /** Main model class. */
    private UWECanoeModel model = null;
    
    /* CONTROLLERS */
    
    private ContentController contentController = null;
    
    /**
     * Constructor, takes model and view as parameters 
     */
    public UWECanoeController(UWECanoeView view, UWECanoeModel model) {
        this.view = view;
        this.model = model;

        this.contentController = new ContentController(view,
                this.model.getContentModel());

        
    }
}
