package de.mlo.controller;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = {"/report"})
public class ReportController {
	
	@Autowired
	    private ResourceLoader resourceLoader;


	    Resource[] loadResources(String pattern) throws IOException {
	        return ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(pattern);
	    }

	
	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(ReportController.class);

	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = {"getpdf"}, method = RequestMethod.GET)
	public String getPdf(@RequestParam(value = "filePath", required = true) String filePath,
			Model model, RedirectAttributes redirectAttrs) throws Exception {
		Resource resource = new ClassPathResource("../../resources/pdf/" + filePath + ".pdf");
		logger.info(resource.getURL().toString());
		File file = resource.getFile();
		PDDocument doc = PDDocument.load(file);
		model.addAttribute("pdfDetails", listFields(doc));
		return "report-detail";
	}
	
	
	
	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String showPdfs(Model model) throws IOException {
		Resource resource = new ClassPathResource("../../resources/pdf/");
		File file = resource.getFile();
		File[] files = file.listFiles(new FilenameFilter() {
			@Override
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(".pdf");
		    }
		});

		model.addAttribute("fileList", getFileListing(files));
		return "report-list";
	}
	
    private ArrayList<File> getFileListing(File[] files) {
        ArrayList<File> filPaths = new ArrayList<File>();
        for (File file : files) {
            filPaths.add(file);
        }
        return filPaths;
    }

    public List<PDField> listFields(PDDocument doc) throws Exception {
        PDDocumentCatalog catalog = doc.getDocumentCatalog();
        PDAcroForm form = catalog.getAcroForm();
        List<PDField> fields = form.getFields();
        return fields;
    }
    
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String importParse(@RequestParam("myFile") MultipartFile myFile) {
         // ... do whatever you want with 'myFile'
         // Redirect to a successful upload page
         return "redirect:uploadSuccess.html";
    } 
	
}
