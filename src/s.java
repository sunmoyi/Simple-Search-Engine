import com.html2txt.DB;
import com.yiibai.lucene.finalAPI;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class s
 */
@WebServlet("/s")
public class s extends HttpServlet {
    static finalAPI lu;
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public s() {
        super();
        lu = new finalAPI();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "使用 POST 方法读取表单数据";
        // 处理中文
        String name =new String(request.getParameter("Name").getBytes("UTF-8"),"UTF-8");
        int ans[] = lu.API(name);

        String docType = "<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t<meta charset=\"utf-8\">\n" +
                "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "\t<title>垂直搜索引擎系统 孙启龙201507189</title>\n" +
                "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "\t<meta name=\"description\" content=\"Free HTML5 Website Template by freehtml5.co\" />\n" +
                "\t<meta name=\"keywords\" content=\"free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive\" />\n" +
                "\t<meta name=\"author\" content=\"freehtml5.co\" />\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "  \t<!-- Facebook and Twitter integration -->\n" +
                "\t<meta property=\"og:title\" content=\"\"/>\n" +
                "\t<meta property=\"og:image\" content=\"\"/>\n" +
                "\t<meta property=\"og:url\" content=\"\"/>\n" +
                "\t<meta property=\"og:site_name\" content=\"\"/>\n" +
                "\t<meta property=\"og:description\" content=\"\"/>\n" +
                "\t<meta name=\"twitter:title\" content=\"\" />\n" +
                "\t<meta name=\"twitter:image\" content=\"\" />\n" +
                "\t<meta name=\"twitter:url\" content=\"\" />\n" +
                "\t<meta name=\"twitter:card\" content=\"\" />\n" +
                "\n" +
                "\t<link href=\"https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800\" rel=\"stylesheet\">\n" +
                "\t\n" +
                "\t<!-- Animate.css -->\n" +
                "\t<link rel=\"stylesheet\" href=\"css/animate.css\">\n" +
                "\t<!-- Icomoon Icon Fonts-->\n" +
                "\t<link rel=\"stylesheet\" href=\"css/icomoon.css\">\n" +
                "\t<!-- Bootstrap  -->\n" +
                "\t<link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n" +
                "\t\n" +
                "\t<!-- Theme style  -->\n" +
                "\t<link rel=\"stylesheet\" href=\"css/style.css\">\n" +
                "\n" +
                "\t<!-- Modernizr JS -->\n" +
                "\t<script src=\"js/modernizr-2.6.2.min.js\"></script>\n" +
                "\t<!-- FOR IE9 below -->\n" +
                "\t<!--[if lt IE 9]>\n" +
                "\t<script src=\"js/respond.min.js\"></script>\n" +
                "\t<![endif]-->\n" +
                "\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "\t\t\n" +
                "\t<div class=\"fh5co-loader\"></div>\n" +
                "\t\n" +
                "\t<div id=\"page\">\n" +
                "\t\t<div id=\"fh5co-aside\" style=\"background-image: url(images/image_1.jpg)\">\n" +
                "\t\t\t<div class=\"overlay\"></div>\n" +
                "\t\t\t<nav role=\"navigation\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t<li><a href=\" " + " http://localhost:8080" + " \"><i class=\"icon-home\"></i></a></li>\n" +
                "\t\t\t\t</ul>\n" +
                "\t\t\t</nav>\n" +
                "\t\t</div>\n" +
                "\t\t<div id=\"fh5co-main-content\">\n" +
                "\t\t\t<div class=\"fh5co-post\"> ";
        out.println(docType);
        for(int a: ans)
        {
            String url, picurl, cpu, ram, camera, size, type;

            url = "http://" + DB.DB_geturl(a);
            type = DB.DB_gettype(a);
            type = type.substring(0, type.indexOf("数") + 1);
            size = DB.DB_getsize(a);
            cpu = DB.DB_getcpu(a);
            ram = DB.DB_getram(a);
            camera = DB.DB_getcamera(a);
            picurl = DB.DB_getpicurl(a);
            if(picurl.indexOf("null") != -1)
                picurl = "Users/sunqilong/Desktop/java/JSP/web/product/1111.png";
            int index = picurl.indexOf("product");
            System.out.println(index);
            if(index != -1)
                picurl = "./" + picurl.substring(index);
            out.print("<div class=\"fh5co-entry padding\"><img src=\" " + picurl + "\" ><div><h2><a href= \" ");
            out.print(url + "\" >" + type + "</a></h2>");
            out.print("<p>                            <table><tr>                                    <td>");
            out.print(size);
            out.print("</td><td>");
            out.print(cpu);
            out.print("</td></tr>                                <tr><td>");
            out.print(ram);
            out.print("</td><td>");
            out.print(camera);
            out.print("</td></tr></table></p></div></div>");
            System.out.println(a);
        }
        out.print("</body></html>");
        out.print("</div></div>");
        out.print("<div class=\"gototop js-top\"> <a href=\"#\" class=\"js-gotop\"><i class=\"icon-arrow-up\"></i></a> </div> <script src=\"js/jquery.min.js\"></script> <!-- jQuery Easing --> <script src=\"js/jquery.easing.1.3.js\"></script><!-- Bootstrap --><script src=\"js/bootstrap.min.js\"></script><!-- Waypoints --><script src=\"js/jquery.waypoints.min.js\"></script><!-- Stellar Parallax --><script src=\"js/jquery.stellar.min.js\"></script><!-- Main --><script src=\"js/main.js\"></script></body></html>");
    }

    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}