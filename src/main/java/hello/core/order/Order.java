package hello.core.order;

public class Order {
    private  Long MemberID;

    private String itemName;

    private int itemPrice;

    private  int discountPrice;

    //계산로직
    public int calculatePrice(){
        return itemPrice - discountPrice;
    }

    // tostring 객체를 출력하면 이결과가 죽나옴
    @Override
    public String toString() {
        return "Order{" +
                "MemberID=" + MemberID +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';

    }

    public Order(Long memberID, String itemName, int itemPrice, int discountPrice) {
        MemberID = memberID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public Long getMemberID() {
        return MemberID;
    }

    public void setMemberID(Long memberID) {
        MemberID = memberID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
}
