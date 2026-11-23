import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Membership member1 = new Membership("Henry Clark",
                3, new BigDecimal("30.00"));

        Membership member2 = new BasicMembership("Alice Johnson",
                6, new BigDecimal("30.00"), true);

        System.out.println(member1);
        System.out.println(member2);
    }
}
