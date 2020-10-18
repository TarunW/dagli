// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the util/function/DefaultOnNullArgument.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.util.function;

import com.linkedin.dagli.util.named.Named;
import java.util.Objects;


/**
 * A function class implementing BooleanFunction5.Serializable<A, B, C, D, E> that returns false if any of
 * the function's inputs are null.
 */
class BooleanDefaultOnNullArgument5<A, B, C, D, E> implements BooleanFunction5.Serializable<A, B, C, D, E>, Named {
  private static final long serialVersionUID = 1;
  private static final int CLASS_HASH = BooleanDefaultOnNullArgument5.class.hashCode();
  private final BooleanFunction5<A, B, C, D, E> _wrapped;

  BooleanDefaultOnNullArgument5(BooleanFunction5<A, B, C, D, E> wrapped) {
    // stacking this wrapper multiple times should be idempotent:
    if (wrapped instanceof BooleanDefaultOnNullArgument5) {
      _wrapped = ((BooleanDefaultOnNullArgument5) wrapped)._wrapped;
    } else {
      _wrapped = Objects.requireNonNull(wrapped);
    }
  }

  @Override
  public BooleanDefaultOnNullArgument5<A, B, C, D, E> safelySerializable() {
    return new BooleanDefaultOnNullArgument5<>(
        ((BooleanFunction5.Serializable<A, B, C, D, E>) _wrapped).safelySerializable());
  }

  @Override
  public boolean apply(A value1, B value2, C value3, D value4, E value5) {
    if (value1 == null || value2 == null || value3 == null || value4 == null || value5 == null) {
      return false;
    }
    return _wrapped.apply(value1, value2, value3, value4, value5);
  }

  @Override
  public int hashCode() {
    return CLASS_HASH + _wrapped.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof BooleanDefaultOnNullArgument5) {
      return this._wrapped.equals(((BooleanDefaultOnNullArgument5) obj)._wrapped);
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
