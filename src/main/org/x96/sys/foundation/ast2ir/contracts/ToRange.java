package org.x96.sys.foundation.ast2ir.contracts;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.RangeHex;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Range;

public interface ToRange {
    public Range convert(RangeHex rangeHex);
}
