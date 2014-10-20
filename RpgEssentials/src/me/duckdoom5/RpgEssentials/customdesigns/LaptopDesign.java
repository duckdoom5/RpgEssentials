package me.duckdoom5.RpgEssentials.customdesigns;

import me.duckdoom5.RpgEssentials.RpgEssentials;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.Quad;
import org.getspout.spoutapi.block.design.SubTexture;
import org.getspout.spoutapi.block.design.Texture;

public class LaptopDesign extends GenericBlockDesign {
    public LaptopDesign(RpgEssentials plugin, Texture texture, String dir) {
        if (dir.equals("East")) {
            setBoundingBox(0, 0, 0, 1, 1, 1).setQuadNumber(10);
            setTexture(plugin, texture.getTexture()).setMinBrightness(1F).setMaxBrightness(1F);
            final SubTexture subTex = texture.getSubTexture(0);
            final SubTexture front = texture.getSubTexture(3);
            final SubTexture frontt2 = texture.getSubTexture(4);

            final Quad bottom1 = new Quad(0, subTex);
            bottom1.addVertex(3, 0.25F, 0F, 0.75F);
            bottom1.addVertex(2, 0.75F, 0F, 0.75F);
            bottom1.addVertex(1, 0.75F, 0F, 0.25F);
            bottom1.addVertex(0, 0.25F, 0F, 0.25F);

            final Quad left1 = new Quad(1, subTex);
            left1.addVertex(0, 0.75F, 0.000F, 0.25F);
            left1.addVertex(1, 0.75F, 0.125F, 0.25F);
            left1.addVertex(2, 0.75F, 0.125F, 0.625F);
            left1.addVertex(3, 0.75F, 0.000F, 0.75F);

            final Quad left2 = new Quad(2, subTex);
            left2.addVertex(3, 0.75F, 0.25F, 0.500F);
            left2.addVertex(2, 0.75F, 0.50F, 0.375F);
            left2.addVertex(1, 0.75F, 0.50F, 0.250F);
            left2.addVertex(0, 0.75F, 0.25F, 0.250F);

            final Quad back1 = new Quad(3, subTex);
            back1.addVertex(3, 0.75F, 0.000F, 0.25F);
            back1.addVertex(2, 0.75F, 0.125F, 0.25F);
            back1.addVertex(1, 0.25F, 0.125F, 0.25F);
            back1.addVertex(0, 0.25F, 0.000F, 0.25F);

            final Quad back2 = new Quad(3, subTex);
            back2.addVertex(3, 0.75F, 0.000F, 0.25F);
            back2.addVertex(2, 0.75F, 0.125F, 0.25F);
            back2.addVertex(1, 0.25F, 0.125F, 0.25F);
            back2.addVertex(0, 0.25F, 0.000F, 0.25F);

            final Quad right1 = new Quad(4, subTex);
            right1.addVertex(3, 0.25F, 0.00F, 0.25F);
            right1.addVertex(2, 0.25F, 0.25F, 0.25F);
            right1.addVertex(1, 0.25F, 0.25F, 0.625F);
            right1.addVertex(0, 0.25F, 0.00F, 0.75F);

            final Quad right2 = new Quad(5, subTex);
            right2.addVertex(1, 0.25F, 0.125F, 0.625F);
            right2.addVertex(2, 0.25F, 0.875F, 0.875F);
            right2.addVertex(3, 0.25F, 0.875F, 0.875F);
            right2.addVertex(0, 0.25F, 0.125F, 0.625F);

            final Quad front2 = new Quad(6, frontt2);
            front2.addVertex(3, 0.25F, 0.125F, 0.375F);
            front2.addVertex(2, 0.25F, 0.625F, 0.125F);
            front2.addVertex(1, 0.75F, 0.625F, 0.125F);
            front2.addVertex(0, 0.75F, 0.125F, 0.375F);

            final Quad front1 = new Quad(7, front);
            front1.addVertex(1, 0.25F, 0.000F, 0.75F);
            front1.addVertex(0, 0.25F, 0.125F, 0.75F);
            front1.addVertex(3, 0.75F, 0.125F, 0.75F);
            front1.addVertex(2, 0.75F, 0.000F, 0.75F);

            final Quad top1 = new Quad(8, subTex);
            top1.addVertex(0, 0.75F, 0.125F, 0.75F);
            top1.addVertex(1, 0.75F, 0.125F, 0.25F);
            top1.addVertex(2, 0.25F, 0.125F, 0.25F);
            top1.addVertex(3, 0.25F, 0.125F, 0.75F);

            final Quad top2 = new Quad(9, subTex);
            top2.addVertex(1, 0.75F, 0.625F, 0.125F);
            top2.addVertex(2, 0.75F, 0.625F, 0.000F);
            top2.addVertex(3, 0.25F, 0.625F, 0.000F);
            top2.addVertex(0, 0.25F, 0.625F, 0.125F);

            this.setQuad(bottom1).setQuad(left1).setQuad(left2).setQuad(front1).setQuad(front2).setQuad(right1).setQuad(right2).setQuad(back1).setQuad(back2).setQuad(top1).setQuad(top2);
        } else if (dir.equals("West")) {
            setBoundingBox(0, 0, 0, 1, 1, 1).setQuadNumber(10);
            setTexture(plugin, texture.getTexture()).setMinBrightness(1F).setMaxBrightness(1F);
            final SubTexture subTex = texture.getSubTexture(0);
            final SubTexture front = texture.getSubTexture(1);
            final SubTexture frontt2 = texture.getSubTexture(2);

            final Quad bottom1 = new Quad(0, subTex);

            bottom1.addVertex(3, 0.25F, 0F, 0.75F);
            bottom1.addVertex(2, 0.75F, 0F, 0.75F);
            bottom1.addVertex(1, 0.75F, 0F, 0.25F);
            bottom1.addVertex(0, 0.25F, 0F, 0.25F);

            final Quad left1 = new Quad(1, subTex);
            left1.addVertex(0, 0.75F, 0.00F, 0.25F);
            left1.addVertex(1, 0.75F, 0.25F, 0.25F);
            left1.addVertex(2, 0.75F, 0.25F, 0.75F);
            left1.addVertex(3, 0.75F, 0.00F, 0.75F);

            final Quad left2 = new Quad(2, subTex);
            left2.addVertex(0, 0.75F, 0.25F, 0.500F);
            left2.addVertex(1, 0.75F, 0.50F, 0.625F);
            left2.addVertex(2, 0.75F, 0.50F, 0.750F);
            left2.addVertex(3, 0.75F, 0.25F, 0.750F);

            final Quad back1 = new Quad(3, subTex);
            back1.addVertex(0, 0.75F, 0.0F, 0.75F);
            back1.addVertex(1, 0.75F, 0.5F, 0.75F);
            back1.addVertex(2, 0.25F, 0.5F, 0.75F);
            back1.addVertex(3, 0.25F, 0.0F, 0.75F);

            final Quad right1 = new Quad(4, subTex);
            right1.addVertex(3, 0.25F, 0.00F, 0.25F);
            right1.addVertex(2, 0.25F, 0.25F, 0.25F);
            right1.addVertex(1, 0.25F, 0.25F, 0.75F);
            right1.addVertex(0, 0.25F, 0.00F, 0.75F);

            final Quad right2 = new Quad(5, subTex);
            right2.addVertex(3, 0.25F, 0.25F, 0.500F);
            right2.addVertex(2, 0.25F, 0.50F, 0.625F);
            right2.addVertex(1, 0.25F, 0.50F, 0.750F);
            right2.addVertex(0, 0.25F, 0.25F, 0.750F);

            final Quad front1 = new Quad(6, frontt2);
            front1.addVertex(1, 0.25F, 0.25F, 0.500F);
            front1.addVertex(2, 0.25F, 0.50F, 0.625F);
            front1.addVertex(3, 0.75F, 0.50F, 0.625F);
            front1.addVertex(0, 0.75F, 0.25F, 0.500F);

            final Quad front2 = new Quad(7, front);
            front2.addVertex(1, 0.25F, 0.00F, 0.25F);
            front2.addVertex(2, 0.25F, 0.25F, 0.25F);
            front2.addVertex(3, 0.75F, 0.25F, 0.25F);
            front2.addVertex(0, 0.75F, 0.00F, 0.25F);

            final Quad top1 = new Quad(8, subTex);
            top1.addVertex(3, 0.75F, 0.25F, 0.25F);
            top1.addVertex(2, 0.75F, 0.25F, 0.50F);
            top1.addVertex(1, 0.25F, 0.25F, 0.50F);
            top1.addVertex(0, 0.25F, 0.25F, 0.25F);

            final Quad top2 = new Quad(9, subTex);
            top2.addVertex(3, 0.75F, 0.5F, 0.625F);
            top2.addVertex(2, 0.75F, 0.5F, 0.750F);
            top2.addVertex(1, 0.25F, 0.5F, 0.750F);
            top2.addVertex(0, 0.25F, 0.5F, 0.625F);

            this.setQuad(bottom1).setQuad(left1).setQuad(left2).setQuad(front1).setQuad(front2).setQuad(right1).setQuad(right2).setQuad(back1).setQuad(top1).setQuad(top2);
        } else if (dir.equals("North")) {
            setBoundingBox(0, 0, 0, 1, 1, 1).setQuadNumber(10);
            setTexture(plugin, texture.getTexture()).setMinBrightness(1F).setMaxBrightness(1F);
            final SubTexture subTex = texture.getSubTexture(0);
            final SubTexture front = texture.getSubTexture(3);
            final SubTexture frontt2 = texture.getSubTexture(2);

            final Quad bottom1 = new Quad(0, subTex);

            bottom1.addVertex(3, 0.25F, 0F, 0.75F);
            bottom1.addVertex(2, 0.75F, 0F, 0.75F);
            bottom1.addVertex(1, 0.75F, 0F, 0.25F);
            bottom1.addVertex(0, 0.25F, 0F, 0.25F);

            final Quad left1 = new Quad(1, subTex);
            left1.addVertex(3, 0.25F, 0.00F, 0.75F);
            left1.addVertex(2, 0.25F, 0.25F, 0.75F);
            left1.addVertex(1, 0.75F, 0.25F, 0.75F);
            left1.addVertex(0, 0.75F, 0.00F, 0.75F);

            final Quad left2 = new Quad(2, subTex);
            left2.addVertex(3, 0.500F, 0.25F, 0.75F);
            left2.addVertex(2, 0.625F, 0.50F, 0.75F);
            left2.addVertex(1, 0.750F, 0.50F, 0.75F);
            left2.addVertex(0, 0.750F, 0.25F, 0.75F);

            final Quad back1 = new Quad(3, subTex);
            back1.addVertex(3, 0.75F, 0.0F, 0.75F);
            back1.addVertex(2, 0.75F, 0.5F, 0.75F);
            back1.addVertex(1, 0.75F, 0.5F, 0.25F);
            back1.addVertex(0, 0.75F, 0.0F, 0.25F);

            final Quad right1 = new Quad(4, subTex);
            right1.addVertex(0, 0.25F, 0.00F, 0.25F);
            right1.addVertex(1, 0.25F, 0.25F, 0.25F);
            right1.addVertex(2, 0.75F, 0.25F, 0.25F);
            right1.addVertex(3, 0.75F, 0.00F, 0.25F);

            final Quad right2 = new Quad(5, subTex);
            right2.addVertex(0, 0.500F, 0.25F, 0.25F);
            right2.addVertex(1, 0.625F, 0.50F, 0.25F);
            right2.addVertex(2, 0.750F, 0.50F, 0.25F);
            right2.addVertex(3, 0.750F, 0.25F, 0.25F);

            final Quad front1 = new Quad(6, frontt2);
            front1.addVertex(0, 0.500F, 0.25F, 0.25F);
            front1.addVertex(3, 0.625F, 0.50F, 0.25F);
            front1.addVertex(2, 0.625F, 0.50F, 0.75F);
            front1.addVertex(1, 0.500F, 0.25F, 0.75F);

            final Quad front2 = new Quad(7, front);
            front2.addVertex(3, 0.25F, 0.00F, 0.25F);
            front2.addVertex(2, 0.25F, 0.25F, 0.25F);
            front2.addVertex(1, 0.25F, 0.25F, 0.75F);
            front2.addVertex(0, 0.25F, 0.00F, 0.75F);

            final Quad top1 = new Quad(8, subTex);
            top1.addVertex(0, 0.25F, 0.25F, 0.75F);
            top1.addVertex(1, 0.50F, 0.25F, 0.75F);
            top1.addVertex(2, 0.50F, 0.25F, 0.25F);
            top1.addVertex(3, 0.25F, 0.25F, 0.25F);

            final Quad top2 = new Quad(9, subTex);
            top2.addVertex(0, 0.625F, 0.5F, 0.75F);
            top2.addVertex(1, 0.750F, 0.5F, 0.75F);
            top2.addVertex(2, 0.750F, 0.5F, 0.25F);
            top2.addVertex(3, 0.625F, 0.5F, 0.25F);

            this.setQuad(bottom1).setQuad(left1).setQuad(left2).setQuad(front1).setQuad(front2).setQuad(right1).setQuad(right2).setQuad(back1).setQuad(top1).setQuad(top2);
        } else if (dir.equals("South")) {
            setBoundingBox(0, 0, 0, 1, 1, 1).setQuadNumber(10);
            setTexture(plugin, texture.getTexture()).setMinBrightness(1F).setMaxBrightness(1F);
            final SubTexture subTex = texture.getSubTexture(0);
            final SubTexture front = texture.getSubTexture(3);
            final SubTexture frontt2 = texture.getSubTexture(4);

            final Quad bottom1 = new Quad(0, subTex);

            bottom1.addVertex(3, 0.25F, 0F, 0.75F);
            bottom1.addVertex(2, 0.75F, 0F, 0.75F);
            bottom1.addVertex(1, 0.75F, 0F, 0.25F);
            bottom1.addVertex(0, 0.25F, 0F, 0.25F);

            final Quad left1 = new Quad(1, subTex);
            left1.addVertex(3, 0.25F, 0.00F, 0.75F);
            left1.addVertex(2, 0.25F, 0.25F, 0.75F);
            left1.addVertex(1, 0.75F, 0.25F, 0.75F);
            left1.addVertex(0, 0.75F, 0.00F, 0.75F);

            final Quad left2 = new Quad(2, subTex);
            left2.addVertex(0, 0.500F, 0.25F, 0.75F);
            left2.addVertex(1, 0.375F, 0.50F, 0.75F);
            left2.addVertex(2, 0.250F, 0.50F, 0.75F);
            left2.addVertex(3, 0.250F, 0.25F, 0.75F);

            final Quad back1 = new Quad(3, subTex);
            back1.addVertex(0, 0.25F, 0.0F, 0.75F);
            back1.addVertex(1, 0.25F, 0.5F, 0.75F);
            back1.addVertex(2, 0.25F, 0.5F, 0.25F);
            back1.addVertex(3, 0.25F, 0.0F, 0.25F);

            final Quad right1 = new Quad(4, subTex);
            right1.addVertex(0, 0.25F, 0.00F, 0.25F);
            right1.addVertex(1, 0.25F, 0.25F, 0.25F);
            right1.addVertex(2, 0.75F, 0.25F, 0.25F);
            right1.addVertex(3, 0.75F, 0.00F, 0.25F);

            final Quad right2 = new Quad(5, subTex);
            right2.addVertex(3, 0.500F, 0.25F, 0.25F);
            right2.addVertex(2, 0.375F, 0.50F, 0.25F);
            right2.addVertex(1, 0.250F, 0.50F, 0.25F);
            right2.addVertex(0, 0.250F, 0.25F, 0.25F);

            final Quad front1 = new Quad(6, frontt2);
            front1.addVertex(0, 0.500F, 0.25F, 0.25F);
            front1.addVertex(1, 0.375F, 0.50F, 0.25F);
            front1.addVertex(2, 0.375F, 0.50F, 0.75F);
            front1.addVertex(3, 0.500F, 0.25F, 0.75F);

            final Quad front2 = new Quad(7, front);
            front2.addVertex(0, 0.75F, 0.00F, 0.25F);
            front2.addVertex(1, 0.75F, 0.25F, 0.25F);
            front2.addVertex(2, 0.75F, 0.25F, 0.75F);
            front2.addVertex(3, 0.75F, 0.00F, 0.75F);

            final Quad top1 = new Quad(8, subTex);
            top1.addVertex(3, 0.75F, 0.25F, 0.75F);
            top1.addVertex(2, 0.50F, 0.25F, 0.75F);
            top1.addVertex(1, 0.50F, 0.25F, 0.25F);
            top1.addVertex(0, 0.75F, 0.25F, 0.25F);

            final Quad top2 = new Quad(9, subTex);
            top2.addVertex(3, 0.375F, 0.5F, 0.75F);
            top2.addVertex(2, 0.250F, 0.5F, 0.75F);
            top2.addVertex(1, 0.250F, 0.5F, 0.25F);
            top2.addVertex(0, 0.375F, 0.5F, 0.25F);

            this.setQuad(bottom1).setQuad(left1).setQuad(left2).setQuad(front1).setQuad(front2).setQuad(right1).setQuad(right2).setQuad(back1).setQuad(top1).setQuad(top2);
        }
    }
}
