package app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import app.entities.ActionType;
import app.entities.ImmutablePermissions;
import app.entities.ImmutableRole;
import app.entities.Permissions;
import app.entities.Role;

public class RolesDAOImpl implements RolesDAO {
    private  static Map<String, Role> rolesMap = new HashMap<>();
    private static RolesDAOImpl INSTANCE;

    private RolesDAOImpl(){
        this.init();
    }

    public static RolesDAOImpl create(){
        if(INSTANCE == null)
            INSTANCE = new RolesDAOImpl();
        return INSTANCE;
    }

    private  void init(){
        ObjectMapper MAPPER = new ObjectMapper();
        try (final InputStream resourceAsStream = RolesDAOImpl.class.getResourceAsStream("/role_mappings.json")) {
            TypeReference<HashMap<String, HashSet<JsonNode>>> typeRef = new TypeReference<>() {};
            Map<String, Set<JsonNode>> config = MAPPER.readValue(resourceAsStream, typeRef);

            for(String role : config.keySet()){
                Set<Permissions> permissions = new HashSet<>();
               for(JsonNode resourcePermission : config.get(role)){

                   Set<ActionType> actionTypes = new HashSet<>();
                   String resource = resourcePermission.get("resource").asText();
                   for(JsonNode action : resourcePermission.get("action")){
                       actionTypes.add(ActionType.valueOf(action.textValue()));
                   }

                   actionTypes.stream()
                              .map(actionType -> ImmutablePermissions.builder()
                                                                      .actionType(actionType)
                                                                      .resource(resource)
                                                                      .build())
                              .forEach(permissions::add);

               }
                rolesMap.put(role, ImmutableRole.builder()
                                                .addAllPermissions(permissions)
                                                .role(role)
                                                .build());
            }
        }
        catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    @Override
    public Set<Permissions> getPermissions(Set<String> roleNames) {

        return roleNames.stream()
                .map(rolesMap::get)
                .filter(Objects::nonNull)
                .flatMap(role -> role.permissions().stream())
                .collect(Collectors.toSet());
    }

    @Override
    public boolean areRolesValid(Collection<String> roleNames) {
        return roleNames
                .stream()
                .allMatch(rolesMap::containsKey);
    }
}
