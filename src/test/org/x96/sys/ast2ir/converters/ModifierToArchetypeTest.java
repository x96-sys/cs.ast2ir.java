package org.x96.sys.ast2ir.converters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.ast.book.passage.pattern.modifier.Ghost;
import org.x96.sys.cs.ast.book.passage.pattern.modifier.Shell;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.archetype.Archetype;

import java.util.Optional;

class ModifierToArchetypeTest {
    @Test
    void happy() {
        Optional<Archetype> convert =
                new ModifierToArchetype().convert(Optional.of(new Ghost("_".getBytes()[0])));
        assertTrue(convert.isPresent());
        assertEquals(Archetype.Ghost, convert.get());

        convert = new ModifierToArchetype().convert(Optional.of(new Shell("@".getBytes()[0])));
        assertTrue(convert.isPresent());
        assertEquals(Archetype.Shell, convert.get());

        convert = new ModifierToArchetype().convert(Optional.empty());
        assertFalse(convert.isPresent());
    }
}
