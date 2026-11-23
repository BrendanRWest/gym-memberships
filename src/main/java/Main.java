import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Membership> members= new ArrayList<>();

        // 'Membership' is abstract; cannot be instantiated
        /*Membership member1 = new Membership("Henry Clark",
                3, new BigDecimal("30.00"));*/

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

        CorporateMembership member8 = new CorporateMembership("Olivia Martin",
                12, new BigDecimal("30.00"), new BigDecimal("0.40"));

        // members.add(member1);
        members.add(member2);
        members.add(member3);
        members.add(member4);
        members.add(member5);
        members.add(member6);
        members.add(member7);
        members.add(member8);

        BigDecimal monthlyIncome = BigDecimal.ZERO;
        BigDecimal allContracts = BigDecimal.ZERO;

        System.out.println("\n=== Gym Memberships ===\n");
        for (Membership member : members) {
            System.out.println(member);
            printCosts(member);

            monthlyIncome = monthlyIncome.add(member.getMonthlyPrice());
            allContracts = allContracts.add(member.getContractTotal());
        }

        String largestContractMemberName = "";
        for (Membership member : members) {
            if(member.getContractTotal().compareTo(findLargestContract(members)) == 0){
                largestContractMemberName = member.getMemberName();
            }
        }

        System.out.println("\n--- Totals ---\n");
        System.out.println("Memberships: " + members.size());
        System.out.println("Monthly income: $" + monthlyIncome.setScale(2));
        System.out.println("All contracts: $" + allContracts.setScale(2));
        System.out.println("Largest contract: " + largestContractMemberName + ", $" + findLargestContract(members).setScale(2));

        System.out.println("\n--- Front desk notes---\n");
        for (Membership member : members) {
            if(member instanceof BasicMembership){
                if(((BasicMembership) member).isOffPeakOnly()){
                    System.out.println(member.getMemberName() + ": entry between" +
                            " 10:00 and 16:00 only");
                }
            } else if(member instanceof PremiumMembership){
                ((PremiumMembership) member).useGuestPass();
            } else if(member instanceof FamilyMembership){
                System.out.println(member.getMemberName() + ": " +
                        "print " + (((FamilyMembership) member).getExtraMembers() + 1) +
                " key cards");
            }
        }

        System.out.println("\n--- Kinds ---\n");
        for (Membership member : members) {
            System.out.println(member.getMemberName() + ": " + member.getClass().getSimpleName());
        }
    }

    public static void printCosts(Membership membership){
        System.out.println("\tMonthly price: $" + membership.getMonthlyPrice().setScale(2) +
                ", sign-up fee: $" + membership.getSignUpFee() +
                ", contract total $" + membership.getContractTotal());
    }

    private static BigDecimal findLargestContract(List<Membership> members) {

        List<BigDecimal> largestContract = members
                .stream().map(member -> member.getContractTotal())
                .sorted(Comparator.reverseOrder())
                .toList();

        return largestContract.get(0);
    }
}
