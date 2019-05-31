/*******************************************************************************
 * Copyright 2017 Bstek
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.bstek.ureport.export;

import java.util.Map;

import javax.sql.DataSource;

import com.bstek.ureport.build.paging.Page;
import com.bstek.ureport.cache.CacheUtils;
import com.bstek.ureport.chart.ChartData;
import com.bstek.ureport.definition.ReportDefinition;
import com.bstek.ureport.export.excel.high.ExcelProducer;
import com.bstek.ureport.export.excel.low.Excel97Producer;
import com.bstek.ureport.export.html.HtmlProducer;
import com.bstek.ureport.export.html.HtmlReport;
import com.bstek.ureport.export.pdf.PdfProducer;
import com.bstek.ureport.export.word.high.WordProducer;
import com.bstek.ureport.model.Report;

/**
 * @author Jacky.gao
 * @since 2016年12月4日
 */
public class ExportManagerImpl implements ExportManager {
	private ReportRender reportRender;
	private HtmlProducer htmlProducer=new HtmlProducer();
	private WordProducer wordProducer=new WordProducer();
	private ExcelProducer excelProducer=new ExcelProducer();
	private Excel97Producer excel97Producer=new Excel97Producer();
	private PdfProducer pdfProducer=new PdfProducer();
	/**
	 * 
	 * <p>Title: exportHtml</p>   
	 * <p>修改:wanglong </p>   
	 */
	@Override
	public String exportHtml(String file,String contextPath,Map<String, Object> parameters,Map<String,DataSource> unionDsMap,String reportId) {
		ReportDefinition reportDefinition=reportRender.getReportDefinition(file);
		Report report=reportRender.render(reportDefinition, parameters,unionDsMap,reportId);
		
		HtmlReport htmlReport=new HtmlReport();
		String content=htmlProducer.produce(report);
	
		return content;
	}
//	@Override
//	public void exportPdf(ExportConfigure config,Map<String,DataSource> unionDsMap) {
//		String file=config.getFile();
//		Map<String, Object> parameters=config.getParameters();
//		ReportDefinition reportDefinition=reportRender.getReportDefinition(file);
//		Report ureport=reportRender.render(reportDefinition, parameters,unionDsMap);
//		pdfProducer.produce(ureport, config.getOutputStream());
//	}
//	@Override
//	public void exportWord(ExportConfigure config,Map<String,DataSource> unionDsMap) {
//		String file=config.getFile();
//		Map<String, Object> parameters=config.getParameters();
//		ReportDefinition reportDefinition=reportRender.getReportDefinition(file);
//		Report ureport=reportRender.render(reportDefinition, parameters,unionDsMap);
//		wordProducer.produce(ureport, config.getOutputStream());
//	}
	@Override
	public void exportExcel(ExportConfigure config,Map<String,DataSource> unionDsMap,String reportId) {
		String file=config.getFile();
		Map<String, Object> parameters=config.getParameters();
		ReportDefinition reportDefinition=reportRender.getReportDefinition(file);
		Report report=reportRender.render(reportDefinition, parameters,unionDsMap,reportId);
		excelProducer.produce(report,null,config.getOutputStream());
	}
	
//	@Override
//	public void exportExcel97(ExportConfigure config,Map<String,DataSource> unionDsMap) {
//		String file=config.getFile();
//		Map<String, Object> parameters=config.getParameters();
//		ReportDefinition reportDefinition=reportRender.getReportDefinition(file);
//		Report ureport=reportRender.render(reportDefinition, parameters,unionDsMap);
//		excel97Producer.produce(ureport, config.getOutputStream());
//	}
//	
//	@Override
//	public void exportExcelWithPaging(ExportConfigure config,Map<String,DataSource> unionDsMap) {
//		String file=config.getFile();
//		Map<String, Object> parameters=config.getParameters();
//		ReportDefinition reportDefinition=reportRender.getReportDefinition(file);
//		Report ureport=reportRender.render(reportDefinition, parameters,unionDsMap);
//		excelProducer.produceWithPaging(ureport, config.getOutputStream());
//	}
//	@Override
//	public void exportExcel97WithPaging(ExportConfigure config,Map<String,DataSource> unionDsMap) {
//		String file=config.getFile();
//		Map<String, Object> parameters=config.getParameters();
//		ReportDefinition reportDefinition=reportRender.getReportDefinition(file);
//		Report ureport=reportRender.render(reportDefinition, parameters,unionDsMap);
//		excel97Producer.produceWithPaging(ureport, config.getOutputStream());
//	}
	
	
	public void setReportRender(ReportRender reportRender) {
		this.reportRender = reportRender;
	}
//	@Override
//	public void exportExcelWithPagingSheet(ExportConfigure config, Map<String, DataSource> unionDsMap) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void exportExcel97WithPagingSheet(ExportConfigure config, Map<String, DataSource> unionDsMap) {
//		// TODO Auto-generated method stub
//		
//	}
}
