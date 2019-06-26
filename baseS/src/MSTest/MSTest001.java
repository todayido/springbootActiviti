package MSTest;

public class MSTest001 {

    public static int rer() {
        int flag = 0;
        try {
            flag = 1;
            System.out.println("ret");
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("12312312");
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(rer());
    }
}
