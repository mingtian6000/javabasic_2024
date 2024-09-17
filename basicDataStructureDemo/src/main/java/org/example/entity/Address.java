package org.example.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Address {

        @XmlElement
        @JsonProperty("street")
        private String street;

        @XmlElement
        @JsonProperty("city")
        private String city;

        @XmlElement
        @JsonProperty("postcode")
        private String postcode;

        public Address(String street, String city, String postcode) {
            this.street = street;
            this.city = city;
            this.postcode = postcode;
        }
        public Address() {}  // Default constructor for Jackson
}
