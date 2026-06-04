package progetto.main.classes;

import progetto.utils.classes.DisplayStrategy;

public class ShopWindow {
    private DisplayStrategy strategy;

    public ShopWindow(DisplayStrategy strategy) {
        this.strategy = strategy;
    }

    public DisplayStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(DisplayStrategy strategy) {
        this.strategy = strategy;
    }

    public double finalPrice(Item item) {
    	double currentPrice = item.calculatePrice();
        double discountedPrice = strategy.newPrice(currentPrice);
        return discountedPrice;
    }
}