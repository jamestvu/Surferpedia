
import models.SurferDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.SurferFormData;



/**
 * Overrides the startup.
 * @author Owner
 *
 */
public class Global extends GlobalSettings {

  /**
   * Initializes the surfers upon startup.
   * @param app The application.
   */
  public void onStart(Application app) {
    SurferDB.addSurfer(new SurferFormData(
        "Kelly Slater",
        "Cocoa Beach, Florida",
        "ASP World Tour Champion (11 times), Boost Mobile Pro (1st Place, 2007)",
        "http://www.carmelmagazine.com/images/archive/fa08/kelly-slater-1.jpg",
        "http://www.carmelmagazine.com/images/archive/fa08/kelly-slater-1.jpg",
        "blah blah bio",
        "kellyslater",
        "Male"));
  }

}