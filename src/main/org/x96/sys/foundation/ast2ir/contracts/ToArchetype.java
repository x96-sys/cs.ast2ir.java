package org.x96.sys.foundation.ast2ir.contracts;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Modifier;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.archetype.Archetype;

import java.util.Optional;

public interface ToArchetype {
    public Optional<Archetype> convert(Optional<Modifier> quantifier);
}
