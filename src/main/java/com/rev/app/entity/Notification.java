package com.rev.app.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Integer notificationId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(length = 150)
    private String title;
    @Lob
    @Column(name = "message")
    private String message;
    @Column(length = 30)
    private String type;
    @Column(name = "is_read")
    private Boolean isRead;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;


    @java.lang.SuppressWarnings("all")
    
    public static class NotificationBuilder {
        @java.lang.SuppressWarnings("all")
        
        private Integer notificationId;
        @java.lang.SuppressWarnings("all")
        
        private User user;
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
        
        NotificationBuilder() {
        }


        @java.lang.SuppressWarnings("all")
        
        public Notification.NotificationBuilder notificationId(final Integer notificationId) {
            this.notificationId = notificationId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public Notification.NotificationBuilder user(final User user) {
            this.user = user;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public Notification.NotificationBuilder title(final String title) {
            this.title = title;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public Notification.NotificationBuilder message(final String message) {
            this.message = message;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public Notification.NotificationBuilder type(final String type) {
            this.type = type;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public Notification.NotificationBuilder isRead(final Boolean isRead) {
            this.isRead = isRead;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public Notification.NotificationBuilder createdAt(final LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public Notification build() {
            return new Notification(this.notificationId, this.user, this.title, this.message, this.type, this.isRead, this.createdAt);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "Notification.NotificationBuilder(notificationId=" + this.notificationId + ", user=" + this.user + ", title=" + this.title + ", message=" + this.message + ", type=" + this.type + ", isRead=" + this.isRead + ", createdAt=" + this.createdAt + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static Notification.NotificationBuilder builder() {
        return new Notification.NotificationBuilder();
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getNotificationId() {
        return this.notificationId;
    }

    @java.lang.SuppressWarnings("all")
    
    public User getUser() {
        return this.user;
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
    
    public void setUser(final User user) {
        this.user = user;
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
        if (!(o instanceof Notification)) return false;
        final Notification other = (Notification) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$notificationId = this.getNotificationId();
        final java.lang.Object other$notificationId = other.getNotificationId();
        if (this$notificationId == null ? other$notificationId != null : !this$notificationId.equals(other$notificationId)) return false;
        final java.lang.Object this$isRead = this.getIsRead();
        final java.lang.Object other$isRead = other.getIsRead();
        if (this$isRead == null ? other$isRead != null : !this$isRead.equals(other$isRead)) return false;
        final java.lang.Object this$user = this.getUser();
        final java.lang.Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
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
        return other instanceof Notification;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $notificationId = this.getNotificationId();
        result = result * PRIME + ($notificationId == null ? 43 : $notificationId.hashCode());
        final java.lang.Object $isRead = this.getIsRead();
        result = result * PRIME + ($isRead == null ? 43 : $isRead.hashCode());
        final java.lang.Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
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
        return "Notification(notificationId=" + this.getNotificationId() + ", user=" + this.getUser() + ", title=" + this.getTitle() + ", message=" + this.getMessage() + ", type=" + this.getType() + ", isRead=" + this.getIsRead() + ", createdAt=" + this.getCreatedAt() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public Notification() {
    }

    @java.lang.SuppressWarnings("all")
    
    public Notification(final Integer notificationId, final User user, final String title, final String message, final String type, final Boolean isRead, final LocalDateTime createdAt) {
        this.notificationId = notificationId;
        this.user = user;
        this.title = title;
        this.message = message;
        this.type = type;
        this.isRead = isRead;
        this.createdAt = createdAt;
    }
}
