package app.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Permissions}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePermissions.builder()}.
 */
@Generated(from = "Permissions", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutablePermissions implements Permissions {
  private final ActionType actionType;
  private final String resource;

  private ImmutablePermissions(ActionType actionType, String resource) {
    this.actionType = actionType;
    this.resource = resource;
  }

  /**
   * @return The value of the {@code actionType} attribute
   */
  @Override
  public ActionType actionType() {
    return actionType;
  }

  /**
   * @return The value of the {@code resource} attribute
   */
  @Override
  public String resource() {
    return resource;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Permissions#actionType() actionType} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for actionType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePermissions withActionType(ActionType value) {
    if (this.actionType == value) return this;
    ActionType newValue = Objects.requireNonNull(value, "actionType");
    if (this.actionType.equals(newValue)) return this;
    return new ImmutablePermissions(newValue, this.resource);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Permissions#resource() resource} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for resource
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePermissions withResource(String value) {
    String newValue = Objects.requireNonNull(value, "resource");
    if (this.resource.equals(newValue)) return this;
    return new ImmutablePermissions(this.actionType, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePermissions} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePermissions
        && equalTo((ImmutablePermissions) another);
  }

  private boolean equalTo(ImmutablePermissions another) {
    return actionType.equals(another.actionType)
        && resource.equals(another.resource);
  }

  /**
   * Computes a hash code from attributes: {@code actionType}, {@code resource}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + actionType.hashCode();
    h += (h << 5) + resource.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Permissions} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Permissions{"
        + "actionType=" + actionType
        + ", resource=" + resource
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link Permissions} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Permissions instance
   */
  public static ImmutablePermissions copyOf(Permissions instance) {
    if (instance instanceof ImmutablePermissions) {
      return (ImmutablePermissions) instance;
    }
    return ImmutablePermissions.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePermissions ImmutablePermissions}.
   * <pre>
   * ImmutablePermissions.builder()
   *    .actionType(app.entities.ActionType) // required {@link Permissions#actionType() actionType}
   *    .resource(String) // required {@link Permissions#resource() resource}
   *    .build();
   * </pre>
   * @return A new ImmutablePermissions builder
   */
  public static ImmutablePermissions.Builder builder() {
    return new ImmutablePermissions.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePermissions ImmutablePermissions}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Permissions", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_ACTION_TYPE = 0x1L;
    private static final long INIT_BIT_RESOURCE = 0x2L;
    private long initBits = 0x3L;

    private ActionType actionType;
    private String resource;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Permissions} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Permissions instance) {
      Objects.requireNonNull(instance, "instance");
      actionType(instance.actionType());
      resource(instance.resource());
      return this;
    }

    /**
     * Initializes the value for the {@link Permissions#actionType() actionType} attribute.
     * @param actionType The value for actionType 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder actionType(ActionType actionType) {
      this.actionType = Objects.requireNonNull(actionType, "actionType");
      initBits &= ~INIT_BIT_ACTION_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link Permissions#resource() resource} attribute.
     * @param resource The value for resource 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder resource(String resource) {
      this.resource = Objects.requireNonNull(resource, "resource");
      initBits &= ~INIT_BIT_RESOURCE;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePermissions ImmutablePermissions}.
     * @return An immutable instance of Permissions
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePermissions build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePermissions(actionType, resource);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ACTION_TYPE) != 0) attributes.add("actionType");
      if ((initBits & INIT_BIT_RESOURCE) != 0) attributes.add("resource");
      return "Cannot build Permissions, some of required attributes are not set " + attributes;
    }
  }
}
