package de.mlo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

import com.google.common.base.Objects;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Permission extends BaseEntity implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3392607517470412023L;
	static Logger logger = LoggerFactory.getLogger(Permission.class);

	@Column(name = "permissionname", length = 50)
	@Getter
	@Setter
	private String permissionname;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "groupe_permissions", joinColumns = { @JoinColumn(name = "permission_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "groupe_id", referencedColumnName = "id") })
	@Getter
	@Setter
	private Set<Groupe> permGroupes;
	
	@Override
	public String getAuthority() {
		return permissionname;
	}
	
	@Override
	public String toString() {
		return String.format("%s(id=%d, permissionname='%s')", this.getClass()
				.getSimpleName(), this.getId(), this.getPermissionname());
	}

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

	@Override
	public int hashCode() {
		return Objects.hashCode(getId(), getPermissionname());
	}
}
