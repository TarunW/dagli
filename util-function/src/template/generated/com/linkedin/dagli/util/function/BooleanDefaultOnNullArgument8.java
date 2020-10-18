// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the util/function/DefaultOnNullArgument.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.util.function;

import com.linkedin.dagli.util.named.Named;
import java.util.Objects;


/**
 * A function class implementing BooleanFunction8.Serializable<A, B, C, D, E, F, G, H> that returns false if any of
 * the function's inputs are null.
 */
class BooleanDefaultOnNullArgument8<A, B, C, D, E, F, G, H> implements
    BooleanFunction8.Serializable<A, B, C, D, E, F, G, H>, Named {
  private static final long serialVersionUID = 1;
  private static final int CLASS_HASH = BooleanDefaultOnNullArgument8.class.hashCode();
  private final BooleanFunction8<A, B, C, D, E, F, G, H> _wrapped;

  BooleanDefaultOnNullArgument8(BooleanFunction8<A, B, C, D, E, F, G, H> wrapped) {
    // stacking this wrapper multiple times should be idempotent:
    if (wrapped instanceof BooleanDefaultOnNullArgument8) {
      _wrapped = ((BooleanDefaultOnNullArgument8) wrapped)._wrapped;
    } else {
      _wrapped = Objects.requireNonNull(wrapped);
    }
  }

  @Override
  public BooleanDefaultOnNullArgument8<A, B, C, D, E, F, G, H> safelySerializable() {
    return new BooleanDefaultOnNullArgument8<>(
        ((BooleanFunction8.Serializable<A, B, C, D, E, F, G, H>) _wrapped).safelySerializable());
  }

  @Override
  public boolean apply(A value1, B value2, C value3, D value4, E value5, F value6, G value7, H value8) {
    if (value1 == null || value2 == null || value3 == null || value4 == null || value5 == null || value6 == null
        || value7 == null || value8 == null) {
      return false;
    }
    return _wrapped.apply(value1, value2, value3, value4, value5, value6, value7, value8);
  }

  @Override
  public int hashCode() {
    return CLASS_HASH + _wrapped.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof BooleanDefaultOnNullArgument8) {
      return this._wrapped.equals(((BooleanDefaultOnNullArgument8) obj)._wrapped);
    }
    return false;
  }

  @Override
  public String toString() {
    return "arg == null ? false : " + Named.getName(_wrapped);
  }

  @Override
  public String getShortName() {
    return "arg == null ? false : " + Named.getShortName(_wrapped);
  }
}
