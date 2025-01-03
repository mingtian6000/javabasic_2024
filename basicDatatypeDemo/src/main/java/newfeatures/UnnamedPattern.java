package newfeatures;

public class UnnamedPattern {
    public static void main(String[] args) {
        Object obj = "Hello, World!";
        if (obj instanceof String s) {
            System.out.println(s);
        }

        //obj = 123; 使用未命名模式 _ 仅进行类型检查，不存储对象，适用于不需要使用对象的情况。
        if (obj instanceof String _) {
            System.out.println("It's a string");
        }
    }
}
