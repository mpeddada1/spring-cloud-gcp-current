package com.example;

import java.util.Arrays;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeReference;

public class MyCustomRuntimeHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints
                .reflection()
                .registerTypes(
                        Arrays.asList(TypeReference.of(OcrStatusReporter.class)),
                        hint ->
                                hint.withMembers(
                                        MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
                                        MemberCategory.INVOKE_PUBLIC_METHODS));
    }
}
