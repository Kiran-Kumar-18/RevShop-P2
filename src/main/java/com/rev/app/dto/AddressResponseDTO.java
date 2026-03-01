package com.rev.app.dto;

public class AddressResponseDTO {
    private Integer addressId;
    private Integer userId;
    private String fullName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String addressType;


    @java.lang.SuppressWarnings("all")
    
    public static class AddressResponseDTOBuilder {
        @java.lang.SuppressWarnings("all")
        
        private Integer addressId;
        @java.lang.SuppressWarnings("all")
        
        private Integer userId;
        @java.lang.SuppressWarnings("all")
        
        private String fullName;
        @java.lang.SuppressWarnings("all")
        
        private String phone;
        @java.lang.SuppressWarnings("all")
        
        private String addressLine1;
        @java.lang.SuppressWarnings("all")
        
        private String addressLine2;
        @java.lang.SuppressWarnings("all")
        
        private String city;
        @java.lang.SuppressWarnings("all")
        
        private String state;
        @java.lang.SuppressWarnings("all")
        
        private String postalCode;
        @java.lang.SuppressWarnings("all")
        
        private String country;
        @java.lang.SuppressWarnings("all")
        
        private String addressType;

        @java.lang.SuppressWarnings("all")
        
        AddressResponseDTOBuilder() {
        }


        @java.lang.SuppressWarnings("all")
        
        public AddressResponseDTO.AddressResponseDTOBuilder addressId(final Integer addressId) {
            this.addressId = addressId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public AddressResponseDTO.AddressResponseDTOBuilder userId(final Integer userId) {
            this.userId = userId;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public AddressResponseDTO.AddressResponseDTOBuilder fullName(final String fullName) {
            this.fullName = fullName;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public AddressResponseDTO.AddressResponseDTOBuilder phone(final String phone) {
            this.phone = phone;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public AddressResponseDTO.AddressResponseDTOBuilder addressLine1(final String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public AddressResponseDTO.AddressResponseDTOBuilder addressLine2(final String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public AddressResponseDTO.AddressResponseDTOBuilder city(final String city) {
            this.city = city;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public AddressResponseDTO.AddressResponseDTOBuilder state(final String state) {
            this.state = state;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public AddressResponseDTO.AddressResponseDTOBuilder postalCode(final String postalCode) {
            this.postalCode = postalCode;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public AddressResponseDTO.AddressResponseDTOBuilder country(final String country) {
            this.country = country;
            return this;
        }


        @java.lang.SuppressWarnings("all")
        
        public AddressResponseDTO.AddressResponseDTOBuilder addressType(final String addressType) {
            this.addressType = addressType;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        
        public AddressResponseDTO build() {
            return new AddressResponseDTO(this.addressId, this.userId, this.fullName, this.phone, this.addressLine1, this.addressLine2, this.city, this.state, this.postalCode, this.country, this.addressType);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        
        public java.lang.String toString() {
            return "AddressResponseDTO.AddressResponseDTOBuilder(addressId=" + this.addressId + ", userId=" + this.userId + ", fullName=" + this.fullName + ", phone=" + this.phone + ", addressLine1=" + this.addressLine1 + ", addressLine2=" + this.addressLine2 + ", city=" + this.city + ", state=" + this.state + ", postalCode=" + this.postalCode + ", country=" + this.country + ", addressType=" + this.addressType + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    
    public static AddressResponseDTO.AddressResponseDTOBuilder builder() {
        return new AddressResponseDTO.AddressResponseDTOBuilder();
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getAddressId() {
        return this.addressId;
    }

    @java.lang.SuppressWarnings("all")
    
    public Integer getUserId() {
        return this.userId;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getFullName() {
        return this.fullName;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getPhone() {
        return this.phone;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getAddressLine1() {
        return this.addressLine1;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getAddressLine2() {
        return this.addressLine2;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getCity() {
        return this.city;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getState() {
        return this.state;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getPostalCode() {
        return this.postalCode;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getCountry() {
        return this.country;
    }

    @java.lang.SuppressWarnings("all")
    
    public String getAddressType() {
        return this.addressType;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setAddressId(final Integer addressId) {
        this.addressId = addressId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setAddressLine1(final String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setAddressLine2(final String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setCity(final String city) {
        this.city = city;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setState(final String state) {
        this.state = state;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setCountry(final String country) {
        this.country = country;
    }

    @java.lang.SuppressWarnings("all")
    
    public void setAddressType(final String addressType) {
        this.addressType = addressType;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof AddressResponseDTO)) return false;
        final AddressResponseDTO other = (AddressResponseDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$addressId = this.getAddressId();
        final java.lang.Object other$addressId = other.getAddressId();
        if (this$addressId == null ? other$addressId != null : !this$addressId.equals(other$addressId)) return false;
        final java.lang.Object this$userId = this.getUserId();
        final java.lang.Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final java.lang.Object this$fullName = this.getFullName();
        final java.lang.Object other$fullName = other.getFullName();
        if (this$fullName == null ? other$fullName != null : !this$fullName.equals(other$fullName)) return false;
        final java.lang.Object this$phone = this.getPhone();
        final java.lang.Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        final java.lang.Object this$addressLine1 = this.getAddressLine1();
        final java.lang.Object other$addressLine1 = other.getAddressLine1();
        if (this$addressLine1 == null ? other$addressLine1 != null : !this$addressLine1.equals(other$addressLine1)) return false;
        final java.lang.Object this$addressLine2 = this.getAddressLine2();
        final java.lang.Object other$addressLine2 = other.getAddressLine2();
        if (this$addressLine2 == null ? other$addressLine2 != null : !this$addressLine2.equals(other$addressLine2)) return false;
        final java.lang.Object this$city = this.getCity();
        final java.lang.Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
        final java.lang.Object this$state = this.getState();
        final java.lang.Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) return false;
        final java.lang.Object this$postalCode = this.getPostalCode();
        final java.lang.Object other$postalCode = other.getPostalCode();
        if (this$postalCode == null ? other$postalCode != null : !this$postalCode.equals(other$postalCode)) return false;
        final java.lang.Object this$country = this.getCountry();
        final java.lang.Object other$country = other.getCountry();
        if (this$country == null ? other$country != null : !this$country.equals(other$country)) return false;
        final java.lang.Object this$addressType = this.getAddressType();
        final java.lang.Object other$addressType = other.getAddressType();
        if (this$addressType == null ? other$addressType != null : !this$addressType.equals(other$addressType)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof AddressResponseDTO;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $addressId = this.getAddressId();
        result = result * PRIME + ($addressId == null ? 43 : $addressId.hashCode());
        final java.lang.Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final java.lang.Object $fullName = this.getFullName();
        result = result * PRIME + ($fullName == null ? 43 : $fullName.hashCode());
        final java.lang.Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        final java.lang.Object $addressLine1 = this.getAddressLine1();
        result = result * PRIME + ($addressLine1 == null ? 43 : $addressLine1.hashCode());
        final java.lang.Object $addressLine2 = this.getAddressLine2();
        result = result * PRIME + ($addressLine2 == null ? 43 : $addressLine2.hashCode());
        final java.lang.Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        final java.lang.Object $state = this.getState();
        result = result * PRIME + ($state == null ? 43 : $state.hashCode());
        final java.lang.Object $postalCode = this.getPostalCode();
        result = result * PRIME + ($postalCode == null ? 43 : $postalCode.hashCode());
        final java.lang.Object $country = this.getCountry();
        result = result * PRIME + ($country == null ? 43 : $country.hashCode());
        final java.lang.Object $addressType = this.getAddressType();
        result = result * PRIME + ($addressType == null ? 43 : $addressType.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    
    public java.lang.String toString() {
        return "AddressResponseDTO(addressId=" + this.getAddressId() + ", userId=" + this.getUserId() + ", fullName=" + this.getFullName() + ", phone=" + this.getPhone() + ", addressLine1=" + this.getAddressLine1() + ", addressLine2=" + this.getAddressLine2() + ", city=" + this.getCity() + ", state=" + this.getState() + ", postalCode=" + this.getPostalCode() + ", country=" + this.getCountry() + ", addressType=" + this.getAddressType() + ")";
    }

    @java.lang.SuppressWarnings("all")
    
    public AddressResponseDTO() {
    }

    @java.lang.SuppressWarnings("all")
    
    public AddressResponseDTO(final Integer addressId, final Integer userId, final String fullName, final String phone, final String addressLine1, final String addressLine2, final String city, final String state, final String postalCode, final String country, final String addressType) {
        this.addressId = addressId;
        this.userId = userId;
        this.fullName = fullName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.addressType = addressType;
    }
}
