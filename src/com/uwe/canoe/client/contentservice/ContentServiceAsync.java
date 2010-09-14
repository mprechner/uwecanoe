package com.uwe.canoe.client.contentservice;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uwe.canoe.client.login.AuthException;

public interface ContentServiceAsync {
  public void  getContent(String id, AsyncCallback<String> async) throws AuthException;
  public void  saveContent(String id, String html, AsyncCallback<String> async) throws AuthException;
}
