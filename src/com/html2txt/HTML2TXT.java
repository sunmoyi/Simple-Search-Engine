package com.html2txt;

import java.io.*;

import static java.lang.Math.min;
import static java.lang.StrictMath.max;

/**
 * Created by sunqilong on 2017/7/2.
 */
public class HTML2TXT {
    public static void main(String args[]){
        HTML2TXT test = new HTML2TXT();
        test.change("/Users/sunqilong/Desktop/java2/mirror/product.pconline.com.cn/mobile");
        //test.change(args[0]);
        //test.gettitle("/Users/sunqilong/Desktop/java2/mirror/product.pconline.com.cn/mobile/bubugao/635808_detail.html");
    }
    public void change(String address){
        String path = address;
        File dir = new File(path);
        String file[] = dir.list();
        int id = 0;
        for(int i = 1; i < file.length; i++){
            file[i] = address + "/" + file[i];
            //System.out.println(file[i] + " ******************");
            String filepath[] = (new File(file[i])).list();
            for(int j = 0; j < filepath.length; j++)
            {
                if(!filepath[j].endsWith("_detail.html"))
                continue;
                String finalpath;
                finalpath = file[i] + "/" + filepath[j];

                String txtpath = "/Users/sunqilong/Desktop/txt";
                txtpath = txtpath + "/" + String.valueOf(++id) + ".txt";
                //txtpath = txtpath.replaceAll(".html", ".txt");
                //System.out.println("    " + txtpath);

                BufferedWriter out = null;
                try{
                    out = new BufferedWriter(new FileWriter(txtpath));
                    System.out.println("    " + finalpath + " ******************");
                    String weburl = finalpath;
                    weburl = weburl.substring(weburl.indexOf("mirror/") + 7);
                    out.write(weburl + "\n");
                    out.write(gettitle(finalpath));
                    out.write(getsize(finalpath));
                    out.write(getcpu(finalpath));
                    out.write(getpower(finalpath));
                    out.write(getram(finalpath));
                    out.write(getcamera(finalpath));
                    out.write(getpicurl(finalpath));
                    //out.write(String.valueOf(id++));
                    DB.DB_add(id, gettitle(finalpath), getsize(finalpath), getcpu(finalpath), getram(finalpath), getcamera(finalpath), weburl, getpicurl(finalpath));
                    out.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.print(id);
    }
    public String getsize(String address){
        BufferedReader in = null;
        String ans = "null";
        try{
            FileInputStream fis = new FileInputStream(new File(address));
            InputStreamReader isr = new InputStreamReader(fis, "GB2312");
            BufferedReader br = new BufferedReader(isr);
            String lineText = null;
            while((lineText = br.readLine()) != null){
                //System.out.println(lineText + "\n");
                if(lineText.indexOf("英寸") != -1)
                {
                    int index = lineText.indexOf("英寸");
                    ans = lineText.substring(0, index + 2);
                    index = ans.lastIndexOf(">");
                    if(index != -1)
                        ans = ans.substring(index + 1);
                    //System.out.println(ans);
                    break;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return "屏幕大小: " + ans + "\n";
    }
    public String gettitle(String address){
        BufferedReader in = null;
        String ans = "null";
        try{
            FileInputStream fis = new FileInputStream(new File(address));
            InputStreamReader isr = new InputStreamReader(fis, "GB2312");
            BufferedReader br = new BufferedReader(isr);
            String lineText = null;
            while((lineText = br.readLine()) != null){
                //System.out.println(lineText + "\n");
                if(lineText.indexOf("<title>") != -1)
                {
                    ans = lineText.substring(lineText.indexOf(">") + 1, lineText.lastIndexOf("<"));
                    //System.out.println(ans);
                    break;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return "手机型号: " + ans + "\n";
    }
    public String getpower(String address){
        BufferedReader in = null;
        String ans = "null";
        try{
            FileInputStream fis = new FileInputStream(new File(address));
            InputStreamReader isr = new InputStreamReader(fis, "GB2312");
            BufferedReader br = new BufferedReader(isr);
            String lineText = null;
            boolean flag1 = false, flag2 = false;
            while((lineText = br.readLine()) != null){
                //System.out.println(lineText + "\n");

                if(lineText.indexOf("mA") != -1)
                {
                    ans = lineText;
                    //System.out.println(ans);
                    break;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return "电池容量: " + ans + "\n";
    }

    public String getcpu(String address){
        BufferedReader in = null;
        String ans = "null";
        try{
            FileInputStream fis = new FileInputStream(new File(address));
            InputStreamReader isr = new InputStreamReader(fis, "GB2312");
            BufferedReader br = new BufferedReader(isr);
            String lineText = null;
            boolean flag1 = false, flag2 = false;
            while((lineText = br.readLine()) != null){
                //System.out.println(lineText + "\n");

                if(lineText.indexOf("GHz") != -1)
                {
                    ans = lineText;
                    //System.out.println(ans);
                    break;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return "CPU型号: " + ans + "\n";
    }

    public String getpicurl(String address){
        String ans = "/Users/sunqilong/Desktop/java2/mirror/img.pconline.com.cn/images/product/";
        ans += address.substring(address.length() - 18, address.length() - 14);
        ans += "/";
        ans += address.substring(address.length() - 18, address.length() - 12);
        ans += "/";

        File dir = new File(ans);
        if(dir.exists())
        {
            String file[] = dir.list();
            if(file.length >= 1)
                ans += file[0];
            System.out.println(ans);
            return ans + "\n";
        }
        return "null\n";
    }

    public String getram(String address){
        BufferedReader in = null;
        String ans = "null";
        try{
            FileInputStream fis = new FileInputStream(new File(address));
            InputStreamReader isr = new InputStreamReader(fis, "GB2312");
            BufferedReader br = new BufferedReader(isr);
            String lineText = null;
            boolean flag1 = false, flag2 = false;
            while((lineText = br.readLine()) != null){
                if(lineText.indexOf("运行内存")!= -1)
                {
                    lineText = br.readLine();
                    lineText = br.readLine();
                    ans = lineText;
                    if(lineText.indexOf("<") != -1)
                    {
                        int index = ans.indexOf(">");
                        ans = ans.substring(index + 1);
                        index = ans.indexOf("<");
                        ans = ans.substring(0, index);
                        //System.out.println(ans);
                    }
                    break;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return "RAM大小: " + ans + "\n";
    }

    public String getcamera(String address){
        BufferedReader in = null;
        String ans = "null";
        try{
            FileInputStream fis = new FileInputStream(new File(address));
            InputStreamReader isr = new InputStreamReader(fis, "GB2312");
            BufferedReader br = new BufferedReader(isr);
            String lineText = null;
            boolean flag1 = false, flag2 = false;
            while((lineText = br.readLine()) != null){
                if(lineText.indexOf("万像素")!= -1)
                {
                    ans = lineText;
                    int index = ans.indexOf("万像素");
                    ans = ans.substring(max(index - 4, 0), min(index + 3, ans.length()));
                    System.out.println(ans);
                    break;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return "摄像头参数: " + ans + "\n";
    }
}
