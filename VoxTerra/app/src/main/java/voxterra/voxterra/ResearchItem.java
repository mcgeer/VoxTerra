package voxterra.voxterra;

/**
 *
 */
public class ResearchItem {
    private String name;
    private String description;

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

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

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
