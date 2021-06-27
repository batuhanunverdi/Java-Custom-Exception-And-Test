import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Mert Batuhan UNVERDI
 * @since 20.04.2021
 */
public class Lab08_20190808075 {
    @Test
    public void shouldCreateProductTest(){
        new Product("1234571459","Yogurt");
        assertTrue(true);
    }
    @Test
    public void productGetNameTest(){
        Product cola = new Product("1245631587","Cola");
        assertEquals("Cola",cola.getName());
    }
    @Test
    public void productGetBarcodeTest(){
        Product cola = new Product("1245631587","Cola");
        assertEquals("1245631587",cola.getBarcode());
    }
    @Test
    public void productBarcodeLengthTest(){
        Product bread = new Product("1452647852","Bread");
        assertEquals(10,bread.getBarcode().length());
    }
    @Test
    public void productToStringTest(){
        Product huptrik = new Product("1234552475","Huptrik");
        assertEquals("Product [barcode=1234552475, name=Huptrik]",
                huptrik.toString());
    }
    @Test
    public void barcodeFormatInvalidExceptionTest(){
        try{
            new Product("1afs","Chips");
        }
        catch (BarcodeFormatInvalidException e){
            assertEquals("Barcode number must be consist of 10 digit",
                    e.getMessage());
            assertTrue(true);
        }
    }
    @Test
    public void shouldCreateUserTest(){
        new User("mbu","mertbatuhanu@hotmail.com");
        assertTrue(true);
    }
    @Test
    public void userGetUsernameTest(){
        User user = new User("mbu","mertbatuhanu@hotmail.com");
        assertEquals("mbu",user.getUsername());
    }
    @Test
    public void userGetEmailTest(){
        User user = new User("mbu","mertbatuhanu@hotmail.com");
        assertEquals("mertbatuhanu@hotmail.com",user.getEmail());
    }
    @Test
    public void userToStringTest(){
        User user = new User("mbu","mertbatuhanu@hotmail.com");
        assertEquals("User [email=mertbatuhanu@hotmail.com, " +
                "username=mbu]",user.toString());
    }
    @Test
    public void shouldCreateChartTest(){
        User user = new User("mbu","mertbatuhanu@hotmail.com");
        new Chart(user);
        assertTrue(true);
    }
    @Test
    public void chartToStringTest(){
        User user = new User("mbu","mertbatuhanu@hotmail.com");
        Chart chart = new Chart(user);
        Product yoghurt = new Product("1234571459","Yoghurt");
        Product bread = new Product("1452647852","Bread");
        Product cola = new Product("1245631587","Cola");
        chart.addToChart(yoghurt);
        chart.addToChart(bread);
        chart.addToChart(cola);
        assertEquals("Chart [products=[Product [barcode=1234571459, " +
                "name=Yoghurt], Product [barcode=1452647852, name=Bread], " +
                "Product [barcode=1245631587, name=Cola]], user=User " +
                "[email=mertbatuhanu@hotmail.com, username=mbu]]",
                chart.toString());
    }
    @Test
    public void chartAddToChartTest(){
            User user = new User("mbu",
                    "mertbatuhanu@hotmail.com");
            Chart chart = new Chart(user);
            Product yoghurt = new Product("1234571459","Yoghurt");
            Product bread = new Product("1452647852","Bread");
            Product cola = new Product("1245631587","Cola");
            chart.addToChart(yoghurt);
            chart.addToChart(bread);
            chart.addToChart(cola);
            assertTrue(true);
    }
    @Test
    public void shoppingChartFullExceptionTest(){
        User user = new User("mbu","mertbatuhanu@hotmail.com");
        Chart chart = new Chart(user);
        Product yoghurt = new Product("1234571459","Yoghurt");
        Product bread = new Product("1452647852","Bread");
        Product cola = new Product("1245631587","Cola");
        Product huptrik = new Product("1234552475","Huptrik");
        chart.addToChart(yoghurt);
        chart.addToChart(bread);
        chart.addToChart(cola);
        try{
            chart.addToChart(huptrik);
            fail();
        }
        catch (ShoppingChartFullException e){
            assertEquals("Shopping chart can not exceed" +
                    " 3 products.", e.getMessage());
            assertTrue(true);
        }
    }
}