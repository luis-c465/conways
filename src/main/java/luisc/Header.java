package luisc;

/**
 * Contains buttons for switching between different
 */
public class Header extends Obj {

  public static final int safe = 10;
  public static final int gap = 350;

  public BinaryBtn binaryBtn;
  public HexadecimalBtn hexBtn;
  public TestModeBtn testModeBtn;

  @Override
  protected void _setup() {
    binaryBtn = new BinaryBtn(m);
    hexBtn = new HexadecimalBtn(m);
    testModeBtn = new TestModeBtn(m);

    binaryBtn.setup();
    hexBtn.setup();
    testModeBtn.setup();
  }

  @Override
  protected void _update() {
    binaryBtn.update();
    hexBtn.update();
    testModeBtn.update();
  }

  // First button the header
  private class BinaryBtn extends Btn {

    @Override
    protected void _setup() {
      icon = p.loadShape("binary.svg");
      x = safe;
      y = safe + h;

      w = 200;

      txt = "Binary";

      cornerToCenter();
    }

    public BinaryBtn(App a) {
      super(a);
    }
  }

  // Second button the header
  private class HexadecimalBtn extends Btn {

    @Override
    protected void _setup() {
      icon = p.loadShape("hexagon.svg");
      x = safe + gap;
      y = safe + h;

      w = 200;

      txt = "Hexadecimal";

      cornerToCenter();
    }

    public HexadecimalBtn(App a) {
      super(a);
    }
  }

  // Second button the header
  private class TestModeBtn extends Btn {

    @Override
    protected void _setup() {
      icon = p.loadShape("notebook.svg");
      x = safe + gap * 2;
      y = safe + h;

      w = 200;

      txt = "Test Mode";

      cornerToCenter();
    }

    public TestModeBtn(App a) {
      super(a);
    }
  }

  public Header(App app) {
    super(app);
  }
}
