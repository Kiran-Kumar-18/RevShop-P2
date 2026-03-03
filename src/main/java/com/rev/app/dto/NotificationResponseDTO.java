package com.rev.app.dto;

import java.time.LocalDateTime;

public class NotificationResponseDTO {
    private Integer notificationId;
    private Integer userId;
    private String title;
    private String message;
    private String type;
    private Boolean isRead;
    private LocalDateTime createdAt;


    @java.lang.SuppressWarnings("all")
    
    public static class NotificationResponseDTOBuilder {
        @java.lang.SuppressWarnings("all")
        
        private Integer notificationId;
        @java.lang.SuppressWarnings("all")
        
        private Integer userId;
        @java.lang.SuppressWarnings("all")
        
        private String title;
        @java.lang.SuppressWarnings("all")
        
        private String message;
        @java.lang.SuppressWarnings("all")
        
        private String type;
        @java.lang.SuppressWarnings("all")
        
        private Boolean isRead;
        @java.lang.SuppressWarnings("all")
        
        private LocalDateTime createdAt;

        @java.lang.SuppressWarnings("all")
        
        NotificationResponseDTOBuilder() {
        }


        @java.lang.SuppressWarnings("all")
        
        public NotificationResponseDTO.NotificationResponseDTOBuilder notificationId(final Integer notificationId) {
            this.notificationId = notificationId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public NotificationResponseDTO.NotificationResponseDTOBuilder userId(final Integer userId) {
            this.userId = userId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public NotificationResponseDTO.NotificationResponseDTOBuilder title(final String title) {
            this.title = title;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public NotificationResponseDTO.NotificationResponseDTOBuilder message(final String message) {
            this.message = message;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public NotificationResponseDTO.NotificationResponseDTOBuilder type(final String type) {
            this.type = type;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public NotificationResponseDTO.NotificationResponseDTOBuilder isRead(final Boolean isRead) {
            this.isRead = isRead;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public NotificationResponseDTO.NotificationResponseDTOBuilder createdAt(final LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public NotificationResponseDTO build() {
            return new NotificationResponseDTO(this.notificationId, this.userId, this.title, this.message, this.type, this.isRead, this.createdAt);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "NotificationResponseDTO.NotificationResponseDTOBuilder(notificationId=" + this.notificationId + ", userId=" + this.userId + ", title=" + this.title + ", message=" + this.message + ", type=" + this.type + ", isRead=" + this.isRead + ", createdAt=" + this.createdAt + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static NotificationResponseDTO.NotificationResponseDTOBuilder builder() {
        return new NotificationResponseDTO.NotificationResponseDTOBuilder();
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getNotificationId() {
        return this.notificationId;
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getUserId() {
        return this.userId;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getTitle() {
        return this.title;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getMessage() {
        return this.message;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getType() {
        return this.type;
    }

    @java.lang.SuppressWarnings("all")
    
    public Boolean getIsRead() {
        return this.isRead;
    }

    @java.lang.SuppressWarnings("all")
    
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setNotificationId(final Integer notificationId) {
        this.notificationId = notificationId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setTitle(final String title) {
        this.title = title;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setMessage(final String message) {
        this.message = message;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setType(final String type) {
        this.type = type;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setIsRead(final Boolean isRead) {
        this.isRead = isRead;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof NotificationResponseDTO)) return false;
        final NotificationResponseDTO other = (NotificationResponseDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$notificationId = this.getNotificationId();
        final java.lang.Object other$notificationId = other.getNotificationId();
        if (this$notificationId == null ? other$notificationId != null : !this$notificationId.equals(other$notificationId)) return false;
        final java.lang.Object this$userId = this.getUserId();
        final java.lang.Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final java.lang.Object this$isRead = this.getIsRead();
        final java.lang.Object other$isRead = other.getIsRead();
        if (this$isRead == null ? other$isRead != null : !this$isRead.equals(other$isRead)) return false;
        final java.lang.Object this$title = this.getTitle();
        final java.lang.Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final java.lang.Object this$message = this.getMessage();
        final java.lang.Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
        final java.lang.Object this$type = this.getType();
        final java.lang.Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final java.lang.Object this$createdAt = this.getCreatedAt();
        final java.lang.Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof NotificationResponseDTO;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $notificationId = this.getNotificationId();
        result = result * PRIME + ($notificationId == null ? 43 : $notificationId.hashCode());
        final java.lang.Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final java.lang.Object $isRead = this.getIsRead();
        result = result * PRIME + ($isRead == null ? 43 : $isRead.hashCode());
        final java.lang.Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final java.lang.Object $message = this.getMessage();
        result = result * PRIME + ($message == null ? 43 : $message.hashCode());
        final java.lang.Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final java.lang.Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public java.lang.String toString() {
        return "NotificationResponseDTO(notificationId=" + this.getNotificationId() + ", userId=" + this.getUserId() + ", title=" + this.getTitle() + ", message=" + this.getMessage() + ", type=" + this.getType() + ", isRead=" + this.getIsRead() + ", createdAt=" + this.getCreatedAt() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public NotificationResponseDTO() {
    }

    @java.lang.SuppressWarnings("all")
    
    public NotificationResponseDTO(final Integer notificationId, final Integer userId, final String title, final String message, final String type, final Boolean isRead, final LocalDateTime createdAt) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.title = title;
        this.message = message;
        this.type = type;
        this.isRead = isRead;
        this.createdAt = createdAt;
    }
}
