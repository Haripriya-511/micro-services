package com.ecommerce.user.controller;

import com.ecommerce.user.dto.AddressDto;
import com.ecommerce.user.dto.UserRequest;
import com.ecommerce.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    @GetMapping
    //@RequestMapping(value = "/api/users",method = RequestMethod.GET)
    public ResponseEntity<List<AddressDto.UserResponse>> getAllUsers(){
     //   return ResponseEntity.ok(userService.fetchAllUsers());
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AddressDto.UserResponse> getUserById(@PathVariable String id){
        return userService.fetchUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequest user){
         userService.addUser(user);
        return ResponseEntity.ok("User added!!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id,@RequestBody UserRequest updateUser){
    boolean isUpdated= userService.updateUser(id,updateUser);
    if(isUpdated)
        return ResponseEntity.ok("User updated successfully!!!");
    return ResponseEntity.notFound().build();
    }
}
