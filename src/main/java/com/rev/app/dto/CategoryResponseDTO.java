package com.rev.app.dto;

public class CategoryResponseDTO {
    private Integer categoryId;
    private String name;
    private String description;


    @java.lang.SuppressWarnings("all")
    
    public static class CategoryResponseDTOBuilder {
        @java.lang.SuppressWarnings("all")
        
        private Integer categoryId;
        @java.lang.SuppressWarnings("all")
        
        private String name;
        @java.lang.SuppressWarnings("all")
        
        private String description;

        @java.lang.SuppressWarnings("all")
        
        CategoryResponseDTOBuilder() {
        }


        @java.lang.SuppressWarnings("all")
        
        public CategoryResponseDTO.CategoryResponseDTOBuilder categoryId(final Integer categoryId) {
            this.categoryId = categoryId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public CategoryResponseDTO.CategoryResponseDTOBuilder name(final String name) {
            this.name = name;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public CategoryResponseDTO.CategoryResponseDTOBuilder description(final String description) {
            this.description = description;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public CategoryResponseDTO build() {
            return new CategoryResponseDTO(this.categoryId, this.name, this.description);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "CategoryResponseDTO.CategoryResponseDTOBuilder(categoryId=" + this.categoryId + ", name=" + this.name + ", description=" + this.description + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static CategoryResponseDTO.CategoryResponseDTOBuilder builder() {
        return new CategoryResponseDTO.CategoryResponseDTOBuilder();
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getCategoryId() {
        return this.categoryId;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getName() {
        return this.name;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getDescription() {
        return this.description;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setCategoryId(final Integer categoryId) {
        this.categoryId = categoryId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setName(final String name) {
        this.name = name;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setDescription(final String description) {
        this.description = description;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof CategoryResponseDTO)) return false;
        final CategoryResponseDTO other = (CategoryResponseDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$categoryId = this.getCategoryId();
        final java.lang.Object other$categoryId = other.getCategoryId();
        if (this$categoryId == null ? other$categoryId != null : !this$categoryId.equals(other$categoryId)) return false;
        final java.lang.Object this$name = this.getName();
        final java.lang.Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final java.lang.Object this$description = this.getDescription();
        final java.lang.Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof CategoryResponseDTO;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $categoryId = this.getCategoryId();
        result = result * PRIME + ($categoryId == null ? 43 : $categoryId.hashCode());
        final java.lang.Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final java.lang.Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public java.lang.String toString() {
        return "CategoryResponseDTO(categoryId=" + this.getCategoryId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public CategoryResponseDTO() {
    }

    @java.lang.SuppressWarnings("all")
    
    public CategoryResponseDTO(final Integer categoryId, final String name, final String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }
}
