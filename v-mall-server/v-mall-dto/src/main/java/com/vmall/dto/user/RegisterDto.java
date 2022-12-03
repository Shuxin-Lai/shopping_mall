package com.vmall.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterDto {

  @NotNull(message = "email should not be null")
  @Email(message = "invalid email")
  @NotEmpty(message = "invalid email")
  private String email;

  @NotNull(
    message = "password length should greater than 6 and shorter than 50"
  )
  @Size(min = 6, max = 50)
  private String password;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
