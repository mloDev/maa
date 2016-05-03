package de.mlo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

import com.google.common.base.Objects;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Groupe.
 */
@Entity
public class Groupe extends BaseEntity implements Serializable, GrantedAuthority {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 406835891585448663L;
	
	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(Groupe.class);

	/** The groupename. */
	@NotNull(message = "{error.groupes.groupe.null}")
	@NotEmpty(message = "{error.groupes.groupe.empty}")
	@Size(max = 50, message = "{error.groupes.groupe.max}")
	@Column(name = "groupename", length = 50)
	
	/**
	 * Gets the groupename.
	 *
	 * @return the groupename
	 */
	@Getter
	
	/**
	 * Sets the groupename.
	 *
	 * @param groupename the new groupename
	 */
	@Setter
	private String groupename;
	
	/** The user groupes. */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_groupes", joinColumns = { @JoinColumn(name = "groupe_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") })
	
	/**
	 * Gets the user groupes.
	 *
	 * @return the user groupes
	 */
	@Getter
	
	/**
	 * Sets the user groupes.
	 *
	 * @param userGroupes the new user groupes
	 */
	@Setter
	private Set<User> userGroupes;

	/** The permissions. */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "groupe_permissions", joinColumns = { @JoinColumn(name = "groupe_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "permission_id", referencedColumnName = "id") })
	
	/**
	 * Gets the permissions.
	 *
	 * @return the permissions
	 */
	@Getter
	
	/**
	 * Sets the permissions.
	 *
	 * @param permissions the new permissions
	 */
	@Setter
	private Set<Permission> permissions;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s(id=%d, groupename='%s')", this.getClass()
				.getSimpleName(), this.getId(), this.getGroupename());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;

		if (o instanceof Groupe) {
			final Groupe other = (Groupe) o;
			return Objects.equal(getId(), other.getId())
					&& Objects.equal(getGroupename(), other.getGroupename());
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(getId(), getGroupename());
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.GrantedAuthority#getAuthority()
	 */
	@Override
	public String getAuthority() {
		return getGroupename();
	}
	
	
}
