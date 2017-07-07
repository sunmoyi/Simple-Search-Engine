package com.yiibai.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import java.io.IOException;

import static java.lang.Math.min;
import static java.lang.StrictMath.max;

/**
 * Created by sunqilong on 2017/7/4.
 */
public class mainpath {
    String indexDir = "/Users/sunqilong/Desktop/txtindex";
    String dataDir = "/Users/sunqilong/Desktop/txt";
    Indexer indexer;
    Searcher searcher;

    public void createIndex() throws IOException{
        indexer = new Indexer(indexDir);
        int numIndexed;
        long startTime = System.currentTimeMillis();
        numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
        long endTime = System.currentTimeMillis();
        indexer.close();
        System.out.println(numIndexed+" File indexed, time taken: "
                +(endTime-startTime)+" ms");
    }


    public int[] search(String searchQuery) throws IOException, ParseException {
        searcher = new Searcher(indexDir);
        long startTime = System.currentTimeMillis();
        TopDocs hits = searcher.search(searchQuery);
        long endTime = System.currentTimeMillis();

        int ans[] = new int[min(10, hits.totalHits)];
        int index = 0;
        System.out.println(hits.totalHits +
                " documents found. Time :" + (endTime - startTime));
        for(ScoreDoc scoreDoc : hits.scoreDocs) {
            Document doc = searcher.getDocument(scoreDoc);
            String temp = doc.get(LuceneConstants.FILE_NAME);
            temp = temp.substring(0, temp.indexOf("."));
            ans[index++] = Integer.parseInt(temp);
            System.out.println("File: "
                    + doc.get(LuceneConstants.FILE_PATH));
        }
        searcher.close();
        return ans;
    }
}
