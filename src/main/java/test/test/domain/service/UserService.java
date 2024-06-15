package test.test.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.test.domain.dto.JoinDto;
import test.test.domain.dto.UserDto;
import test.test.domain.entity.User;
import test.test.domain.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long join(JoinDto joinDto){
        joinDto.setPassword(passwordEncoder.encode(joinDto.getPassword()));
        User user = new User(joinDto);
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    public List<UserDto> findAll(){
        List<User> users = userRepository.findAll();
        return UserDto.toDto(users);

    }

    public UserDto findById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserDto.toDto(user);
    }
}
