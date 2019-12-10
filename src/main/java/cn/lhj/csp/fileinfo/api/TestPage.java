package cn.lhj.csp.fileinfo.api;

import java.io.File;
import java.io.FileInputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xslf.XSLFSlideShow;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class TestPage {
	
	public static void main(String[] args) throws Exception {
		// TODO code application logic here
		parse2007();
		//parse97();
		//pdf();
		//ppt();
		//pptx();
	}

	public static void parse2007() throws Exception {
		int pages = 0;
		int wordCount = 0;
		try {
			XWPFDocument docx = new XWPFDocument(POIXMLDocument.openPackage("E:\\11.docx"));
			pages = docx.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();// 总页数
			wordCount = docx.getProperties().getExtendedProperties().getUnderlyingProperties().getCharacters();// 忽略空格的总字符数
																												// 另外还有getCharactersWithSpaces()方法获取带空格的总字数。
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("docxpages=" + pages + " wordCount=" + wordCount);
	}

	public static void parse97() throws Exception {
		int pages = 0;
		int wordCount = 0;
		try {
			WordExtractor doc = new WordExtractor(new FileInputStream("E:\\泉州信息工程.doc"));
			pages = doc.getSummaryInformation().getPageCount();// 总页数
			wordCount = doc.getSummaryInformation().getWordCount();// 总字符数
		} catch (Exception e) {

		}
		System.out.println("docpages=" + pages + " wordCount=" + wordCount);
	}

	public static void pdf() throws Exception {
		// 创建PdfDocument实例
		int pages = 0;
		try {
			File file = new File("E:\\Web前端职业前景－李文华专家.pdf");
			PDDocument pdf = PDDocument.load(file);
			pages = pdf.getNumberOfPages();
			System.out.println("pdf全部页数" + pdf.getNumberOfPages());
		} catch (Exception e) {

		}
	}

	public static void ppt() throws Exception {

		int pages = 0;
		String filePath = "E:\\56.ppt";
		FileInputStream fis = new FileInputStream(filePath);
		SlideShow pptfile = new SlideShow(new HSLFSlideShow(fis));
		pages = pptfile.getSlides().length;
		System.out.println("ppt" + pages);

	}

	public static void pptx() throws Exception {
		int pages = 0;
		String text = "";
		String filePath = "E:\\23234.pptx";
		XSLFSlideShow fis = new XSLFSlideShow(filePath);
		XMLSlideShow pptxfile = new XMLSlideShow(fis);
		pages = pptxfile.getSlides().length;
		System.out.println("pptx" + pages);
	}
}