package app.entities;


import org.immutables.value.Value;

@Value.Immutable
public interface Permissions {
    ActionType actionType();

    String resource();
}
