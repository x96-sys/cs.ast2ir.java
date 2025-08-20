package org.x96.sys.foundation.ast2ir.converters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.*;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrOne;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.occurrence.Occurrence;

import java.util.Optional;

class QuantifierToOccurrenceTest {
    @Test
    void happy() {
        assertEquals(
                Optional.of(Occurrence.OneOrMore),
                new QuantifierToOccurrence()
                        .convert(Optional.of(new OneOrMore("+".getBytes()[0]))));
        assertEquals(
                Optional.of(Occurrence.ZeroOrOne),
                new QuantifierToOccurrence()
                        .convert(Optional.of(new ZeroOrOne("?".getBytes()[0]))));
        assertEquals(
                Optional.of(Occurrence.ZeroOrMore),
                new QuantifierToOccurrence()
                        .convert(Optional.of(new ZeroOrMore("*".getBytes()[0]))));
        assertEquals(Optional.empty(), new QuantifierToOccurrence().convert(Optional.empty()));
    }
}
