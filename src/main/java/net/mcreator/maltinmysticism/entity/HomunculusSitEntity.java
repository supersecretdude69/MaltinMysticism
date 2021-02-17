
package net.mcreator.maltinmysticism.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.maltinmysticism.MaltinmysticismModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@MaltinmysticismModElements.ModElement.Tag
public class HomunculusSitEntity extends MaltinmysticismModElements.ModElement {
	public static EntityType entity = null;
	public HomunculusSitEntity(MaltinmysticismModElements instance) {
		super(instance, 70);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("homunculus_sit")
						.setRegistryName("homunculus_sit");
		elements.entities.add(() -> entity);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelSit_HumunculusModel(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("maltinmysticism:textures/humunculustexture.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 1;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelSit_HumunculusModel extends EntityModel<Entity> {
		private final ModelRenderer TorsoGroup;
		private final ModelRenderer TorsoLower_r1;
		private final ModelRenderer Torso_r1;
		private final ModelRenderer Torso_r2;
		private final ModelRenderer Torso_r3;
		private final ModelRenderer Head;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer ArmRight;
		private final ModelRenderer cube_r4;
		private final ModelRenderer ArmRight2;
		private final ModelRenderer cube_r5;
		private final ModelRenderer FootOne;
		private final ModelRenderer FootOne2;
		public ModelSit_HumunculusModel() {
			textureWidth = 64;
			textureHeight = 64;
			TorsoGroup = new ModelRenderer(this);
			TorsoGroup.setRotationPoint(-0.025F, 13.25F, -0.25F);
			TorsoLower_r1 = new ModelRenderer(this);
			TorsoLower_r1.setRotationPoint(-0.075F, 4.25F, 3.25F);
			TorsoGroup.addChild(TorsoLower_r1);
			setRotationAngle(TorsoLower_r1, -0.7854F, 0.0F, 0.0F);
			TorsoLower_r1.setTextureOffset(20, 20).addBox(-3.0F, 1.5F, -2.5F, 6.0F, 7.0F, 4.0F, 0.0F, false);
			Torso_r1 = new ModelRenderer(this);
			Torso_r1.setRotationPoint(-3.475F, 1.25F, 3.65F);
			TorsoGroup.addChild(Torso_r1);
			setRotationAngle(Torso_r1, -0.48F, 0.0F, 0.0F);
			Torso_r1.setTextureOffset(36, 27).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			Torso_r2 = new ModelRenderer(this);
			Torso_r2.setRotationPoint(1.525F, 5.25F, 3.15F);
			TorsoGroup.addChild(Torso_r2);
			setRotationAngle(Torso_r2, -0.48F, 0.0F, 0.0F);
			Torso_r2.setTextureOffset(39, 8).addBox(1.0F, -4.5F, -1.5F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			Torso_r3 = new ModelRenderer(this);
			Torso_r3.setRotationPoint(0.525F, 3.45F, 2.25F);
			TorsoGroup.addChild(Torso_r3);
			setRotationAngle(Torso_r3, -0.48F, 0.0F, 0.0F);
			Torso_r3.setTextureOffset(24, 0).addBox(-3.0F, -4.5F, -1.5F, 5.0F, 9.0F, 3.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 11.9125F, 4.2625F);
			Head.setTextureOffset(0, 0).addBox(-3.0F, -5.8125F, -3.3625F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			Head.setTextureOffset(0, 21).addBox(-3.5F, -6.3125F, 2.6375F, 7.0F, 11.0F, 1.0F, 0.0F, false);
			Head.setTextureOffset(0, 12).addBox(-2.5F, -7.3125F, -4.3625F, 5.0F, 2.0F, 7.0F, 0.0F, false);
			Head.setTextureOffset(23, 31).addBox(-3.5F, -6.3125F, -2.3625F, 1.0F, 7.0F, 5.0F, 0.0F, false);
			Head.setTextureOffset(11, 28).addBox(2.5F, -6.3125F, -2.3625F, 1.0F, 7.0F, 5.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-3.0F, -4.3125F, -3.1625F);
			Head.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, 0.3054F);
			cube_r1.setTextureOffset(0, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(3.0F, -4.3125F, -3.1625F);
			Head.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, -0.3054F);
			cube_r2.setTextureOffset(0, 12).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 8.1875F, 4.1375F);
			Head.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.2182F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(24, 12).addBox(-3.5F, -3.5F, -0.5F, 7.0F, 7.0F, 1.0F, 0.0F, false);
			ArmRight = new ModelRenderer(this);
			ArmRight.setRotationPoint(3.3F, 16.9333F, 5.0F);
			ArmRight.setTextureOffset(33, 42).addBox(0.1F, 3.0667F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			ArmRight.setTextureOffset(13, 40).addBox(-0.3F, 5.0667F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.7F, 0.8667F, 0.0F);
			ArmRight.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.0F, -0.2182F);
			cube_r4.setTextureOffset(0, 42).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			ArmRight2 = new ModelRenderer(this);
			ArmRight2.setRotationPoint(-3.3F, 16.9333F, 4.0F);
			ArmRight2.setTextureOffset(40, 22).addBox(-2.1F, 3.0667F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			ArmRight2.setTextureOffset(37, 17).addBox(-2.7F, 5.0667F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-0.7F, 0.7667F, 0.0F);
			ArmRight2.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0F, 0.2182F);
			cube_r5.setTextureOffset(30, 31).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			FootOne = new ModelRenderer(this);
			FootOne.setRotationPoint(2.0F, 19.25F, 0.0F);
			setRotationAngle(FootOne, -1.5708F, 0.0F, 0.0F);
			FootOne.setTextureOffset(35, 35).addBox(-1.5F, 4.75F, 0.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);
			FootOne.setTextureOffset(40, 4).addBox(-1.5F, 3.75F, 2.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			FootOne2 = new ModelRenderer(this);
			FootOne2.setRotationPoint(-2.0F, 19.25F, 0.0F);
			setRotationAngle(FootOne2, -1.5708F, 0.0F, 0.0F);
			FootOne2.setTextureOffset(0, 35).addBox(-1.5F, 4.75F, 0.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);
			FootOne2.setTextureOffset(40, 0).addBox(-1.5F, 3.75F, 2.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			TorsoGroup.render(matrixStack, buffer, packedLight, packedOverlay);
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			ArmRight.render(matrixStack, buffer, packedLight, packedOverlay);
			ArmRight2.render(matrixStack, buffer, packedLight, packedOverlay);
			FootOne.render(matrixStack, buffer, packedLight, packedOverlay);
			FootOne2.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
