package com.yiibai.lucene;

/**
 * Created by sunqilong on 2017/6/28.
 */

import java.io.File;
import java.io.FileFilter;

public class TextFileFilter implements FileFilter{
    public boolean accept(File pathname) {
        return pathname.getName().toLowerCase().endsWith(".txt");
    }
}
