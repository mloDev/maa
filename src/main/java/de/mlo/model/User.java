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
// TODO: Auto-generated Javadoc

/**
 * The Class User.
 */
@Entity
public class User extends BaseEntity implements UserDetails {
	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2419083400342934706L;
	
	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(User.class);
	
	/** The username. */
	@NotNull(message = "{error.user.username.null}")
	@NotEmpty(message = "{error.user.username.empty}")
	@Size(max = 50, message = "{error.user.username.max}")
	@Column(name = "username", length = 50)
	
	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	@Setter
	private String username;

	/** The password. */
	@NotNull(message = "{error.user.password.null}")
	@NotEmpty(message = "{error.user.password.empty}")
	@Size(max = 50, message = "{error.user.password.max}")
	@Column(name = "password", length = 50)
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	@Setter
	private String password;

	/** The e mail. */
	@NotNull(message = "{error.user.email.null}")
	@NotEmpty(message = "{error.user.email.empty}")
	@Size(max = 50, message = "{error.user.email.max}")
	@Column
	
	/**
	 * Sets the e mail.
	 *
	 * @param eMail the new e mail
	 */
	@Setter
	
	/**
	 * Gets the e mail.
	 *
	 * @return the e mail
	 */
	@Getter
	private String eMail;
	
	/** The phone. */
	@NotNull(message = "{error.user.phone.null}")
	@NotEmpty(message = "{error.user.phone.empty}")
	@Size(max = 50, message = "{error.user.phone.max}")
	@Column(name = "phone")
	
	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	@Setter
	
	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	@Getter
	private String phone;
	
	/** The enabled. */
	@Column(name = "enabled")
	
	/**
	 * Sets the enabled.
	 *
	 * @param enabled the new enabled
	 */
	@Setter
	private boolean enabled;
	
	/** The groupe. */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "user_groupes", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "groupe_id", referencedColumnName = "id") })
	
	/**
	 * Sets the groupe.
	 *
	 * @param groupe the new groupe
	 */
	@Setter
	
	/**
	 * Gets the groupe.
	 *
	 * @return the groupe
	 */
	@Getter
	private Groupe groupe;

	/**
	 * Gets the permissions.
	 *
	 * @return the permissions
	 */
	@Transient
	public Set<Permission> getPermissions() {
		Set<Permission> perms = new HashSet<Permission>();
		perms.addAll(groupe.getPermissions());
		return perms;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(getGroupe());
		authorities.addAll(getGroupe().getPermissions());
		return authorities;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		// return true = account is valid / not expired
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		// return true = account is not locked
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// return true = password is valid / not expired
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
	

}
