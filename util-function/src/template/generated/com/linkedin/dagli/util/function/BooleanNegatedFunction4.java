// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the util/function/BooleanNegatedFunction.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.util.function;

import com.linkedin.dagli.util.named.Named;
import java.util.Objects;


/**
 * Implements the negation of the result of a boolean function.
 *
 * This class is {@link java.io.Serializable} to allow its subclass (also named Serializable) to be serialized, but
 * should not be regarded as "safely serializable" since the function it wraps is not itself guaranteed to be
 * serializable.
 */
class BooleanNegatedFunction4<A, B, C, D> implements BooleanFunction4<A, B, C, D>, java.io.Serializable, Named {
  private static final int CLASS_HASH = BooleanNegatedFunction4.class.hashCode();

  private final BooleanFunction4<A, B, C, D> _function;

  // no-arg constructor for Kryo
  private BooleanNegatedFunction4() {
    _function = null;
  }

  /**
   * Creates a new instance that will negate the result provided by the given, wrapped function.
   *
   * @param function the function to be wrapped
   */
  private BooleanNegatedFunction4(BooleanFunction4<A, B, C, D> function) {
    _function = Objects.requireNonNull(function);
  }

  /**
   * Returns a function that will have a result that is a negation of the function provided.  If the passed function
   * is itself of this type, its underlying (wrapped) function will be returned; otherwise, a new instance of this class
   * will be created to wrap the passed function.
   *
   * @param function the function whose result will be negated
   * @return a function (which may or may not be new) that negates the return value of the provided function
   */
  static <A, B, C, D> BooleanFunction4<A, B, C, D> negate(BooleanFunction4<A, B, C, D> function) {
    if (function instanceof BooleanNegatedFunction4) {
      return ((BooleanNegatedFunction4<A, B, C, D>) function)._function; // negation of a negation is the original function
    }
    return new BooleanNegatedFunction4<>(function);
  }

  @Override
  public boolean apply(A value1, B value2, C value3, D value4) {
    return !_function.apply(value1, value2, value3, value4);
  }

  @Override
  public int hashCode() {
    return CLASS_HASH + _function.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof BooleanNegatedFunction4) {
      return this._function.equals(((BooleanNegatedFunction4) obj)._function);
    }
    return false;
  }

  @Override
  public String toString() {
    return "!(" + Named.getShortName(_function) + ")";
  }

  @Override
  public String getShortName() {
    return "!(" + Named.getShortName(_function) + ")";
  }

  static class Serializable<A, B, C, D> extends BooleanNegatedFunction4<A, B, C, D> implements
      BooleanFunction4.Serializable<A, B, C, D> {
    private static final long serialVersionUID = 1;

    // no-arg constructor for Kryo
    private Serializable() {
    }

    /**
     * Creates a new instance that will negate the result provided by the given, wrapped function.
     *
     * @param function the function to be wrapped
     */
    private Serializable(BooleanFunction4.Serializable<A, B, C, D> function) {
      super(function);
    }

    /**
     * Returns a function that will have a result that is a negation of the function provided.  If the passed function
     * is itself of this type, its underlying (wrapped) function will be returned; otherwise, a new instance of this class
     * will be created to wrap the passed function.
     *
     * @param function the function whose result will be negated
     * @return a function (which may or may not be new) that negates the return value of the provided function
     */
    static <A, B, C, D> BooleanFunction4.Serializable<A, B, C, D> negate(
        BooleanFunction4.Serializable<A, B, C, D> function) {
      if (function instanceof BooleanNegatedFunction4.Serializable) {
        // negation of a negation is the original function
        return (BooleanFunction4.Serializable<A, B, C, D>) ((BooleanNegatedFunction4<A, B, C, D>) function)._function;
      }
      return new BooleanNegatedFunction4.Serializable<>(function);
    }
  }
}
