package com.hello.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.hello.entity.Resource;
import com.hello.entity.Role;
import com.hello.entity.User;
import com.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException {
		
		UserDetails userDetails = null;
		
		try {
			User user = userService.getByName(name).get(0);
			Collection<GrantedAuthority> authorities = getAuthorities(user);
			userDetails = (UserDetails) new com.hello.security.CustomUserDetails(user.getName(), user.getPassword(), true, true, true, true, authorities);
		} catch (Exception e) { 
            throw new UsernameNotFoundException("Error in retrieving user"); 
		}
		return userDetails;
	}

	 /** 
     * 获得访问角色权限 
     *  
     * @param user
     * @return 
     */  
	private Set<GrantedAuthority> getAuthorities(User user) {
  
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();  
        Set<Role> roles = user.getRoles();
        Set<Resource> resources = new HashSet<Resource>();
        for(Role role : roles){
        	resources = role.getResources();
        	for(Resource resource : resources){
        		authorities .add(new  SimpleGrantedAuthority(resource.getAuthority())); 
        	}     	
        } 
        return authorities ;  
    }  
}
