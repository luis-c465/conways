package luisc;

import controlP5.ControlP5;
import controlP5.Slider;
import processing.core.PShape;

/**
 * Contains buttons for switching between different
 */
public class Header extends Obj {

  public static final int safe = 10;
  public static final int gap = 350;

  public PausedButton pausedBtn;
  public HelpBtn helpBtn;

  public Slider intervalSlider;

  @Override
  protected void _setup() {
    pausedBtn = new PausedButton(m);
    helpBtn = new HelpBtn(m);

    pausedBtn.setup();
    helpBtn.setup();

    intervalSlider =
      m.cp5
        .addSlider("ticks per second")
        .setPosition(safe, safe)
        .setSize(400, 40)
        .setRange(1, 60)
        .setValue(5)
        .setNumberOfTickMarks(60)
        .snapToTickMarks(true)
        .showTickMarks(false)
        .setDecimalPrecision(0)
        .hide();

    // reposition the Label for controller 'slider'
    intervalSlider
      .getValueLabel()
      .align(ControlP5.LEFT, ControlP5.BOTTOM_OUTSIDE)
      .setPaddingX(0)
      .setSize(30)
      .setFont(a.nunito_small);
    intervalSlider
      .getCaptionLabel()
      .align(ControlP5.RIGHT, ControlP5.BOTTOM_OUTSIDE)
      .setPaddingX(0)
      .setSize(30)
      .setFont(a.nunito_small);
  }

  @Override
  protected void _update() {
    pausedBtn.update();
    helpBtn.update();

    if (!m.startUp.done) {
      intervalSlider.hide();
    } else {
      intervalSlider.show();
    }

    m.conways.interval = 1_000 / Math.round(intervalSlider.getValue());
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
