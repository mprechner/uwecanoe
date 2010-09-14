package com.uwe.canoe.client.contentservice;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uwe.canoe.client.login.AuthException;

    @RemoteServiceRelativePath("content")
    public interface ContentService extends RemoteService {
      public String getContent(String id) throws AuthException;
      public String saveContent(String id, String html) throws AuthException;
    }
