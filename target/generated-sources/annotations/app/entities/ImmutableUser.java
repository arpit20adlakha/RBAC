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
 * Immutable implementation of {@link User}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUser.builder()}.
 */
@Generated(from = "User", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableUser implements User {
  private final int id;
  private final Set<String> roles;

  private ImmutableUser(int id, Set<String> roles) {
    this.id = id;
    this.roles = roles;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @Override
  public int id() {
    return id;
  }

  /**
   * @return The value of the {@code roles} attribute
   */
  @Override
  public Set<String> roles() {
    return roles;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link User#id() id} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUser withId(int value) {
    if (this.id == value) return this;
    return new ImmutableUser(value, this.roles);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link User#roles() roles}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableUser withRoles(String... elements) {
    Set<String> newValue = createUnmodifiableSet(createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableUser(this.id, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link User#roles() roles}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of roles elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableUser withRoles(Iterable<String> elements) {
    if (this.roles == elements) return this;
    Set<String> newValue = createUnmodifiableSet(createSafeList(elements, true, false));
    return new ImmutableUser(this.id, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUser} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUser
        && equalTo((ImmutableUser) another);
  }

  private boolean equalTo(ImmutableUser another) {
    return id == another.id
        && roles.equals(another.roles);
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code roles}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + id;
    h += (h << 5) + roles.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code User} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "User{"
        + "id=" + id
        + ", roles=" + roles
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link User} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable User instance
   */
  public static ImmutableUser copyOf(User instance) {
    if (instance instanceof ImmutableUser) {
      return (ImmutableUser) instance;
    }
    return ImmutableUser.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableUser ImmutableUser}.
   * <pre>
   * ImmutableUser.builder()
   *    .id(int) // required {@link User#id() id}
   *    .addRoles|addAllRoles(String) // {@link User#roles() roles} elements
   *    .build();
   * </pre>
   * @return A new ImmutableUser builder
   */
  public static ImmutableUser.Builder builder() {
    return new ImmutableUser.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUser ImmutableUser}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "User", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private long initBits = 0x1L;

    private int id;
    private List<String> roles = new ArrayList<String>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code User} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(User instance) {
      Objects.requireNonNull(instance, "instance");
      id(instance.id());
      addAllRoles(instance.roles());
      return this;
    }

    /**
     * Initializes the value for the {@link User#id() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder id(int id) {
      this.id = id;
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Adds one element to {@link User#roles() roles} set.
     * @param element A roles element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addRoles(String element) {
      this.roles.add(Objects.requireNonNull(element, "roles element"));
      return this;
    }

    /**
     * Adds elements to {@link User#roles() roles} set.
     * @param elements An array of roles elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addRoles(String... elements) {
      for (String element : elements) {
        this.roles.add(Objects.requireNonNull(element, "roles element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link User#roles() roles} set.
     * @param elements An iterable of roles elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder roles(Iterable<String> elements) {
      this.roles.clear();
      return addAllRoles(elements);
    }

    /**
     * Adds elements to {@link User#roles() roles} set.
     * @param elements An iterable of roles elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllRoles(Iterable<String> elements) {
      for (String element : elements) {
        this.roles.add(Objects.requireNonNull(element, "roles element"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutableUser ImmutableUser}.
     * @return An immutable instance of User
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUser build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableUser(id, createUnmodifiableSet(roles));
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      return "Cannot build User, some of required attributes are not set " + attributes;
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
