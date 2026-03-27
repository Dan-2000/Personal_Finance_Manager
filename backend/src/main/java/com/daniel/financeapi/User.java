package com.daniel.financeapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import jakarta.persistence.Column;
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

   @OneToMany(mappedBy = "user")
   private List<Transaction> transactions;
   public User() {}
   public User(String email, String password){
    this.email = email;
    this.password = password;
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

   public void setEmail(String email) {
      this.email = email;
   }

   public void setPassword(String password) {
      this.password = password;
   }

}
