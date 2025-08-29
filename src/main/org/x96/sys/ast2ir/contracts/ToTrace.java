package org.x96.sys.ast2ir.contracts;

import org.x96.sys.cs.ast.book.passage.pattern.core.Segment;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Trace;

public interface ToTrace {
    public Trace convert(Segment segment);
}
