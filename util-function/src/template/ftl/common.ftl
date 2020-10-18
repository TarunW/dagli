<#macro AutoGeneratedWarning>
// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the ${.caller_template_name} file.
// See the README in the module's src/template directory for details.
</#macro>

<#assign tuples = ["Nil", "Unit", "Pair", "Triplet", "Quartet", "Quintet", "Sextet", "Septet", "Octet", "Ennead",
                   "Decade"] />

<#assign inputLetters = ["Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"] />

<#assign resultLetter = "R" />

<#assign maxArity = 10 />

<#-- Gets the generic type parameter name corresponding to the provided 1-based index -->
<#function InputGenericArgument number>
  <#return inputLetters[number] />
</#function>

<#-- Gets the generic result tuple subtype parameter name corresponding to the provided 1-based index -->
<#-- e.g. RA, RB, RC... -->
<#function ResultGenericArgument number>
  <#return "R" + inputLetters[number] />
</#function>

<#-- Gets the suffix appended to an input value or producer corresponding to the provided 1-based index -->
<#function InputSuffix number>
  <#return number />
</#function>

<#macro InputSuffixedList prefix count extraSuffix="">
  <@compress single_line=true>
  <#if (count > 0)>
    <#list 1..count as index>${prefix}${InputSuffix(index)}${extraSuffix}<#sep>, </#list>
  </#if>
  </@compress>
</#macro>

<#macro InputSuffixedParameters prefix count>
  <@compress single_line=true>
    <#list 1..count as index>${InputGenericArgument(index)} ${prefix}${InputSuffix(index)}<#sep>, </#list>
  </@compress>
</#macro>

<#-- e.g. Pair<? extends A, ? extends B> -->
<#macro ValueTupleType count>
  <@compress single_line=true>
    ${tuples[count]}<<#list 1..count as index>? extends ${InputGenericArgument(index)}<#sep>, </#list>>
  </@compress>
</#macro>

<#macro InputGenericArguments count startingAt=1>
  <@compress single_line=true>
    <#list startingAt..<(count+1) as index>${InputGenericArgument(index)}<#sep>, </#list>
  </@compress>
</#macro>

<#macro InputGenericArgumentsExcept count exception>
  <@compress single_line=true>
    <#list ((1..<exception) + (exception+1..<(count+1))) as index>${InputGenericArgument(index)}<#sep>, </#list>
  </@compress>
</#macro>

<#macro ResultGenericArguments count startingAt=1>
  <@compress single_line=true>
    <#list startingAt..count as index>${ResultGenericArgument(index)}<#sep>, </#list>
  </@compress>
</#macro>

<#-- Producer<? extends A> input0, Producer<? extends B> input1, ... -->
<#macro InputProducerList count name="input">
  <@compress single_line=true>
    <#list 1..count as index>Producer<? extends ${InputGenericArgument(index)}> ${name}${InputSuffix(index)}<#sep>, </#list>
  </@compress>
</#macro>

<#-- getInput0(), getInput1(), ... -->
<#macro GetInputList count prepend="">
  <@compress single_line=true>
    <#list 1..count as index>${prepend}getInput${InputSuffix(index)}()<#sep>, </#list>
  </@compress>
</#macro>

<#-- CollectionType<? extends A> values0, CollectionType<? extends B> values1, ... -->
<#macro ValuesArguments collectionType count name="values">
  <@compress single_line=true>
    <#list 1..count as index>${collectionType}<? extends ${InputGenericArgument(index)}> ${name}${InputSuffix(index)}<#sep>, </#list>
  </@compress>
</#macro>

<#macro InputValueList count>
  <@compress single_line=true>
    <#if (count > 0)>
    <#list 1..count as index>${InputGenericArgument(index)} value${InputSuffix(index)}<#sep>, </#list>
    </#if>
  </@compress>
</#macro>

<#macro Transformer arity offset=0>
  <@compress single_line=true>
    Transformer${arity}<<@InputGenericArguments arity />, R>
  </@compress>
</#macro>

<#macro PreparedTransformer arity>
  <@compress single_line=true>
    PreparedTransformer${arity}<<@InputGenericArguments arity />, R>
  </@compress>
</#macro>

<#macro PreparableTransformer arity preparedType>
  <@compress single_line=true>
    PreparableTransformer${arity}<<@InputGenericArguments arity />, R, ${preparedType}>
  </@compress>
</#macro>

<#macro TransformerInternalAPI arity subclass>
  <@compress single_line=true>
    Transformer${arity}InternalAPI<<@InputGenericArguments arity />, R, ${subclass}>
  </@compress>
</#macro>

<#macro PreparableTransformerInternalAPI arity preparedType subclass>
  <@compress single_line=true>
    PreparableTransformer${arity}InternalAPI<<@InputGenericArguments arity />, R, ${preparedType}, ${subclass}>
  </@compress>
</#macro>

<#macro PreparedTransformerInternalAPI arity subclass>
  <@compress single_line=true>
    PreparedTransformer${arity}InternalAPI<<@InputGenericArguments arity />, R, ${subclass}>
  </@compress>
</#macro>

<#macro AbstractTransformer arity api_interface subclass>
  <@compress single_line=true>
    AbstractTransformer${arity}<<@InputGenericArguments arity />, R, ${api_interface}, ${subclass}>
  </@compress>
</#macro>

<#macro AbstractPreparedTransformer arity subclass>
  <@compress single_line=true>
    AbstractPreparedTransformer${arity}<<@InputGenericArguments arity />, R, ${subclass}>
  </@compress>
</#macro>

<#macro AbstractPreparableTransformer arity preparedType subclass>
  <@compress single_line=true>
    AbstractPreparableTransformer${arity}<<@InputGenericArguments arity />, R, ${preparedType}, ${subclass}>
  </@compress>
</#macro>

<#macro Preparer arity resultType>
  <@compress single_line=true>
    Preparer${arity}<<@InputGenericArguments arity />, R, ${resultType}>
  </@compress>
</#macro>

<#macro TrivialPreparer arity resultType="?">
  <@compress single_line=true>
    TrivialPreparer${arity}<<@InputGenericArguments arity />, R, ${resultType}>
  </@compress>
</#macro>

<#macro AbstractTransformerBuilder arity>
  <@compress single_line=true>
    AbstractTransformerBuilder${arity}<<@InputGenericArguments arity />, R, <#nested />>
  </@compress>
</#macro>

<#macro Tupled arity>
  <@compress single_line=true>
    Tupled${arity}<<@InputGenericArguments arity />>
  </@compress>
</#macro>

<#macro MethodResult arity>
  <@compress single_line=true>
  MethodResult${arity}<<@InputGenericArguments arity />, R>
  </@compress>
</#macro>

<#macro FunctionResult arity>
  <@compress single_line=true>
  FunctionResult${arity}<<@InputGenericArguments arity />, R>
  </@compress>
</#macro>

<#macro DAGClassName inputArity outputArity>
  <@compress single_line=true>
  DAG${inputArity}x${outputArity}
  </@compress>
</#macro>

<#macro DAG inputArity outputArity>
  <@compress single_line=true>
    <@DAGClassName inputArity outputArity /><<@InputGenericArguments inputArity />, <@ResultGenericArguments outputArity />>
  </@compress>
</#macro>

<#macro AbstractDAGResultName outputArity>
  <@compress single_line=true>
  AbstractDAGResult${outputArity}
  </@compress>
</#macro>

<#macro AbstractDAGResult outputArity>
  <@compress single_line=true>
    <@AbstractDAGResultName outputArity /><<@ResultGenericArguments outputArity />>
  </@compress>
</#macro>


<#macro DAGResultInterfaceName outputArity>
  <@compress single_line=true>
  DAGResult${outputArity}
  </@compress>
</#macro>

<#macro DAGResultInterface outputArity>
  <@compress single_line=true>
    <@DAGResultInterfaceName outputArity /><<@ResultGenericArguments outputArity />>
  </@compress>
</#macro>

<#macro DAGResultClassName inputArity outputArity>
  <@compress single_line=true>
  DAG${inputArity}x${outputArity}.Result
  </@compress>
</#macro>

<#macro DAGResult inputArity outputArity>
  <@compress single_line=true>
    <@DAGResultClassName inputArity outputArity /><<@InputGenericArguments inputArity />, <@ResultGenericArguments outputArity />>
  </@compress>
</#macro>

<#macro DAGResultLocal inputArity outputArity>
  <@compress single_line=true>
    Result<<@InputGenericArguments inputArity />, <@ResultGenericArguments outputArity />>
  </@compress>
</#macro>

<#macro PreparedDAGResultClassName inputArity outputArity>
  <@compress single_line=true>
  DAG${inputArity}x${outputArity}.Prepared.Result
  </@compress>
</#macro>

<#macro PreparedDAGResult inputArity outputArity>
  <@compress single_line=true>
    <@PreparedDAGResultClassName inputArity outputArity /><<@ResultGenericArguments outputArity />>
  </@compress>
</#macro>

<#macro PreparedDAGResultLocal outputArity>
  <@compress single_line=true>
    Result<<@ResultGenericArguments outputArity />>
  </@compress>
</#macro>

<#macro PreparedDAGClassName inputArity outputArity>
  <@compress single_line=true>
      DAG${inputArity}x${outputArity}.Prepared
  </@compress>
</#macro>

<#-- Class signature as used outside the class and enclosing class -->
<#macro PreparedDAG inputArity outputArity>
  <@compress single_line=true>
    <@PreparedDAGClassName inputArity outputArity /><<@InputGenericArguments inputArity />, <@ResultGenericArguments outputArity />>
  </@compress>
</#macro>

<#-- Class signature as used within the class and enclosing class -->
<#macro PreparedDAGLocal inputArity outputArity>
  <@compress single_line=true>
    Prepared<<@InputGenericArguments inputArity />, <@ResultGenericArguments outputArity />>
  </@compress>
</#macro>

<#-- Tuple type used to return results from DAGs.  For a single value, the value type is used directly, e.g. RA -->
<#-- For multiple values, this becomes, e.g. Pair<RA, RB>, Triplet<RA, RB, RC>, etc. -->
<#macro ResultTuple outputArity>
  <@compress single_line=true>
    <#if (outputArity > 1)>
      ${tuples[outputArity]}<<@ResultGenericArguments outputArity />>
    <#else>
      ${ResultGenericArgument(1)}
    </#if>
  </@compress>
</#macro>

<#macro ResultTupleOrUnit outputArity>
  <@compress single_line=true>
    ${tuples[outputArity]}<<@ResultGenericArguments outputArity />>
  </@compress>
</#macro>

<#macro LengthCheck variable arity>
  Preconditions.checkArgument(${variable}.length == ${arity}, "${arity} argument<#if (arity > 1)>s</#if> must be provided");
</#macro>

<#macro SizeCheck variable arity>
  Preconditions.checkArgument(${variable}.size() == ${arity}, "${arity} argument<#if (arity > 1)>s</#if> must be provided");
</#macro>

<#-- Generate a list of "MissingInput.get(), MissingInput.get(), ..., MissingInput.get()" -->
<#macro MissingInputs arity>
  <@compress single_line=true>
    <#list 1..arity as index>MissingInput.get()<#sep>, </#list>
  </@compress>
</#macro>

<#macro s arity>
  <@compress single_line=true>
    <#if (arity > 1)>s</#if>
  </@compress>
</#macro>

<#macro WithGeneratorAsInput prepared arity resultArity><#if (arity > 1)><#list 1..arity as index>
public <#if prepared><@PreparedDAGClassName arity-1 resultArity /><#else><@DAGClassName arity-1 resultArity /></#if><<@InputGenericArgumentsExcept arity index />, <@ResultGenericArguments resultArity />> withGeneratorAsInput${index-1}(Generator<${InputGenericArgument(index)}> generator) {
  <#list ((1..<index) + ((index+1)..<(arity+1))) as placeholderIndex>
  Placeholder<${InputGenericArgument(placeholderIndex)}> nestedPlaceholder${InputSuffix(placeholderIndex)} = new Placeholder<>("Original Input ${InputSuffix(placeholderIndex)}");
  </#list>
  <#if prepared><@PreparedDAGLocal arity resultArity /><#else><@DAG arity resultArity /></#if> dag =
    this.withInputs(<#list 1..<index as placeholderIndex>nestedPlaceholder${InputSuffix(placeholderIndex)}, </#list>generator<#list (index+1)..<(arity+1) as placeholderIndex>, nestedPlaceholder${InputSuffix(placeholderIndex)}</#list>);

  return DAG<#if prepared>.Prepared</#if>
    .withPlaceholder<@s arity-1 />(<#list ((1..<index) + ((index+1)..<(arity+1))) as placeholderIndex>nestedPlaceholder${InputSuffix(placeholderIndex)}<#sep>, </#list>)
    <#if (resultArity > 1)>
    .withOutputs(<#list 1..resultArity as resultIndex>new Value${resultIndex-1}FromTuple<>(dag)<#sep>, </#list>)
    <#else>
    .withOutput(dag)
    </#if>
    .withExecutor(_executor)
    .withInput<@s arity-1 />(<#list ((1..<index) + ((index+1)..<(arity+1))) as placeholderIndex>getInput${InputSuffix(placeholderIndex)}()<#sep>, </#list>);
}
</#list></#if></#macro>

<#-- Gets indentation whitespace for a specified level.  This returned string will have 2 * indentLevel spaces. -->
<#function Indentation level>
  <#return ''?left_pad(level * 2, ' ') />
</#function>

<#-- Indents each line of whatever this macro contains through a necessarily convoluted scheme -->
<#macro Indent level=1>
<#assign nestedString><#nested /></#assign>
<#assign indentedNestedString = Indentation(level) + nestedString?replace("\n", "\n" + Indentation(level)) />
${indentedNestedString?keep_before_last(Indentation(level))}</#macro> <#-- remove extra indent added to end of the input -->