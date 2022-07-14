
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mugrootbeer.init;

import net.mcreator.mugrootbeer.procedures.SasssaplingUpdateTickProcedure;
import net.mcreator.mugrootbeer.procedures.SasssaplingPlantRightClickedProcedure;
import net.mcreator.mugrootbeer.procedures.MugRootBeerPlayerFinishesUsingItemProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class MugRootbeerModProcedures {
	public static void load() {
		new MugRootBeerPlayerFinishesUsingItemProcedure();
		new SasssaplingUpdateTickProcedure();
		new SasssaplingPlantRightClickedProcedure();
	}
}
