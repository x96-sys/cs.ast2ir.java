package org.x96.sys.ast2ir.converters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.cs.ast.book.passage.pattern.Lineage;
import org.x96.sys.cs.ast.book.passage.pattern.core.*;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.Bang;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.OneOrMore;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrMore;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.Track;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Natural;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Nucleus;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Switch;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Term;

import java.util.Optional;

class LineageToTrackTest {
    @Test
    void happy() {
        Hexadecimal hex = new Hexadecimal(0x73);
        Nucleus convert = new CoreToNucleus().convert(hex);
        assertInstanceOf(Natural.class, convert);

        Bang i = new Bang((byte) '!');
        Unit unit = new Unit(Optional.of(i), new Glyph("cs".getBytes()), Optional.empty());
        convert = new CoreToNucleus().convert(unit);
        assertInstanceOf(Term.class, convert);

        Choices choices =
                new Choices(
                        new Core[] {new Word("cs".getBytes()), new Word("sc".getBytes())},
                        Optional.of(new OneOrMore("+".getBytes()[0])));
        convert = new CoreToNucleus().convert(choices);
        assertInstanceOf(Switch.class, convert);

        Segment segment =
                new Segment(
                        new Axis[] {
                            new RangeHex(new Hexadecimal(0x1), new Hexadecimal(0x2)),
                            new Word("cs".getBytes()),
                            new Segment(
                                    new Axis[] {
                                        new RangeHex(new Hexadecimal(0x11), new Hexadecimal(0x22)),
                                        new Word("sc".getBytes())
                                    },
                                    Optional.empty())
                        },
                        Optional.of(new ZeroOrMore("*".getBytes()[0])));

        Track track =
                new LineageToTrack().convert(new Lineage(new Core[] {hex, unit, choices, segment}));
        assertEquals(4, track.nuclei().length);
    }
}
