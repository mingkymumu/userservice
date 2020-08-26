package com.noer.userservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain=true)
@Table(name = "user_account")
public class UserAccount implements Serializable {
   private static final long serialVersionUID = 2L;

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;
   @NotEmpty(message = "First name is required")
   private String firstName;
   @NotEmpty(message = "Last name is required")
   private String lastName;
   private String email;
   private String address;

   public String getFullName() {
      return firstName.concat(" ").concat(lastName);
   }
}
