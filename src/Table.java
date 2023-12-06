import java.text.NumberFormat;

public class Table {
    NumberFormat format = NumberFormat.getNumberInstance();
    private float width;

    private float length;
    private float price;
    private String woodType;



    public Table(float width, float length, String woodType) {
        this.length = length;
        this.width = width;
        this.woodType = woodType;
        this.price = computeIncreasedPrice();
    }
    public Table(){
        this.length = 120;
        this.width = 80;
        this.price = 42500;
        this.woodType = "Pine";
    }

    private float computeIncreasedPrice(){
        //Compute area received
        float areaReceived = (this.length * this.width);

        //Increased Area and type "Mahogany"
        if (areaReceived > 9600){
            return (42500+(((areaReceived - 9600)*825)));
        }
        return 42500;
    }

    protected void setCustomPrice(float customPrice){
        this.price = this.price+customPrice;
    }
    protected void setWoodPrice() {
        switch (this.woodType) {
            case "Mahogany" -> this.price = this.price + 3000;
            case "Pine" -> this.price = this.price + 0;
            case "Oak" -> this.price = this.price + 2015;
            default -> throw new RuntimeException("Wood type not defined: " + this.woodType);
        }
    }
    public void getData(){
        System.out.println("The area is: " + format.format(width*length));
        System.out.println("The price is: " + format.format(price));
        System.out.println("The woodType is: " + woodType);

    }
    public float getPrice(){
        return price;
    }

    public float getWidth() {
        return width;
    }

    public float getLength() {
        return length;
    }

    public String getWoodType() {
        return woodType;
    }
    public float getArea(){
        return (this.length*this.width);
    }
    protected void discount(int numOfTables){
        if (numOfTables>1){
            this.price = (float) ((this.price*numOfTables)*0.95);
        }
    }
}
