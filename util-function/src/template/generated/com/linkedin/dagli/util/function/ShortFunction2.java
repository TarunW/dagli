// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the util/function/Function.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.util.function;

import com.linkedin.dagli.util.exception.Exceptions;


@FunctionalInterface
public interface ShortFunction2<A, B> extends FunctionBase {
  short apply(A value1, B value2);

  /**
   * Returns a new function that wraps this "original" function.  The wrapping function will return 0
   * without calling the original function if any argument is null.  If no argument is null, the original function will
   * be called as normal and its return value will be returned by the wrapping function.
   *
   * This is useful when you have a function that cannot accept a null as an argument but are satisfied to just return
   * a default value in such instances.
   *
   * @return a new function that calls this one if all arguments or non-null, or returns a default value otherwise.
   */
  default ShortFunction2<A, B> returnZeroOnNullArgument() {
    return new ShortDefaultOnNullArgument2<>(this);
  }

  static <A, B> ShortFunction2<A, B> unchecked(Checked<A, B, ?> checkedFunction) {
    return (A value1, B value2) -> {
      try {
        return checkedFunction.apply(value1, value2);
      } catch (Throwable e) {
        throw Exceptions.asRuntimeException(e);
      }
    };
  }

  @FunctionalInterface
  interface Checked<A, B, X extends Throwable> extends FunctionBase {
    short apply(A value1, B value2) throws X;
  }

  interface Serializable<A, B> extends ShortFunction2<A, B>, java.io.Serializable {
    /**
     * Creates a new, safely-serializable function from this one if this is a method reference (e.g. Object::toString),
     * or simply returns this if this is a function object.  If this is something not safely serializable (e.g. a
     * lambda), an exception will be thrown.
     *
     * "Safely-serializable" means that a function can be deserialized in a way that is not inherently brittle.
     * We recommend only serializing functions when they are safely-serializable, but note that this is not a guarantee;
     * as with Serializable objects in general it's always possible to create something (safely-)serializable that will
     * not serialize, e.g. an instance method with a captured instance (e.g. new Object()::toString) where the captured
     * instance is not itself serializable.
     *
     * Function objects that wrap functions and implement ShortFunction2.Serializable should override this method
     * when appropriate.  Generally such an implementation will simply create a new instance wrapping
     * wrappedFunction.safelySerializable() instead of wrappedFunction.
     *
     * Anonymous lambdas, such as "a -> a + 5", are *not* safely-serializable, even if they are technically
     * serializable, as they are extraordinarily fragile and will only deserialize correctly under these conditions:
     * (1) the class in which they were created must exist in both serializing and deserializing programs.
     * (2) the ORDER in which the lambdas are defined must not change.  The names of the generated anonymous classes are
     * dependent upon the position in which the lambda appears in the file!
     * (3) the JVM should be consistent, as different JVMs are in principle free to generate different class names.
     */
    default Serializable<A, B> safelySerializable() {
      try {
        return new ShortMethodReference2<A, B>(this);
      } catch (java.lang.RuntimeException e) {
        if (e.getCause() instanceof java.lang.NoSuchMethodException) {
          // must be a function object
          return this;
        } else {
          // anonymous lambda or something went wrong
          throw e;
        }
      }
    }

    @Override
    default Serializable<A, B> returnZeroOnNullArgument() {
      return new ShortDefaultOnNullArgument2(this);
    }

  }
}