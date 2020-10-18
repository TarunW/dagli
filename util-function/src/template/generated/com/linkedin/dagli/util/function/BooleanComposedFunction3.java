// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the util/function/ComposedFunction.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.util.function;

import java.util.Objects;
import com.linkedin.dagli.util.named.Named;


/**
 * A function class implementing {@link BooleanFunction3.Serializable} that composes
 * {@link BooleanFunction3} with a {@link Function1}.  The function is only <strong>actually</strong> serializable
 * if its constituent composed functions are serializable, of course.
 */
class BooleanComposedFunction3<A, B, C, Q> implements BooleanFunction3.Serializable<A, B, C>, Named {
  private static final long serialVersionUID = 1;

  private final Function3<A, B, C, Q> _first;
  private final BooleanFunction1<? super Q> _andThen;

  /**
   * Creates a new instance that composes two functions, i.e. {@code andThen(first(inputs))}.
   *
   * @param first the first function to be called in the composition
   * @param andThen the second function to be called in the composition, accepting the {@code first} functions result
   *                as input
   */
  BooleanComposedFunction3(Function3<A, B, C, Q> first, BooleanFunction1<? super Q> andThen) {
    _first = first;
    _andThen = andThen;
  }

  @Override
  @SuppressWarnings("unchecked")
  public BooleanComposedFunction3<A, B, C, Q> safelySerializable() {
    return new BooleanComposedFunction3<>(((Function3.Serializable<A, B, C, Q>) _first).safelySerializable(),
        ((BooleanFunction1.Serializable<? super Q>) _andThen).safelySerializable());
  }

  @Override
  public boolean apply(A value1, B value2, C value3) {
    return _andThen.apply(_first.apply(value1, value2, value3));
  }

  @Override
  public int hashCode() {
    return Objects.hash(BooleanComposedFunction3.class, _first, _andThen);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof BooleanComposedFunction3) {
      return this._first.equals(((BooleanComposedFunction3) obj)._first)
          && this._andThen.equals(((BooleanComposedFunction3) obj)._andThen);
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
