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
  /** Checks if the slug was created or edited. */
  public boolean newlyCreated = true;
  
  /**
   * Default Constructor.
   */
  public SurferFormData() {
  }
  
  /**
   * Creates a Surfer form data from 8 parameters.
   * @param name The surfer name.
   * @param home The surfer's home.
   * @param awards The list of awards.
   * @param carouselURL The image to be used for the carousel.
   * @param bioURL The image to be used for the bio page.
   * @param bio The bio narrative.
   * @param slug The surfer slug.
   * @param type The surfer type.
   */
  public SurferFormData(String name, String home, String awards, String carouselURL, String bioURL,
      String bio, String slug, String type) {
    this.name = name;
    this.home = home;
    this.awards = awards;
    this.carouselURL = carouselURL;
    this.bioURL = bioURL;
    this.bio = bio;
    this.slug = slug;
    this.type = type;
    
  }
  
  /**
   * Creates a Surfer Form Data object based a surfer object.
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
  }
  /**
   * Checks that form fields are valid. Called by bindFormRequest().
   * @return null if valid, a list of ValidationError if problem is found.
   */
  public List<ValidationError> validate()  {
    List<ValidationError> errors = new ArrayList<>();
    
    if (name.isEmpty()) {
      errors.add(new ValidationError("name", "Name is required."));
    }
    
    if (home.isEmpty()) {
      errors.add(new ValidationError("home", "Home is required."));
    }
    
    if (carouselURL.isEmpty()) {
      errors.add(new ValidationError("carouselURL", "Carousel URL is required."));
    }
    
    if (bioURL.isEmpty()) {
      errors.add(new ValidationError("bioURL", "Bio URL is required."));
    }
    
    if (bio.isEmpty()) {
      errors.add(new ValidationError("bio", "Bio field is required."));
    }

    if (slug.isEmpty()) {
      errors.add(new ValidationError("slug", "Slug field is required."));
    }
    
    if (!slug.matches("^[a-zA-Z0-9]*$")) {
      errors.add(new ValidationError("slug", "Slug must be alphanumeric."));
    }
    
    if (newlyCreated && SurferDB.slugExists(slug)) {
      errors.add(new ValidationError("slug", "Slug '" + slug + "' already in use, duplicate slugs not allowed."));
    }
    
    if (!SurferTypes.isType(type)) {
      errors.add(new ValidationError("type", "Please select a surfer type."));
    }
    
    return errors.isEmpty() ? null : errors;
  }
}
