package com.mingeso.msRequest.Clients;

import com.mingeso.msRequest.request.userDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "ms-Register", url = "http://localhost:8080")
public interface UsersFeignClient {
    @GetMapping("api/user/{id}")
    userDto getUserById(@PathVariable("id") Long id);
}

