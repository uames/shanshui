package controller;

public class PlanController extends BaseController {
	public PlanController() {
        super();
        viewPath = "/WEB-INF/view/plan/";
    }
	public void index() {
	    renderJsp("index.jsp");
	}
	
	public void show() {
	    renderJsp("show.jsp");
	}
}
