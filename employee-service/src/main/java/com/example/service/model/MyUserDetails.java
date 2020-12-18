package com.example.service.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class MyUserDetails implements UserDetails
{
	private String userName;
	private String password;
	private boolean enabled;
	private List<GrantedAuthority> authorities;
	private int employeeId;
	
	public MyUserDetails() 
	{
		
	}
	
	public MyUserDetails(User user) 
	{
		userName=user.getUserName();
		password=user.getPassword();
		enabled=user.isActive();
		authorities=Arrays.stream(user.getRoles().split(","))
							.map(SimpleGrantedAuthority::new)
							.collect(Collectors.toList());
		employeeId=user.getEmployee().getId();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		return authorities;
	}

	@Override
	public String getPassword() 
	{
		return password;
	}

	@Override
	public String getUsername() 
	{
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked() 
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isEnabled() 
	{
		return enabled;
	}

	public int getEmployeeId() {
		return employeeId;
	}

}
