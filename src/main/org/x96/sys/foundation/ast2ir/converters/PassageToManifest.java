package org.x96.sys.foundation.ast2ir.converters;

import org.x96.sys.foundation.ast2ir.contracts.ToManifest;
import org.x96.sys.foundation.cs.ast.book.passage.Passage;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.Manifest;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.Characterization;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.archetype.Archetype;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.Facet;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Identity;

import java.util.Optional;

public class PassageToManifest implements ToManifest {
    @Override
    public Manifest convert(Passage passage) {
        Identity identity = new GlyphToIdentity().convert(passage.glyph());
        Facet facet = new PatternToFacet().convert(passage.pattern());
        Optional<Archetype> archetype = new ModifierToArchetype().convert(passage.modifier());
        Characterization characterization = new Characterization(archetype, facet);
        return new Manifest(identity, characterization);
    }
}
