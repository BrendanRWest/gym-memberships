import java.lang.reflect.Member;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Membership member1 = new Membership("Henry Clark",
                3, new BigDecimal("30.00"));

        BasicMembership member2 = new BasicMembership("Alice Johnson",
                6, new BigDecimal("30.00"), true);

        BasicMembership member3 = new BasicMembership("Bob Smith",
                2, new BigDecimal("27.50"), false);

        PremiumMembership member4 = new PremiumMembership("Carol White",
                12, new BigDecimal("30.00"), 2);

        PremiumMembership member5 = new PremiumMembership("Frank Miller",
                3, new BigDecimal("30.00"), 0);


        System.out.println("=== Gym Memberships ===");
        System.out.println(member1);
        System.out.println(member2);
        System.out.println(member3);
        System.out.println(member4);
        System.out.println(member5);

        System.out.println("--- Guest Passes ---");
        member4.useGuestPass();
        member4.useGuestPass();
        member4.useGuestPass();
        member5.useGuestPass();
    }
}
