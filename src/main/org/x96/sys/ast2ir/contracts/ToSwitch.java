package org.x96.sys.ast2ir.contracts;

import org.x96.sys.cs.ast.book.passage.pattern.core.Choices;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Switch;

public interface ToSwitch {
    public Switch convert(Choices choices);
}
