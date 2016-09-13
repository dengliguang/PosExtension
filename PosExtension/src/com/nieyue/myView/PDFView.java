package com.nieyue.myView;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nieyue.bean.User;

@Component("pdfView")
public class PDFView extends AbstractPdfView{
	private String fileName;
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String fName = fileName+".pdf";  
        // 设置response方式,使执行此controller时候自动出现下载页面,而非直接使用excel打开    
			//response.setContentType("application/pdf");    
			response.setContentType("application/pdf");    
			response.setHeader("Content-Disposition", "inline; filename="+new String(fName.getBytes(),"iso8859-1")); 
		//设置中文
			BaseFont bfChinese = BaseFont.createFont("/config/SIMYOU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

			com.lowagie.text.Font FontChinese = new com.lowagie.text.Font(bfChinese, 12, com.lowagie.text.Font.NORMAL);
		
			List<User> list = (List<User>) model.get("userList");
			writer.getInstance(document, new FileOutputStream(fName+".PDF"));
			document.open();
			//创建一个有list.size()列的表格  
			PdfPTable table = new PdfPTable(list.size());
	        //定义一个表格单元  
	        PdfPCell cell = new PdfPCell(new Paragraph("客户信息"));
	        //定义一个表格单元的跨度  
	        cell.setColspan(3); 
	        table.addCell(cell);
	        PdfPCell name = new PdfPCell(new Paragraph("用户名称",FontChinese));
	        PdfPCell phone = new PdfPCell(new Paragraph("手机号",FontChinese));
	        PdfPCell address = new PdfPCell(new Paragraph("收货地址",FontChinese));
	        PdfPCell remark = new PdfPCell(new Paragraph("备注",FontChinese));
	        PdfPCell fillTime = new PdfPCell(new Paragraph("填写时间",FontChinese));  
	        PdfPCell channelId = new PdfPCell(new Paragraph("渠道id",FontChinese));
	        table.addCell(name); 
	        table.addCell(phone); 
	        table.addCell(address); 
	        table.addCell(remark); 
	        table.addCell(fillTime); 
	        table.addCell(channelId); 
	        for (int i = 0; i < list.size(); i++) {
				User user = list.get(i);
				PdfPCell na = new PdfPCell(new Paragraph(user.getName().toString(),FontChinese));
				PdfPCell ph = new PdfPCell(new Paragraph(user.getPhone().toString(),FontChinese));
				PdfPCell ad = new PdfPCell(new Paragraph(user.getAddress().toString(),FontChinese));
				PdfPCell re = new PdfPCell(new Paragraph(user.getRemark().toString(),FontChinese));
			    PdfPCell fi = new PdfPCell(new Paragraph(user.getFillTime().toLocaleString(),FontChinese));  
				PdfPCell ch = new PdfPCell(new Paragraph(user.getChannelId().toString(),FontChinese));

				table.addCell(na);
				table.addCell(ph);
				table.addCell(ad);
				table.addCell(re);
				table.addCell(fi);
				table.addCell(ch);
			}
	        document.add(table);
	        document.close();
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
