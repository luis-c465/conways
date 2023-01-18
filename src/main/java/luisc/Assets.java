package luisc;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 * Class which loads images and audio to be used in the main class {@link App}
 *
 * Call the {@link #setup(App) setup method} to load all the images and the sounds
 */
public class Assets {

  public PApplet p;
  public Class _class;

  // * BUTTONS
  public PImage enter;
  public PImage space;

  // * MISCELLANEOUS
  public PImage bg;

  // * FONTS
  public PFont nunito;
  // !Smaller versions of fonts are loaded because controlP5 does not give a method to set the font size of the input text
  public PFont nunito_small;

  public void setup(App app) {
    this.p = app;
    this._class = this.getClass();

    // * LOAD BUTTONS
    enter = p.loadImage("btn/enter.png");
    space = p.loadImage("btn/space.png");
    space.resize(200, 100);

    // * LOAD MISC
    bg = p.loadImage("bg-blur.jpg");

    // * LOAD FONTS
    nunito = p.createFont("fonts/Nunito.ttf", 64);
    nunito_small = p.createFont("fonts/Nunito.ttf", 32);
    p.textFont(nunito);
  }

  /**
   * Safely and dynamically get an asset with the given name
   *
   * @return null if an error occurred getting the asset
   */
  public PImage getAsset(String name) {
    try {
      return (PImage) get(name);
    } catch (Exception e) {
      return null;
    }
  }

  public Object get(String k) throws IllegalAccessException, NoSuchFieldException {
    return (_class.getDeclaredField(k).get(this));
  }
}
