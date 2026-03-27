package com.daniel.financeapi.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long UserID;

   @Email(message = "Email is not valid.")
   @NotBlank(message = "Email is required.")
   @Column(unique = true, nullable = false)
   private String email;

   @Column(nullable = false)
   @Size(min = 8, message = "Password must be at least 8 characters")
   private String password;

  @NotNull(message = "Role type is required.")
  @Enumerated(EnumType.STRING)
   private RoleType role;

   @OneToMany(mappedBy = "user")
   private List<Transaction> transactions;
   public User() {}
   public User(String email, String password, RoleType role){
    this.email = email;
    this.password = password;
    this.role = role;
   }
   public Long getUserID() {
    return UserID;
   }

   public String getEmail() {
    return email;
   }

   public String getPassword() {
    return password;
   }

   public RoleType getRole() {
      return role;
   }
   
   public enum RoleType {
      ADMIN,USER
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setPassword(String password) {
      this.password = password;
   }
   public void setRoleType(RoleType roleType) {
      this.role = role;
   }

}
