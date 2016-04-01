package edu.ifpb.reports;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;


import edu.ifpb.model.Aluno;

public class Relatorio {
	
	private final static String CONEXAO = "jdbc:postgresql://localhost:5432/matriculaCRPNM";
	private final static String USUARIO = "postgres";
	private final static String PASS = "postgres";
	

	
	
	public Relatorio() {
		
	}
	
	public static Connection getConnection() throws SQLException{
	
		return DriverManager.getConnection(CONEXAO, USUARIO, PASS);
	}
	
	public static StreamedContent gerarConfirmacaoMatricula(Aluno aluno){
		InputStream report = null;
		ByteArrayOutputStream out= new ByteArrayOutputStream();
		try {
			
		
		Connection conexao = getConnection();
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("ID", aluno.getId());
		String relatorio= FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/reports/comprovante-matricula.jasper");
		JasperPrint print = JasperFillManager.fillReport(relatorio, parametros, conexao);
		JRExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
		exporter.exportReport();
		report= new ByteArrayInputStream(out.toByteArray());
		
		conexao.close();
		
		
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new DefaultStreamedContent(report,"application/pdf","confirmacao-cadastro-"+aluno.getNome()+".pdf" );
	}

}
