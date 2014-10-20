package me.duckdoom5.RpgEssentials.customdesigns;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgeManager;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.Quad;
import org.getspout.spoutapi.block.design.SubTexture;
import org.getspout.spoutapi.block.design.Texture;

public final class CustomAltarDesign extends GenericBlockDesign {
    public CustomAltarDesign(RpgEssentials plugin) {
        final Texture texture = RpgeManager.getInstance().misc;
        setBoundingBox(0, 0, 0, 1, 1, 1).setQuadNumber(11);
        setTexture(plugin, texture.getTexture()).setMinBrightness(1F).setMaxBrightness(1F);
        final SubTexture subTex = texture.getSubTexture(3);
        final SubTexture front = texture.getSubTexture(4);
        final SubTexture back = texture.getSubTexture(5);
        final SubTexture bottom = texture.getSubTexture(6);

        final Quad bottom1 = new Quad(0, subTex);
        // I X Y Z 1F= full block
        bottom1.addVertex(0, 0.25F, 0.02F, 0.875F);// rf
        bottom1.addVertex(1, 0.75F, 0.02F, 0.875F);// rb
        bottom1.addVertex(2, 0.75F, 0.02F, 0.125F);// lb
        bottom1.addVertex(3, 0.25F, 0.02F, 0.125F);// lf

        final Quad bottom2 = new Quad(1, bottom);
        // I X Y Z
        bottom2.addVertex(3, 0.25F, 0.0F, 0.875F);// lf
        bottom2.addVertex(2, 0.75F, 0.0F, 0.875F);// lb
        bottom2.addVertex(1, 0.75F, 0.0F, 0.125F);// rb
        bottom2.addVertex(0, 0.25F, 0.0F, 0.125F);// rf

        final Quad left1 = new Quad(2, subTex);
        left1.addVertex(0, 0.25F, 0.0F, 0.125F);// f
        left1.addVertex(1, 0.75F, 0.0F, 0.125F);// b
        left1.addVertex(2, 0.75F, 0.5F, 0.125F);// b
        left1.addVertex(3, 0.25F, 0.5F, 0.125F);// f

        final Quad left2 = new Quad(3, subTex);
        left2.addVertex(3, 0.25F, 0.0F, 0.125F);
        left2.addVertex(2, 0.75F, 0.0F, 0.125F);
        left2.addVertex(1, 0.75F, 0.5F, 0.125F);
        left2.addVertex(0, 0.25F, 0.5F, 0.125F);

        final Quad back1 = new Quad(4, subTex);
        back1.addVertex(0, 0.75F, 0.0F, 0.125F);
        back1.addVertex(1, 0.75F, 0.0F, 0.875F);
        back1.addVertex(2, 0.75F, 0.5F, 0.875F);
        back1.addVertex(3, 0.75F, 0.5F, 0.125F);

        final Quad back2 = new Quad(5, back);
        back2.addVertex(3, 0.75F, 0.0F, 0.125F);
        back2.addVertex(2, 0.75F, 0.0F, 0.875F);
        back2.addVertex(1, 0.75F, 0.5F, 0.875F);
        back2.addVertex(0, 0.75F, 0.5F, 0.125F);

        final Quad right1 = new Quad(6, subTex);
        right1.addVertex(0, 0.25F, 0F, 0.875F);
        right1.addVertex(1, 0.75F, 0F, 0.875F);
        right1.addVertex(2, 0.75F, 0.5F, 0.875F);
        right1.addVertex(3, 0.25F, 0.5F, 0.875F);

        final Quad right2 = new Quad(7, subTex);
        right2.addVertex(3, 0.25F, 0F, 0.875F);
        right2.addVertex(2, 0.75F, 0F, 0.875F);
        right2.addVertex(1, 0.75F, 0.5F, 0.875F);
        right2.addVertex(0, 0.25F, 0.5F, 0.875F);

        final Quad front1 = new Quad(8, front);
        front1.addVertex(1, 0.25F, 0F, 0.125F);
        front1.addVertex(2, 0.25F, 0F, 0.875F);
        front1.addVertex(3, 0.25F, 0.5F, 0.875F);
        front1.addVertex(0, 0.25F, 0.5F, 0.125F);

        final Quad top1 = new Quad(9, subTex);
        top1.addVertex(0, 0.75F, 0.5F, 0.125F);
        top1.addVertex(1, 0.75F, 0.5F, 0.875F);
        top1.addVertex(2, 0.25F, 0.5F, 0.875F);
        top1.addVertex(3, 0.25F, 0.5F, 0.125F);

        final Quad top2 = new Quad(10, subTex);
        top2.addVertex(3, 0.75F, 0.5F, 0.125F);
        top2.addVertex(2, 0.75F, 0.5F, 0.875F);
        top2.addVertex(1, 0.25F, 0.5F, 0.875F);
        top2.addVertex(0, 0.25F, 0.5F, 0.125F);

        this.setQuad(bottom1).setQuad(bottom2).setQuad(left1).setQuad(left2).setQuad(front1).setQuad(right2).setQuad(right1).setQuad(back1).setQuad(back2).setQuad(top1).setQuad(top2);
    }
}
