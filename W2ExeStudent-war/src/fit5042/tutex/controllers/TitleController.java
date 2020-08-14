package fit5042.tutex.controllers;

import javax.inject.Named;
import fit5042.tutex.entities.Property;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

@Named("titleController")
@RequestScoped
public class TitleController {
	private String pageTitle;

	public TitleController() { // Set the page title
		pageTitle = "Real Estate Agency";
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	@PostConstruct
	public void init() {
		pageTitle = "Real Estate Agency";
	}
}
