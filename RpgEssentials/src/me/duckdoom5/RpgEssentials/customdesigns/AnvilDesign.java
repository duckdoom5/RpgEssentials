package me.duckdoom5.RpgEssentials.customdesigns;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.Quad;
import org.getspout.spoutapi.block.design.SubTexture;
import org.getspout.spoutapi.block.design.Texture;

public final class AnvilDesign extends GenericBlockDesign {
	public AnvilDesign(RpgEssentials plugin, Texture texture) {
		setBoundingBox(0, 0, 0.2F, 1, 0.5F, .8F).setQuadNumber(18);
		setTexture(plugin, texture.getTexture()).setMinBrightness(1F).setMaxBrightness(1F);
		SubTexture subTex = texture.getSubTexture(0);
		
		
		Quad base = new Quad(0, subTex);
		base.addVertex(0, 0F, 0F, 0.2F);
		base.addVertex(1, 1F, 0F, 0.2F);
		base.addVertex(2, 1F, 0F, 0.8F);
		base.addVertex(3, 0F, 0F, 0.8F);
		
		Quad left1 = new Quad(1, subTex);
		left1.addVertex(0, 0F, 0.15F, 0.2F);
		left1.addVertex(1, 1F, 0.15F, 0.2F);
		left1.addVertex(2, 1F, 0F, 0.2F);
		left1.addVertex(3, 0F, 0F, 0.2F);
		
		Quad top= new Quad(2, subTex);
		top.addVertex(0, 1F, 0F, 0.2F);
		top.addVertex(1, 1F, 0.15F, 0.2F);
		top.addVertex(2, 1F, 0.15F, 0.8F);
		top.addVertex(3, 1F, 0F, 0.8F);
		
		Quad right= new Quad(3, subTex);
		right.addVertex(0, 0F, 0F, 0.8F);
		right.addVertex(1, 1F, 0F, 0.8F);
		right.addVertex(2, 1F, 0.15F, 0.8F);
		right.addVertex(3, 0F, 0.15F, 0.8F);
		
		Quad bottom= new Quad(4, subTex);
		bottom.addVertex(0, 0F, 0F, 0.8F);
		bottom.addVertex(1, 0F, 0.15F, 0.8F);
		bottom.addVertex(2, 0F, 0.15F, 0.2F);
		bottom.addVertex(3, 0F, 0F, 0.2F);
		
		
		
		Quad fFront= new Quad(5, subTex);
		fFront.addVertex(0, 0F, 0.15F, 0.8F);
		fFront.addVertex(1, 0.3F, 0.35F, 0.65F);
		fFront.addVertex(2, 0.3F, 0.35F, 0.35F);
		fFront.addVertex(3, 0F, 0.15F, 0.2F);
		
		Quad fLeft= new Quad(6, subTex);
		fLeft.addVertex(0, 0F, 0.15F, 0.2F);
		fLeft.addVertex(1, 0.3F, 0.35F, 0.35F);
		fLeft.addVertex(2, 0.85F, 0.35F, 0.35F);
		fLeft.addVertex(3, 1F, 0.15F, 0.2F);
		
		Quad fTop= new Quad(7, subTex);
		fTop.addVertex(0, 1F, 0.15F, 0.2F);
		fTop.addVertex(1, .85F, 0.35F, 0.35F);
		fTop.addVertex(2, .85F, 0.35F, 0.65F);
		fTop.addVertex(3, 1F, 0.15F, 0.8F);
		
		Quad fRight= new Quad(8, subTex);
		fRight.addVertex(0, 1F, 0.15F, 0.8F);
		fRight.addVertex(1, 0.85F, 0.35F, 0.65F);
		fRight.addVertex(2, 0.3F, 0.35F, 0.65F);
		fRight.addVertex(3, 0F, 0.15F, 0.8F);
		
		Quad TopBase= new Quad(9, subTex);
		TopBase.addVertex(0, 1F, 0.5F, 0.7F);
		TopBase.addVertex(1, 1F, 0.5F, 0.3F);
		TopBase.addVertex(2, 0.2F, 0.5F, 0.3F);
		TopBase.addVertex(3, 0.2F, 0.5F, 0.7F);
		
		Quad TopSide= new Quad(10, subTex);
		TopSide.addVertex(0, 0.85F, 0.35F, 0.65F);
		TopSide.addVertex(1, 0.85F, 0.35F, 0.35F);
		TopSide.addVertex(2, 1F, 0.5F, 0.3F);
		TopSide.addVertex(3, 1F, 0.5F, 0.7F);
		
		Quad TopLeft= new Quad(11, subTex);
		TopLeft.addVertex(0, 0.85F, 0.35F, 0.35F);
		TopLeft.addVertex(1, 0.3F, 0.35F, 0.35F);
		TopLeft.addVertex(2, 0.2F, 0.5F, 0.3F);
		TopLeft.addVertex(3, 1F, 0.5F, 0.3F);
		
		Quad TopRight= new Quad(12, subTex);
		TopRight.addVertex(0, 1F, 0.5F, 0.7F);
		TopRight.addVertex(1, 0.2F, 0.5F, 0.7F);
		TopRight.addVertex(2, 0.3F, 0.35F, 0.65F);
		TopRight.addVertex(3, 0.85F, 0.35F, 0.65F);
		
		Quad TopTip= new Quad(13, subTex);
		TopTip.addVertex(0, 0.2F, 0.5F, 0.7F);
		TopTip.addVertex(1, 0.2F, 0.5F, 0.3F);
		TopTip.addVertex(2, 0F, 0.5F, 0.35F);
		TopTip.addVertex(3, 0F, 0.5F, 0.65F);
		
		Quad TopTipVert= new Quad(14, subTex);
		TopTipVert.addVertex(0, 0F, 0.5F, 0.65F);
		TopTipVert.addVertex(1, 0F, 0.5F, 0.35F);
		TopTipVert.addVertex(2, 0F, 0.4F, 0.35F);
		TopTipVert.addVertex(3, 0F, 0.4F, 0.65F);
		
		
		Quad TopUnderSide= new Quad(15, subTex);
		TopUnderSide.addVertex(0, 0F, 0.4F, 0.65F);
		TopUnderSide.addVertex(1, 0F, 0.4F, 0.35F);
		TopUnderSide.addVertex(2, 0.3F, 0.3F, 0.35F);
		TopUnderSide.addVertex(3, 0.3F, 0.3F, 0.65F);
		
		Quad TopLeftX= new Quad(16, subTex);
		TopLeftX.addVertex(0, 0F, 0.5F, 0.65F);
		TopLeftX.addVertex(1, 0F, 0.4F, 0.65F);
		TopLeftX.addVertex(2, 0.3F, 0.35F, 0.65F);
		TopLeftX.addVertex(3, 0.2F, 0.5F, 0.7F);
		
		Quad TopRightX= new Quad(17, subTex);
		TopRightX.addVertex(0, 0.2F, 0.5F, 0.3F);
		TopRightX.addVertex(1, 0.3F, 0.35F, 0.35F);
		TopRightX.addVertex(2, 0F, 0.4F, 0.35F);
		TopRightX.addVertex(3, 0F, 0.5F, 0.35F);
		
		this.setQuad(left1).setQuad(top).setQuad(right).setQuad(bottom).setQuad(fFront).setQuad(fLeft).setQuad(fTop).setQuad(fRight).setQuad(base).setQuad(TopBase).setQuad(TopSide).setQuad(TopLeft).setQuad(TopRight);
		this.setQuad(TopTip).setQuad(TopTipVert).setQuad(TopUnderSide).setQuad(TopLeftX).setQuad(TopRightX);
	}
}