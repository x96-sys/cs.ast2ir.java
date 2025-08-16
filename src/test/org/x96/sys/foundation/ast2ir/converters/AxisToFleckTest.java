package org.x96.sys.foundation.ast2ir.converters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Choices;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Unit;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Word;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.Inhibitor;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.OneOrMore;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Fleck;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Switch;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Term;

import java.util.Optional;

class AxisToFleckTest {
    @Test
    void happy() {
        Inhibitor i = new Inhibitor('!');
        Unit unit = new Unit(Optional.of(i), new Glyph("cs".getBytes()), Optional.empty());
        Fleck convert = new AxisToFleck().convert(unit);
        assertInstanceOf(Term.class, convert);

        Choices choices =
                new Choices(
                        new Core[] {new Word("cs".getBytes()), new Word("sc".getBytes())},
                        Optional.of(new OneOrMore("+".getBytes()[0])));
        convert = new AxisToFleck().convert(choices);
        assertInstanceOf(Switch.class, convert);
    }
}
