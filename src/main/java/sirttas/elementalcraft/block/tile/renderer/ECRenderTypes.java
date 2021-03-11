package sirttas.elementalcraft.block.tile.renderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import sirttas.elementalcraft.ElementalCraft;

public class ECRenderTypes {

	@SuppressWarnings("deprecation") 
	public static final RenderType GHOST = RenderType.makeType(ElementalCraft.createRL("ghost").toString(), DefaultVertexFormats.BLOCK, GL11.GL_QUADS, 256,
			RenderType.State.getBuilder().texture(new RenderState.TextureState(AtlasTexture.LOCATION_BLOCKS_TEXTURE, false, false)).alpha(new RenderState.AlphaState(0.5F) {
				@Override
				public void setupRenderState() {
					RenderSystem.pushMatrix();
					RenderSystem.color4f(1F, 1F, 1F, 1F);
					GlStateManager.enableBlend();
					GL14.glBlendColor(1.0F, 1.0F, 1.0F, 0.5F);
					GlStateManager.blendFunc(GlStateManager.SourceFactor.CONSTANT_ALPHA.param, GlStateManager.DestFactor.ONE_MINUS_CONSTANT_ALPHA.param);
				}

				@Override
				public void clearRenderState() {
					GL14.glBlendColor(1.0F, 1.0F, 1.0F, 1.0F);
					GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA.param, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA.param);
					RenderSystem.disableBlend();
					RenderSystem.popMatrix();
				}
			}).build(false));
	
	private ECRenderTypes() {}
}
