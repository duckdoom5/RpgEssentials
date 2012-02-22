package me.duckdoom5.RpgEssentials.blocks.misc;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.Quad;
import org.getspout.spoutapi.block.design.SubTexture;
import org.getspout.spoutapi.block.design.Texture;

public final class SafeDesign extends GenericBlockDesign {
	public SafeDesign(RpgEssentials plugin, int[] id) {
		Texture texture = plugin.misc;
		setBoundingBox(0, 0, 0, 1, 1, 1).setQuadNumber(10);
		setTexture(plugin, texture.getTexture()).setMinBrightness(1F).setMaxBrightness(1F);
		SubTexture subTex = texture.getSubTexture(id[0]);
		SubTexture front = texture.getSubTexture(id[1]);
		SubTexture left = texture.getSubTexture(id[2]);
		SubTexture back = texture.getSubTexture(id[3]);
		SubTexture right = texture.getSubTexture(id[4]);
		
		Quad bottom1 = new Quad(0, subTex);
		bottom1.addVertex(3, 0.0F, 0.0F, 1.0F);
		bottom1.addVertex(2, 1.0F, 0.0F, 1.0F);
		bottom1.addVertex(1, 1.0F, 0.0F, 0.0F);
		bottom1.addVertex(0, 0.0F, 0.0F, 0.0F);
		
		Quad left1 = new Quad(1, left);
		left1.addVertex(3, 1.0F, 0.0F, 1.0F);
		left1.addVertex(2, 1.0F, 1.0F, 1.0F);
		left1.addVertex(1, 1.0F, 1.0F, 0.0F);
		left1.addVertex(0, 1.0F, 0.0F, 0.0F);
		
		Quad back1 = new Quad(2, back);
		back1.addVertex(0, 1.0F, 0.0F, 1.0F);
		back1.addVertex(1, 1.0F, 1.0F, 1.0F);
		back1.addVertex(2, 0.0F, 1.0F, 1.0F);
		back1.addVertex(3, 0.0F, 0.0F, 1.0F);
		
		Quad right1 = new Quad(3, right);
		right1.addVertex(0, 0.0F, 0.0F, 1.0F);
		right1.addVertex(1, 0.0F, 1.0F, 1.0F);
		right1.addVertex(2, 0.0F, 1.0F, 0.0F);
		right1.addVertex(3, 0.0F, 0.0F, 0.0F);
		
		Quad front1 = new Quad(4, front);
		front1.addVertex(1, 0.0F, 0.0F, 0.0F);
		front1.addVertex(2, 0.0F, 1.0F, 0.0F);
		front1.addVertex(3, 1.0F, 1.0F, 0.0F);
		front1.addVertex(0, 1.0F, 0.0F, 0.0F);
		
		Quad top1 = new Quad(5, subTex);
		top1.addVertex(0, 1.0F, 1.0F, 1.0F);
		top1.addVertex(1, 1.0F, 1.0F, 0.0F);
		top1.addVertex(2, 0.0F, 1.0F, 0.0F);
		top1.addVertex(3, 0.0F, 1.0F, 1.0F);
		
		this.setQuad(bottom1).setQuad(left1).setQuad(front1).setQuad(right1).setQuad(back1).setQuad(top1);
	}
}
