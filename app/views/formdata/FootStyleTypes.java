package views.formdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.Surfer;


/**
 * Class that declares surfer types.
 * @author Owner
 *
 */
public class FootStyleTypes {
  
  private static String[] types = {"Regular", "Goofy"};
  
  /**
   * Returns a map of all the surferTypes.
   * @return The surfer type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<String, Boolean>();
    for (String type: types) {
      typeMap.put(type,  false);
    }
    return typeMap;
  }
  
  /**
   * Sets a valid type and return the map.
   * @param surferType A string that will be set to a valid type.
   * @return Map A map of the valid surfer types.
   */
  public static Map<String, Boolean> getTypes(String surferType) {
    Map<String, Boolean> typeMap = FootStyleTypes.getTypes();
    typeMap.put(surferType, true);
    return typeMap;
  }
  
  /**
   * Returns true if the parameter is a valid type.
   * @param type The surfer type.
   * @return True if the type is valid.
   */
  public static boolean isType(String type) {
    return FootStyleTypes.getTypes().keySet().contains(type);
  }
  
  /**
   * Returns the list of footstyles.
   * @return List of Surfers.
   */
  public static List<String> getFootStyles() {
    return new ArrayList<>(Arrays.asList(types));
  }

}