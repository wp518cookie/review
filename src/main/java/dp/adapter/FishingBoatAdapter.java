package dp.adapter;

/**
 * Created by Administrator on 2018/4/11.
 */
public class FishingBoatAdapter implements RowingBoat {
    private FishingBoat fishingBoat;

    public FishingBoatAdapter(FishingBoat fishingBoat) {
        this.fishingBoat = fishingBoat;
    }

    public void row() {
        fishingBoat.sail();
    }
}
