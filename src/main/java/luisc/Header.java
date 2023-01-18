package luisc;

import processing.core.PShape;

/**
 * Contains buttons for switching between different
 */
public class Header extends Obj {

  public static final int safe = 10;
  public static final int gap = 350;

  public PausedButton pausedBtn;
  public HelpBtn helpBtn;

  @Override
  protected void _setup() {
    pausedBtn = new PausedButton(m);
    helpBtn = new HelpBtn(m);

    pausedBtn.setup();
    helpBtn.setup();
  }

  @Override
  protected void _update() {
    pausedBtn.update();
    helpBtn.update();
  }

  // First button the header
  private class PausedButton extends Btn {

    private PShape pause;
    private PShape play;

    private String pau = "Pause";
    private String pla = "Play";

    @Override
    protected void _setup() {
      pause = p.loadShape("clock-pause.svg");
      play = p.loadShape("clock-play.svg");

      icon = pause;
      x = App.w - 70 - w - 75;
      y = safe + h;

      w = 200;

      txt = pau;

      cornerToCenter();
    }

    @Override
    protected void postUpdate() {
      super.postUpdate();

      if (m.paused) {
        icon = play;
        txt = pla;
      } else {
        icon = pause;
        txt = pau;
      }
    }

    @Override
    protected void _update() {
      super._update();

      if (clicked) {
        m.paused = !m.paused;
      }
    }

    public PausedButton(App a) {
      super(a);
    }
  }

  private class HelpBtn extends Btn {

    @Override
    protected void _setup() {
      icon = p.loadShape("help.svg");
      w = 75;
      y = safe + h;

      x = App.w - safe - w;

      txt = "";
      icon_space = 0;

      cornerToCenter();
    }

    public HelpBtn(App a) {
      super(a);
    }
  }

  public Header(App app) {
    super(app);
  }
}
