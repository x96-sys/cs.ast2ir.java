package org.x96.sys.foundation.ast2ir.contracts;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Choices;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Switch;

public interface ToSwitch {
    public Switch convert(Choices choices);
}
