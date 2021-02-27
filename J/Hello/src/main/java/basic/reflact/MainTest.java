package basic.reflact;

public class MainTest {
    public static void main(String[] args) throws Exception {

        Demo demo = new Demo("16", "张三", "阿波罗");
        byte[] bytes1 = new byte[30];
        int position = 0;
        getFiledBytes(bytes1, demo.getAge(), 6, position);
        position += 6;
        getFiledBytes(bytes1, demo.getName(), 12, position);
        position += 12;
        getFiledBytes(bytes1, demo.getLike(), 12, position);

        FixFormatAdapt fixFormatAdapt = new FixFormatAdapt();
        Demo demo1 = fixFormatAdapt.unformat(new String(bytes1), Demo.class);
        System.out.println(demo1);

    }


    public static void getFiledBytes(byte[] bytes1, String value, int length, int position) {

        byte[] b = getByte(value, length);
        int l = b.length;
        int l2 = bytes1.length;
        System.arraycopy(b, 0, bytes1, position, length);
    }

    static byte[] getByte(String value, int length) {
        byte[] b1 = new byte[length];
        // TODO 长度判断，过长则先 String.format("%s20", value)
        byte[] b2 = value.getBytes();
        System.arraycopy(b2, 0, b1, 0, b2.length);
        for (int i = b2.length; i < b1.length; i++) {
            b1[i] = (char) 32;
        }
        return b1;
    }
}
