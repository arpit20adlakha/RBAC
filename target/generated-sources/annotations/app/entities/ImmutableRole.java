package app.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Role}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableRole.builder()}.
 */
@Generated(from = "Role", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableRole implements Role {
  private final String role;
  private final Set<Permissions> permissions;

  private ImmutableRole(String role, Set<Permissions> permissions) {
    this.role = role;
    this.permissions = permissions;
  }

  /**
   * @return The value of the {@code role} attribute
   */
  @Override
  public String role() {
    return role;
  }

  /**
   * @return The value of the {@code permissions} attribute
   */
  @Override
  public Set<Permissions> permissions() {
    return permissions;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Role#role() role} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for role
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRole withRole(String value) {
    String newValue = Objects.requireNonNull(value, "role");
    if (this.role.equals(newValue)) return this;
    return new ImmutableRole(newValue, this.permissions);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Role#permissions() permissions}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRole withPermissions(Permissions... elements) {
    Set<Permissions> newValue = createUnmodifiableSet(createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableRole(this.role, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Role#permissions() permissions}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of permissions elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRole withPermissions(Iterable<? extends Permissions> elements) {
    if (this.permissions == elements) return this;
    Set<Permissions> newValue = createUnmodifiableSet(createSafeList(elements, true, false));
    return new ImmutableRole(this.role, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableRole} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableRole
        && equalTo((ImmutableRole) another);
  }

  private boolean equalTo(ImmutableRole another) {
    return role.equals(another.role)
        && permissions.equals(another.permissions);
  }

  /**
   * Computes a hash code from attributes: {@code role}, {@code permissions}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + role.hashCode();
    h += (h << 5) + permissions.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Role} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Role{"
        + "role=" + role
        + ", permissions=" + permissions
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link Role} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Role instance
   */
  public static ImmutableRole copyOf(Role instance) {
    if (instance instanceof ImmutableRole) {
      return (ImmutableRole) instance;
    }
    return ImmutableRole.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableRole ImmutableRole}.
   * <pre>
   * ImmutableRole.builder()
   *    .role(String) // required {@link Role#role() role}
   *    .addPermissions|addAllPermissions(app.entities.Permissions) // {@link Role#permissions() permissions} elements
   *    .build();
   * </pre>
   * @return A new ImmutableRole builder
   */
  public static ImmutableRole.Builder builder() {
    return new ImmutableRole.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableRole ImmutableRole}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Role", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_ROLE = 0x1L;
    private long initBits = 0x1L;

    private String role;
    private List<Permissions> permissions = new ArrayList<Permissions>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Role} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Role instance) {
      Objects.requireNonNull(instance, "instance");
      role(instance.role());
      addAllPermissions(instance.permissions());
      return this;
    }

    /**
     * Initializes the value for the {@link Role#role() role} attribute.
     * @param role The value for role 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder role(String role) {
      this.role = Objects.requireNonNull(role, "role");
      initBits &= ~INIT_BIT_ROLE;
      return this;
    }

    /**
     * Adds one element to {@link Role#permissions() permissions} set.
     * @param element A permissions element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addPermissions(Permissions element) {
      this.permissions.add(Objects.requireNonNull(element, "permissions element"));
      return this;
    }

    /**
     * Adds elements to {@link Role#permissions() permissions} set.
     * @param elements An array of permissions elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addPermissions(Permissions... elements) {
      for (Permissions element : elements) {
        this.permissions.add(Objects.requireNonNull(element, "permissions element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link Role#permissions() permissions} set.
     * @param elements An iterable of permissions elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder permissions(Iterable<? extends Permissions> elements) {
      this.permissions.clear();
      return addAllPermissions(elements);
    }

    /**
     * Adds elements to {@link Role#permissions() permissions} set.
     * @param elements An iterable of permissions elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllPermissions(Iterable<? extends Permissions> elements) {
      for (Permissions element : elements) {
        this.permissions.add(Objects.requireNonNull(element, "permissions element"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutableRole ImmutableRole}.
     * @return An immutable instance of Role
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableRole build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableRole(role, createUnmodifiableSet(permissions));
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ROLE) != 0) attributes.add("role");
      return "Cannot build Role, some of required attributes are not set " + attributes;
    }
  }

  private static <T> List<T> createSafeList(Iterable<? extends T> iterable, boolean checkNulls, boolean skipNulls) {
    ArrayList<T> list;
    if (iterable instanceof Collection<?>) {
      int size = ((Collection<?>) iterable).size();
      if (size == 0) return Collections.emptyList();
      list = new ArrayList<>();
    } else {
      list = new ArrayList<>();
    }
    for (T element : iterable) {
      if (skipNulls && element == null) continue;
      if (checkNulls) Objects.requireNonNull(element, "element");
      list.add(element);
    }
    return list;
  }

  /** Unmodifiable set constructed from list to avoid rehashing. */
  private static <T> Set<T> createUnmodifiableSet(List<T> list) {
    switch(list.size()) {
    case 0: return Collections.emptySet();
    case 1: return Collections.singleton(list.get(0));
    default:
      Set<T> set = new LinkedHashSet<>(list.size());
      set.addAll(list);
      return Collections.unmodifiableSet(set);
    }
  }
}
