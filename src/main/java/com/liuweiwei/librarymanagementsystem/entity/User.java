package com.liuweiwei.librarymanagementsystem.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *@author liuweiwei
 **/
public class User implements UserDetails {

	public User(){
		super();
	}

	public User(int id){
		this.id = id;
	}

	private int id;
	private String userName;
	private String passWord;
	private String born_data;
	private String phone;
	private String city;
	private String address;
	private String email;
	private String job;
	private String create_time;
	private String update_time;
	private String lastLoginTime;
	private String delete_flag;
	private Date changeDate;
	// 用户角色信息
	private List<UserRole> roles;
	// 权限集合数据
	private String roleArray;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}

	public void setPassword(String password) {
		this.passWord = password;
	}

	public String getBorn_data() {
		return born_data;
	}

	public void setBorn_data(String born_data) {
		this.born_data = born_data;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	public String getRoleArray() {
		return roleArray;
	}

	public void setRoleArray(String roleArray) {
		this.roleArray = roleArray;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	/**
	 * 功能描述：组装角色数据集合
	 * @param roleArray
	 */
	public void packagingRoles(String roleArray){
		List<UserRole> roles = new ArrayList<UserRole>();
		if(roleArray!=null){
			UserRole userRole = null;
			for(String roleId:roleArray.split(",")){
				if(!roleId.isEmpty()){
					userRole = new UserRole();
					userRole.setId(Long.parseLong(roleId));
					roles.add(userRole);
				}
			}
		}
		this.setRoles(roles);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		if(this.getRoles()!=null){
			List<UserRole> roles=this.getRoles();
			for(UserRole role:roles){
				if(role.getName()!=null){
					auths.add(new SimpleGrantedAuthority(role.getName()));
				}
			}
		}
		return auths;
	}
	@Override
	public String getUsername() {
		return this.getUserName();
	}

	@Override
	public String getPassword() {
		return this.getPassWord();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void changeToDate(){
		DateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			this.changeDate = simpleFormat.parse(this.getBorn_data());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
