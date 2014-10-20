package me.duckdoom5.RpgEssentials.customdesigns;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.Quad;
import org.getspout.spoutapi.block.design.Texture;

public class CustomStairEdgeDesign extends GenericBlockDesign {

    public CustomStairEdgeDesign(RpgEssentials plugin, int[] textureids) {
        final Texture texture = RpgeManager.getInstance().stairs;
        setBoundingBox(0, 0, 0, 1, 1, 1).setQuadNumber(11);
        setTexture(plugin, texture.getTexture()).setMinBrightness(1F).setMaxBrightness(1F);

        final Quad bottom = new Quad(0, texture.getSubTexture(textureids[0]));
        bottom.addVertex(3, 0.0F, 0.0F, 0.0F);
        bottom.addVertex(0, 1.0F, 0.0F, 0.0F);
        bottom.addVertex(1, 1.0F, 0.0F, 1.0F);
        bottom.addVertex(2, 0.0F, 0.0F, 1.0F);

        final Quad front = new Quad(1, texture.getSubTexture(textureids[1]));
        front.addVertex(0, 0.0F, 0.0F, 0.0F);
        front.addVertex(1, 0.0F, 0.5F, 0.0F);
        front.addVertex(2, 1.0F, 0.5F, 0.0F);
        front.addVertex(3, 1.0F, 0.0F, 0.0F);

        final Quad fronttop = new Quad(2, texture.getSubTexture(textureids[2]));
        fronttop.addVertex(3, 0.5F, 0.5F, 0.5F);
        fronttop.addVertex(0, 0.5F, 1.0F, 0.5F);
        fronttop.addVertex(1, 1.0F, 1.0F, 0.5F);
        fronttop.addVertex(2, 1.0F, 0.5F, 0.5F);

        final Quad back = new Quad(3, texture.getSubTexture(textureids[1]));
        back.addVertex(3, 0.0F, 0.0F, 1.0F);
        back.addVertex(0, 1.0F, 0.0F, 1.0F);
        back.addVertex(1, 1.0F, 0.5F, 1.0F);
        back.addVertex(2, 0.0F, 0.5F, 1.0F);

        final Quad backtop = new Quad(4, texture.getSubTexture(textureids[2]));
        backtop.addVertex(3, 0.5F, 0.5F, 1.0F);
        backtop.addVertex(0, 1.0F, 0.5F, 1.0F);
        backtop.addVertex(1, 1.0F, 1.0F, 1.0F);
        backtop.addVertex(2, 0.5F, 1.0F, 1.0F);

        final Quad left = new Quad(5, texture.getSubTexture(textureids[1]));
        left.addVertex(0, 1.0F, 0.0F, 0.0F);
        left.addVertex(1, 1.0F, 0.5F, 0.0F);
        left.addVertex(2, 1.0F, 0.5F, 1.0F);
        left.addVertex(3, 1.0F, 0.0F, 1.0F);

        final Quad lefttop = new Quad(6, texture.getSubTexture(textureids[2]));
        lefttop.addVertex(0, 1.0F, 0.5F, 0.5F);
        lefttop.addVertex(1, 1.0F, 1.0F, 0.5F);
        lefttop.addVertex(2, 1.0F, 1.0F, 1.0F);
        lefttop.addVertex(3, 1.0F, 0.5F, 1.0F);

        final Quad right = new Quad(7, texture.getSubTexture(textureids[1]));
        right.addVertex(3, 0.0F, 0.0F, 0.0F);
        right.addVertex(2, 0.0F, 0.5F, 0.0F);
        right.addVertex(1, 0.0F, 0.5F, 1.0F);
        right.addVertex(0, 0.0F, 0.0F, 1.0F);

        final Quad righttop = new Quad(8, texture.getSubTexture(textureids[2]));
        righttop.addVertex(3, 0.5F, 0.5F, 0.5F);
        righttop.addVertex(2, 0.5F, 1.0F, 0.5F);
        righttop.addVertex(1, 0.5F, 1.0F, 1.0F);
        righttop.addVertex(0, 0.5F, 0.5F, 1.0F);

        final Quad top1 = new Quad(9, texture.getSubTexture(textureids[0]));
        top1.addVertex(2, 0.0F, 0.5F, 0.0F);
        top1.addVertex(1, 1.0F, 0.5F, 0.0F);
        top1.addVertex(0, 1.0F, 0.5F, 1.0F);
        top1.addVertex(3, 0.0F, 0.5F, 1.0F);

        final Quad top2 = new Quad(10, texture.getSubTexture(textureids[2]));
        top2.addVertex(2, 0.5F, 1.0F, 0.5F);
        top2.addVertex(1, 1.0F, 1.0F, 0.5F);
        top2.addVertex(0, 1.0F, 1.0F, 1.0F);
        top2.addVertex(3, 0.5F, 1.0F, 1.0F);

        this.setQuad(bottom).setQuad(front).setQuad(back).setQuad(left).setQuad(right).setQuad(top1);
        this.setQuad(backtop).setQuad(fronttop).setQuad(lefttop).setQuad(righttop).setQuad(top2);
    }
}