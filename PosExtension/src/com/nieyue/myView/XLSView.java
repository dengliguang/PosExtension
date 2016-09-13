package com.nieyue.myView;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nieyue.bean.User;

@Component("xlsView")
public class XLSView extends AbstractXlsView{
	private String fileName;
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/vnd.ms-excel");  
        String fName = fileName+".xls";  
//      response.setContentType("APPLICATION/OCTET-STREAM");    
        response.setHeader("Content-Disposition", "inline; filename="+new String(fName.getBytes(),"iso8859-1")); 
        
			List<User> sheetList=(List<User>)model.get("userList");
			 Font f = workbook.createFont();      
			CellStyle dateStyle = workbook.createCellStyle();
			f.setFontHeightInPoints((short)11);;// 字号   
			f.setBoldweight(Font.BOLDWEIGHT_NORMAL);// 加粗   
			
			dateStyle.setFont(f);      
			dateStyle.setAlignment(CellStyle.ALIGN_CENTER);// 左右居中   
			dateStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 上下居中   
			dateStyle.setRotation((short) 0);;// 单元格内容的旋转的角度  
			
            Sheet sheet =  workbook.createSheet("用户列表");
            Row headrow = sheet.createRow(0);
            Cell headrowcell0 = headrow.createCell(0);
            headrowcell0.setCellValue("用户名称");
            Cell headrowcell1 = headrow.createCell(1);
            headrowcell1.setCellValue("手机号");
            Cell headrowcell2 = headrow.createCell(2);
            headrowcell2.setCellValue("收货地址");
            Cell headrowcell3 = headrow.createCell(3);
            headrowcell3.setCellValue("备注");
            Cell headrowcell4 = headrow.createCell(4);
            headrowcell4.setCellValue("填写时间");
            Cell headrowcell5 = headrow.createCell(5);
            headrowcell5.setCellValue("渠道id");
            for (int i = 0; i <sheetList.size(); i++) {
                User user = sheetList.get(i);
                Row row = sheet.createRow(i+1);
                
                row.createCell(0).setCellValue(user.getName().toString());
                row.createCell(1).setCellValue(user.getPhone());
                row.createCell(2).setCellValue(user.getAddress());
                row.createCell(3).setCellValue(user.getRemark());
                row.createCell(4).setCellValue(user.getFillTime().toLocaleString());
                row.createCell(5).setCellValue(user.getChannelId());
            }
	}
			


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
