package com.mingeso.msRequest.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class userDto {
    public Long id;
    public String name;
    public String rut;
    public String mail;
    public String phoneN;
    public String password;
    public boolean isEjecutive;
}
