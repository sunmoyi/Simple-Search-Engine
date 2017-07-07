package com.yiibai.lucene;

import org.apache.lucene.queryParser.ParseException;

import java.io.IOException;

/**
 * Created by sunqilong on 2017/7/4.
 */
public class finalAPI {
    mainpath tester;
    public static void main(String args[]){
        finalAPI ai = new finalAPI();
        int ans[] = ai.API("3GB");
        for(int a: ans)
            System.out.println(a);
    }
    public finalAPI(){
        try {
            tester = new mainpath();
            tester.createIndex();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public int[] API(String str){
        try {
            return tester.search(str);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
