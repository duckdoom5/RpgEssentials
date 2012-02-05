package me.duckdoom5.RpgEssentials.blocks.misc;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.Quad;
import org.getspout.spoutapi.block.design.SubTexture;
import org.getspout.spoutapi.block.design.Texture;

public class CheckoutDesign extends GenericBlockDesign{
	public CheckoutDesign(RpgEssentials plugin, Texture texture, String dir) {
		if(dir == "East"){
			setBoundingBox(0, 0, 0, 1, 1, 1).setQuadNumber(10);
			setTexture(plugin, texture.getTexture()).setMinBrightness(1F).setMaxBrightness(1F);
			SubTexture subTex = texture.getSubTexture(0);
			SubTexture front = texture.getSubTexture(3);
			SubTexture frontt2 = texture.getSubTexture(4);
			
			Quad bottom1 = new Quad(0, subTex);
			bottom1.addVertex(3, 0.25F, 0F, 0.75F);
			bottom1.addVertex(2, 0.75F, 0F, 0.75F);
			bottom1.addVertex(1, 0.75F, 0F, 0.25F);
			bottom1.addVertex(0, 0.25F, 0F, 0.25F);
			
			Quad left1 = new Quad(1, subTex);
			left1.addVertex(0, 0.75F, 0.00F, 0.25F);
			left1.addVertex(1, 0.75F, 0.25F, 0.25F);
			left1.addVertex(2, 0.75F, 0.25F, 0.75F);
			left1.addVertex(3, 0.75F, 0.00F, 0.75F);
			
			Quad left2 = new Quad(2, subTex);
			left2.addVertex(3, 0.75F, 0.25F, 0.500F);
			left2.addVertex(2, 0.75F, 0.50F, 0.375F);
			left2.addVertex(1, 0.75F, 0.50F, 0.250F);
			left2.addVertex(0, 0.75F, 0.25F, 0.250F);
			
			Quad back1 = new Quad(3, subTex);
			back1.addVertex(3, 0.75F, 0.0F, 0.25F);
			back1.addVertex(2, 0.75F, 0.5F, 0.25F);
			back1.addVertex(1, 0.25F, 0.5F, 0.25F);
			back1.addVertex(0, 0.25F, 0.0F, 0.25F);
			
			Quad right1 = new Quad(4, subTex);
			right1.addVertex(3, 0.25F, 0.00F, 0.25F);
			right1.addVertex(2, 0.25F, 0.25F, 0.25F);
			right1.addVertex(1, 0.25F, 0.25F, 0.75F);
			right1.addVertex(0, 0.25F, 0.00F, 0.75F);
			
			Quad right2 = new Quad(5, subTex);
			right2.addVertex(1, 0.25F, 0.25F, 0.500F);
			right2.addVertex(2, 0.25F, 0.50F, 0.375F);
			right2.addVertex(3, 0.25F, 0.50F, 0.250F);
			right2.addVertex(0, 0.25F, 0.25F, 0.250F);
			
			Quad front2 = new Quad(6, frontt2);
			front2.addVertex(3, 0.25F, 0.25F, 0.500F);
			front2.addVertex(2, 0.25F, 0.50F, 0.375F);
			front2.addVertex(1, 0.75F, 0.50F, 0.375F);
			front2.addVertex(0, 0.75F, 0.25F, 0.500F);
			
			Quad front1 = new Quad(7, front);
			front1.addVertex(1, 0.25F, 0.00F, 0.75F);
			front1.addVertex(0, 0.25F, 0.25F, 0.75F);
			front1.addVertex(3, 0.75F, 0.25F, 0.75F);
			front1.addVertex(2, 0.75F, 0.00F, 0.75F);
			
			Quad top1 = new Quad(8, subTex);
			top1.addVertex(0, 0.75F, 0.25F, 0.75F);
			top1.addVertex(1, 0.75F, 0.25F, 0.50F);
			top1.addVertex(2, 0.25F, 0.25F, 0.50F);
			top1.addVertex(3, 0.25F, 0.25F, 0.75F);
			
			Quad top2 = new Quad(9, subTex);
			top2.addVertex(1, 0.75F, 0.5F, 0.375F);
			top2.addVertex(2, 0.75F, 0.5F, 0.250F);
			top2.addVertex(3, 0.25F, 0.5F, 0.250F);
			top2.addVertex(0, 0.25F, 0.5F, 0.375F);
			
			this.setQuad(bottom1).setQuad(left1).setQuad(left2).setQuad(front1).setQuad(front2).setQuad(right1).setQuad(right2).setQuad(back1).setQuad(top1).setQuad(top2);
		}else if(dir == "West"){
			setBoundingBox(0, 0, 0, 1, 1, 1).setQuadNumber(10);
			setTexture(plugin, texture.getTexture()).setMinBrightness(1F).setMaxBrightness(1F);
			SubTexture subTex = texture.getSubTexture(0);
			SubTexture front = texture.getSubTexture(1);
			SubTexture frontt2 = texture.getSubTexture(2);
			
			Quad bottom1 = new Quad(0, subTex);
			
			bottom1.addVertex(3, 0.25F, 0F, 0.75F);
			bottom1.addVertex(2, 0.75F, 0F, 0.75F);
			bottom1.addVertex(1, 0.75F, 0F, 0.25F);
			bottom1.addVertex(0, 0.25F, 0F, 0.25F);
			
			Quad left1 = new Quad(1, subTex);
			left1.addVertex(0, 0.75F, 0.00F, 0.25F);
			left1.addVertex(1, 0.75F, 0.25F, 0.25F);
			left1.addVertex(2, 0.75F, 0.25F, 0.75F);
			left1.addVertex(3, 0.75F, 0.00F, 0.75F);
			
			Quad left2 = new Quad(2, subTex);
			left2.addVertex(0, 0.75F, 0.25F, 0.500F);
			left2.addVertex(1, 0.75F, 0.50F, 0.625F);
			left2.addVertex(2, 0.75F, 0.50F, 0.750F);
			left2.addVertex(3, 0.75F, 0.25F, 0.750F);
			
			Quad back1 = new Quad(3, subTex);
			back1.addVertex(0, 0.75F, 0.0F, 0.75F);
			back1.addVertex(1, 0.75F, 0.5F, 0.75F);
			back1.addVertex(2, 0.25F, 0.5F, 0.75F);
			back1.addVertex(3, 0.25F, 0.0F, 0.75F);
			
			Quad right1 = new Quad(4, subTex);
			right1.addVertex(3, 0.25F, 0.00F, 0.25F);
			right1.addVertex(2, 0.25F, 0.25F, 0.25F);
			right1.addVertex(1, 0.25F, 0.25F, 0.75F);
			right1.addVertex(0, 0.25F, 0.00F, 0.75F);
			
			Quad right2 = new Quad(5, subTex);
			right2.addVertex(3, 0.25F, 0.25F, 0.500F);
			right2.addVertex(2, 0.25F, 0.50F, 0.625F);
			right2.addVertex(1, 0.25F, 0.50F, 0.750F);
			right2.addVertex(0, 0.25F, 0.25F, 0.750F);
			
			Quad front1 = new Quad(6, frontt2);
			front1.addVertex(1, 0.25F, 0.25F, 0.500F);
			front1.addVertex(2, 0.25F, 0.50F, 0.625F);
			front1.addVertex(3, 0.75F, 0.50F, 0.625F);
			front1.addVertex(0, 0.75F, 0.25F, 0.500F);
			
			Quad front2 = new Quad(7, front);
			front2.addVertex(1, 0.25F, 0.00F, 0.25F);
			front2.addVertex(2, 0.25F, 0.25F, 0.25F);
			front2.addVertex(3, 0.75F, 0.25F, 0.25F);
			front2.addVertex(0, 0.75F, 0.00F, 0.25F);
			
			Quad top1 = new Quad(8, subTex);
			top1.addVertex(3, 0.75F, 0.25F, 0.25F);
			top1.addVertex(2, 0.75F, 0.25F, 0.50F);
			top1.addVertex(1, 0.25F, 0.25F, 0.50F);
			top1.addVertex(0, 0.25F, 0.25F, 0.25F);
			
			Quad top2 = new Quad(9, subTex);
			top2.addVertex(3, 0.75F, 0.5F, 0.625F);
			top2.addVertex(2, 0.75F, 0.5F, 0.750F);
			top2.addVertex(1, 0.25F, 0.5F, 0.750F);
			top2.addVertex(0, 0.25F, 0.5F, 0.625F);
			
			this.setQuad(bottom1).setQuad(left1).setQuad(left2).setQuad(front1).setQuad(front2).setQuad(right1).setQuad(right2).setQuad(back1).setQuad(top1).setQuad(top2);
		}else if(dir == "North"){
			setBoundingBox(0, 0, 0, 1, 1, 1).setQuadNumber(10);
			setTexture(plugin, texture.getTexture()).setMinBrightness(1F).setMaxBrightness(1F);
			SubTexture subTex = texture.getSubTexture(0);
			SubTexture front = texture.getSubTexture(1);
			SubTexture frontt2 = texture.getSubTexture(2);
			
			Quad bottom1 = new Quad(0, subTex);
			
			bottom1.addVertex(3, 0.25F, 0F, 0.75F);
			bottom1.addVertex(2, 0.75F, 0F, 0.75F);
			bottom1.addVertex(1, 0.75F, 0F, 0.25F);
			bottom1.addVertex(0, 0.25F, 0F, 0.25F);
			
			Quad left1 = new Quad(1, subTex);
			left1.addVertex(0, 0.25F, 0.00F, 0.75F);
			left1.addVertex(1, 0.25F, 0.25F, 0.75F);
			left1.addVertex(2, 0.75F, 0.25F, 0.75F);
			left1.addVertex(3, 0.75F, 0.00F, 0.75F);
			
			Quad left2 = new Quad(2, subTex);
			left2.addVertex(0, 0.500F, 0.25F, 0.75F);
			left2.addVertex(1, 0.625F, 0.50F, 0.75F);
			left2.addVertex(2, 0.750F, 0.50F, 0.75F);
			left2.addVertex(3, 0.750F, 0.25F, 0.75F);
			
			Quad back1 = new Quad(3, subTex);
			back1.addVertex(0, 0.75F, 0.0F, 0.75F);
			back1.addVertex(1, 0.75F, 0.5F, 0.75F);
			back1.addVertex(2, 0.75F, 0.5F, 0.25F);
			back1.addVertex(3, 0.75F, 0.0F, 0.25F);
			
			Quad right1 = new Quad(4, subTex);
			right1.addVertex(3, 0.25F, 0.00F, 0.25F);
			right1.addVertex(2, 0.25F, 0.25F, 0.25F);
			right1.addVertex(1, 0.75F, 0.25F, 0.25F);
			right1.addVertex(0, 0.75F, 0.00F, 0.25F);
			
			Quad right2 = new Quad(5, subTex);
			right2.addVertex(3, 0.500F, 0.25F, 0.25F);
			right2.addVertex(2, 0.625F, 0.50F, 0.25F);
			right2.addVertex(1, 0.750F, 0.50F, 0.25F);
			right2.addVertex(0, 0.750F, 0.25F, 0.25F);
			
			Quad front1 = new Quad(6, frontt2);
			front1.addVertex(1, 0.500F, 0.25F, 0.25F);
			front1.addVertex(2, 0.625F, 0.50F, 0.25F);
			front1.addVertex(3, 0.625F, 0.50F, 0.75F);
			front1.addVertex(0, 0.500F, 0.25F, 0.75F);
			
			Quad front2 = new Quad(7, front);
			front2.addVertex(1, 0.25F, 0.00F, 0.25F);
			front2.addVertex(2, 0.25F, 0.25F, 0.25F);
			front2.addVertex(3, 0.75F, 0.25F, 0.25F);
			front2.addVertex(0, 0.75F, 0.00F, 0.25F);
			
			Quad top1 = new Quad(8, subTex);
			top1.addVertex(3, 0.25F, 0.25F, 0.75F);
			top1.addVertex(2, 0.50F, 0.25F, 0.75F);
			top1.addVertex(1, 0.50F, 0.25F, 0.25F);
			top1.addVertex(0, 0.25F, 0.25F, 0.25F);
			
			Quad top2 = new Quad(9, subTex);
			top2.addVertex(3, 0.625F, 0.5F, 0.75F);
			top2.addVertex(2, 0.750F, 0.5F, 0.75F);
			top2.addVertex(1, 0.750F, 0.5F, 0.25F);
			top2.addVertex(0, 0.625F, 0.5F, 0.25F);
			
			this.setQuad(bottom1).setQuad(left1).setQuad(left2).setQuad(front1).setQuad(front2).setQuad(right1).setQuad(right2).setQuad(back1).setQuad(top1).setQuad(top2);
		}else if(dir == "South"){
			setBoundingBox(0, 0, 0, 1, 1, 1).setQuadNumber(10);
			setTexture(plugin, texture.getTexture()).setMinBrightness(1F).setMaxBrightness(1F);
			SubTexture subTex = texture.getSubTexture(0);
			SubTexture front = texture.getSubTexture(1);
			SubTexture frontt2 = texture.getSubTexture(2);
			
			Quad bottom1 = new Quad(0, subTex);
			
			bottom1.addVertex(3, 0.25F, 0F, 0.75F);
			bottom1.addVertex(2, 0.75F, 0F, 0.75F);
			bottom1.addVertex(1, 0.75F, 0F, 0.25F);
			bottom1.addVertex(0, 0.25F, 0F, 0.25F);
			
			Quad left1 = new Quad(1, subTex);
			left1.addVertex(0, 0.75F, 0.00F, 0.25F);
			left1.addVertex(1, 0.75F, 0.25F, 0.25F);
			left1.addVertex(2, 0.75F, 0.25F, 0.75F);
			left1.addVertex(3, 0.75F, 0.00F, 0.75F);
			
			Quad left2 = new Quad(2, subTex);
			left2.addVertex(0, 0.75F, 0.25F, 0.500F);
			left2.addVertex(1, 0.75F, 0.50F, 0.625F);
			left2.addVertex(2, 0.75F, 0.50F, 0.750F);
			left2.addVertex(3, 0.75F, 0.25F, 0.750F);
			
			Quad back1 = new Quad(3, subTex);
			back1.addVertex(0, 0.75F, 0.0F, 0.75F);
			back1.addVertex(1, 0.75F, 0.5F, 0.75F);
			back1.addVertex(2, 0.25F, 0.5F, 0.75F);
			back1.addVertex(3, 0.25F, 0.0F, 0.75F);
			
			Quad right1 = new Quad(4, subTex);
			right1.addVertex(3, 0.25F, 0.00F, 0.25F);
			right1.addVertex(2, 0.25F, 0.25F, 0.25F);
			right1.addVertex(1, 0.25F, 0.25F, 0.75F);
			right1.addVertex(0, 0.25F, 0.00F, 0.75F);
			
			Quad right2 = new Quad(5, subTex);
			right2.addVertex(3, 0.25F, 0.25F, 0.500F);
			right2.addVertex(2, 0.25F, 0.50F, 0.625F);
			right2.addVertex(1, 0.25F, 0.50F, 0.750F);
			right2.addVertex(0, 0.25F, 0.25F, 0.750F);
			
			Quad front1 = new Quad(6, frontt2);
			front1.addVertex(1, 0.25F, 0.25F, 0.500F);
			front1.addVertex(2, 0.25F, 0.50F, 0.625F);
			front1.addVertex(3, 0.75F, 0.50F, 0.625F);
			front1.addVertex(0, 0.75F, 0.25F, 0.500F);
			
			Quad front2 = new Quad(7, front);
			front2.addVertex(1, 0.25F, 0.00F, 0.25F);
			front2.addVertex(2, 0.25F, 0.25F, 0.25F);
			front2.addVertex(3, 0.75F, 0.25F, 0.25F);
			front2.addVertex(0, 0.75F, 0.00F, 0.25F);
			
			Quad top1 = new Quad(8, subTex);
			top1.addVertex(3, 0.75F, 0.25F, 0.25F);
			top1.addVertex(2, 0.75F, 0.25F, 0.50F);
			top1.addVertex(1, 0.25F, 0.25F, 0.50F);
			top1.addVertex(0, 0.25F, 0.25F, 0.25F);
			
			Quad top2 = new Quad(9, subTex);
			top2.addVertex(3, 0.75F, 0.5F, 0.625F);
			top2.addVertex(2, 0.75F, 0.5F, 0.750F);
			top2.addVertex(1, 0.25F, 0.5F, 0.750F);
			top2.addVertex(0, 0.25F, 0.5F, 0.625F);
			
			this.setQuad(bottom1).setQuad(left1).setQuad(left2).setQuad(front1).setQuad(front2).setQuad(right1).setQuad(right2).setQuad(back1).setQuad(top1).setQuad(top2);
		}
	}
}
