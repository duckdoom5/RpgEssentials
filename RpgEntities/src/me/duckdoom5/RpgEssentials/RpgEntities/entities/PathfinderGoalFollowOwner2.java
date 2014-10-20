package me.duckdoom5.RpgEssentials.RpgEntities.entities;

import net.minecraft.server.v1_6_R3.EntityInsentient;
import net.minecraft.server.v1_6_R3.EntityLiving;
import net.minecraft.server.v1_6_R3.MathHelper;
import net.minecraft.server.v1_6_R3.Navigation;
import net.minecraft.server.v1_6_R3.PathfinderGoal;
import net.minecraft.server.v1_6_R3.World;

public class PathfinderGoalFollowOwner2 extends PathfinderGoal {
    private EntityInsentient d;
    private EntityLiving e;
    private World a;
    private double f;
    private Navigation g;
    private int h;
    private float b;
    private float c;
    private boolean i;

    public PathfinderGoalFollowOwner2(EntityInsentient entitytameableanimal, double d0, float f, float f1) {
        this.d = entitytameableanimal;
        this.a = entitytameableanimal.world;
        this.f = d0;
        this.g = entitytameableanimal.getNavigation();
        this.c = f;
        this.b = f1;
        this.a(3);
    }

    @Override
    public boolean a() {
        EntityLiving entityliving = ((EntityRpg)this.d).getOwner();

        if (entityliving == null) {
            return false;
        } else if (((EntityRpg)this.d).isSitting()) {
            return false;
        } else if (this.d.e(entityliving) < this.c * this.c) {
            return false;
        } else {
            this.e = entityliving;
            return true;
        }
    }

    @Override
    public boolean b() {
        return !this.g.g() && this.d.e(this.e) > this.b * this.b && !((EntityRpg)this.d).isSitting();
    }

    @Override
    public void c() {
        this.h = 0;
        this.i = this.d.getNavigation().a();
        this.d.getNavigation().a(false);
    }

    @Override
    public void d() {
        this.e = null;
        this.g.h();
        this.d.getNavigation().a(this.i);
    }

    @Override
    public void e() {
        this.d.getControllerLook().a(this.e, 10.0F, this.d.bp());
        if (!((EntityRpg)this.d).isSitting()) {
            if (--this.h <= 0) {
                this.h = 10;
                if (!this.g.a(this.e, this.f)) {
                    if (!this.d.bH()) {
                        if (this.d.e(this.e) >= 144.0D) {
                            int i = MathHelper.floor(this.e.locX) - 2;
                            int j = MathHelper.floor(this.e.locZ) - 2;
                            int k = MathHelper.floor(this.e.boundingBox.b);

                            for (int l = 0; l <= 4; ++l) {
                                for (int i1 = 0; i1 <= 4; ++i1) {
                                    if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && this.a.w(i + l, k - 1, j + i1) && !this.a.u(i + l, k, j + i1) && !this.a.u(i + l, k + 1, j + i1)) {
                                        this.d.setPositionRotation(i + l + 0.5F, k, j + i1 + 0.5F, this.d.yaw, this.d.pitch);
                                        this.g.h();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
