package org.x96.sys.ast2ir.contracts;

import org.x96.sys.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Nucleus;

public interface ToNucleus {
    public Nucleus convert(Core core);
}
