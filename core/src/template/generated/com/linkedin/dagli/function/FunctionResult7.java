// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the function/FunctionResultX.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.function;

import com.linkedin.dagli.annotation.equality.ValueEquality;
import com.linkedin.dagli.producer.Producer;
import com.linkedin.dagli.transformer.AbstractPreparedTransformer7;
import com.linkedin.dagli.producer.MissingInput;
import com.linkedin.dagli.util.function.Function1;
import com.linkedin.dagli.util.function.Function7;
import com.linkedin.dagli.util.named.Named;


/**
 * FunctionResult transformers apply a (serializable) function object, method reference, or lambda against their inputs.
 *
 * Versioning of the underlying function is not enforced (i.e. FunctionResult doesn't know if the implementation of a
 * method changes).
 *
 * If you're using serializable function objects or method references (e.g. String::length, str::startsWith, etc.), you
 * can stop reading here.
 *
 * For lambdas (anonymous functions, i.e. {@code (args) -> { body }}), there are strict limitations with respect to
 * serializability because they are implemented as anonymous classes.  Make sure you understand these, as otherwise your
 * DAG may be writable, but not readable, or an innocuous change may break deserialization after initially working fine!
 *
 * Because of this, you must use withFunctionUnsafe(...) to use a lambda function.  This is by design, to warn you that
 * your DAG will consequently not be safely serializable.
 *
 * Again, <strong>warning!</strong>  Lambda functions, which are implemented with anonymous classes, are inherently
 * unsafe to serialize! Lambdas are not a problem if the DAG is not serialized, but we highly discourage them in
 * any serialized setup, <strong>especially</strong> if it's production.  Three conditions must be met for lambdas to
 * serialize and deserialize successfully:
 * (1) the class in which they were created must exist in both serializing and deserializing programs.
 * (2) the ORDER in which the lambdas are defined must not change.  The names of the generated anonymous classes are
 * dependent upon the position in which the lambda appears in the file!
 * (3) the JVM should be consistent, as different JVMs are in principle free to generate different class names.
 */
@ValueEquality
public class FunctionResult7<A, B, C, D, E, F, G, R> extends
    AbstractPreparedTransformer7<A, B, C, D, E, F, G, R, FunctionResult7<A, B, C, D, E, F, G, R>> {
  private static final long serialVersionUID = 1;

  private Function7.Serializable<A, B, C, D, E, F, G, R> _function = null;

  /**
   * Creates a new instance with no function and missing inputs.  These must be set via the withFunction(...) and
   * withInputs(...) methods, respectively.
   */
  public FunctionResult7() {
    super(MissingInput.get(), MissingInput.get(), MissingInput.get(), MissingInput.get(), MissingInput.get(),
        MissingInput.get(), MissingInput.get());
  }

  /**
   * Creates a new instance that processes inputs with the specified function.
   *
   * @param func a serializable function object or a method reference.  FunctionResult will attempt to detect lambda
   *        functions and throw an exception in such cases, but as this is in principle JDK dependent these checks
   *        cannot absolutely be guaranteed to catch such abuses.  If you MUST use a lambda, call
   *        withFunctionUnsafe(...).
   */
  public FunctionResult7(Function7.Serializable<A, B, C, D, E, F, G, R> func) {
    this();
    _function = func.safelySerializable();
  }

  /**
   * Specifies that this transformer will produce a null value if any input value is null.  In such cases, the wrapped
   * function will not be called, making this useful if your inputs may contain nulls that would otherwise cause your
   * function to throw a {@link NullPointerException} or similar error.
   *
   * @return a copy of this transformer that will produce a null value if any of the input values is null.
   */
  public FunctionResult7<A, B, C, D, E, F, G, R> withNullResultOnNullInput() {
    return clone(c -> c._function = _function.returnNullOnNullArgument());
  }

  public FunctionResult7<A, B, C, D, E, F, G, R> withInputs(Producer<? extends A> input1, Producer<? extends B> input2,
      Producer<? extends C> input3, Producer<? extends D> input4, Producer<? extends E> input5,
      Producer<? extends F> input6, Producer<? extends G> input7) {
    return super.withAllInputs(input1, input2, input3, input4, input5, input6, input7);
  }

  /**
   * Returns a copy of this instance that will process inputs with the specified function.
   *
   * @param func a serializable function object or a method reference.  FunctionResult will attempt to detect lambda
   *        functions and throw an exception in such cases, but as this is in principle JDK dependent these checks
   *        cannot absolutely be guaranteed to catch such abuses.  If you MUST use a lambda, call
   *        withFunctionUnsafe(...).
   */
  public FunctionResult7<A, B, C, D, E, F, G, R> withFunction(Function7.Serializable<A, B, C, D, E, F, G, R> func) {
    return clone(c -> c._function = func.safelySerializable());
  }

  /**
   * Returns a copy of this instance that will process inputs with the specified function.  This method is UNSAFE
   * because it permits arbitrary lambda functions, which are very difficult to safely serialize.  We strongly caution
   * against using this method if you need FunctionResult (and thus your DAG as a whole) to be reliably deserializable.
   *
   * @param func an arbitrary lambda function
   */
  public FunctionResult7<A, B, C, D, E, F, G, R> withFunctionUnsafe(Function7.Serializable<A, B, C, D, E, F, G, R> func) {
    return clone(c -> {
      try {
        c._function = func.safelySerializable();
      } catch (RuntimeException e) {
        c._function = func; // force use of non-safely-serializable method
      }
    });
  }

  @Override
  public R apply(A input1, B input2, C input3, D input4, E input5, F input6, G input7) {
    return _function.apply(input1, input2, input3, input4, input5, input6, input7);
  }

  /**
   * Returns a new {@link FunctionResult7} that composes this instance's function with another "mapper" function such
   * that the result is {@code mapper.apply(thisFunction.apply(...))}.  The other properties of the returned
   * transformer, including the inputs, remain the same as this one.
   *
   * Note that, while very close, this is not <i>exactly</i> equivalent to
   * {@code new FunctionResult1(someFunction).withInput(thisTransformer)} because the intermediate results never transit
   * through the DAG, which is slightly more efficient and means that, e.g. these intermediates can safely share or
   * reuse (thread-local) state.
   *
   * @param mapper a function that will map the result of this instance's function; this function must be safely
   *               serializable (see {@link Function1.Serializable#safelySerializable()}).
   * @param <Q> the type of the final result of the composed function
   * @return a new {@link FunctionResult7} that composes this instance's function with another "mapper" function
   */
  @SuppressWarnings("unchecked")
  public <Q> FunctionResult7<A, B, C, D, E, F, G, Q> andThen(Function1.Serializable<? super R, ? extends Q> mapper) {
    return (FunctionResult7<A, B, C, D, E, F, G, Q>) clone(c -> ((FunctionResult7<A, B, C, D, E, F, G, Q>) c)._function =
        _function.andThen(mapper.safelySerializable()));
  }

  @Override
  public String toString() {
    return "FunctionResult7(" + _function.toString() + ")";
  }

  @Override
  protected String getDefaultName() {
    return Named.getName(_function);
  }

  @Override
  protected String getDefaultShortName() {
    return Named.getShortName(_function);
  }
}
