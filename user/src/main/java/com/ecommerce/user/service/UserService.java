package com.ecommerce.user.service;

import com.ecommerce.user.dto.AddressDto;
import com.ecommerce.user.dto.UserRequest;
import com.ecommerce.user.models.Address;
import com.ecommerce.user.models.User;
import com.ecommerce.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
   // private List<User> userList=new ArrayList<>();
  //  private  Long cnt=1L;
    public List<AddressDto.UserResponse> fetchAllUsers(){
        return userRepository.findAll()
                .stream().map(this::mapToUserResponse)
                .collect(Collectors.toList());
    }
    public Optional<AddressDto.UserResponse> fetchUser(String id){
        return userRepository.findById(String.valueOf(id))
                .map(this::mapToUserResponse);

    }
    public void addUser(UserRequest userRequest){
      //  user.setId(cnt++);
        User user=new User();
        updateUserFromRequest(user,userRequest);
        userRepository.save(user);
    }
    public boolean updateUser(String id,UserRequest updatedUser){
        return userRepository.findById(id)
                .map(existingUser->{
                    //User userTobeInserted=new User();
                    updateUserFromRequest(existingUser,updatedUser);
                   userRepository.save(existingUser);
                    return true;
                }).orElse(false);

    }
    private AddressDto.UserResponse mapToUserResponse(User user){
        AddressDto.UserResponse userResponse=new AddressDto.UserResponse();
        userResponse.setId(String.valueOf(user.getId()));
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhone(user.getPhone());
        userResponse.setRole(user.getRole());
        if(user.getAddress()!=null){
            AddressDto addressDto=new AddressDto();

            addressDto.setCity(user.getAddress().getCity());
            addressDto.setZipcode(user.getAddress().getZipcode());
            addressDto.setCountry(user.getAddress().getCountry());
            addressDto.setStreet(user.getAddress().getStreet());
            addressDto.setState(user.getAddress().getState());
            userResponse.setAddress(addressDto);
        }
        return userResponse;

    }
    private void updateUserFromRequest(User user,UserRequest userRequest){
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        if(userRequest.getAddress()!=null){
            Address address=new Address();
            address.setCity(userRequest.getAddress().getCity());
            address.setStreet(userRequest.getAddress().getStreet());
            address.setState(userRequest.getAddress().getState());
            address.setCountry(userRequest.getAddress().getCountry());;
            address.setZipcode(userRequest.getAddress().getZipcode());
            user.setAddress(address);
        }
    }
}
