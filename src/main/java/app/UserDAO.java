package app;

import java.util.Collection;
import java.util.Set;

public interface UserDAO {
    Set<String> getRoles(String userId);

    // Will add the supplied roles to the existing ones
    boolean addRoles(String userId, Collection<String> roleNames);

    void removeRoles(String userId, Collection<String> roleName);

    void removeAllRoles(String userId);
}
