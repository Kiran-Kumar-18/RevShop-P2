package com.rev.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class RegisterRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(max = 100)
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    @Size(max = 20)
    private String phone;
    @NotBlank(message = "Role is required")
    private String role; // BUYER or SELLER
    private String address;
    private String businessName;
    private String gstNumber;
    
    @NotBlank(message = "Security Question is required")
    private String securityQuestion;
    
    @NotBlank(message = "Security Answer is required")
    private String securityAnswer;

    @java.lang.SuppressWarnings("all")
    public static class RegisterRequestDTOBuilder {
        @java.lang.SuppressWarnings("all")
        private String name;
        @java.lang.SuppressWarnings("all")
        private String email;
        @java.lang.SuppressWarnings("all")
        private String password;
        @java.lang.SuppressWarnings("all")
        private String phone;
        @java.lang.SuppressWarnings("all")
        private String role;
        @java.lang.SuppressWarnings("all")
        private String address;
        @java.lang.SuppressWarnings("all")
        private String businessName;
        @java.lang.SuppressWarnings("all")
        private String gstNumber;
        @java.lang.SuppressWarnings("all")
        private String securityQuestion;
        @java.lang.SuppressWarnings("all")
        private String securityAnswer;

        @java.lang.SuppressWarnings("all")
        RegisterRequestDTOBuilder() {
        }

        @java.lang.SuppressWarnings("all")
        public RegisterRequestDTO.RegisterRequestDTOBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public RegisterRequestDTO.RegisterRequestDTOBuilder email(final String email) {
            this.email = email;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public RegisterRequestDTO.RegisterRequestDTOBuilder password(final String password) {
            this.password = password;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public RegisterRequestDTO.RegisterRequestDTOBuilder phone(final String phone) {
            this.phone = phone;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public RegisterRequestDTO.RegisterRequestDTOBuilder role(final String role) {
            this.role = role;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public RegisterRequestDTO.RegisterRequestDTOBuilder address(final String address) {
            this.address = address;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public RegisterRequestDTO.RegisterRequestDTOBuilder businessName(final String businessName) {
            this.businessName = businessName;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public RegisterRequestDTO.RegisterRequestDTOBuilder gstNumber(final String gstNumber) {
            this.gstNumber = gstNumber;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public RegisterRequestDTO.RegisterRequestDTOBuilder securityQuestion(final String securityQuestion) {
            this.securityQuestion = securityQuestion;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public RegisterRequestDTO.RegisterRequestDTOBuilder securityAnswer(final String securityAnswer) {
            this.securityAnswer = securityAnswer;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public RegisterRequestDTO build() {
            return new RegisterRequestDTO(this.name, this.email, this.password, this.phone, this.role, this.address, this.businessName, this.gstNumber, this.securityQuestion, this.securityAnswer);
        }
    }

    @java.lang.SuppressWarnings("all")
    public static RegisterRequestDTO.RegisterRequestDTOBuilder builder() {
        return new RegisterRequestDTO.RegisterRequestDTOBuilder();
    }

    @java.lang.SuppressWarnings("all")
    public String getName() {
        return this.name;
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
    public String getPhone() {
        return this.phone;
    }

    @java.lang.SuppressWarnings("all")
    public String getRole() {
        return this.role;
    }

    @java.lang.SuppressWarnings("all")
    public String getAddress() {
        return this.address;
    }

    @java.lang.SuppressWarnings("all")
    public String getBusinessName() {
        return this.businessName;
    }

    @java.lang.SuppressWarnings("all")
    public String getGstNumber() {
        return this.gstNumber;
    }

    @java.lang.SuppressWarnings("all")
    public String getSecurityQuestion() {
        return this.securityQuestion;
    }

    @java.lang.SuppressWarnings("all")
    public String getSecurityAnswer() {
        return this.securityAnswer;
    }

    @java.lang.SuppressWarnings("all")
    public void setName(final String name) {
        this.name = name;
    }

    @java.lang.SuppressWarnings("all")
    public void setEmail(final String email) {
        this.email = email;
    }

    @java.lang.SuppressWarnings("all")
    public void setPassword(final String password) {
        this.password = password;
    }

    @java.lang.SuppressWarnings("all")
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    @java.lang.SuppressWarnings("all")
    public void setRole(final String role) {
        this.role = role;
    }

    @java.lang.SuppressWarnings("all")
    public void setAddress(final String address) {
        this.address = address;
    }

    @java.lang.SuppressWarnings("all")
    public void setBusinessName(final String businessName) {
        this.businessName = businessName;
    }

    @java.lang.SuppressWarnings("all")
    public void setGstNumber(final String gstNumber) {
        this.gstNumber = gstNumber;
    }

    @java.lang.SuppressWarnings("all")
    public void setSecurityQuestion(final String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    @java.lang.SuppressWarnings("all")
    public void setSecurityAnswer(final String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    @java.lang.SuppressWarnings("all")
    public RegisterRequestDTO() {
    }

    @java.lang.SuppressWarnings("all")
    public RegisterRequestDTO(final String name, final String email, final String password, final String phone, final String role, final String address, final String businessName, final String gstNumber, final String securityQuestion, final String securityAnswer) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.address = address;
        this.businessName = businessName;
        this.gstNumber = gstNumber;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }
}

