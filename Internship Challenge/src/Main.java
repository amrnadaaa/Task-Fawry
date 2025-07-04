import com.example.ecommerce.service.CartService;
import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Products;
import com.example.ecommerce.model.ShippableProduct;
import com.example.ecommerce.service.CheckoutService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ShippableProduct cheese = new ShippableProduct("Cheese",25,100,.25);
        ShippableProduct tv = new ShippableProduct("Tv",2500,40,20);
         Products scratchCard = new Products("scratchCard",22,500);
         CartService cart = new CartService();
         cart.add(cheese,1);
         cart.add(tv,1);
         cart.add(scratchCard,2);
         Customer customer= new Customer("amr",20000);
        try{
            CheckoutService.checkout(customer,cart);
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }

    }
}