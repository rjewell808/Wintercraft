// Date: 12/13/2013 12:53:50 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package gruntpie224.wintercraft.render.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelAntlers extends ModelBiped
{

  //fields 
    ModelRenderer hornbase1;
    ModelRenderer hornbase2;
    ModelRenderer horn;
    ModelRenderer horn1;
    ModelRenderer horn2;
    ModelRenderer horn3;
    ModelRenderer hornlong1;
    ModelRenderer point1;
    ModelRenderer point2;
    ModelRenderer point3;
    ModelRenderer point4;
    ModelRenderer point5;
    ModelRenderer point6;
    ModelRenderer point7;
    ModelRenderer hornlong2;
    ModelRenderer point1b;
    ModelRenderer point2b;
    ModelRenderer point3b;
    ModelRenderer point4b;
    ModelRenderer point5b;
    ModelRenderer point6b;
    ModelRenderer point7b;
    protected float field_78145_g = 8.0F;
    protected float field_78151_h = 4.0F;
  
  public ModelAntlers(float f, float xOff, float yOff,float zOff)
  {
	super(f);  
    textureWidth = 64;
    textureHeight = 128;
    
      hornbase1 = new ModelRenderer(this, 0, 0);
      hornbase1.addBox(0F, 0F, 0F, 1, 2, 1);
      hornbase1.setRotationPoint(0F+xOff, -5F+yOff, -13F+zOff);
      hornbase1.setTextureSize(64, 128);
      hornbase1.mirror = true;
      setRotation(hornbase1, 0.1570796F, 0F, 0F);
      hornbase2 = new ModelRenderer(this, 0, 0);
      hornbase2.addBox(0F, 0F, 0F, 1, 2, 1);
      hornbase2.setRotationPoint(-4F+xOff, -5F+yOff, -13F+zOff);
      hornbase2.setTextureSize(64, 128);
      hornbase2.mirror = true;
      setRotation(hornbase2, 0.1570796F, 0F, 0F);
      horn = new ModelRenderer(this, 0, 0);
      horn.addBox(0F, 0F, 0F, 1, 1, 3);
      horn.setRotationPoint(0F+xOff, -5F+yOff, -14F+zOff);
      horn.setTextureSize(64, 128);
      horn.mirror = true;
      setRotation(horn, 0.5410521F, 0F, 0F);
      horn1 = new ModelRenderer(this, 0, 0);
      horn1.addBox(0F, 0F, 0F, 1, 1, 3);
      horn1.setRotationPoint(-4F+xOff, -5F+yOff, -14F+zOff);
      horn1.setTextureSize(64, 128);
      horn1.mirror = true;
      setRotation(horn1, 0.5410521F, 0F, 0F);
      horn2 = new ModelRenderer(this, 0, 0);
      horn2.addBox(0F, 0F, 0F, 1, 2, 1);
      horn2.setRotationPoint(0F+xOff, -5F+yOff, -15.2F+zOff);
      horn2.setTextureSize(64, 128);
      horn2.mirror = true;
      setRotation(horn2, 1.134464F, 0F, 0F);
      horn3 = new ModelRenderer(this, 0, 0);
      horn3.addBox(0F, 0F, 0F, 1, 2, 1);
      horn3.setRotationPoint(-4F+xOff, -5F+yOff, -15.2F+zOff);
      horn3.setTextureSize(64, 128);
      horn3.mirror = true;
      setRotation(horn3, 1.134464F, 0F, 0F);
      hornlong1 = new ModelRenderer(this, 0, 0);
      hornlong1.addBox(0F, 0F, 0F, 1, 9, 1);
      hornlong1.setRotationPoint(0F+xOff, -12.8F+yOff, -5.5F+zOff);
      hornlong1.setTextureSize(64, 128);
      hornlong1.mirror = true;
      setRotation(hornlong1, -0.7679449F, 0F, 0F);
      point1 = new ModelRenderer(this, 0, 0);
      point1.addBox(0F, 0F, 0F, 1, 4, 1);
      point1.setRotationPoint(0F+xOff, -16.2F+yOff, -4.6F+zOff);
      point1.setTextureSize(64, 128);
      point1.mirror = true;
      setRotation(point1, -0.2792527F, 0F, 0F);
      point2 = new ModelRenderer(this, 0, 0);
      point2.addBox(0F, 0F, 0F, 1, 4, 1);
      point2.setRotationPoint(0F+xOff, -15.5F+yOff, -7.3F+zOff);
      point2.setTextureSize(64, 128);
      point2.mirror = true;
      setRotation(point2, 0.3490659F, 0F, 0F);
      point3 = new ModelRenderer(this, 0, 0);
      point3.addBox(0F, 0F, 0F, 1, 2, 1);
      point3.setRotationPoint(0F+xOff, -14F+yOff, -6F+zOff);
      point3.setTextureSize(64, 128);
      point3.mirror = true;
      setRotation(point3, -1.919862F, 0F, 0F);
      point4 = new ModelRenderer(this, 0, 0);
      point4.addBox(0F, 0F, 0F, 1, 3, 1);
      point4.setRotationPoint(0F+xOff, -12.5F+yOff, -9F+zOff);
      point4.setTextureSize(64, 128);
      point4.mirror = true;
      setRotation(point4, 0.418879F, 0F, 0F);
      point5 = new ModelRenderer(this, 0, 0);
      point5.addBox(0F, 0F, 0F, 1, 2, 1);
      point5.setRotationPoint(0F+xOff, -11F+yOff, -9.7F+zOff);
      point5.setTextureSize(64, 128);
      point5.mirror = true;
      setRotation(point5, 1.099557F, 0.0174533F, 0F);
      point6 = new ModelRenderer(this, 0, 0);
      point6.addBox(0F, 0F, 0F, 1, 2, 1);
      point6.setRotationPoint(0F+xOff, -8F+yOff, -12F+zOff);
      point6.setTextureSize(64, 128);
      point6.mirror = true;
      setRotation(point6, 0F, 0F, 0F);
      point7 = new ModelRenderer(this, 0, 0);
      point7.addBox(0F, 0F, 0F, 1, 2, 1);
      point7.setRotationPoint(0F+xOff, -10F+yOff, -10.5F+zOff);
      point7.setTextureSize(64, 128);
      point7.mirror = true;
      setRotation(point7, 0.6108652F, 0F, 0F);
      hornlong2 = new ModelRenderer(this, 0, 0);
      hornlong2.addBox(0F, 0F, 0F, 1, 9, 1);
      hornlong2.setRotationPoint(-4F+xOff, -13F+yOff, -5.4F+zOff);
      hornlong2.setTextureSize(64, 128);
      hornlong2.mirror = true;
      setRotation(hornlong2, -0.7679449F, 0F, 0F);
      point1b = new ModelRenderer(this, 0, 0);
      point1b.addBox(0F, 0F, 0F, 1, 4, 1);
      point1b.setRotationPoint(-4F+xOff, -16.3F+yOff, -4.6F+zOff);
      point1b.setTextureSize(64, 128);
      point1b.mirror = true;
      setRotation(point1b, -0.2792527F, 0F, 0F);
      point2b = new ModelRenderer(this, 0, 0);
      point2b.addBox(0F, 0F, 0F, 1, 2, 1);
      point2b.setRotationPoint(-4F+xOff, -8F+yOff, -12F+zOff);
      point2b.setTextureSize(64, 128);
      point2b.mirror = true;
      setRotation(point2b, 0F, 0F, 0F);
      point3b = new ModelRenderer(this, 0, 0);
      point3b.addBox(0F, 0F, 0F, 1, 2, 1);
      point3b.setRotationPoint(-4F+xOff, -10F+yOff, -10.5F+zOff);
      point3b.setTextureSize(64, 128);
      point3b.mirror = true;
      setRotation(point3b, 0.6108652F, 0F, 0F);
      point4b = new ModelRenderer(this, 0, 0);
      point4b.addBox(0F, 0F, 0F, 1, 3, 1);
      point4b.setRotationPoint(-4F+xOff, -12.5F+yOff, -9F+zOff);
      point4b.setTextureSize(64, 128);
      point4b.mirror = true;
      setRotation(point4b, 0.418879F, 0F, 0F);
      point5b = new ModelRenderer(this, 0, 0);
      point5b.addBox(0F, 0F, 0F, 1, 2, 1);
      point5b.setRotationPoint(-4F+xOff, -11F+yOff, -9.7F+zOff);
      point5b.setTextureSize(64, 128);
      point5b.mirror = true;
      setRotation(point5b, 1.099557F, 0F, 0F);
      point6b = new ModelRenderer(this, 0, 0);
      point6b.addBox(0F, 0F, 0F, 1, 4, 1);
      point6b.setRotationPoint(-4F+xOff, -15.5F+yOff, -7.3F+zOff);
      point6b.setTextureSize(64, 128);
      point6b.mirror = true;
      setRotation(point6b, 0.3490659F, 0F, 0F);
      point7b = new ModelRenderer(this, 0, 0);
      point7b.addBox(0F, 0F, 0F, 1, 2, 1);
      point7b.setRotationPoint(-4F+xOff, -14F+yOff, -6F+zOff);
      point7b.setTextureSize(64, 128);
      point7b.mirror = true;
      setRotation(point7b, -1.919862F, 0F, 0F);
      
      this.bipedHead.addChild(horn);
      this.bipedHead.addChild(horn1);
      this.bipedHead.addChild(horn2);
      this.bipedHead.addChild(horn3);
      this.bipedHead.addChild(hornbase1);
      this.bipedHead.addChild(hornbase2);
      this.bipedHead.addChild(hornlong1);
      this.bipedHead.addChild(hornlong2);
      this.bipedHead.addChild(point1);
      this.bipedHead.addChild(point2);
      this.bipedHead.addChild(point3);
      this.bipedHead.addChild(point4);
      this.bipedHead.addChild(point5);
      this.bipedHead.addChild(point6);
      this.bipedHead.addChild(point7);
      this.bipedHead.addChild(point1b);
      this.bipedHead.addChild(point2b);
      this.bipedHead.addChild(point3b);
      this.bipedHead.addChild(point4b);
      this.bipedHead.addChild(point5b);
      this.bipedHead.addChild(point6b);
      this.bipedHead.addChild(point7b);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  

}
