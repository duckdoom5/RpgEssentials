package me.duckdoom5.RpgEssentials.customdesigns;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.Quad;
import org.getspout.spoutapi.block.design.Texture;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class CustomSlabDesign extends GenericBlockDesign {
	
	public CustomSlabDesign(RpgEssentials plugin, int[] textureids) {
		Texture texture = plugin.stairs;
		setBoundingBox(0, 0, 0, 1, 0.5F, 1).setQuadNumber(6);
		setTexture(plugin, texture.getTexture()).setMinBrightness(0F).setMaxBrightness(0F);
		
		Quad bottom = new Quad(0, texture.getSubTexture(textureids[0]));
		bottom.addVertex(3, 0.0F, 0.0F, 0.0F);
		bottom.addVertex(0, 1.0F, 0.0F, 0.0F);
		bottom.addVertex(1, 1.0F, 0.0F, 1.0F);
		bottom.addVertex(2, 0.0F, 0.0F, 1.0F);

		Quad front = new Quad(1, texture.getSubTexture(textureids[0]));
		front.addVertex(3, 0.0F, 0.0F, 1.0F);
		front.addVertex(2, 0.0F, 0.5F, 1.0F);
		front.addVertex(1, 1.0F, 0.5F, 1.0F);
		front.addVertex(0, 1.0F, 0.0F, 1.0F);
		
		Quad back = new Quad(2, texture.getSubTexture(textureids[0]));
		back.addVertex(2, 0.0F, 0.0F, 0.0F);
		back.addVertex(1, 1.0F, 0.0F, 0.0F);
		back.addVertex(0, 1.0F, 0.5F, 0.0F);
		back.addVertex(3, 0.0F, 0.5F, 0.0F);

		Quad left = new Quad(3, texture.getSubTexture(textureids[0]));
		left.addVertex(0, 1.0F, 0.0F, 0.0F);
		left.addVertex(1, 1.0F, 0.5F, 0.0F);
		left.addVertex(2, 1.0F, 0.5F, 1.0F);
		left.addVertex(3, 1.0F, 0.0F, 1.0F);
		
		Quad right = new Quad(4, texture.getSubTexture(textureids[0]));
		right.addVertex(0, 0.0F, 0.0F, 1.0F);
		right.addVertex(1, 0.0F, 0.5F, 1.0F);
		right.addVertex(2, 0.0F, 0.5F, 0.0F);
		right.addVertex(3, 0.0F, 0.0F, 0.0F);
		
		Quad top = new Quad(5, texture.getSubTexture(textureids[0]));
		top.addVertex(0, 1.0F, 0.5F, 1.0F);
		top.addVertex(1, 1.0F, 0.5F, 0.0F);
		top.addVertex(2, 0.0F, 0.5F, 0.0F);
		top.addVertex(3, 0.0F, 0.5F, 1.0F);

		this.setQuad(bottom).setQuad(front).setQuad(back).setQuad(left).setQuad(right).setQuad(top);
	}
}