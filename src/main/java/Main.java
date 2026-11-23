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

        FamilyMembership member6 = new FamilyMembership("Grace Lee",
                12, new BigDecimal("30.00"), 3);

        FamilyMembership member7 = new FamilyMembership("Emma Wilson",
                6, new BigDecimal("30.00"), 1);


        System.out.println("\n=== Gym Memberships ===");
        System.out.println(member1);
        System.out.println(member2);
        System.out.println(member3);
        System.out.println(member4);
        System.out.println(member5);
        System.out.println(member6);
        System.out.println(member7);

        System.out.println("\n--- Guest Passes ---");
        member4.useGuestPass();
        member4.useGuestPass();
        member4.useGuestPass();
        member5.useGuestPass();

        System.out.println("\n--- Sign-up Fee and contract total ---");
        System.out.println(member1.getMemberName() + ": fee $" + member1.getSignUpFee() +
                ", total $" + member1.getContractTotal());
        System.out.println(member4.getMemberName() + ": fee $" + member4.getSignUpFee() +
                ", total $" + member4.getContractTotal());
        System.out.println(member5.getMemberName() + ": fee $" + member5.getSignUpFee() +
                ", total $" + member5.getContractTotal());
        System.out.println(member6.getMemberName() + ": fee $" + member6.getSignUpFee() +
                ", total $" + member6.getContractTotal());
    }
}
