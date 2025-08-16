package org.x96.sys.foundation.ast2ir.converters;

import org.x96.sys.foundation.ast2ir.contracts.ToTrace;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Segment;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Fleck;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Trace;

public class SegmentToTrace implements ToTrace {
    @Override
    public Trace convert(Segment segment) {
        Fleck[] f = new Fleck[segment.axes().length];
        for (int i = 0; i < segment.axes().length; i++) {
            f[i] = new AxisToFleck().convert(segment.axes()[i]);
        }
        return new Trace(f, new QuantifierToOccurrence().convert(segment.quantifier()));
    }
}
