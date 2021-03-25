//package com.excilys.formationcdb.dto.dao;
//
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "users")
//public class UserPersist {
//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(nullable = false, unique = true)
//    private String username;
//
//    private String password;
//    
//    private boolean enabled;
//    
//    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "user_id")
//    private  Set<UserAuthPersist> userAuthPersistList;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public boolean isEnabled() {
//		return enabled;
//	}
//
//	public void setEnabled(boolean enabled) {
//		this.enabled = enabled;
//	}
//
//	public Set<UserAuthPersist> getUserAuthPersistList() {
//		return userAuthPersistList;
//	}
//
//	public void setUserAuthPersistList(Set<UserAuthPersist> userAuthPersistList) {
//		this.userAuthPersistList = userAuthPersistList;
//	}
//}
