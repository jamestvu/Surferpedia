package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Surfer;
import models.SurferDB;
import play.data.validation.ValidationError;

/**
 * Stores the Contact form data object.
 * 
 * @author Owner
 *
 */
public class SurferFormData {
  
  /** The name. */
  public String name = "";
  /** The home. */
  public String home = "";
  /** The awards. */
  public String awards = "";
  /** The carousel URL.*/
  public String carouselURL = "";
  /** The bio URL.*/
  public String bioURL = "";
  /** The bio. */
  public String bio = "";
  /** The slug. */
  public String slug = "";
  /** The type. */
  public String type = "";
  
  /**
   * Default Constructor.
   */
  public SurferFormData() {
    
  }
  /**
   * Creates a Cfd based a contact object.
   * @param formData
   * @param formData the form data.
   */
  public SurferFormData(Surfer formData) {
    this.name = formData.getName();
    this.home = formData.getHome();
    this.awards = formData.getAwards();
    this.carouselURL = formData.getCarouselURL();
    this.bioURL = formData.getBioURL();
    this.bio = formData.getBio();
    this.slug = formData.getSlug();
    this.type = formData.getType();
    System.out.println("2surfer slug set:"+slug+":");
  }
  /**
   * Checks that form fields are valid. Called by bindFormRequest().
   * @return null if valid, a list of ValidationError if problem is found.
   */
  public List<ValidationError> validate()  {
    List<ValidationError> errors = new ArrayList<>();
    
    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", "Name is required."));
    }
    
    if (home == null || home.length() == 0) {
      errors.add(new ValidationError("home", "Home is required."));
    }
    
    if (carouselURL == null || carouselURL.length() == 0) {
      errors.add(new ValidationError("carouselURL", "Carousel URL is required."));
    }
    
    if (bioURL == null || bioURL.length() == 0) {
      errors.add(new ValidationError("bioURL", "Bio URL is required."));
    }
    
    if (bio == null || bio.length() == 0) {
      errors.add(new ValidationError("bio", "Bio field is required."));
    }

    if (slug.isEmpty()) {
      errors.add(new ValidationError("slug", "Slug field is required."));
    }
    
    if (SurferDB.slugExists(slug)) {
      errors.add(new ValidationError("slug", "Slug '" + slug +"' already in use, duplicate slugs not allowed."));
    }
    
    if (!SurferTypes.isType(type)) {
      errors.add(new ValidationError("type", "Please select a surfer type."));
    }
    
    return errors.isEmpty() ? null : errors;
  }
}
