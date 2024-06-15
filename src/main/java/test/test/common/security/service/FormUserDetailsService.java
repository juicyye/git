package test.test.common.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import test.test.domain.dto.AccountContext;
import test.test.domain.dto.UserDto;
import test.test.domain.entity.User;
import test.test.domain.repository.UserRepository;

import java.util.List;

@Component("userDetailsService")
@RequiredArgsConstructor

public class FormUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLoginId(username);
        if(user == null) {
            throw new UsernameNotFoundException("not found user = " + username);
        }
        UserDto userDto = UserDto.toDto(user);
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole().name()));

        return new AccountContext(userDto, authorities);
    }
}
