package app.entities;

import org.immutables.value.Value;

import java.util.Set;

@Value.Immutable
public interface User {
    int id();

    Set<String> roles();
}
