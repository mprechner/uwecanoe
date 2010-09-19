package com.uwe.canoe.server.contentservice;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Text;

/**
 * @author temp
 *
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Content {

  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Long id;
  @Persistent
  private String contentId;
  @Persistent
  private Date createDate;
  @Persistent
  private Text html;
  

  public Content() {
    this.createDate = new Date();
  }

  public Content(String contentId, Text html) {
    this();
    this.contentId = contentId;
    this.html = html;
  }

  public Long getId() {
    return this.id;
  }

  public String getContentId() {
    return this.contentId;
  }
  
    public Text getHtml() {
        return this.html;
    }
  
  public Date getCreateDate() {
    return this.createDate;
  }

  public void setConentId(String contentId) {
    this.contentId = contentId;
  }

  public void setHtml(Text html) {
    this.html = html;
  }
}
