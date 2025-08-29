package org.x96.sys.ast2ir.contracts;

import org.x96.sys.cs.ast.book.passage.pattern.core.RangeHex;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Range;

public interface ToRange {
    public Range convert(RangeHex rangeHex);
}
