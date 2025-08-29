package org.x96.sys.ast2ir.contracts;

import org.x96.sys.cs.ast.book.Book;
import org.x96.sys.cs.ir.manuscript.Manuscript;

public interface ToManuscript {
    public Manuscript convert(Book book);
}
