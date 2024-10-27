package com.proyecto.service.impl;

import java.io.ByteArrayInputStream;
import java.util.Map;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.thymeleaf.context.Context;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.itextpdf.io.source.ByteArrayOutputStream;
@Service
public class PdfService {
	@Autowired
	private SpringTemplateEngine templateEngine;
	
	public ByteArrayInputStream generarPdf(String templateNombre, Map<String, Object>datos)throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		Context context = new Context();
		context.setVariables(datos);
		
		String html = templateEngine.process(templateNombre, context);
		
		HtmlConverter.convertToPdf(new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8)),outputStream);
		
		return new ByteArrayInputStream(outputStream.toByteArray());
		}
}
