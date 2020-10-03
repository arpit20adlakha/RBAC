package app;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import app.entities.ActionType;
import app.entities.ImmutablePermissions;
import app.entities.Operation;
import app.entities.Permissions;

public class RBAC {
    private static final String SUCCESS = "SUCCESS";

    private final RolesDAO rolesDAO;
    private final UserDAO userDAO;

    public RBAC(RolesDAO rolesDAO, UserDAO userDAO) {
        this.rolesDAO = rolesDAO;
        this.userDAO = userDAO;

    }

    public String executeOperatation(Operation operation, List<String> arguments){
        String result;
        try {
            switch (operation) {
                case ADD:
                    result = addUserRole(arguments.get(0), arguments.subList(1, arguments.size()));
                    break;
                case REMOVE:
                    result = removeUserRole(arguments.get(0), arguments.subList(1, arguments.size()));
                    break;
                case CHECKROLE:
                    result = checkRole(arguments.get(0), arguments.get(1), ActionType.valueOf(arguments.get(2).toUpperCase()));
                    break;
                default:
                    throw new UnsupportedOperationException("Unsupported operation");
            }
            return result;
        }
        catch (Exception ex){
            System.out.println(ex);
            return ex.getMessage();
        }
    }

    private String addUserRole(String userName, Collection<String> roles){
        if(rolesDAO.areRolesValid(roles)){
            userDAO.addRoles(userName, roles);
            return SUCCESS;
        }
        else
            throw new IllegalStateException("Role(s) invalid");
    }

    private String removeUserRole(String userName, Collection<String> roles){
        userDAO.removeRoles(userName, roles);
        return SUCCESS;
    }

    private String checkRole(String userName, String resource, ActionType actionType){
        Permissions permission  = ImmutablePermissions.builder()
                .actionType(actionType)
                .resource(resource)
                .build();
        Set<String> roleNames  = userDAO.getRoles(userName);
        boolean canAllowUser = rolesDAO.getPermissions(roleNames)
                .stream()
                .anyMatch(permission::equals);

        return canAllowUser ? SUCCESS : "FAILURE";
    }
}
