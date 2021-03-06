package dayz.common.world;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.MapGenStructure;
import net.minecraft.src.StructureStart;
import dayz.DayZ;

public class MapGenTown extends MapGenStructure
{
    /** A list of all the biomes villages can spawn in. */
    public static List villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] {DayZ.biomeDayZForest, DayZ.biomeDayZPlains});

    /** World terrain type, 0 for normal, 1 for flat map */
    private final int terrainType;

    public MapGenTown(int par1)
    {
        this.terrainType = par1;
    }

    protected boolean canSpawnStructureAtCoords(int par1, int par2)
    {
        byte var3 = 32;
        byte var4 = 8;
        int var5 = par1;
        int var6 = par2;

        if (par1 < 0)
        {
            par1 -= var3 - 1;
        }

        if (par2 < 0)
        {
            par2 -= var3 - 1;
        }

        int var7 = par1 / var3;
        int var8 = par2 / var3;
        Random var9 = this.worldObj.setRandomSeed(var7, var8, 10387312);
        var7 *= var3;
        var8 *= var3;
        var7 += var9.nextInt(var3 - var4);
        var8 += var9.nextInt(var3 - var4);

        if (var5 == var7 && var6 == var8)
        {
        	return true;
        }

        return false;
    }

    protected StructureStart getStructureStart(int par1, int par2)
    {
        return new StructureVillageStartDayZ(this.worldObj, this.rand, par1, par2, this.terrainType);
    }
}
