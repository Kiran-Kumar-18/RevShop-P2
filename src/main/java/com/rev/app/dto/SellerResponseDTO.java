package com.rev.app.dto;

public class SellerResponseDTO {
    private Integer sellerId;
    private String userName;
    private String businessName;
    private String gstNumber;
    private String address;
    private java.math.BigDecimal totalRevenue;


    @java.lang.SuppressWarnings("all")
    
    public static class SellerResponseDTOBuilder {
        @java.lang.SuppressWarnings("all")
        
        private Integer sellerId;
        @java.lang.SuppressWarnings("all")
        
        private String userName;
        @java.lang.SuppressWarnings("all")
        
        private String businessName;
        @java.lang.SuppressWarnings("all")
        
        private String gstNumber;
        @java.lang.SuppressWarnings("all")
        
        private String address;
        @java.lang.SuppressWarnings("all")
        private java.math.BigDecimal totalRevenue;

        @java.lang.SuppressWarnings("all")
        
        SellerResponseDTOBuilder() {
        }


        @java.lang.SuppressWarnings("all")
        
        public SellerResponseDTO.SellerResponseDTOBuilder sellerId(final Integer sellerId) {
            this.sellerId = sellerId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public SellerResponseDTO.SellerResponseDTOBuilder userName(final String userName) {
            this.userName = userName;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public SellerResponseDTO.SellerResponseDTOBuilder businessName(final String businessName) {
            this.businessName = businessName;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public SellerResponseDTO.SellerResponseDTOBuilder gstNumber(final String gstNumber) {
            this.gstNumber = gstNumber;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public SellerResponseDTO.SellerResponseDTOBuilder address(final String address) {
            this.address = address;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public SellerResponseDTO.SellerResponseDTOBuilder totalRevenue(final java.math.BigDecimal totalRevenue) {
            this.totalRevenue = totalRevenue;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public SellerResponseDTO build() {
            return new SellerResponseDTO(this.sellerId, this.userName, this.businessName, this.gstNumber, this.address, this.totalRevenue);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "SellerResponseDTO.SellerResponseDTOBuilder(sellerId=" + this.sellerId + ", userName=" + this.userName + ", businessName=" + this.businessName + ", gstNumber=" + this.gstNumber + ", address=" + this.address + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static SellerResponseDTO.SellerResponseDTOBuilder builder() {
        return new SellerResponseDTO.SellerResponseDTOBuilder();
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getSellerId() {
        return this.sellerId;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getUserName() {
        return this.userName;
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
    
    public String getAddress() {
        return this.address;
    }

    @java.lang.SuppressWarnings("all")
    public java.math.BigDecimal getTotalRevenue() {
        return this.totalRevenue;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setSellerId(final Integer sellerId) {
        this.sellerId = sellerId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setUserName(final String userName) {
        this.userName = userName;
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
    
    public void setAddress(final String address) {
        this.address = address;
    }

    @java.lang.SuppressWarnings("all")
    public void setTotalRevenue(final java.math.BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof SellerResponseDTO)) return false;
        final SellerResponseDTO other = (SellerResponseDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$sellerId = this.getSellerId();
        final java.lang.Object other$sellerId = other.getSellerId();
        if (this$sellerId == null ? other$sellerId != null : !this$sellerId.equals(other$sellerId)) return false;
        final java.lang.Object this$userName = this.getUserName();
        final java.lang.Object other$userName = other.getUserName();
        if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) return false;
        final java.lang.Object this$businessName = this.getBusinessName();
        final java.lang.Object other$businessName = other.getBusinessName();
        if (this$businessName == null ? other$businessName != null : !this$businessName.equals(other$businessName)) return false;
        final java.lang.Object this$gstNumber = this.getGstNumber();
        final java.lang.Object other$gstNumber = other.getGstNumber();
        if (this$gstNumber == null ? other$gstNumber != null : !this$gstNumber.equals(other$gstNumber)) return false;
        final java.lang.Object this$address = this.getAddress();
        final java.lang.Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof SellerResponseDTO;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $sellerId = this.getSellerId();
        result = result * PRIME + ($sellerId == null ? 43 : $sellerId.hashCode());
        final java.lang.Object $userName = this.getUserName();
        result = result * PRIME + ($userName == null ? 43 : $userName.hashCode());
        final java.lang.Object $businessName = this.getBusinessName();
        result = result * PRIME + ($businessName == null ? 43 : $businessName.hashCode());
        final java.lang.Object $gstNumber = this.getGstNumber();
        result = result * PRIME + ($gstNumber == null ? 43 : $gstNumber.hashCode());
        final java.lang.Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public java.lang.String toString() {
        return "SellerResponseDTO(sellerId=" + this.getSellerId() + ", userName=" + this.getUserName() + ", businessName=" + this.getBusinessName() + ", gstNumber=" + this.getGstNumber() + ", address=" + this.getAddress() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public SellerResponseDTO() {
    }

    @java.lang.SuppressWarnings("all")
    
    public SellerResponseDTO(final Integer sellerId, final String userName, final String businessName, final String gstNumber, final String address, final java.math.BigDecimal totalRevenue) {
        this.sellerId = sellerId;
        this.userName = userName;
        this.businessName = businessName;
        this.gstNumber = gstNumber;
        this.address = address;
        this.totalRevenue = totalRevenue;
    }
}
