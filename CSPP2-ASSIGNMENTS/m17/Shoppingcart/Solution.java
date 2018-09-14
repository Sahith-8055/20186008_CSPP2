import java.util.Arrays;
import java.util.Scanner;
/**
 * Class for item.
 */
class Item {
    /**
     * {Variable for name of the product}.
     */
    private String productname;
    /**
     * {Variable for quantity of that product}.
     */
    private int quantity;
    /**
     * {Variable for price of one unit of that product}.
     */
    private double unitprice;

    /**
     * Constructs the object.
     */
    Item() {
        //Empty.
    }

    /**
     * Constructs the object.
     *
     * @param      productname1  The productname 1
     * @param      quantity1     The quantity 1
     * @param      unitprice1    The unitprice 1
     */
    Item(final String productname1, final int quantity1, final double unitprice1) {
        this.productname = productname1;
        this.quantity = quantity1;
        this.unitprice = unitprice1;
    }

    /**
     * Constructs the object.
     *
     * @param      productname1  The productname 1
     * @param      quantity1     The quantity 1
     */
    Item(final String productname1, final int quantity1) {
        this.productname = productname1;
        this.quantity = quantity1;
    }

    /**
     * {Method to retrieve the product name}.
     *
     * @return     {Name of the product}
     */
    public String getproductName() {
        return this.productname;
    }

    /**
     * Gets the quantity of the product.
     *
     * @return     The quantity.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * {Method to get unit price}.
     *
     * @return     {Price of one unit of that product}
     */
    public double getunitPrice() {
        return this.unitprice;
    }
    /**
     * Method to set the name of the product.
     *
     * @param      pName  The name
     */
    public void setproductName(final String pName) {
        this.productname = pName;
    }
    /**
     * Method to set the quantity.
     *
     * @param      quan  The quan
     */
    public void setQuantity(final int quan) {
        this.quantity = quan;
    }
    /**
     * Method to set the price.
     *
     * @param      givePrice  The give price
     */
    public void setPrice(final double givePrice) {
        this.unitprice = givePrice;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.productname + " " + this.quantity + " " + this.unitprice;
    }
}

/**
 * Class for shopping cart.
 */
class ShoppingCart {
    /**
     * {List of items avaliable}.
     */
    private Item[] catalog;
    /**
     * {List of items in the cart}.
     */
    private Item[] cart;
    /**
     * {Size of the cart}.
     */
    private int cartSize;
    /**
     * {Size of the catalog}.
     */
    private int catalogSize;
    private String[] coupons;
    private boolean avaliableCoupon;
    private double t;
    private double tax;
    private double discount;
    ShoppingCart() {
        final int number = 10;
        this.catalog = new Item[number];
        this.cart = new Item[number];
        this.coupons = new String[]{"IND10","IND20","IND30","IND40"};
        this.cartSize = 0;
        this.catalogSize = 0;
        this.t = 0.0;
        this.discount = 0.0;
        this.tax = 0.0;
        this.avaliableCoupon = false;
    }
    /**
     * {Method to resize}.
     */
    private void resize() {
        catalog = Arrays.copyOf(catalog, 2 * catalog.length);
        cart = Arrays.copyOf(cart, 2 * cart.length);
    }

    /**
     * {Method to get the number of catalog in the cart}.
     *
     * @return     {Size of the cart}
     */
    public int getcartSize() {
        return cartSize;
    }

    /**
     * {Method to get the number of catalog in the catalog}.
     *
     * @return     {Size of the catalog}
     */
    public int getcatalogSize() {
        return catalogSize;
    }

    /**
     * Method to add an item to catalog.
     *
     * @param      item  The item
     */
    public void addToCatalog(final Item item) {
        if (catalogSize >= catalog.length) {
            resize();
        }
        catalog[catalogSize++] = item;
    }
    public int indexofCart(final Item item) {
        for (int i = 0; i < cartSize; i++) {
            if (cart[i].getproductName().equals(item.getproductName())) {
                return i;
            }
        }
        return -1;
    }
    public int indexofCatalog(final Item item) {
        for (int i = 0; i < catalogSize; i++) {
            if (catalog[i].getproductName().equals(item.getproductName())) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Method to add an item to the cart.
     *
     * @param      item  The item
     */
    public void addToCart(final Item item) {
        if (cartSize >= catalog.length) {
            resize();
        }
        int index = indexofCart(item);
        if (index == -1) {
            for (int i = 0; i < catalogSize; i++) {
            if (item.getproductName().equals(catalog[i].getproductName())
                && item.getQuantity() <= catalog[i].getQuantity()) {
                cart[cartSize++] = item;
            }
        }
    } else {
        int q = cart[index].getQuantity() + item.getQuantity();
        Item temp = catalog[index];
        if (item.getQuantity() <= temp.getQuantity()) {
            cart[index].setQuantity(q);
        }
    }
}
    /**
     * Method to remove an item from the cart.
     *
     * @param      item  The item
     */
    public void removeFromCart(final Item item) {
        int index1 = indexofCart(item);
        if (index1 != -1) {
            if (cart[index1].getQuantity() == item.getQuantity()) {
               for (int j = index1; j < cartSize; j++) {
                    cart[j] = cart[j + 1];
                }
            } else if (cart[index1].getQuantity() > item.getQuantity()) {
                cart[index1].setQuantity(cart[index1].getQuantity() - item.getQuantity());
            } else {
                System.out.println("Not Applicable");
            }
        }
    }
    /**
     * Method to display the cart.
     */
    public void showCart() {
        for (int i = 0; i < cartSize; i++) {
            System.out.println(cart[i].getproductName() + " " + cart[i].getQuantity());
        }
    }

    /**
     * Method to display the catalog.
     */
    public void showCatalog() {
        for (int i = 0; i < catalogSize; i++) {
            System.out.println(catalog[i]);
        }
    }
    /**
     * Gets the total amount of the items in the cart.
     *
     * @return     The total amount.
     */
    public double getTotalAmount() {
        double amount = 0.0;
        int m = 0;
        for (int i = 0; i < cartSize; i++) {
            m = indexofCatalog(cart[i]);
            if (m != -1) {
                amount += catalog[m].getunitPrice() * cart[i].getQuantity();
            }
        }
        return amount;
    }
    public double getPayableAmount() {
        double amount = getTotalAmount();
        discount = amount * (t/10);
        amount -= discount;
        tax = amount * 0.15;
        amount += tax;
        return amount;
    }
    public void isCoupon(String coupon) {
        System.out.println("Hi");
        for (int i = 0; i < coupons.length; i++) {
            if (coupon.equals(coupons[i]) && !avaliableCoupon) {
                t = Character.getNumericValue(coupons[i].charAt(3));
                avaliableCoupon = true;
                break;
            }
        }
        if (!avaliableCoupon) {
            System.out.println("Invalid coupon");
        }
    }
    public void printInvoice() {
        for (int i = 0; i < cartSize; i++) {
            int p = indexofCatalog(cart[i]);
            System.out.println(cart[i].getproductName() + " " + cart[i].getQuantity() + " " + catalog[p].getunitPrice());
        }
        System.out.println("Total:" + getTotalAmount());
        System.out.println("Disc%:" + discount);
        System.out.println("Tax:" + tax);
        System.out.println("Payable amount:" + " " + getPayableAmount());
    }
}
/**
 * {Solution class}.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }

    /**
     * {Main method}.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ShoppingCart sc = new ShoppingCart();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "Item":
                    String[] items = tokens[1].split(",");
                    sc.addToCatalog(new Item(items[0], Integer.parseInt(items[1]),
                        Double.parseDouble(items[2])));
                break;
                case "add":
                    items = tokens[1].split(",");
                    sc.addToCart(new Item(items[0], Integer.parseInt(items[1])));
                break;
                case "remove":
                    items = tokens[1].split(",");
                    sc.removeFromCart(new Item(items[0], Integer.parseInt(items[1])));
                break;
                case "show":
                    sc.showCart();
                break;
                case "totalAmount":
                    System.out.println("totalAmount:" + " " + sc.getTotalAmount());
                break;
                case "payableAmount":
                    System.out.println("Payable amount:" + " " + sc.getPayableAmount());
                break;
                case "catalog":
                    sc.showCatalog();
                break;
                case "coupon":
                    sc.isCoupon(tokens[1]);
                break;
                case "print":
                    System.out.println("Name   quantity   Price");
                    sc.printInvoice();
                break;
                default:
                break;
            }
        }
    }
}