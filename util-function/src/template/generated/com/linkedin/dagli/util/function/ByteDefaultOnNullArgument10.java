// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the util/function/DefaultOnNullArgument.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.util.function;

import com.linkedin.dagli.util.named.Named;
import java.util.Objects;


/**
 * A function class implementing ByteFunction10.Serializable<A, B, C, D, E, F, G, H, I, J> that returns 0 if any of
 * the function's inputs are null.
 */
class ByteDefaultOnNullArgument10<A, B, C, D, E, F, G, H, I, J> implements
    ByteFunction10.Serializable<A, B, C, D, E, F, G, H, I, J>, Named {
  private static final long serialVersionUID = 1;
  private static final int CLASS_HASH = ByteDefaultOnNullArgument10.class.hashCode();
  private final ByteFunction10<A, B, C, D, E, F, G, H, I, J> _wrapped;

  ByteDefaultOnNullArgument10(ByteFunction10<A, B, C, D, E, F, G, H, I, J> wrapped) {
    // stacking this wrapper multiple times should be idempotent:
    if (wrapped instanceof ByteDefaultOnNullArgument10) {
      _wrapped = ((ByteDefaultOnNullArgument10) wrapped)._wrapped;
    } else {
      _wrapped = Objects.requireNonNull(wrapped);
    }
  }

  @Override
  public ByteDefaultOnNullArgument10<A, B, C, D, E, F, G, H, I, J> safelySerializable() {
    return new ByteDefaultOnNullArgument10<>(
        ((ByteFunction10.Serializable<A, B, C, D, E, F, G, H, I, J>) _wrapped).safelySerializable());
  }

  @Override
  public byte apply(A value1, B value2, C value3, D value4, E value5, F value6, G value7, H value8, I value9, J value10) {
    if (value1 == null || value2 == null || value3 == null || value4 == null || value5 == null || value6 == null
        || value7 == null || value8 == null || value9 == null || value10 == null) {
      return 0;
    }
    return _wrapped.apply(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10);
  }

  @Override
  public int hashCode() {
    return CLASS_HASH + _wrapped.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ByteDefaultOnNullArgument10) {
      return this._wrapped.equals(((ByteDefaultOnNullArgument10) obj)._wrapped);
    }
    return false;
  }

  @Override
  public String toString() {
    return "arg == null ? 0 : " + Named.getName(_wrapped);
  }

  @Override
  public String getShortName() {
    return "arg == null ? 0 : " + Named.getShortName(_wrapped);
  }
}
