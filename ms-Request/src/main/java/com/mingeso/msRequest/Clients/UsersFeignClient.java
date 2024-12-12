package com.mingeso.msRequest.Clients;

import com.mingeso.msRequest.request.userDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "ms-Register",
        path = "/api/users"
)
public interface UsersFeignClient {
    @GetMapping("/{id}")
    userDto getUserById(@PathVariable("id") Long id);
}

