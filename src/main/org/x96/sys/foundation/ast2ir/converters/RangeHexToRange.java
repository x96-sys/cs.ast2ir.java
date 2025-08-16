package org.x96.sys.foundation.ast2ir.converters;

import org.x96.sys.foundation.ast2ir.contracts.ToRange;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.RangeHex;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Natural;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Range;

public class RangeHexToRange implements ToRange {
    @Override
    public Range convert(RangeHex rangeHex) {
        Natural from = new HexadecimalToNatural().convert(rangeHex.min());
        Natural to = new HexadecimalToNatural().convert(rangeHex.max());
        return new Range(from, to);
    }
}
