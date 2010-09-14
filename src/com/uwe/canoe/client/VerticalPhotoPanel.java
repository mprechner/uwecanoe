package com.uwe.canoe.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;

/**
 * Panel containing vertical small picture icons.
 *
 * @author Matthew Prechner
 *
 */
public class VerticalPhotoPanel extends Composite {

    /** vertical photo panel class name. */
    public static final String CLASS_VERTICAL_PHOTO_PANEL = "verticalPhotoPanel";

    /**
     * Create panel containing vertical picture icons.
     */
    public VerticalPhotoPanel() {
        // All composites must call initWidget() in their constructors.
        initWidget(new Image("leftImagesTmp.png"));

        setStyleName(CLASS_VERTICAL_PHOTO_PANEL);
    }
}
