package org.x96.sys.foundation.ast2ir.converters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.*;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrMore;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.occurrence.Occurrence;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Range;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Text;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Trace;

import java.util.Optional;

class SegmentToTraceTest {
    @Test
    void happy() {
        Segment s =
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

        Trace trace = new SegmentToTrace().convert(s);
        assertEquals(3, trace.flecks().length);
        assertTrue(trace.occurrence().isPresent());
        assertEquals(Occurrence.ZeroOrMore, trace.occurrence().get());
        assertInstanceOf(Range.class, trace.flecks()[0]);
        assertInstanceOf(Text.class, trace.flecks()[1]);
        assertInstanceOf(Trace.class, trace.flecks()[2]);
    }
}
