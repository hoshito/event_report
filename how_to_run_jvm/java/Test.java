public class Test {
  private int add(int x, int y) {
    int z = x + y;
    return z;
  }
  public static void main(String... args) {
    Test test = new Test();
    int z = test.add(10, 20);
  }
}
