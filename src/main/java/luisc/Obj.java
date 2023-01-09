package luisc;

import processing.core.PApplet;

/**
 * Abstract class for objects that will be drawn to the screen
 */
public abstract class Obj {

  protected Assets a;
  protected App m;
  protected PApplet p;
  protected boolean shouldUpdate = true;

  public Obj(App app) {
    this.a = app.a;
    this.m = app;
    this.p = app;
  }

  public void setup() {
    // Do sone setup
    preSetup();

    _setup();

    postSetup();
  }

  protected void preSetup() {
    // Should be used for super classes to setup variables
  }

  protected void postSetup() {
    // Should be used for super classes to override variables
  }

  protected void _setup() {
    // Does nothing
    // Should be overridden by a super class and called in the setup method if needed
  }

  /**
   * Draws and updates the object
   * Should not be overridden by a super class
   */
  public final void update() {
    preUpdate();

    if (shouldUpdate) {
      _update();
    }

    postUpdate();
  }

  protected abstract void _update();

  protected void preUpdate() {
    push();
  }

  protected void postUpdate() {
    pop();
  }

  protected final void push() {
    m.pushMatrix();
    m.pushStyle();
  }

  protected final void pop() {
    m.popMatrix();
    m.popStyle();
  }
}
