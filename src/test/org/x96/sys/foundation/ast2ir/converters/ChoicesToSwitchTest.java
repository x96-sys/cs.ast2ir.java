package org.x96.sys.foundation.ast2ir.converters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Choices;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Word;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrMore;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.occurrence.Occurrence;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Switch;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Text;

import java.util.Optional;

class ChoicesToSwitchTest {
    @Test
    void happy() {
        Choices choices =
                new Choices(
                        new Core[] {new Word("cs".getBytes()), new Word("sc".getBytes())},
                        Optional.of(new ZeroOrMore("*".getBytes()[0])));
        Switch s = new ChoicesToSwitch().convert(choices);
        assertTrue(s.occurrence().isPresent());
        assertEquals(Occurrence.ZeroOrMore, s.occurrence().get());
        assertEquals(2, s.nuclei().length);
        assertInstanceOf(Text.class, s.nuclei()[0]);
        assertEquals("cs", new String(((Text) s.nuclei()[0]).raw()));
        assertInstanceOf(Text.class, s.nuclei()[1]);
        assertEquals("sc", new String(((Text) s.nuclei()[1]).raw()));
        assertInstanceOf(Text.class, s.nuclei()[1]);
    }
}
