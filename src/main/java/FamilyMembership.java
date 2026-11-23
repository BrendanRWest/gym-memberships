import java.math.BigDecimal;

public class FamilyMembership extends Membership{

    private int extraMembers;

    public FamilyMembership(String memberName, int months, BigDecimal baseRate, int extraMembers) {
        super(memberName, months, baseRate);
        this.extraMembers = extraMembers;
    }

    public int getExtraMembers() {
        return extraMembers;
    }

    public void setExtraMembers(int extraMembers) {
        this.extraMembers = extraMembers;
    }

    @Override
    public BigDecimal getMonthlyPrice(){
        BigDecimal total = getBaseRate();

        for (int i = 0; i < extraMembers; i++) {
            total = total.add(new BigDecimal("12.50"));
        }
        if(extraMembers >= 3){
            total = total.multiply(new BigDecimal(".90"));
        }
        return total;
    }

    @Override
    public String toString() {
        return "Family | " + getMemberName() + " | " + getMonths() +
                " months | extra members: " + extraMembers;
    }
}
