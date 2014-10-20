package me.duckdoom5.RpgEssentials.customdesigns;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.Quad;
import org.getspout.spoutapi.block.design.Texture;

public class RailsDesign extends GenericBlockDesign {

    public RailsDesign(RpgEssentials plugin, int[] textureids) {
        final Texture texture = RpgeManager.getInstance().stairs;
        setBoundingBox(0, 0, 0, 1, 0.125F, 1).setQuadNumber(6);
        setTexture(plugin, texture.getTexture()).setMinBrightness(0F).setMaxBrightness(0F);

        final Quad bottom = new Quad(0, texture.getSubTexture(textureids[0]));
        bottom.addVertex(3, 0.0F, 0.0F, 0.0F);
        bottom.addVertex(0, 1.0F, 0.0F, 0.0F);
        bottom.addVertex(1, 1.0F, 0.0F, 1.0F);
        bottom.addVertex(2, 0.0F, 0.0F, 1.0F);

        final Quad front = new Quad(1, texture.getSubTexture(textureids[1]));
        front.addVertex(3, 0.0F, 0.000F, 1.0F);
        front.addVertex(2, 0.0F, 0.125F, 1.0F);
        front.addVertex(1, 1.0F, 0.125F, 1.0F);
        front.addVertex(0, 1.0F, 0.000F, 1.0F);

        final Quad back = new Quad(2, texture.getSubTexture(textureids[2]));
        back.addVertex(2, 0.0F, 0.0F, 0.0F);
        back.addVertex(1, 1.0F, 0.0F, 0.0F);
        back.addVertex(0, 1.0F, 1.0F, 0.0F);
        back.addVertex(3, 0.0F, 1.0F, 0.0F);

        final Quad left = new Quad(3, texture.getSubTexture(textureids[3]));
        left.addVertex(0, 1.0F, 0.000F, 0.0F);
        left.addVertex(1, 1.0F, 0.125F, 0.0F);
        left.addVertex(2, 1.0F, 0.125F, 1.0F);
        left.addVertex(3, 1.0F, 0.000F, 1.0F);

        final Quad right = new Quad(4, texture.getSubTexture(textureids[4]));
        right.addVertex(3, 0.0F, 0.000F, 0.0F);
        right.addVertex(2, 0.0F, 0.125F, 0.0F);
        right.addVertex(1, 0.0F, 0.125F, 1.0F);
        right.addVertex(0, 0.0F, 0.000F, 1.0F);

        final Quad top = new Quad(5, texture.getSubTexture(textureids[5]));
        top.addVertex(2, 0.0F, 0.125F, 0.0F);
        top.addVertex(1, 1.0F, 0.125F, 0.0F);
        top.addVertex(0, 1.0F, 0.125F, 1.0F);
        top.addVertex(3, 0.0F, 0.125F, 1.0F);

        this.setQuad(bottom).setQuad(front).setQuad(back).setQuad(left).setQuad(right).setQuad(top);
    }
}