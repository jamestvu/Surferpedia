package controllers;

import models.SurferDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.html.Eddie;
import views.html.Index;
import views.html.ManageSurfer;
import views.html.ShowSurfer;


/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render(SurferDB.getSurfers()));
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The manage surfer page.
   */
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render(formData, SurferTypes.getTypes()));
    
  }
  
  /**
   * Returns the page containing the surfer info.
   * @param slug The slug used to retrieve the surfer.
   * @return The manage surfer page.
   */
  public static Result getSurfer(String slug) {
    return ok(Index.render(SurferDB.getSurfers()));
    
  }
  
  /**
   * Returns the index page.
   * @param slug The slug used to retrieve the surfer.
   * @return The indexed surfer page.
   */
  public static Result deleteSurfer(String slug) {
    return ok(Index.render(SurferDB.getSurfers()));
    
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @param slug The slug used to retrieve the surfer.
   * @return The manage surfer page.
   */
  public static Result manageSurfer(String slug) {
    return ok(Index.render(SurferDB.getSurfers()));
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @param slug The slug used to retrieve the surfer.
   * @return The manage surfer page.
   */
  public static Result eddie() {
    return ok(Eddie.render("eddie"));
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @param slug The slug used to retrieve the surfer.
   * @return The manage surfer page.
   */
  public static Result showSurfer() {
    return ok(ShowSurfer.render("eddie"));
  }
  
  /**
   * Returns the index page.
   * @return The manage surfer page.
   */
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    
    if (formData.hasErrors()) {
      return badRequest(ManageSurfer.render(formData, SurferTypes.getTypes()));
    }
    else {
      SurferFormData data = formData.get();
      SurferDB.addSurfer(data);
      return ok(ManageSurfer.render(formData, SurferTypes.getTypes()));
    }
    
  }
}
