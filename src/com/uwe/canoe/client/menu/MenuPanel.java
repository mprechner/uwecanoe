package com.uwe.canoe.client.menu;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.Tree.Resources;
import com.google.gwt.user.client.ui.TreeItem;
import com.uwe.canoe.client.panels.HomePanel;

/**
 * Create menu panel.
 * 
 * @author Matthew Prechner
 *
 */
public class MenuPanel extends Composite {

    /** Resource bundle containing tree node images. */
    public static final MenuTreeResourceBundle resourceBundle = 
        (MenuTreeResourceBundle)GWT.create(MenuTreeResourceBundle.class);
    
    /** 
     * Resource bundle containing tree node images for empty trees, i.e. trees with only a single
     * child, the root node. This is requires a separate leaf not image to be used.
     */
    public static final EmptyMenuTreeResourceBundle emptyResourceBundle = 
        (EmptyMenuTreeResourceBundle)GWT.create(EmptyMenuTreeResourceBundle.class);
    
    /** Menu panel class name. */
    public static final String CLASS_MENU_PANEL = "menuPanel";
    
    /** List of tree objects, each of which represents a menu item. */
    private ArrayList<Tree> menuTrees = null;
    
    /** Flow panel containing menu trees. */
    private FlowPanel flowPanel = null;
    
    
    /**
     * Create menu panel.
     */
    public MenuPanel() {
        // Create list of menu trees
        menuTrees = new ArrayList<Tree>();
        
        // Create flow panel
        flowPanel = new FlowPanel();
        
        // Home
        TreeItem rootNode = addEmptyMenuTree(HomePanel.HOME);

        // Freshers
        TreeItem freshersNode = addEmptyMenuTree("Freshers");

        // Forum
        TreeItem forumNode = addEmptyMenuTree("Forum");

        // Trips
        rootNode = addMenuTree("Trips");
        addMenuItem(rootNode, "What To Bring");
        
        // Socials
        TreeItem socialsNode = addEmptyMenuTree("Socials");
        
        // Pool Sessions
        TreeItem trainingNode = addEmptyMenuTree("Pool Sessions");

        // Polo
        TreeItem competitionsNode = addEmptyMenuTree("Polo");
        
        // Polo
        TreeItem slalomNode = addEmptyMenuTree("Slalom");
        
        // Media
        TreeItem mediaNode = addEmptyMenuTree("Media");

        // Committee
        TreeItem committeeNode = addEmptyMenuTree("Committee");

        // Code of Conduct 
        TreeItem codeOfConductNode = addEmptyMenuTree("Code of Conduct");

        // Links
        TreeItem linksNode = addEmptyMenuTree("Links");

        // Initialise panel
        initWidget(flowPanel);
        setStyleName(CLASS_MENU_PANEL);  
    }
    
    public ArrayList<Tree> getMenuTrees() {
        return menuTrees;
    }
    
    
    /**
     * Create new empty menu tree with the root node containing the specified text.
     * Will use the empty image resource bundle.
     * 
     * @param rootNodeText
     *  String - root node text
     * @return
     *  TreeItem - root node of the tree
     */
    private TreeItem addEmptyMenuTree(String rootNodeText) {
        return addMenuTree(rootNodeText, (Resources) emptyResourceBundle);
    }
    
    
    /**
     * Create new empty menu tree with the root node containing the specified text.
     * Will use the default image resource bundle.
     * 
     * @param rootNodeText
     *  String - root node text
     * @return
     *  TreeItem - root node of the tree
     */
    private TreeItem addMenuTree(String rootNodeText) {
        return addMenuTree(rootNodeText, (Resources) resourceBundle);
    }
    
    
    /**
     * Add new new menu tree
     * 
     * @param rootNodeText
     *  String - root node text
     * @return
     *  TreeItem - root node of the tree
     */
    private TreeItem addMenuTree(String rootNodeText, Resources treeResources) {
        // Add root node
        TreeItem rootNode = new TreeItem(rootNodeText);
        rootNode.addStyleName("rootMenuItem");

        // Create tree with menu resources and leaf node icons displayed
        final Tree tree = new Tree(treeResources, true);
        tree.addStyleName("menuItem");
        tree.addItem(rootNode);
        
        // Add menu handlers
        tree.addMouseOverHandler(new MenuMouseOverHandler());
        tree.addMouseOutHandler(new MenuMouseOutHandler());
        tree.addSelectionHandler(new MenuSelectionHandler());
        
        // Add tree to list and panel
        menuTrees.add(tree);
        flowPanel.add(tree);
        
        return rootNode;
    }
    
    
    /**
     * Add a child node to a menu tree.
     * 
     * @param rootNode
     *  TreeItem - Root node of menu tree
     * @param menuItemText
     *  String - Text of root node
     * @return
     *  TreeItem - child node
     */
    private TreeItem addMenuItem(TreeItem rootNode, String menuItemText) {
        TreeItem menuItem = new TreeItem(menuItemText);
        menuItem.addStyleName("childMenuItem");
        rootNode.addItem(menuItem);
        return menuItem;
    }
    
    
    class MenuMouseOverHandler implements MouseOverHandler {
        @Override
        public void onMouseOver(MouseOverEvent event) {
            Object obj = event.getSource();
            if (obj instanceof Tree) {
                Tree tree = (Tree) obj;
                tree.addStyleName("menuTreeMouseOver");
            }
        }
    }
    
    
    class MenuMouseOutHandler implements MouseOutHandler {
        @Override
        public void onMouseOut(MouseOutEvent event) {
            Object obj = event.getSource();
            if (obj instanceof Tree) {
                Tree tree = (Tree) obj;
                tree.removeStyleName("menuTreeMouseOver");
            }
        }
    }
    
    class MenuSelectionHandler implements SelectionHandler<TreeItem> {

        @Override
        public void onSelection(SelectionEvent<TreeItem> event) {
            Object obj = event.getSource();
            if (obj instanceof Tree) {            
                Tree tree = (Tree) obj;
                
                // Remove any existing selections
                removeAllSelections(tree);
                
                tree.addStyleName("menuTreeSelected");
            }
            
        } 
    }
    
    
    /**
     * Remove any selections on any other tables
     */
    private void removeAllSelections(final Tree selectedTree) {
        for (Tree tree : menuTrees) {
            if (!tree.equals(selectedTree)){
                tree.removeStyleName("menuTreeSelected");
                
                // Unselect all child nodes
                if (tree.getItemCount() > 0) {       
                    unselectNode(tree.getItem(0));
                }
            }
        }
    }
    
    private void unselectNode(TreeItem node) {
        node.setSelected(false);
        
        // Unselect child
        for (int i=0; i<node.getChildCount(); i++) {
            unselectNode(node.getChild(i));
        }
    }

}
