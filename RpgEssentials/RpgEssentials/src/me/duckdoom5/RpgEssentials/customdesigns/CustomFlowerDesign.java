package me.duckdoom5.RpgEssentials.customdesigns;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.Quad;
import org.getspout.spoutapi.block.design.Texture;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class CustomFlowerDesign extends GenericBlockDesign {
	
	public CustomFlowerDesign(RpgEssentials plugin, int[] textureids) {
		Texture texture = plugin.plants;
		setBoundingBox(0, 0, 0, 1, 1, 1).setQuadNumber(4);
		setTexture(plugin, texture.getTexture()).setMinBrightness(0F).setMaxBrightness(0F);
		
		Quad front = new Quad(0, texture.getSubTexture(textureids[0]));
		front.addVertex(0, 1.0F, 0.0F, 0.0F);
		front.addVertex(1, 1.0F, 1.0F, 0.0F);
		front.addVertex(2, 0.0F, 1.0F, 1.0F);
		front.addVertex(3, 0.0F, 0.0F, 1.0F);
		
		Quad back = new Quad(1, texture.getSubTexture(textureids[0]));
		back.addVertex(0, 0.0F, 0.0F, 1.0F);
		back.addVertex(1, 0.0F, 1.0F, 1.0F);
		back.addVertex(2, 1.0F, 1.0F, 0.0F);
		back.addVertex(3, 1.0F, 0.0F, 0.0F);

		Quad left = new Quad(2, texture.getSubTexture(textureids[0]));
		left.addVertex(0, 1.0F, 0.0F, 1.0F);
		left.addVertex(1, 1.0F, 1.0F, 1.0F);
		left.addVertex(2, 0.0F, 1.0F, 0.0F);
		left.addVertex(3, 0.0F, 0.0F, 0.0F);
		
		Quad right = new Quad(3, texture.getSubTexture(textureids[0]));
		right.addVertex(0, 0.0F, 0.0F, 0.0F);
		right.addVertex(1, 0.0F, 1.0F, 0.0F);
		right.addVertex(2, 1.0F, 1.0F, 1.0F);
		right.addVertex(3, 1.0F, 0.0F, 1.0F);

		this.setQuad(front).setQuad(back).setQuad(left).setQuad(right);
	}
}