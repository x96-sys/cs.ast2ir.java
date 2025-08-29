package org.x96.sys.ast2ir.converters;

import org.x96.sys.ast2ir.contracts.ToManuscript;
import org.x96.sys.cs.ast.book.Book;
import org.x96.sys.cs.ir.manuscript.Manuscript;
import org.x96.sys.cs.ir.manuscript.manifest.Manifest;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Identity;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Text;

public class BookToManuscript implements ToManuscript {

    @Override
    public Manuscript convert(Book book) {
        Manifest[] manifests = new Manifest[book.passages().length];
        for (int i = 0; i < book.passages().length; i++) {
            manifests[i] = new PassageToManifest().convert(book.passages()[i]);
        }
        return new Manuscript(
                new Text("0.1.2".getBytes()), new Identity("cs".getBytes()), manifests);
    }
}
