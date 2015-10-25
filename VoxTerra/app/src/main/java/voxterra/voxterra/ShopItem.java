package voxterra.voxterra;

/**
 * Holds frame for shop items
 */
public class ShopItem {

    private String name;
    private String description;

    private long cost;
    private boolean unlocked;
    private boolean purchased;


    private ShopItem[] result_items;
//This constructor is for initial Items that are unlocked
    public ShopItem(String name, String description, long cost, boolean unlocked, ShopItem[] result_items){
        this.name           = name;
        this.description    = description;
        this.cost           = cost;
        this.unlocked       = unlocked;
        this.purchased      = false;
        this.result_items   = result_items;
    }
//To display things that are not unlocked --> If we do this
    public ShopItem(String name, String description, long cost, ShopItem[] result_items){
        this.name           = name;
        this.description    = description;
        this.cost           = cost;
        this.unlocked       = false;
        this.purchased      = false;
        this.result_items   = result_items;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCost() {
        return this.cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public boolean isPurchased() {
        return this.purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public ShopItem[] getResult_items() {
        return this.result_items;
    }

    public void setResult_items(ShopItem[] result_items) {
        this.result_items = result_items;
    }

    public boolean isUnlocked(){
        return this.unlocked;
    }

    public void setUnlocked(boolean unlocked){
        this.unlocked = unlocked;
    }
}
