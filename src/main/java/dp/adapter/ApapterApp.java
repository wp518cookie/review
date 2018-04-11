package dp.adapter;

/**
 * Created by Administrator on 2018/4/11.
 */
public class ApapterApp {
    public static void main(String[] args) {
        FishingBoat fishingBoat = new FishingBoat();
        new FishingBoatAdapter(fishingBoat).row();
    }
}
