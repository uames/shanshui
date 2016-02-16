package controller;

public class MainController extends BaseController {
	public MainController() {
        super();
        viewPath = "/WEB-INF/view/main/";
    }
	public void index() {
	    renderJsp("index.jsp");
	}
	
	public void show() {
	    renderJsp("show.jsp");
	}
}
