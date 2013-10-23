package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SurferFormData;

/**
 * Provides a simple in memory repository for Surfer data.
 * @author Owner
 *
 */
public class SurferDB {
  
  private static Map<String, Surfer> surfers = new HashMap<String, Surfer>();

  /**
   * Updates the repo with a new surfer or edits an existing surfer.
   * @param formData the Surfer form data to add.
   * @return Surfer the newly created Surfer to return.
   */
  public static Surfer addSurfer(SurferFormData formData) {
    String slug = formData.slug;
    
    Surfer surfer = new Surfer(formData.name, formData.home, formData.awards, 
          formData.carouselURL, formData.bioURL, formData.bio, slug, formData.type);
    surfers.put(slug, surfer);
    
    return surfer;
  }
  
  /**
   * Deletes the surfer from the repository.
   * @param slug the slug.
   */
  public static void deleteSurfer(String slug) {
    surfers.remove(slug);
  }
  
  
  /**
   * Returns the list of Surfers.
   * @return List of Surfers.
   */
  public static List<Surfer> getSurfers() {
    return new ArrayList<>(surfers.values());
  }
  
  /**
   * Returns if the slug is in use or not.
   * @param slug The slug to check.
   * @return True if a surfer is already using the slug.
   */
  public static boolean slugExists(String slug) {
    return surfers.containsKey(slug);
  }
  
  /**
   * Returns a Surfer object.
   * @param slug the slug.
   * @return Surfer based on the slug.
   */
  public static Surfer getSurfer(String slug) {
    Surfer surfer = surfers.get(slug);
    if (surfer == null) {
      throw new RuntimeException("Passed an invalid slug: " + slug); 
    }
    return surfer;
  }

}
