package org.x96.sys.foundation.ast2ir.converters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Unit;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.Bang;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrMore;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.occurrence.Occurrence;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Term;

import java.util.Optional;

class UnitToTermTest {
    @Test
    void happy() {
        Unit unit =
                new Unit(
                        Optional.of(new Bang("!".getBytes()[0])),
                        new Glyph("cs".getBytes()),
                        Optional.of(new ZeroOrMore("*".getBytes()[0])));
        Term term = new UnitToTerm().convert(unit);
        assertTrue(term.negate());
        assertEquals("cs", new String(term.identity().raw()));
        assertTrue(term.occurrence().isPresent());
        assertEquals(Occurrence.ZeroOrMore, term.occurrence().get());
        assertEquals("*", term.occurrence().get().decor());
    }
}
