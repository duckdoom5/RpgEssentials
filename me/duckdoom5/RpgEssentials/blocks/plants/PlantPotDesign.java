package me.duckdoom5.RpgEssentials.blocks.plants;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.Quad;
import org.getspout.spoutapi.block.design.Texture;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class PlantPotDesign extends GenericBlockDesign {
	
	public PlantPotDesign(RpgEssentials plugin, int[] textureids) {
		Texture texture = plugin.plants;
		setBoundingBox(0, 0, 0, 2, 2, 2).setQuadNumber(14);
		setTexture(plugin, texture.getTexture()).setMinBrightness(1F).setMaxBrightness(1F);
		
		Quad bottom = new Quad(0, texture.getSubTexture(textureids[0]));
		bottom.addVertex(3, 0.875F, 0.0F, 0.125F);
		bottom.addVertex(0, 0.875F, 0.0F, 0.875F);
		bottom.addVertex(1, 0.125F, 0.0F, 0.875F);
		bottom.addVertex(2, 0.125F, 0.0F, 0.125F);

		Quad front = new Quad(1, texture.getSubTexture(textureids[0]));
		front.addVertex(0, 1.000F, 1.0F, 0.000F);
		front.addVertex(1, 0.875F, 0.0F, 0.125F);
		front.addVertex(2, 0.125F, 0.0F, 0.125F);
		front.addVertex(3, 0.000F, 1.0F, 0.000F);

		Quad back = new Quad(2, texture.getSubTexture(textureids[0]));
		back.addVertex(2, 1.000F, 1.0F, 1.000F);
		back.addVertex(1, 0.875F, 0.0F, 0.875F);
		back.addVertex(0, 0.125F, 0.0F, 0.875F);
		back.addVertex(3, 0.000F, 1.0F, 1.000F);

		Quad left = new Quad(3, texture.getSubTexture(textureids[0]));
		left.addVertex(3, 1.000F, 1.0F, 0.000F);
		left.addVertex(2, 0.875F, 0.0F, 0.125F);
		left.addVertex(1, 0.875F, 0.0F, 0.875F);
		left.addVertex(0, 1.000F, 1.0F, 1.000F);
		
		Quad right = new Quad(4, texture.getSubTexture(textureids[0]));
		right.addVertex(0, 0.000F, 1.0F, 0.000F);
		right.addVertex(1, 0.125F, 0.0F, 0.125F);
		right.addVertex(2, 0.125F, 0.0F, 0.875F);
		right.addVertex(3, 0.000F, 1.0F, 1.000F);

		Quad top = new Quad(5, texture.getSubTexture(textureids[1]));
		top.addVertex(2, 0.875F, 0.875F, 0.125F);
		top.addVertex(1, 0.875F, 0.875F, 0.875F);
		top.addVertex(0, 0.125F, 0.875F, 0.875F);
		top.addVertex(3, 0.125F, 0.875F, 0.125F);
		
		Quad side1 = new Quad(6, texture.getSubTexture(textureids[0]));//front
		side1.addVertex(3, 0.9375F, 1.000F, 0.0625F);
		side1.addVertex(0, 0.8750F, 0.875F, 0.1250F);
		side1.addVertex(2, 0.9375F, 1.000F, 0.9375F);
		side1.addVertex(1, 0.8750F, 0.875F, 0.8750F);
		
		Quad side2 = new Quad(7, texture.getSubTexture(textureids[0]));//left
		side2.addVertex(3, 0.9375F, 1.000F, 0.9375F);
		side2.addVertex(0, 0.8750F, 0.875F, 0.8750F);
		side2.addVertex(2, 0.0625F, 1.000F, 0.9375F);
		side2.addVertex(1, 0.1250F, 0.875F, 0.8750F);
		
		Quad side3 = new Quad(8, texture.getSubTexture(textureids[0]));//back !
		side3.addVertex(3, 0.0625F, 1.000F, 0.9375F);
		side3.addVertex(0, 0.1250F, 0.875F, 0.8750F);
		side3.addVertex(2, 0.0625F, 1.000F, 0.0625F);
		side3.addVertex(1, 0.1250F, 0.875F, 0.1250F);
		
		Quad side4 = new Quad(9, texture.getSubTexture(textureids[0]));//right !
		side4.addVertex(3, 0.0625F, 1.000F, 0.0625F);
		side4.addVertex(0, 0.1250F, 0.875F, 0.1250F);
		side4.addVertex(2, 0.9375F, 1.000F, 0.0625F);
		side4.addVertex(1, 0.8750F, 0.875F, 0.1250F);
		
		Quad top1 = new Quad(10, texture.getSubTexture(textureids[0]));
		top1.addVertex(0, 1.0000F, 1.0F, 0.0000F);
		top1.addVertex(1, 0.9375F, 1.0F, 0.0625F);
		top1.addVertex(2, 0.9375F, 1.0F, 0.9375F);
		top1.addVertex(3, 1.0000F, 1.0F, 1.0000F);
		
		Quad top2 = new Quad(11, texture.getSubTexture(textureids[0]));
		top2.addVertex(0, 1.0000F, 1.0F, 1.0000F);
		top2.addVertex(1, 0.9375F, 1.0F, 0.9375F);
		top2.addVertex(2, 0.0625F, 1.0F, 0.9375F);
		top2.addVertex(3, 0.0000F, 1.0F, 1.0000F);
		
		Quad top3 = new Quad(12, texture.getSubTexture(textureids[0]));
		top3.addVertex(0, 0.0000F, 1.0F, 1.0000F);
		top3.addVertex(1, 0.0625F, 1.0F, 0.9375F);
		top3.addVertex(2, 0.0625F, 1.0F, 0.0625F);
		top3.addVertex(3, 0.0000F, 1.0F, 0.0000F);
		
		Quad top4 = new Quad(13, texture.getSubTexture(textureids[0]));
		top4.addVertex(0, 0.0000F, 1.0F, 0.0000F);
		top4.addVertex(1, 0.0625F, 1.0F, 0.0625F);
		top4.addVertex(2, 0.9375F, 1.0F, 0.0625F);
		top4.addVertex(3, 1.0000F, 1.0F, 0.0000F);

		this.setQuad(bottom).setQuad(front).setQuad(back).setQuad(left).setQuad(right).setQuad(top).setQuad(side1).setQuad(side2).setQuad(side3).setQuad(side4).setQuad(top1).setQuad(top2).setQuad(top3).setQuad(top4);
		
	}
}
