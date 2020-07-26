package entity;


import entity.inter.CustomFeature;
import entity.inter.HasBatteries;
import entity.inter.Shoots;
import entity.inter.WaterProof;

/**
 * @author zx
 */
public class FancyToy extends Toy implements HasBatteries, WaterProof, Shoots, CustomFeature {
    FancyToy() {
        super(1);
    }
}
