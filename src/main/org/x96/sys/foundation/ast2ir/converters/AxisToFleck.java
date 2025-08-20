package org.x96.sys.foundation.ast2ir.converters;

import org.x96.sys.foundation.ast2ir.contracts.ToFleck;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.*;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Fleck;

public class AxisToFleck implements ToFleck {
    @Override
    public Fleck convert(Axis axis) {
        return switch (axis) {
            case RangeHex rangeHex -> {
                yield new RangeHexToRange().convert(rangeHex);
            }
            case Word word -> {
                yield new WordToText().convert(word);
            }
            case Unit unit -> {
                yield new UnitToTerm().convert(unit);
            }
            case Choices choices -> {
                yield new ChoicesToSwitch().convert(choices);
            }
            case Segment segment -> {
                yield new SegmentToTrace().convert(segment);
            }
        };
    }
}
