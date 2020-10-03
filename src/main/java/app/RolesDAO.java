package app;

import java.util.Collection;
import java.util.Set;

import app.entities.Permissions;
import app.entities.Role;

public interface RolesDAO {

    Set<Permissions> getPermissions(Set<String> roleName);

    boolean areRolesValid(Collection<String> roleNames);
}
