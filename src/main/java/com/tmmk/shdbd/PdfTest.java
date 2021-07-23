package com.tmmk.shdbd;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.layout.font.FontProvider;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * TODO <功能详细描述>
 *
 * @author Lost
 * @date 2020-09-08 9:59
 * @see
 * @since 4.0.0
 */
public class PdfTest {

    public static void main(String[] args) throws IOException {

        File htmlSource = new File("D:\\workspace\\Git\\tmmk\\shdbd\\src\\main\\resources\\license.html");
        File pdfDest = new File("D:\\workspace\\Git\\tmmk\\shdbd\\src\\main\\resources\\cert.pdf");
        // pdfHTML specific code
        FileReader fr = new FileReader(htmlSource);
        BufferedReader bis = new BufferedReader(fr);
        StringBuilder html = new StringBuilder();
        String line;
        while ((line = bis.readLine()) != null) {
            html.append(line);
        }
        String strHtml = html.toString().replace("${{name}}", "测试");
        ConverterProperties converterProperties = new ConverterProperties();
        FontProvider font = new FontProvider();
        font.addStandardPdfFonts();
        font.addFont("D:\\workspace\\Git\\tmmk\\shdbd\\src\\main\\resources\\puhuiti\\Alibaba-PuHuiTi-Heavy.ttf");
        font.addFont("D:\\workspace\\Git\\tmmk\\shdbd\\src\\main\\resources\\puhuiti\\Alibaba-PuHuiTi-Light.ttf");
        font.addFont("D:\\workspace\\Git\\tmmk\\shdbd\\src\\main\\resources\\puhuiti\\Alibaba-PuHuiTi-Medium.ttf");
        font.addFont("D:\\workspace\\Git\\tmmk\\shdbd\\src\\main\\resources\\puhuiti\\Alibaba-PuHuiTi-Regular.ttf");
        font.addFont("D:\\workspace\\Git\\tmmk\\shdbd\\src\\main\\resources\\puhuiti\\阿里巴巴普惠体v1.10版本更新说明.txt");
        //中文字体
        converterProperties.setFontProvider(font);
        converterProperties.setCharset("UTF-8");
        HtmlConverter.convertToPdf(strHtml, new FileOutputStream(pdfDest), converterProperties);

    }


}
