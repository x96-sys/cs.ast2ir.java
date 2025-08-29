package org.x96.sys.ast2ir.contracts;

import org.x96.sys.cs.ast.book.passage.pattern.core.Hexadecimal;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Natural;

public interface ToNatural {
    Natural convert(Hexadecimal h);
}
