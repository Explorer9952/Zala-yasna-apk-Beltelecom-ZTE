package com.tencent.stat.i;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class f {
    public static File a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        if (!file.getParentFile().exists()) {
            a(file.getParentFile().getAbsolutePath());
        }
        file.mkdir();
        return file;
    }

    public static List<String> a(File file) {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine.trim());
        }
    }
}
