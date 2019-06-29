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
public class Node {

    private String Id;
    private String Name;
    private String Desp;
    private String Sql;
    private String Type;
    private String Target;
    private String Style;
    private String Tooltip;
    private String Visible;
    private String Collapse;
    private Constraint Constraint;
    private String SourceConnections;
    private String InArgs;
    private String OutArgs;
    private List<String> Logic;
    public void setId(String Id) {
         this.Id = Id;
     }
     public String getId() {
         return Id;
     }

    public void setName(String Name) {
         this.Name = Name;
     }
     public String getName() {
         return Name;
     }

    public void setDesp(String Desp) {
         this.Desp = Desp;
     }
     public String getDesp() {
         return Desp;
     }

    public void setSql(String Sql) {
         this.Sql = Sql;
     }
     public String getSql() {
         return Sql;
     }

    public void setType(String Type) {
         this.Type = Type;
     }
     public String getType() {
         return Type;
     }

    public void setTarget(String Target) {
         this.Target = Target;
     }
     public String getTarget() {
         return Target;
     }

    public void setStyle(String Style) {
         this.Style = Style;
     }
     public String getStyle() {
         return Style;
     }

    public void setTooltip(String Tooltip) {
         this.Tooltip = Tooltip;
     }
     public String getTooltip() {
         return Tooltip;
     }

    public void setVisible(String Visible) {
         this.Visible = Visible;
     }
     public String getVisible() {
         return Visible;
     }

    public void setCollapse(String Collapse) {
         this.Collapse = Collapse;
     }
     public String getCollapse() {
         return Collapse;
     }

    public void setConstraint(Constraint Constraint) {
         this.Constraint = Constraint;
     }
     public Constraint getConstraint() {
         return Constraint;
     }

    public void setSourceConnections(String SourceConnections) {
         this.SourceConnections = SourceConnections;
     }
     public String getSourceConnections() {
         return SourceConnections;
     }

    public void setInArgs(String InArgs) {
         this.InArgs = InArgs;
     }
     public String getInArgs() {
         return InArgs;
     }

    public void setOutArgs(String OutArgs) {
         this.OutArgs = OutArgs;
     }
     public String getOutArgs() {
         return OutArgs;
     }

    public void setLogic(List<String> Logic) {
         this.Logic = Logic;
     }
     public List<String> getLogic() {
         return Logic;
     }

}