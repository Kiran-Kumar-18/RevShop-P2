package com.rev.app.dto;

import jakarta.validation.constraints.NotBlank;

public class ResetPasswordRequestDTO {
    @NotBlank(message = "Email is required")
    private String email;
    
    @NotBlank(message = "Security Answer is required")
    private String securityAnswer;
    
    @NotBlank(message = "New Password is required")
    private String newPassword;
    
    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;

    public ResetPasswordRequestDTO() {}

    public ResetPasswordRequestDTO(String email, String securityAnswer, String newPassword, String confirmPassword) {
        this.email = email;
        this.securityAnswer = securityAnswer;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSecurityAnswer() { return securityAnswer; }
    public void setSecurityAnswer(String securityAnswer) { this.securityAnswer = securityAnswer; }

    public String getNewPassword() { return newPassword; }
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
}
