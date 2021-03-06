package org.demo.model;

// Generated Sep 29, 2014 1:57:16 PM by Hibernate Tools 4.3.1

import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Office generated by hbm2java
 */
@Entity
@Table(name = "office", schema = "public")
public class Office implements java.io.Serializable
{

   private long id;
   private Integer version;
   private String city;

   private static final Logger LOG = Logger.getLogger(Office.class.getName());

   public Office()
   {
   }

   public Office(long id, String city)
   {
      this.id = id;
      this.city = city;
   }

   @Id
   @Column(name = "id", unique = true, nullable = false)
   @GeneratedValue
   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   @Version
   @Column(name = "version")
   public Integer getVersion()
   {
      return this.version;
   }

   public void setVersion(Integer version)
   {
      this.version = version;
   }

   @Column(name = "city", nullable = false)
   public String getCity()
   {
      return this.city;
   }

   public void setCity(String city)
   {
      this.city = city;
   }

   @Override
   public String toString()
   {
      return city;
   }

}
