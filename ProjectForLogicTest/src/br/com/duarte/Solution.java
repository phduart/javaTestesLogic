package br.com.duarte;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final Map<String, Double> ITEM_PRICES = new HashMap<>();

    static {
        ITEM_PRICES.put("apple", 0.50);
        ITEM_PRICES.put("orange", 0.40);
        ITEM_PRICES.put("banana", 0.20);
        ITEM_PRICES.put("strawberry", 2.00);
    }

    private static double getTaxRate(String taxCode) {
        switch (taxCode) {
            case "MO":
                return 1.225;
            case "OR":
                return 0;
            case "GA":
                return 4;
            default:
                return 2;
        }
    }

    public static void main(String[] args) {
        CartItem[] cart = new CartItem[] {
                new CartItem("apple", 6),
                new CartItem("orange", 3),
                new CartItem("banana", 4)
        };

        System.out.println("PARTE 1 : ");
        System.out.println(checkout(cart, null, null));
        System.out.println();

        System.out.println("PARTE 2 : ");
        System.out.println(checkout(cart, "MO", null));
        System.out.println();

        System.out.println("PARTE 3 : ");
        System.out.println(checkout(cart, "IL", "tenpercentoff"));
        System.out.println();

        System.out.println("PARTE 4 : ");
        System.out.println(checkout(cart, "GA", "2dollarsoff"));
        System.out.println();

        System.out.println("PARTE 5 : ");
        System.out.println(checkout(cart, "MO", "buyonegetonefree"));
        System.out.println();
    }

    private static CheckoutResult checkout(CartItem[] cart, String taxCode, String discountCode) {
        CheckoutResult checkoutResult = new CheckoutResult();

        processSubTotal(cart, checkoutResult);

        if(discountCode != null){
            processDiscount(cart, checkoutResult, discountCode);
        }

        if(taxCode != null){
            processTaxRate(checkoutResult, taxCode);
        }

        return checkoutResult;
    }

    private static void processSubTotal(CartItem[] cart, CheckoutResult checkoutResult){
        for (CartItem cartItem : cart) {
            String item = cartItem.item.toLowerCase();
            if (ITEM_PRICES.containsKey(item)) {
                checkoutResult.subtotal += ITEM_PRICES.get(item) * cartItem.getCount();
            }
        }
    }

    private static void processDiscount(CartItem[] cart, CheckoutResult checkoutResult,
                                        String discountCode){
        switch (discountCode) {
            case "tenpercentoff":
                checkoutResult.discount = checkoutResult.subtotal * 0.10;
                checkoutResult.subtotal -= checkoutResult.discount;
                break;
            case "2dollarsoff":
                if(checkoutResult.subtotal >= 5){
                    checkoutResult.subtotal -= 2;
                }
                break;
            case "buyonegetonefree":
                for (CartItem cartItem : cart) {
                    String item = cartItem.item.toLowerCase();
                    if (ITEM_PRICES.containsKey(item) && cartItem.getCount() > 2) {
                        checkoutResult.subtotal -= ITEM_PRICES.get(item) * (cartItem.getCount() / 2);
                    }
                }
                break;
        }

    }

    private static void processTaxRate(CheckoutResult checkoutResult, String taxCode){
        double taxQtd = checkoutResult.subtotal * (getTaxRate(taxCode) / 100.0);
        taxQtd = Math.round(taxQtd * 100.0) / 100.0;
        checkoutResult.tax = taxQtd;
        checkoutResult.total = checkoutResult.subtotal + checkoutResult.tax;
    }

    private static class CartItem {
        private String item;
        private int count;

        public CartItem(String item, int count) {
            this.item = item;
            this.count = count;
        }

        public String getItem() { return item; }
        public int getCount() { return count; }
    }

    private static class CheckoutResult {
        private double subtotal;
        private double discount;
        private double tax;
        private double total;

        public double getSubtotal() { return subtotal; }
        public void setSubtotal(double value) { subtotal = value; }

        public double getDiscount() { return discount; }
        public void setDiscount(double value) { discount = value; }

        public double getTax() { return tax; }
        public void setTax(double value) { tax = value; }

        public double getTotal() { return total; }
        public void setTotal(double value) { total = value; }

        @Override
        public String toString() {
            return String.format(
                    "Subtotal: %f%nDiscount: %f%nTax:      %f%nTotal:    %f",
                    subtotal, discount,tax,total);
        }
    }
}
