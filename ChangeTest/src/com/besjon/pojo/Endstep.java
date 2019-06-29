/**
  * Copyright 2019 bejson.com 
  */
package com.besjon.pojo;
import java.util.List;

/**
 * Auto-generated: 2019-06-26 8:52:50
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Endstep {

    private String id;
    private Geometry geometry;
    private List<In> in;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setGeometry(Geometry geometry) {
         this.geometry = geometry;
     }
     public Geometry getGeometry() {
         return geometry;
     }

    public void setIn(List<In> in) {
         this.in = in;
     }
     public List<In> getIn() {
         return in;
     }

}