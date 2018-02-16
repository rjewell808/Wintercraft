package wintercraft.render.item;

import wintercraft.render.models.ModelCandle;
import wintercraft.render.tileEntity.TileEntityCandle;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

public class ItemCandleRenderer implements IItemRenderer {

private ModelCandle Model;

public ItemCandleRenderer() {

	Model = new ModelCandle();
}

@Override
public boolean handleRenderType(ItemStack item, ItemRenderType type) {

return true;
}

@Override
public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

return true;
}

@Override
public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

}


}