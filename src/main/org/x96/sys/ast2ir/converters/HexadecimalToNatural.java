package org.x96.sys.ast2ir.converters;

import org.x96.sys.ast2ir.contracts.ToNatural;
import org.x96.sys.cs.ast.book.passage.pattern.core.Hexadecimal;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Natural;

public class HexadecimalToNatural implements ToNatural {
    @Override
    public Natural convert(Hexadecimal h) {
        return new Natural(h.raw());
    }
}
