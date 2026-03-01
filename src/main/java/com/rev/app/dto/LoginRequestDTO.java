package com.rev.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class LoginRequestDTO {
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;


    @java.lang.SuppressWarnings("all")
    
    public static class LoginRequestDTOBuilder {
        @java.lang.SuppressWarnings("all")
        
        private String email;
        @java.lang.SuppressWarnings("all")
        
        private String password;

        @java.lang.SuppressWarnings("all")
        
        LoginRequestDTOBuilder() {
        }

        @java.lang.SuppressWarnings("all")
        
        public LoginRequestDTO.LoginRequestDTOBuilder email(final String email) {
            this.email = email;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public LoginRequestDTO.LoginRequestDTOBuilder password(final String password) {
            this.password = password;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public LoginRequestDTO build() {
            return new LoginRequestDTO(this.email, this.password);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "LoginRequestDTO.LoginRequestDTOBuilder(email=" + this.email + ", password=" + this.password + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static LoginRequestDTO.LoginRequestDTOBuilder builder() {
        return new LoginRequestDTO.LoginRequestDTOBuilder();
    }

    @java.lang.SuppressWarnings("all")
    
    public String getEmail() {
        return this.email;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getPassword() {
        return this.password;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setEmail(final String email) {
        this.email = email;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setPassword(final String password) {
        this.password = password;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof LoginRequestDTO)) return false;
        final LoginRequestDTO other = (LoginRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$email = this.getEmail();
        final java.lang.Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final java.lang.Object this$password = this.getPassword();
        final java.lang.Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof LoginRequestDTO;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final java.lang.Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public java.lang.String toString() {
        return "LoginRequestDTO(email=" + this.getEmail() + ", password=" + this.getPassword() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public LoginRequestDTO() {
    }

    @java.lang.SuppressWarnings("all")
    
    public LoginRequestDTO(final String email, final String password) {
        this.email = email;
        this.password = password;
    }
}
