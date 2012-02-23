package me.duckdoom5.RpgEssentials.blocks.stairs;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.Quad;
import org.getspout.spoutapi.block.design.Texture;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class CustomStairDesign extends GenericBlockDesign {
	
	public CustomStairDesign(RpgEssentials plugin, int[] textureids) {
		Texture texture = plugin.stairs;
		setBoundingBox(0, 0, 0, 1, 0.5F, 1).setQuadNumber(10);
		setTexture(plugin, texture.getTexture()).setMinBrightness(1F).setMaxBrightness(1F);
		
		Quad bottom = new Quad(0, texture.getSubTexture(textureids[0]));
		bottom.addVertex(3, 0.0F, 0.0F, 0.0F);
		bottom.addVertex(0, 1.0F, 0.0F, 0.0F);
		bottom.addVertex(1, 1.0F, 0.0F, 1.0F);
		bottom.addVertex(2, 0.0F, 0.0F, 1.0F);

		Quad front = new Quad(1, texture.getSubTexture(textureids[0]));
		front.addVertex(0, 0.0F, 0.0F, 0.0F);
		front.addVertex(1, 0.0F, 0.5F, 0.0F);
		front.addVertex(2, 1.0F, 0.5F, 0.0F);
		front.addVertex(3, 1.0F, 0.0F, 0.0F);

		Quad fronttop = new Quad(2, texture.getSubTexture(textureids[0]));
		fronttop.addVertex(0, 0.0F, 0.5F, 0.5F);
		fronttop.addVertex(1, 0.0F, 1.0F, 0.5F);
		fronttop.addVertex(2, 1.0F, 1.0F, 0.5F);
		fronttop.addVertex(3, 1.0F, 0.5F, 0.5F);
		
		Quad back = new Quad(3, texture.getSubTexture(textureids[0]));
		back.addVertex(3, 0.0F, 0.0F, 1.0F);
		back.addVertex(0, 1.0F, 0.0F, 1.0F);
		back.addVertex(1, 1.0F, 1.0F, 1.0F);
		back.addVertex(2, 0.0F, 1.0F, 1.0F);

		Quad left = new Quad(4, texture.getSubTexture(textureids[0]));
		left.addVertex(0, 1.0F, 0.0F, 0.0F);
		left.addVertex(1, 1.0F, 0.5F, 0.0F);
		left.addVertex(2, 1.0F, 0.5F, 1.0F);
		left.addVertex(3, 1.0F, 0.0F, 1.0F);
		
		Quad lefttop = new Quad(5, texture.getSubTexture(textureids[0]));
		lefttop.addVertex(0, 1.0F, 0.5F, 0.5F);
		lefttop.addVertex(1, 1.0F, 1.0F, 0.5F);
		lefttop.addVertex(2, 1.0F, 1.0F, 1.0F);
		lefttop.addVertex(3, 1.0F, 0.5F, 1.0F);
		
		Quad right = new Quad(6, texture.getSubTexture(textureids[0]));
		right.addVertex(3, 0.0F, 0.0F, 0.0F);
		right.addVertex(2, 0.0F, 0.5F, 0.0F);
		right.addVertex(1, 0.0F, 0.5F, 1.0F);
		right.addVertex(0, 0.0F, 0.0F, 1.0F);
		
		Quad righttop = new Quad(7, texture.getSubTexture(textureids[0]));
		righttop.addVertex(3, 0.0F, 0.5F, 0.5F);
		righttop.addVertex(2, 0.0F, 1.0F, 0.5F);
		righttop.addVertex(1, 0.0F, 1.0F, 1.0F);
		righttop.addVertex(0, 0.0F, 0.5F, 1.0F);

		Quad top1 = new Quad(8, texture.getSubTexture(textureids[0]));
		top1.addVertex(2, 0.0F, 0.5F, 0.0F);
		top1.addVertex(1, 1.0F, 0.5F, 0.0F);
		top1.addVertex(0, 1.0F, 0.5F, 1.0F);
		top1.addVertex(3, 0.0F, 0.5F, 1.0F);
		
		Quad top2 = new Quad(9, texture.getSubTexture(textureids[0]));
		top2.addVertex(2, 0.0F, 1.0F, 0.5F);
		top2.addVertex(1, 1.0F, 1.0F, 0.5F);
		top2.addVertex(0, 1.0F, 1.0F, 1.0F);
		top2.addVertex(3, 0.0F, 1.0F, 1.0F);

		this.setQuad(bottom).setQuad(front).setQuad(back).setQuad(left).setQuad(right).setQuad(top1);
		this.setQuad(fronttop).setQuad(lefttop).setQuad(righttop).setQuad(top2);
	}
}