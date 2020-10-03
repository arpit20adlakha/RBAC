package app.entities;

import org.immutables.value.Value;

import java.util.Set;

@Value.Immutable
public interface Role {

    String role();

    Set<Permissions> permissions();
}
