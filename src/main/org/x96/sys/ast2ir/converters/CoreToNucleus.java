package org.x96.sys.ast2ir.converters;

import org.x96.sys.ast2ir.contracts.ToNucleus;
import org.x96.sys.cs.ast.book.passage.pattern.core.*;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Nucleus;

public class CoreToNucleus implements ToNucleus {

    @Override
    public Nucleus convert(Core core) {
        return switch (core) {
            case Hexadecimal hexadecimal -> {
                yield new HexadecimalToNatural().convert(hexadecimal);
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
