package helloworld;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import helloworld.client.WebServiceClient;

@Named(value = "webServiceBean")
@SessionScoped
public class WebServiceBean implements Serializable {
	private String name;
	private WebServiceClient webServiceClient;

	public WebServiceBean() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WebServiceClient getWebServiceClient() {
		return webServiceClient;
	}

	public void setWebServiceClient() {
		webServiceClient = new WebServiceClient();
		webServiceClient.setPostName2(getName());
	}
}
