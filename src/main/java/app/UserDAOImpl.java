package app;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserDAOImpl implements UserDAO {
    private static Map<String, Set<String>> userRolesMap = new HashMap<>();
    private static  UserDAOImpl INSTANCE;

    private UserDAOImpl(){
    }

    public static UserDAOImpl create(){
         if(INSTANCE == null)
             INSTANCE = new UserDAOImpl();
         return INSTANCE;
    }

    @Override
    public boolean addRoles(String userId, Collection<String> roleNames) {
        userRolesMap.computeIfAbsent(userId, _userId -> new HashSet<>());
        return userRolesMap.get(userId).addAll(roleNames);
    }

    @Override
    public void removeRoles(String userId, Collection<String> roleName) {
        if(!userRolesMap.containsKey(userId))
            throw new IllegalArgumentException("UserId invalid");

        roleName.stream()
                .forEach(userRolesMap.get(userId)::remove);
    }

    @Override
    public void removeAllRoles(String userId) {
        userRolesMap.remove(userId);
    }

    @Override
    public Set<String> getRoles(String userId) {
        return userRolesMap.getOrDefault(userId, Collections.EMPTY_SET);
    }

}
