package de.mlo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

import com.google.common.base.Objects;

import lombok.Getter;
import lombok.Setter;


// TODO: Auto-generated Javadoc
/**
 * The Class Permission.
 */
@Entity
@Table(name="GROUPE_PERMISSIONS")
public class Permission extends BaseEntity implements GrantedAuthority {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3392607517470412023L;
	
	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(Permission.class);

	/** The permissionname. */
	@Column(name = "permissionname", length = 50)
	
	/**
	 * Gets the permissionname.
	 *
	 * @return the permissionname
	 */
	@Getter
	
	/**
	 * Sets the permissionname.
	 *
	 * @param permissionname the new permissionname
	 */
	@Setter
	private String permissionname;
	
	/** The perm groupes. */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "groupe_permissions", joinColumns = { @JoinColumn(name = "permission_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "groupe_id", referencedColumnName = "id") })
	
	/**
	 * Gets the perm groupes.
	 *
	 * @return the perm groupes
	 */
	@Getter
	
	/**
	 * Sets the perm groupes.
	 *
	 * @param permGroupes the new perm groupes
	 */
	@Setter
	private Set<Groupe> permGroupes;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.GrantedAuthority#getAuthority()
	 */
	@Override
	public String getAuthority() {
		return permissionname;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s(id=%d, permissionname='%s')", this.getClass()
				.getSimpleName(), this.getId(), this.getPermissionname());
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

		if (o instanceof Permission) {
			final Permission other = (Permission) o;
			return Objects.equal(getId(), other.getId())
					&& Objects.equal(getPermissionname(),
							other.getPermissionname());
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(getId(), getPermissionname());
	}
}
