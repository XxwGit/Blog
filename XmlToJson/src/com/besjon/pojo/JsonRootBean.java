/**
  * Copyright 2019 bejson.com 
  */
package com.besjon.pojo;
import java.util.List;

/**
 * Auto-generated: 2019-06-28 17:19:37
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

    private String Id;
    private String UUID;
    private String Level;
    private String Quote;
    private String Desp;
    private String RefImpl;
    private String Auth;
    private String ReadOnly;
    private String ToolTip;
    private InArgs InArgs;
    private OutArgs OutArgs;
    private Implementation Implementation;
    public void setId(String Id) {
         this.Id = Id;
     }
     public String getId() {
         return Id;
     }

    public void setUUID(String UUID) {
         this.UUID = UUID;
     }
     public String getUUID() {
         return UUID;
     }

    public void setLevel(String Level) {
         this.Level = Level;
     }
     public String getLevel() {
         return Level;
     }

    public void setQuote(String Quote) {
         this.Quote = Quote;
     }
     public String getQuote() {
         return Quote;
     }

    public void setDesp(String Desp) {
         this.Desp = Desp;
     }
     public String getDesp() {
         return Desp;
     }

    public void setRefImpl(String RefImpl) {
         this.RefImpl = RefImpl;
     }
     public String getRefImpl() {
         return RefImpl;
     }

    public void setAuth(String Auth) {
         this.Auth = Auth;
     }
     public String getAuth() {
         return Auth;
     }

    public void setReadOnly(String ReadOnly) {
         this.ReadOnly = ReadOnly;
     }
     public String getReadOnly() {
         return ReadOnly;
     }

    public void setToolTip(String ToolTip) {
         this.ToolTip = ToolTip;
     }
     public String getToolTip() {
         return ToolTip;
     }

     

    public InArgs getInArgs() {
		return InArgs;
	}
	public void setInArgs(InArgs inArgs) {
		InArgs = inArgs;
	}
	public OutArgs getOutArgs() {
		return OutArgs;
	}
	public void setOutArgs(OutArgs outArgs) {
		OutArgs = outArgs;
	}
	public void setImplementation(Implementation Implementation) {
         this.Implementation = Implementation;
     }
     public Implementation getImplementation() {
         return Implementation;
     }

}