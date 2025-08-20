package org.x96.sys.foundation.ast2ir.contracts;

import org.x96.sys.foundation.cs.ast.book.Book;
import org.x96.sys.foundation.cs.ir.manuscript.Manuscript;

public interface ToManuscript {
    public Manuscript convert(Book book);
}
