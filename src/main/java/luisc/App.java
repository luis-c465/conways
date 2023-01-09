package luisc;

import controlP5.ControlP5;
import processing.core.PApplet;

/**
 * Hello world!
 */
public final class App extends PApplet {

  @Override
  public void settings() {
    size(1000, 1000);
  }

  @Override
  public void setup() {
    //   surface.setLocation(-1200, 500);
    procSet();

    // * Setup variables and assets
    a.setup(this);
    cp5 = new ControlP5(this);
    // * SETUP CLASSES
  }

  @Override
  public void draw() {
    fill(0);
    ellipse(mouseX, mouseY, 255, 255);
  }

  /**
   * Sets the default settings for drawing with processing
   */
  void procSet() {
    background(0);
    shapeMode(CENTER);
    textAlign(CENTER);
    imageMode(CENTER);
    noStroke();

    // Default fill color is white
    fill(255);
  }

  public static void main(String[] args) {
    runSketch(appletArgs, null);
  }

  // * CONSTANTS
  public static final int h = 1000;
  public static final int w = 1000;

  public static final int ch = 500;
  public static final int cw = 500;

  // * COLORS
  public static final int bg = 0xff1e293b;

  // * VARIABLES
  public boolean transitioning = false;

  // * Util classes
  public Assets a = new Assets();

  // * Library classes
  public ControlP5 cp5;

  // * Transition classes
  public TransitionIn transIn = new TransitionIn(this);
  public TransitionOut transOut = new TransitionOut(this);

  public static final String[] appletArgs = { "luisc.App", "--display=1" };
}
