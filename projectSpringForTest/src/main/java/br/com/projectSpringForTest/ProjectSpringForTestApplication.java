package br.com.projectSpringForTest;
import br.com.projectSpringForTest.GNRE.retornoConsultaConfig.TConfigUf;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ProjectSpringForTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSpringForTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("------ INICIO PROCESSO ------");

		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			// Cria o elemento raiz <gnr:gnreDadosMsg> sem namespace
			Element rootElement = doc.createElement("gnr:gnreDadosMsg");
			doc.appendChild(rootElement);

			// Cria o elemento <TConsultaConfigUf> com o namespace
			Element tConsultaConfigUf = doc.createElementNS("http://www.gnre.pe.gov.br", "TConsultaConfigUf");
			rootElement.appendChild(tConsultaConfigUf);

			// Cria o elemento <ambiente> sem namespace
			Element ambiente = doc.createElement("ambiente");
			ambiente.setTextContent("1");
			tConsultaConfigUf.appendChild(ambiente);

			// Cria o elemento <uf> sem namespace
			Element uf = doc.createElement("uf");
			uf.setTextContent("RJ");
			tConsultaConfigUf.appendChild(uf);

			// Cria o elemento <receita> sem namespace
			Element receita = doc.createElement("receita");
			receita.setAttribute("courier", "N");
			receita.setTextContent("100030");
			tConsultaConfigUf.appendChild(receita);

			// Cria o elemento <tiposGnre> sem namespace
			Element tiposGnre = doc.createElement("tiposGnre");
			tiposGnre.setTextContent("N");
			tConsultaConfigUf.appendChild(tiposGnre);

			// Escreve o conteúdo do XML em uma string
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			transformer.transform(source, result);

			// Imprime o XML gerado
			String xmlString = writer.toString();
			System.out.println(xmlString);

		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}


		System.out.println("------ FIM PROCESSO ------");
	}

}
