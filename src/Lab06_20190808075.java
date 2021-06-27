import java.util.Arrays;
/**
 * @author Mert Batuhan UNVERDI
 * @since 6.04.2021
 */
public class Lab06_20190808075 {
    public static void main(String[] args) {
        try{
            Product chips = new Product("1afs","Chips");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        Product yoghurt = new Product("1234571459","Yoghurt");
        Product bread = new Product("1452647852","Bread");
        Product cola = new Product("1245631587","Cola");
        Product huptrik = new Product("1234552475","Huptrik");

        System.out.println(huptrik.toString());
        User user = new User("mbu",
                "mertbatuhan@hotmailcom");
        System.out.println(user.toString());
        Chart chart = new Chart(user);

        System.out.println(huptrik.toString());
        chart.addToChart(yoghurt);
        System.out.println(chart);
        chart.addToChart(bread);
        System.out.println(chart);
        chart.addToChart(cola);
        System.out.println(chart);

        chart.addToChart(huptrik);
    }
}
class BarcodeFormatInvalidException extends RuntimeException
{
    public BarcodeFormatInvalidException() {
        super("Barcode number must be consist of 10 digit");
    }
}
class ShoppingChartFullException extends RuntimeException
{
    public ShoppingChartFullException() {
        super("Shopping chart can not exceed 3 products.");
    }
}
class Product
{
    private String barcode;
    private String name;

    public Product(String barcode, String name) {
        if(barcode.length()!=10){
            throw new BarcodeFormatInvalidException();
        }
        else{
            this.barcode = barcode;
        }
            this.name = name;

    }

    public String getBarcode() {
        return this.barcode;
    }

    public String getName() {
        return this.name;
    }

    public String toString()
    {
        return "Product [barcode=" + barcode + ", name=" + name + "]";
    }
}
class User
{
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }
    public String toString()
    {
        return "User [email=" + email + ", username=" + username + "]";
    }
}
class Chart
{
    private User user;
    private Product[] products;

    public Chart(User user) {
        this.user = user;
        this.products = new Product[3];
    }
    public void addToChart(Product product){
       if(products[0]==null)
           products[0] = product;
       else if(products[1]==null)
           products[1] = product;
       else if(products[2]==null)
           products[2] = product;
       else
           throw new ShoppingChartFullException();

    }
    public String toString()
    {
        return "Chart [products=" + Arrays.toString(products) +
                ", user=" + user + "]";
    }
}