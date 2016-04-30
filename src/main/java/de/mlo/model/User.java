package de.mlo.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
@Entity
public class User extends BaseEntity implements UserDetails {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2419083400342934706L;
	static Logger logger = LoggerFactory.getLogger(User.class);
	
	@NotNull(message = "{error.user.username.null}")
	@NotEmpty(message = "{error.user.username.empty}")
	@Size(max = 50, message = "{error.user.username.max}")
	@Column(name = "username", length = 50)
	@Setter
	private String username;

	@NotNull(message = "{error.user.password.null}")
	@NotEmpty(message = "{error.user.password.empty}")
	@Size(max = 50, message = "{error.user.password.max}")
	@Column(name = "password", length = 50)
	@Setter
	private String password;

	@NotNull(message = "{error.user.email.null}")
	@NotEmpty(message = "{error.user.email.empty}")
	@Size(max = 50, message = "{error.user.email.max}")
	@Column
	@Setter
	@Getter
	private String eMail;
	
	@NotNull(message = "{error.user.phone.null}")
	@NotEmpty(message = "{error.user.phone.empty}")
	@Size(max = 50, message = "{error.user.phone.max}")
	@Column(name = "phone")
	@Setter
	@Getter
	private String phone;
	
	@Column(name = "enabled")
	@Setter
	private boolean enabled;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "user_groupes", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "groupe_id", referencedColumnName = "id") })
	@Setter
	@Getter
	private Groupe groupe;

	@Transient
	public Set<Permission> getPermissions() {
		Set<Permission> perms = new HashSet<Permission>();
		perms.addAll(groupe.getPermissions());
		return perms;
	}
	
	@Override
	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(getGroupe());
		authorities.addAll(getGroupe().getPermissions());
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// return true = account is valid / not expired
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// return true = account is not locked
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// return true = password is valid / not expired
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
	

}
