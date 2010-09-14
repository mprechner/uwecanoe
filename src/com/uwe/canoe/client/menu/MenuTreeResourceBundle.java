package com.uwe.canoe.client.menu;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Tree;;
/**
 * A ClientBundle that provides images for this widget.
 */
public interface MenuTreeResourceBundle extends Tree.Resources {
    /**
     * An image indicating a closed branch.
     */
    ImageResource treeClosed();

    /**
     * An image indicating a leaf.
     */
    ImageResource treeLeaf();

    /**
     * An image indicating an open branch.
     */
    ImageResource treeOpen();

}
