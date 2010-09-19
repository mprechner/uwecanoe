package com.uwe.canoe.server.contentservice;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.google.appengine.api.datastore.Text;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.uwe.canoe.client.contentservice.ContentService;
import com.uwe.canoe.client.login.AuthException;

public class ContentServiceImpl extends RemoteServiceServlet implements
ContentService {

  private static final PersistenceManagerFactory PMF =
      JDOHelper.getPersistenceManagerFactory("transactions-optional");



    @Override
    public String getContent(String id) throws AuthException {
        Content content = null;
        PersistenceManager pm = getPersistenceManager();
        try {
          long deleteCount = 0;
          Query q = pm.newQuery(Content.class, "contentId == c");
          q.declareParameters("java.lang.String c");
          
          List<Content> contentList = (List<Content>) q.execute(id);
          
          if (contentList.size() == 0) {
              System.out.println("content 0");
              content = addContent(id);
          } else {
              content = contentList.get(0);
              System.out.println("content 1");
          }
        } finally {
          pm.close();
        }
        
        String strContent = "";
        if (content != null) {
            strContent = content.getHtml().getValue();
        }
        return strContent;
    }
    
    private Content addContent(String id) {
        Content newContent = new Content(id, new Text("HTML " + id));
        PersistenceManager pm = getPersistenceManager();
        try {
          pm.makePersistent(newContent);
        } finally {
          pm.close();
        }
        
        return newContent;
    }
    
    private PersistenceManager getPersistenceManager() {
        return PMF.getPersistenceManager();
      }

    @Override
    public String saveContent(String id, String html) throws AuthException {
        Content content = null;
        PersistenceManager pm = getPersistenceManager();
        try {
          long deleteCount = 0;
          Query q = pm.newQuery(Content.class, "contentId == c");
          q.declareParameters("java.lang.String c");
          
          List<Content> contentList = (List<Content>) q.execute(id);
          
          if (contentList.size() == 0) {
              System.out.println("Error content doesn't exist");
              content = addContent(id);
          } else {
              content = contentList.get(0);
              content.setHtml(new Text(html));
          }
        } finally {
          pm.close();
        }
        
        return "";
    }
}
