package com.yiibai.lucene;

/**
 * Created by sunqilong on 2017/6/28.
 */

import java.io.File;
import java.io.IOException;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.lucene.index.*;
public class Searcher {

    IndexSearcher indexSearcher;
    QueryParser queryParser;
    Query query;

//    PhraseQuery q = new PhraseQuery();
//    {q.add(new Term("contents", "钢"));}
//    {q.add(new Term("contents", "铁"));}
//    {q.setSlop(1);}
    public Searcher(String indexDirectoryPath)
            throws IOException{
        Directory indexDirectory =
                FSDirectory.open(new File(indexDirectoryPath));
        indexSearcher = new IndexSearcher(indexDirectory);
        queryParser = new QueryParser(Version.LUCENE_36,
                LuceneConstants.CONTENTS,
                new StandardAnalyzer(Version.LUCENE_36));
    }

    public TopDocs search( String searchQuery)
            throws IOException, ParseException{
        query = queryParser.parse(searchQuery);
        //query = q;
        return indexSearcher.search(query, LuceneConstants.MAX_SEARCH);
    }

    public Document getDocument(ScoreDoc scoreDoc)
            throws CorruptIndexException, IOException{
        return indexSearcher.doc(scoreDoc.doc);
    }

    public void close() throws IOException{
        indexSearcher.close();
    }
}
