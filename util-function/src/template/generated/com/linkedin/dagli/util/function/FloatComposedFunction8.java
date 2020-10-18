// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the util/function/ComposedFunction.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.util.function;

import java.util.Objects;
import com.linkedin.dagli.util.named.Named;


/**
 * A function class implementing {@link FloatFunction8.Serializable} that composes
 * {@link FloatFunction8} with a {@link Function1}.  The function is only <strong>actually</strong> serializable
 * if its constituent composed functions are serializable, of course.
 */
class FloatComposedFunction8<A, B, C, D, E, F, G, H, Q> implements FloatFunction8.Serializable<A, B, C, D, E, F, G, H>,
    Named {
  private static final long serialVersionUID = 1;

  private final Function8<A, B, C, D, E, F, G, H, Q> _first;
  private final FloatFunction1<? super Q> _andThen;

  /**
   * Creates a new instance that composes two functions, i.e. {@code andThen(first(inputs))}.
   *
   * @param first the first function to be called in the composition
   * @param andThen the second function to be called in the composition, accepting the {@code first} functions result
   *                as input
   */
  FloatComposedFunction8(Function8<A, B, C, D, E, F, G, H, Q> first, FloatFunction1<? super Q> andThen) {
    _first = first;
    _andThen = andThen;
  }

  @Override
  @SuppressWarnings("unchecked")
  public FloatComposedFunction8<A, B, C, D, E, F, G, H, Q> safelySerializable() {
    return new FloatComposedFunction8<>(
        ((Function8.Serializable<A, B, C, D, E, F, G, H, Q>) _first).safelySerializable(),
        ((FloatFunction1.Serializable<? super Q>) _andThen).safelySerializable());
  }

  @Override
  public float apply(A value1, B value2, C value3, D value4, E value5, F value6, G value7, H value8) {
    return _andThen.apply(_first.apply(value1, value2, value3, value4, value5, value6, value7, value8));
  }

  @Override
  public int hashCode() {
    return Objects.hash(FloatComposedFunction8.class, _first, _andThen);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof FloatComposedFunction8) {
      return this._first.equals(((FloatComposedFunction8) obj)._first)
          && this._andThen.equals(((FloatComposedFunction8) obj)._andThen);
    }
    return false;
  }

  @Override
  public String toString() {
    return Named.getShortName(_andThen) + "(" + Named.getShortName(_first) + ")";
  }

  @Override
  public String getShortName() {
    return Named.getShortName(_andThen) + "(...)";
  }
}
