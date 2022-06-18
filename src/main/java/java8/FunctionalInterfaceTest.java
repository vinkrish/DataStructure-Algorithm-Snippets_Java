package java8;

public class FunctionalInterfaceTest {

    public static void main(String[] args) {
        FunctionalInterfaceTest fit = new FunctionalInterfaceTest();
        Functionalnterface fi = new Functionalnterface();
        fi.setFi(fit::getConvertedValue);

        fi.checkFi("9");
    }

    public void test() {
        Functionalnterface fi = new Functionalnterface();
        fi.setFi(this::getConvertedValue);
        fi.checkFi("9");
    }

    public Integer getConvertedValue(String str) {
		return Integer.valueOf(str);
	}
}
