package org.x96.sys.foundation.ast2ir.converters;

import org.x96.sys.foundation.ast2ir.contracts.ToArchetype;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Ghost;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Modifier;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Shell;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.archetype.Archetype;

import java.util.Optional;

public class ModifierToArchetype implements ToArchetype {

    @Override
    public Optional<Archetype> convert(Optional<Modifier> modifier) {
        if (modifier.isPresent()) {
            switch (modifier.get()) {
                case Ghost ghost -> {
                    return Optional.of(Archetype.Ghost);
                }
                case Shell shell -> {
                    return Optional.of(Archetype.Shell);
                }
            }
        }
        return Optional.empty();
    }
}
