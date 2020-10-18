// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the transformer/PreparedTransformerX.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.transformer;

import java.util.ArrayList;
import java.util.Arrays;

import com.linkedin.dagli.dag.DAG;
import com.linkedin.dagli.dag.DAG9x1;
import com.linkedin.dagli.objectio.biglist.BigListWriter;
import com.linkedin.dagli.objectio.ObjectReader;
import com.linkedin.dagli.placeholder.Placeholder;
import com.linkedin.dagli.transformer.internal.PreparedTransformer9InternalAPI;
import com.linkedin.dagli.util.collection.Iterables;


public interface PreparedTransformer9<A, B, C, D, E, F, G, H, I, R> extends Transformer9<A, B, C, D, E, F, G, H, I, R>,
    PreparedTransformer<R> {

  /**
   * Applies the transformer to the given input values.
   *
   * This method must be thread-safe as it may be invoked concurrently on the same instance.
   *
   * @param value1 the first input value
   * @param value2 the second input value
   * @param value3 the third input value
   * @param value4 the fourth input value
   * @param value5 the fifth input value
   * @param value6 the sixth input value
   * @param value7 the seventh input value
   * @param value8 the eighth input value
   * @param value9 the ninth input value
   * @return the result of applying this transformer to the given example
   */
  R apply(A value1, B value2, C value3, D value4, E value5, F value6, G value7, H value8, I value9);

  /**
   * Applies the transformer to the given examples, provided as parallel {@link Iterable}s of values.  Each position
   * in each value list corresponds to a particular example; e.g. values1.get(5) is the first input value for the
   * 6th example.
   *
   * @param values1 the list of values for the first input
   * @param values2 the list of values for the second input
   * @param values3 the list of values for the third input
   * @param values4 the list of values for the fourth input
   * @param values5 the list of values for the fifth input
   * @param values6 the list of values for the sixth input
   * @param values7 the list of values for the seventh input
   * @param values8 the list of values for the eighth input
   * @param values9 the list of values for the ninth input
   * @return an {@link ObjectReader} containing the results of the transformation
   */
  default ObjectReader<R> applyAll(Iterable<? extends A> values1, Iterable<? extends B> values2,
      Iterable<? extends C> values3, Iterable<? extends D> values4, Iterable<? extends E> values5,
      Iterable<? extends F> values6, Iterable<? extends G> values7, Iterable<? extends H> values8,
      Iterable<? extends I> values9) {
    long count = Iterables.size64(values1);
    Object executionObject = internalAPI().createExecutionCache(count);

    int minibatchSize = (int) Math.min(count, Math.max(1024, internalAPI().getPreferredMinibatchSize()));
    ArrayList<R> resultBuffer = new ArrayList<>(minibatchSize);
    BigListWriter<R> result = new BigListWriter<>(count);

    ObjectReader
        .concatenate(Object[]::new, ObjectReader.wrap(values1), ObjectReader.wrap(values2), ObjectReader.wrap(values3),
            ObjectReader.wrap(values4), ObjectReader.wrap(values5), ObjectReader.wrap(values6),
            ObjectReader.wrap(values7), ObjectReader.wrap(values8), ObjectReader.wrap(values9)).lazyMap(Arrays::asList)
        .forEachBatch(minibatchSize, batch -> {
          internalAPI().applyAllUnsafe(executionObject, batch.size(), batch, resultBuffer);
          result.writeAll(resultBuffer);
          resultBuffer.clear();
        });

    return result.createReader();
  }

  @Override
  PreparedTransformer9InternalAPI<A, B, C, D, E, F, G, H, I, R, ? extends PreparedTransformer9<A, B, C, D, E, F, G, H, I, R>> internalAPI();

  /**
   * Casts a prepared transformer to a "supertype".  This cast is safe due to the semantics of prepared transformers.
   *
   * @param prepared the prepared transformer to cast
   * @param <A> the new type of input #1
   * @param <B> the new type of input #2
   * @param <C> the new type of input #3
   * @param <D> the new type of input #4
   * @param <E> the new type of input #5
   * @param <F> the new type of input #6
   * @param <G> the new type of input #7
   * @param <H> the new type of input #8
   * @param <I> the new type of input #9
   * @param <R> the new result type
   * @return the provided {@code prepared}, cast to the desired "supertype"
   */
  @SuppressWarnings("unchecked")
  static <A, B, C, D, E, F, G, H, I, R> PreparedTransformer9<A, B, C, D, E, F, G, H, I, R> cast(
      PreparedTransformer9<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? super H, ? super I, ? extends R> prepared) {
    // safe due to semantics of prepared transformers:
    return (PreparedTransformer9<A, B, C, D, E, F, G, H, I, R>) prepared;
  }

  /**
   * Creates a trivial DAG that wraps the provided transformer, with the DAG retaining the transformer's existing
   * inputs or, if the transformer is already a DAG, simply returns it unaltered.
   *
   * @param transformer the transformer to wrap
   * @param <A> the type of transformer input #1
   * @param <B> the type of transformer input #2
   * @param <C> the type of transformer input #3
   * @param <D> the type of transformer input #4
   * @param <E> the type of transformer input #5
   * @param <F> the type of transformer input #6
   * @param <G> the type of transformer input #7
   * @param <H> the type of transformer input #8
   * @param <I> the type of transformer input #9
   * @param <R> the type of result produced by the transformer
   * @return a trivial DAG that wraps the provided transformer, or the transformer itself if it is already a DAG
   */
  static <A, B, C, D, E, F, G, H, I, R> DAG9x1.Prepared<A, B, C, D, E, F, G, H, I, R> toDAG(
      PreparedTransformer9<A, B, C, D, E, F, G, H, I, R> transformer) {
    if (transformer instanceof DAG9x1.Prepared) {
      return (DAG9x1.Prepared<A, B, C, D, E, F, G, H, I, R>) transformer;
    }

    Placeholder<A> placeholder1 = new Placeholder<>("Input #1");
    Placeholder<B> placeholder2 = new Placeholder<>("Input #2");
    Placeholder<C> placeholder3 = new Placeholder<>("Input #3");
    Placeholder<D> placeholder4 = new Placeholder<>("Input #4");
    Placeholder<E> placeholder5 = new Placeholder<>("Input #5");
    Placeholder<F> placeholder6 = new Placeholder<>("Input #6");
    Placeholder<G> placeholder7 = new Placeholder<>("Input #7");
    Placeholder<H> placeholder8 = new Placeholder<>("Input #8");
    Placeholder<I> placeholder9 = new Placeholder<>("Input #9");
    return DAG.Prepared
        .withPlaceholders(placeholder1, placeholder2, placeholder3, placeholder4, placeholder5, placeholder6,
            placeholder7, placeholder8, placeholder9)
        .withNoReduction()
        .withOutput(
            transformer.internalAPI().withInputs(placeholder1, placeholder2, placeholder3, placeholder4, placeholder5,
                placeholder6, placeholder7, placeholder8, placeholder9))
        .withAllInputs(transformer.internalAPI().getInput1(), transformer.internalAPI().getInput2(),
            transformer.internalAPI().getInput3(), transformer.internalAPI().getInput4(),
            transformer.internalAPI().getInput5(), transformer.internalAPI().getInput6(),
            transformer.internalAPI().getInput7(), transformer.internalAPI().getInput8(),
            transformer.internalAPI().getInput9());
  }
}
