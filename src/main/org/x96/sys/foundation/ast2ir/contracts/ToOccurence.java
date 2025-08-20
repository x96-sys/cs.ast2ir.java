package org.x96.sys.foundation.ast2ir.contracts;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.occurrence.Occurrence;

import java.util.Optional;

public interface ToOccurence {
    public Optional<Occurrence> convert(Optional<Quantifier> quantifier);
}
