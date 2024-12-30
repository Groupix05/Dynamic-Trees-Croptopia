package groupix05.dtcroptopia.genfeatures;

import com.ferreusveritas.dynamictrees.api.registry.Registry;
import com.ferreusveritas.dynamictrees.systems.genfeature.GenFeature;
import groupix05.dtcroptopia.DynamicTreesCROPTOPIA;

public class DTCROPTOPIAGenFeatures {

    public static final GenFeature BANANA_FRUIT = new BananaFruitGenFeature(DynamicTreesCROPTOPIA.location("banana_fruit"));
    public static final GenFeature DRAGON_FRUIT_FRUIT = new DragonFruitFruitGenFeature(DynamicTreesCROPTOPIA.location("dragon_fruit_fruit"));
    public static final GenFeature PALM_FRUIT = new PalmFruitGenFeature(DynamicTreesCROPTOPIA.location("palm_fruit"));
    public static final GenFeature PLANT_SUCKERS = new PlantSuckerGenFeature(DynamicTreesCROPTOPIA.location("plant_suckers"));

    public static void register(final Registry<GenFeature> registry) {
        registry.registerAll(BANANA_FRUIT, DRAGON_FRUIT_FRUIT, PALM_FRUIT, PLANT_SUCKERS);
    }

}
