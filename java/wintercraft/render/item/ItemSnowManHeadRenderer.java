package wintercraft.render.item;

import wintercraft.helper.tileEntity.TileEntitySnowManHead;
import wintercraft.render.models.ModelCandle;
import wintercraft.render.models.ModelHead;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

public class ItemSnowManHeadRenderer implements IItemRenderer {
	private ModelHead Model;

	public ItemSnowManHeadRenderer() {

		Model = new ModelHead();
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
	TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntitySnowManHead(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
	}
