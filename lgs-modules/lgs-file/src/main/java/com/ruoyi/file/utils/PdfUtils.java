package com.ruoyi.file.utils;

import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PdfUtils * @Description TODO
 * @Author lgn
 * @Date 16:43 2022/8/22
 * @Version 1.0
 **/
public class PdfUtils {
    public static void main(String[] args) throws Exception {

        String template_path="C:\\Users\\lgn\\Desktop\\JS-PAS-2208-002.pdf";
        String out_path="C:\\Users\\lgn\\Desktop\\result.pdf";

        Map<String, String> data = new HashMap<String, String>();
        data.put("executor", "钢铁侠");
        data.put("reviewed", "小辣椒");
        data.put("applicationTypeModifi","√");
        data.put("fill_9","test");
        export(template_path,out_path,data);
        System.out.println("生成完成!");
    }

    /**
    　　* @description: TODO
    　　* @param
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/23 9:44
    　　*/
    public static void export(String template_path, String out_path, Map<String, String> data){
        try {
            // pdf模板所在路径，就是网站制作好后下载的pdf模板路径
            String fileName = template_path;
            PdfReader reader = new PdfReader(fileName);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            PdfStamper ps = new PdfStamper(reader, bos);

            // 使用中文字体
            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            ArrayList<BaseFont> fontList = new ArrayList<BaseFont>();
            fontList.add(bf);

            AcroFields fields = ps.getAcroFields();
            fields.setSubstitutionFonts(fontList);
            fillData(fields, data);

            //必须要调用这个，否则文档会出现你不想出现的东西
            ps.setFormFlattening(true);
            ps.close();

            //生成pdf路径存放的路径
            OutputStream fos = new FileOutputStream(out_path);
            fos.write(bos.toByteArray());
            fos.flush();
            fos.close();
            bos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 填充模板中的数据
     */
    public static void fillData(AcroFields fields, Map<String, String> data) {
        try {
            for (String key : data.keySet()) {
                String value = data.get(key);
                // 为字段赋值,注意字段名称是区分大小写的
                fields.setField(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 填充数据源
     * 其中data存放的key值与pdf模板中的文本域值相对应
     */
    public static Map<String, String> data() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("executor", "钢铁侠");
        data.put("reviewed", "小辣椒");
        return data;
    }
}
