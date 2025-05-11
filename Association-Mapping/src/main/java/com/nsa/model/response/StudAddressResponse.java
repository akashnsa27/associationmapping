package com.nsa.model.response;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudAddressResponse {

    Integer age;
    String studName;
    String city;
    Long pincode;

}
