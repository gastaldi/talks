package org.demo.model;

// Generated Sep 29, 2014 1:57:16 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.GeneratedValue;

import java.util.logging.Logger;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", schema = "public")
public class Employee implements java.io.Serializable
{

   private long id;
   private Integer version;
   private Office office;
   private Role role;
   private String email;
   private String firstname;
   private String lastname;

   private static final Logger LOG = Logger
         .getLogger(Employee.class.getName());

   public Employee()
   {
   }

   public Employee(long id)
   {
      this.id = id;
   }

   public Employee(long id, Office office, Role role, String email,
         String firstname, String lastname)
   {
      this.id = id;
      this.office = office;
      this.role = role;
      this.email = email;
      this.firstname = firstname;
      this.lastname = lastname;
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

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "office_id")
   public Office getOffice()
   {
      return this.office;
   }

   public void setOffice(Office office)
   {
      this.office = office;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "role_id")
   public Role getRole()
   {
      return this.role;
   }

   public void setRole(Role role)
   {
      this.role = role;
   }

   @Column(name = "email")
   public String getEmail()
   {
      return this.email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   @Column(name = "firstname")
   public String getFirstname()
   {
      return this.firstname;
   }

   public void setFirstname(String firstname)
   {
      this.firstname = firstname;
   }

   @Column(name = "lastname")
   public String getLastname()
   {
      return this.lastname;
   }

   public void setLastname(String lastname)
   {
      this.lastname = lastname;
   }

   @Override
   public String toString()
   {
      return firstname + " " + lastname;
   }

}