package voxterra.voxterra;

/**
 * Holds Instances for research items
 */
public class ResearchItem {
    private final String name;
    private final String description;

    private long cost;
    private boolean unlocked;
    private boolean purchased;

    private ResearchItem[] child_items;
    private ShopItem[] result_items;
    public ResearchItem(String name, String description, long cost, boolean unlocked, ResearchItem[] child_items, ShopItem[] result_items){
        this.name           = name;
        this.description    = description;
        this.cost           = cost;
        this.unlocked       = unlocked;
        this.purchased      = false;
        this.child_items    = child_items;
        this.result_items   = result_items;
    }

    //===================Getter Methods===================//
    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public long getCost(){
        return this.cost;
    }

    public boolean isUnlocked() {
        return this.unlocked;
    }

    public boolean isPurchased() {
        return this.purchased;
    }

    public ResearchItem[] getChild_items(){
        return this.child_items;
    }

    public ShopItem[] getResult_items(){
        return this.result_items;
    }

    //===================Setter Methods===================//
    public void setCost(long cost) {
        this.cost = cost;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    //====================State Methods===================//
    public void purchaseReseach(){
        if(this.unlocked && !this.purchased){
            this.purchased = true;
            for(int i = 0; i < this.result_items.length; i++){
                this.result_items[i].setUnlocked(true);
            }
            for(int i = 0; i < this.child_items.length; i++){
                this.child_items[i].setUnlocked(true);
            }
        }
    }
}
